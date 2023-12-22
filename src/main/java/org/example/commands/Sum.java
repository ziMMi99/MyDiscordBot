package org.example.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;

import java.util.ArrayList;
import java.util.List;

public class Sum implements ICommand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "Will give the sum of 2 numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> data = new ArrayList<>();

        data.add(new OptionData(OptionType.INTEGER, "number1", "The first number", true)
                        .setMinValue(Integer.MIN_VALUE)
                        .setMaxValue(Integer.MAX_VALUE));

        data.add(new OptionData(OptionType.INTEGER, "number2", "The second number", true)
                        .setMinValue(Integer.MIN_VALUE)
                        .setMaxValue(Integer.MAX_VALUE));

        return data;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        OptionMapping number1 = event.getOption("number1");
        OptionMapping number2 = event.getOption("number2");
        int num1 = number1.getAsInt();
        int num2 = number2.getAsInt();

        event.reply(num1 + " + " + num2 + " = " + String.valueOf(num1 + num2)).queue();
    }
}
