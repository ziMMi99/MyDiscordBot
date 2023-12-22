package org.example;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.modals.Modal;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;

public class Listeners extends ListenerAdapter {

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("yes-button")) {
            event.reply("Nice, me too").queue();
        } else if (event.getButton().getId().equals("no-button")) {
            event.reply("Go to hell").queue();
        }

        event.getMessage().delete().queue();
    }

    @Override
    public void onModalInteraction(ModalInteractionEvent event) {
        if (event.getModalId().equals("person-modal")) {
            ModalMapping nameValue = event.getValue("name-field");
            ModalMapping ageValue = event.getValue("age-field");
            ModalMapping descValue = event.getValue("description-field");

            String name = nameValue.getAsString();
            String description = descValue.getAsString();

            String age;
            if (ageValue.getAsString().isBlank()) {
                age = "N/A";
            } else {
                age = ageValue.getAsString();
            }

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle(name);
            builder.setDescription("The Description of " + name);
            builder.addField("Name", name, false);
            builder.addField("Age", age, false);
            builder.addField("Description", description, false);

            event.replyEmbeds(builder.build()).queue();
        }
    }
}
