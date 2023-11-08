package ru.krayseer;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.channel.TextChannel;

/**
 * Реализация дискорд бота
 */
public class DiscordBot implements Bot {

    private String token;

    private final Logic logic;

    private GatewayDiscordClient client;

    public DiscordBot(String token) {
        this.token = token;
        logic = new Logic();
    }

    @Override
    public void start() {
        client = DiscordClient.create(token).login().block();
        if(client == null) {
            System.err.println("Ошибка при входе в Discord");
            return;
        }
        client.on(MessageCreateEvent.class)
                .subscribe(event -> {
                    String message = event.getMessage().getContent();
                    logic.processMessage(this, message);
                });
        System.out.println("Discord бот запущен");
        client.onDisconnect().block();
    }

    @Override
    public void sendMessage(String message) {
        Snowflake channelId = Snowflake.of("channel_id");
        TextChannel channel = client.getChannelById(channelId).ofType(TextChannel.class).block();
        if (channel != null) {
            channel.createMessage(message).block();
        }
    }
}
