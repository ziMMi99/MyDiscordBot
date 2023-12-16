package org.example.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class Sum extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("sum")) {
            OptionMapping number1 = event.getOption("number1");
            OptionMapping number2 = event.getOption("number2");
            int num1 = number1.getAsInt();
            int num2 = number2.getAsInt();

            event.reply(num1 + " + " + num2 + " = " + String.valueOf(num1 + num2)).queue();
        } else  {
            return;
        }
    }
}
