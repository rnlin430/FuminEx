package com.github.rnlin.fuminex;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EventListener implements Listener {
    JavaPlugin plugin;

    public EventListener(JavaPlugin p ) {
        plugin = p;
        p.getServer().getPluginManager().registerEvents(this, p);
    }

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        onCheckFlyMode();
    }

    private void onCheckFlyMode() {
    }
}
