package com.github.rnlin.rnlibrary;

import org.bukkit.entity.Player;

public class Massage {
    private Player player;

    public void sendMessage(String text) {
        player.sendMessage(text);
    }
}
