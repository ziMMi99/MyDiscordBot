package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.example.commands.*;
import org.example.music.*;

public class Bot {
    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(secret.token).build();

        jda.addEventListener(new Listeners());
        CommandManager manager = new CommandManager();
        manager.add(new Sum());
        manager.add(new RandomGame());
        manager.add(new Embed());
        manager.add(new Buttons());
        manager.add(new Modals());
        manager.add(new Play());
        manager.add(new Skip());
        manager.add(new Stop());
        manager.add(new Queue());
        manager.add(new Repeat());
        manager.add(new NowPlaying());
        jda.addEventListener(manager);
    }
        /*
            Global commands - can be used anywhere
            Guild commands - can be used in certain guilds
         */
}