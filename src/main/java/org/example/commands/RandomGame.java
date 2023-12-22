package org.example.commands;

import java.util.ArrayList;
import java.util.Random;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;

import java.util.List;

public class RandomGame implements ICommand {
    @Override
    public String getName() {
        return "random";
    }

    @Override
    public String getDescription() {
        return "Gives a Random game to play";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {

        Random rand = new Random();

        String[] games = {"Game1", "Game2", "Game3", "Game4", "Game5", "Game6", "Game7", "cum on me daddy" };

        int randInt = rand.nextInt(8);

        String gameToPlay = games[randInt];

        event.reply("You Got: " + gameToPlay).queue();
    }
}
