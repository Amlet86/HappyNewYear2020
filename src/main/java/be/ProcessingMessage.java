package be;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ProcessingMessage extends AbstractMessage {

    private String parseQuestionAndPreparingResponse(String question) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("src/main/resources/QA.csv"), ',');
        String[] nextLine;
        HashMap<String, String> qa = new HashMap<>();
        String answer = "I don't understand you.";
        while ((nextLine = reader.readNext()) != null) {
            qa.put(nextLine[0], nextLine[1]);
        }
        for (Map.Entry<String, String> e : qa.entrySet()) {
            if (question.contains(e.getKey()))
                answer = qa.get(e.getKey());
        }
        return answer;
    }

    public SendMessage processing(Update update) {
        SendMessage sendMessage = prepareMessage(update);
        String question = update.getMessage().getText().toLowerCase();
        try {
            sendMessage.setText(parseQuestionAndPreparingResponse(question));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sendMessage;
    }

}
