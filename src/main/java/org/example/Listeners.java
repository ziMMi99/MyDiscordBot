package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class Listeners extends ListenerAdapter {


    @Override
    public void onReady(ReadyEvent event) {
        Guild guild = event.getJDA().getGuildById(secret.guildID);
        guild.upsertCommand("sum", "Gives a sum of 2 numbers").addOptions(
                new OptionData(OptionType.INTEGER, "number1", "The first number", true)
                        .setMinValue(1)
                        .setMaxValue(100),
                new OptionData(OptionType.INTEGER, "number2", "The second number", true)
                        .setMinValue(1)
                        .setMaxValue(100)
                ).queue();
    }

}
