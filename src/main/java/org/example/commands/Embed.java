package org.example.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;

import java.awt.*;
import java.util.List;

public class Embed implements ICommand {
    @Override
    public String getName() {
        return "embed";
    }

    @Override
    public String getDescription() {
        return "Will send an embed";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Example Embed");
        builder.setDescription("An example embed");
        builder.addField("Field 1", "Field Value", false);
        builder.addField("Field 2", "Field Value", false);
        builder.addField("Field 3", "Field Value", false);
        builder.setFooter("Example Footer");
        builder.setColor(Color.BLUE);
        builder.appendDescription("This has been added");
        builder.setAuthor("Simon Knudsen");
        event.replyEmbeds(builder.build()).queue();
    }
}
