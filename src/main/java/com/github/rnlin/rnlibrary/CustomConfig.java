package com.github.rnlin.rnlibrary;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class CustomConfig {
    private FileConfiguration config = null;
    final File configFile;
    private final String filename;
    private final Plugin plugin;

    public CustomConfig(Plugin plugin) {
        this(plugin, "config.yml");
    }

    public CustomConfig(Plugin plugin, String fileName) {
        this.plugin = plugin;
        this.filename = fileName;
        configFile = new File(plugin.getDataFolder(), filename);
    }

    public void saveDefaultConfig() {
        if (!configFile.exists()) {
            try{
                plugin.saveResource(filename, false);
            }catch (IllegalArgumentException ei) {
                // if filename is null, empty, or points to a nonexistent resource, create an empty configuration file.
                YamlConfiguration yamlconf = new YamlConfiguration();
                try{
                    yamlconf.save(configFile);
                }catch (IOException eio) {
                    eio.printStackTrace();
                }

            }
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        final InputStream defConfigStream = plugin.getResource(filename);
        if (defConfigStream == null) {
            return;
        }
        config.setDefaults(YamlConfiguration.loadConfiguration(
                new InputStreamReader(defConfigStream, StandardCharsets.UTF_8)));
    }

    public FileConfiguration getConfig() {
        if (config == null) {
            reloadConfig();
        }
        if (!(config == null)) {
        }
        return config;
    }

    public void saveConfig() {
        if (config == null) {
            return;
        }
        try {
            getConfig().save(configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, e);
        }
    }
}
