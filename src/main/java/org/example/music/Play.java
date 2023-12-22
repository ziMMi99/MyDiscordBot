package org.example.music;

import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.example.ICommand;
import org.example.lavaplayer.PlayerManager;

import java.util.ArrayList;
import java.util.List;

public class Play implements ICommand {
    @Override
    public String getName() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "Will play a song";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.STRING, "name", "Name of the song to play", true));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member memeber = event.getMember();
        GuildVoiceState memeberVoiceState = memeber.getVoiceState();

        if (!memeberVoiceState.inAudioChannel()) {
            event.reply("You need to be in a voice channel").queue();
            return;
        }

        Member self = event.getGuild().getSelfMember();
        GuildVoiceState selfVoiceState = self.getVoiceState();

        if (!selfVoiceState.inAudioChannel()) {
            //Joins the same voice channel as the user who used the /play command
            event.getGuild().getAudioManager().openAudioConnection(memeberVoiceState.getChannel());
        } else {
            if (selfVoiceState.getChannel() != memeberVoiceState.getChannel()) {
                event.reply("You need to be in the same channel");
                return;
            }
        }

        PlayerManager playerManager = PlayerManager.get();
        event.reply("Playing").queue();
        playerManager.play(event.getGuild(), event.getOption("name").getAsString());
    }
}
