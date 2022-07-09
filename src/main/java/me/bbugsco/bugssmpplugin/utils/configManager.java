package me.bbugsco.bugssmpplugin.utils;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class configManager {

    private File customConfigFile;
    private FileConfiguration customConfig;

    BugsSmpPlugin plugin;

    public configManager(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public void createCustomConfig() {
        customConfigFile = new File(Bukkit.getServer().getPluginManager().getPlugin("BugsSmpPlugin").getDataFolder(), "data.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            Bukkit.getServer().getPluginManager().getPlugin("BugsSmpPlugin").saveResource("data.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveCustomConfig() {
        try {
            customConfig.save(customConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
