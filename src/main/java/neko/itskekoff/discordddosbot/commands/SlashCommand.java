package neko.itskekoff.discordddosbot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;

public interface SlashCommand {

    String getname();

    Mono<Void> handle(ChatInputInteractionEvent e);
}
