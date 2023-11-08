package ru.krayseer;

/**
 * Интерфейс, описывающий функции бота
 */
public interface Bot {

    /**
     * Запустить бота
     */
    void start();

    /**
     * Отправить сообщение
     */
    void sendMessage(String message);

}
