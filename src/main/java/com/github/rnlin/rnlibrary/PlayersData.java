package com.github.rnlin.rnlibrary;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class PlayersData extends CustomConfig{

    public PlayersData(JavaPlugin p, String fileName) {
        super(p, fileName);
        init();
    }

    public void saveData(UUID uuid, String key, Object b) {
        getConfig().set(uuid.toString() + "." + key, b);
        saveConfig();
    }

    public void setData(UUID uuid, String key, Object b) {
        getConfig().set(uuid.toString() + "." + key, b);
    }

    public boolean getBool(UUID uuid, String key) {
        return getConfig().getBoolean(uuid.toString() + "." + key);
    }

    public boolean contains(UUID uuid, String key) {
        return getConfig().contains(uuid.toString() + "." + key);
    }

    private void init() {
        saveDefaultConfig();
        reloadConfig();
    }
}
