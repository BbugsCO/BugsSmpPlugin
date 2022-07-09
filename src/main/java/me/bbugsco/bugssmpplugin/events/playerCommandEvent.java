package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class playerCommandEvent implements Listener {
    BugsSmpPlugin plugin;

    public playerCommandEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler

    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        if (this.plugin.getConfig().getString("logging.simple-log") == "true") {
            // Log commands to simple log

            String player = event.getPlayer().getName();
            String command = event.getMessage();

            String message = "[PlayerCommand] " + player + " Has ran " + command;

            this.plugin.log("bugs-smp", message);
        }
    }
}
