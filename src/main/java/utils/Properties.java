package utils;

public class Properties {

    private static String chatId;
    private static String botUsername;
    private static String botToken;

    public static void setChatId(String chatId) {
        Properties.chatId = chatId;
    }

    public static String getChatId() {
        return chatId;
    }

    public static void setBotUsername(String botUsername) {
        Properties.botUsername = botUsername;
    }

    public static String getBotUsername() {
        return botUsername;
    }

    public static void setBotToken(String botToken) {
        Properties.botToken = botToken;
    }

    public static String getBotToken() {
        return botToken;
    }
}
