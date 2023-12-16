package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import org.example.commands.Sum;

public class Bot {
    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(secret.token).build();

        jda.addEventListener(new Listeners());
        jda.addEventListener(new Sum());

        /*
            Global commands - can be used anywhere
            Guild commands - can be used in certain guilds
         */
    }
}