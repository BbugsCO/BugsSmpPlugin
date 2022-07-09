package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class playerChatEvent implements Listener {
    BugsSmpPlugin plugin;

    public playerChatEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        // log chat to simple log
        if (this.plugin.getConfig().getString("logging.simple-log") == "true") {

            String chat = event.getMessage();
            String player = event.getPlayer().getName();

            String message = "[PlayerChat] " + player + " > " + chat;

            this.plugin.log("bugs-smp", message);
        }
    }
}
