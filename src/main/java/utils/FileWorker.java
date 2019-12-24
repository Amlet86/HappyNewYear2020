package utils;

import java.io.*;

public class FileWorker {

    private static final String TELEGRAM_DATA_FILE_PATH = "src/main/resources/TelegramData.txt";

    public static void writeUserDataFile() {
        try (FileWriter writer = new FileWriter(TELEGRAM_DATA_FILE_PATH, false)) {

            writer.write(Properties.getChatId());
            writer.append('\n');
            writer.append(Properties.getBotUsername());
            writer.append('\n');
            writer.append(Properties.getBotToken());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] readTelegramDataFile() {
        String[] telegramData = new String[3];
        try (BufferedReader br = new BufferedReader(new FileReader(TELEGRAM_DATA_FILE_PATH))) {
            if (br.ready()) {
                telegramData[0] = br.readLine();
                telegramData[1] = br.readLine();
                telegramData[2] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return telegramData;
    }
}
