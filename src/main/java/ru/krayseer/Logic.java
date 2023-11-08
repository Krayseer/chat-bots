package ru.krayseer;

/**
 * Класс, отвечающий за обработку сообщений
 */
public class Logic {

    /**
     * Обработать сообщение и отправить
     * @param bot бот, которому нужно отправить сообщение
     * @param message необработанное сообщение
     */
    public void processMessage(Bot bot, String message) {
        String processedMessage = String.format("Ваше сообщение: '%s'", message);
        bot.sendMessage(processedMessage);
    }

}
