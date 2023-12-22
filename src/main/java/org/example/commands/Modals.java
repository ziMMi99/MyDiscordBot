package org.example.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.text.TextInput;
import net.dv8tion.jda.api.interactions.components.text.TextInputStyle;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.example.ICommand;

import java.util.List;

public class Modals implements ICommand {
    @Override
    public String getName() {
        return "modal";
    }

    @Override
    public String getDescription() {
        return "Will open a model";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        TextInput name = TextInput.create("name-field", "Name", TextInputStyle.SHORT)
                .setRequired(true)
                .setMinLength(1)
                .setPlaceholder("Enter your name")
                .build();
        TextInput age = TextInput.create("age-field", "Age", TextInputStyle.SHORT)
                .setRequired(false)
                .setPlaceholder("enter your age")
                .build();
        TextInput description = TextInput.create("description-field", "Description", TextInputStyle.PARAGRAPH)
                .setRequired(true)
                .setMinLength(1)
                .setPlaceholder("Descripe Yourself")
                .build();
        Modal modal = Modal.create("person-modal", "Decripe Yourself")
                .addComponents(ActionRow.of(name), ActionRow.of(age), ActionRow.of(description))
                .build();

        event.replyModal(modal).queue();
    }
}
