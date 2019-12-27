package be;

import java.util.Date;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import utils.Properties;

public class Bot extends TelegramLongPollingBot {

    Bot() {
        /*
        * //https://www.fileformat.info/tip/java/date2millis.htm
         */
        long newYearTime = 1577826000000L;
        Date newYearDate = new Date(newYearTime);
        while (new Date().before(newYearDate)) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        /*
        * https://api.telegram.org/botBOT:TOKEN/getChat?chat_id=@channelName
         */
        sendMessage.setChatId(Properties.getChatId());
        sendMessage.setText("Happy New Year! \nWishing you ... \nAnd of course somewhere i hided a gift for you!");
        sendMsg(sendMessage);
    }

    public void onUpdateReceived(Update update) {
        ProcessingMessage processingMessage = new ProcessingMessage();
        sendMsg(processingMessage.processing(update));
    }

    public synchronized void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return Properties.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return Properties.getBotToken();
    }

}
