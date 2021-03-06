package me.bbugsco.bugssmpplugin;

import me.bbugsco.bugssmpplugin.commands.*;
import me.bbugsco.bugssmpplugin.events.*;
import me.bbugsco.bugssmpplugin.utils.*;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BugsSmpPlugin extends JavaPlugin implements Listener {

    BugsSmpPlugin instance;

    configManager ConfigManager;

    logger logMgr;

    invUtil invUtil;

    @Override
    public void onEnable() {
        // define instance
        instance = this;

        // load utils and configs
        ConfigManager = new configManager(this);
        logMgr = new logger(this);
        invUtil = new invUtil(this);

        this.saveDefaultConfig();
        this.ConfigManager.createCustomConfig();
        this.logMgr.logToFile("bugs-smp", "[ServerStart]");

        // register events
        getServer().getPluginManager().registerEvents(this, this);

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new playerQuitEvent(this), this);
        pm.registerEvents(new playerJoinEvent(this), this);
        pm.registerEvents(new playerDeathEvent(this), this);
        pm.registerEvents(new playerChatEvent(this), this);
        pm.registerEvents(new playerAchievementEvent(this), this);
        pm.registerEvents(new playerCommandEvent(this), this);
        pm.registerEvents(new playerRightClickEntityEvent(this), this);

        // register commands
        getCommand("bugssmpreload").setExecutor(new reloadConfig(this));

        getCommand("gma").setExecutor(new gma(this));
        getCommand("gmc").setExecutor(new gmc(this));
        getCommand("gmt").setExecutor(new gmt(this));
        getCommand("gms").setExecutor(new gms(this));

        getCommand("playerinfo").setExecutor(new playerinfo(this));
        getCommand("ping").setExecutor(new ping(this));

        getCommand("banstick").setExecutor(new banstickcmd(this));
        getCommand("kickstick").setExecutor(new kickstickcmd(this));

        // TODO: Lightning rod
        // TODO: Tool break sound
        // TODO: Elder Guardian Jump Scare
    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
        this.ConfigManager.saveCustomConfig();

        this.logMgr.logToFile("bugs-smp", "[ServerStop]");

    }

    public void saveCustomConfig() { this.ConfigManager.saveCustomConfig(); }

    public FileConfiguration getCustomConfig() { return this.ConfigManager.getCustomConfig(); }

    public void log(String filename, String message) { this.logMgr.logToFile(filename, message); }

    public void saveInventory(Inventory inventory, String name) { this.invUtil.saveInventory(inventory, name); }

    public void saveEnderInventory(Inventory inventory, String name) { this.invUtil.saveEnderInventory(inventory, name); }
}