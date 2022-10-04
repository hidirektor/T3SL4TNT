package me.t3sl4.tnt.util;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class SettingsManager {
    private SettingsManager() {}
    static SettingsManager instance = new SettingsManager();
    private Plugin p;
    private FileConfiguration config;
    private File configfile;

    public void setup(Plugin p) {
        if(!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        create("config", p);
    }

    public FileConfiguration get(String file) {
        if(file.equalsIgnoreCase("config")) {
            return config;
        }
        return null;
    }

    public void save(String file) {
        if(file.equalsIgnoreCase("config")) {
            try {
                config.save(configfile);
            } catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Config.yml kaydedilemedi!");
            }
        }
    }

    public void reload(String file) {
        if(file.equalsIgnoreCase("config")) {
            config = YamlConfiguration.loadConfiguration(configfile);
        }
    }

    public void create(String file, Plugin p) {
        if(file.equalsIgnoreCase("config")) {
            configfile = new File(p.getDataFolder(), "config.yml");
            if(!configfile.exists()) {
                p.saveDefaultConfig();
            }
            config = p.getConfig();
        }
    }

    public PluginDescriptionFile getDesc() {
        return p.getDescription();
    }

    public static SettingsManager getInstance() {
        return instance;
    }
}