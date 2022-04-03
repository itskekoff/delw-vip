package neko.itskekoff.discordddosbot.commands.impl;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.Embed;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;
import neko.itskekoff.discordddosbot.commands.SlashCommand;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodsCommand implements SlashCommand {
    public String toPrint = "";
    public String[] methods = {"join", "default", "legitjoin", "localhost", "invalidnames", "longnames", "botjoiner", "spoof", "ping", "nullping", "multikiller", "handshake", "bighandshake", "query", "bigpacket", "network", "randombytes", "extremejoin", "spamjoin", "nettydowner", "ram", "yoonikscry", "colorcrasher", "tcphit", "tcpbypass", "botnet", "queue", "ultimatesmasher", "sf", "nabcry"};


    @Override
    public String getname() {
        return "methods";
    }

    @Override
    public Mono<Void> handle(ChatInputInteractionEvent e) {
        List list = Arrays.asList(methods);
        for (int i = 0; i < list.size(); i++) {
            toPrint += list.get(i) + ", ";
        }
        EmbedCreateSpec emb = EmbedCreateSpec.builder()
                .color(Color.BROWN)
                .title("Методы:")
                .addField("Список методов", toPrint, true)
                .timestamp(Instant.now())
                .footer("View /credits to get additional info!", "https://i.ytimg.com/vi/HJ9Hq5wu-xw/maxresdefault.jpg")
                .build();
        return e.reply()
                .withEmbeds(emb)
                .withEphemeral(true);
    }
}
