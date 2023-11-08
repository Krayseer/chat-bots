package ru.krayseer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Тест для класса {@link Logic}
 */
public class LogicTest {

    private Logic logic;

    private Bot bot;

    @Before
    public void setUp() {
        logic = new Logic();
        bot = Mockito.mock(Bot.class);
    }

    /**
     * Тест для обработки и отправки сообщения (метод {@link Logic#processMessage(Bot, String)})
     */
    @Test
    public void testProcessMessage() {
        String message = "Hello, World!";
        String expectedProcessedMessage = "Ваше сообщение: 'Hello, World!'";

        logic.processMessage(bot, message);

        Mockito.verify(bot).sendMessage(expectedProcessedMessage);
    }
}
