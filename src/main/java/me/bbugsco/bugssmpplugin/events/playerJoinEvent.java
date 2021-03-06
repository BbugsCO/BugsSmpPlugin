package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class playerJoinEvent implements Listener {

    BugsSmpPlugin plugin;

    public playerJoinEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Log player IP into data.yml
        Player player = event.getPlayer();
        String username = player.getName();
        this.plugin.getCustomConfig().getString(username);

        if (this.plugin.getConfig().getString("log-data.log-address") == "true") {
            String address = player.getAddress().getAddress().toString();

            String pathToAddress = "players." + username + ".address";

            this.plugin.getCustomConfig().set(pathToAddress, address);
            this.plugin.saveCustomConfig();
        }

        // Log player joining in simple log
        if (this.plugin.getConfig().getString("logging.simple-log") == "true") {

            String message = "[PlayerJoin] " + username + " Has joined the game";
            this.plugin.log("bugs-smp", message);
        }
    }
}