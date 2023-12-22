package org.example.lavaplayer;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class GuildMusicManager {

    private TrackSheduler trackSheduler;
    private AudioForwarder audioForwarder;

    public GuildMusicManager(AudioPlayerManager manager) {
        AudioPlayer player = manager.createPlayer();
        trackSheduler = new TrackSheduler(player);
        player.addListener(trackSheduler);
        audioForwarder = new AudioForwarder(player);
    }

    public AudioForwarder getAudioForwarder() {
        return audioForwarder;
    }

    public TrackSheduler getTrackSheduler() {
        return trackSheduler;
    }
}
