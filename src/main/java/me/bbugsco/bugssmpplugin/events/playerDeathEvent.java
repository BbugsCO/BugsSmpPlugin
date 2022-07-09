package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class playerDeathEvent implements Listener {
    BugsSmpPlugin plugin;

    public playerDeathEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (this.plugin.getConfig().getString("logging.simple-log") == "true") {
            String deathMessage = event.getDeathMessage();

            String message = "[PlayerDeath] " + deathMessage;
            this.plugin.log("bugs-smp", message);
        }
    }
}
