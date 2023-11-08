package ru.krayseer;

import java.util.List;

/**
 * Класс для запуска приложения
 */
public class Application {

    public static void main(String[] args) {
        String telegramUsername = "telegram_username";
        String telegramToken = "telegram_token";
        Bot telegramBot = new TelegramBot(telegramUsername, telegramToken);

        String discordToken = "discord_token";
        Bot discordBot = new DiscordBot(discordToken);

        List<Bot> bots = List.of(telegramBot, discordBot);
        bots.forEach(Bot::start);
    }

}
