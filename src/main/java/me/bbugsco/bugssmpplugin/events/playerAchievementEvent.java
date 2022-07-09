package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class playerAchievementEvent implements Listener {
    BugsSmpPlugin plugin;

    public playerAchievementEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler

    public void onPlayerAchievement(PlayerAdvancementDoneEvent event) {
        if (this.plugin.getConfig().getString("logging.simple-log") == "true") {
            // Log advancements to simple log

            String player = event.getPlayer().getName();
            String advancement = event.getAdvancement().key().asString();
            if (!advancement.startsWith("minecraft:recipes/")) {
                String message = "[PlayerAdvancement] " + player + " Has made the advancement " + advancement;

                this.plugin.log("bugs-smp", message);
            }
        }
    }
}
