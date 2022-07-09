package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

public class playerQuitEvent implements Listener {

    BugsSmpPlugin plugin;

    public playerQuitEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // Log player location and dimension to data.yml
        Player player = event.getPlayer();
        String username = player.getName();
        this.plugin.getCustomConfig().getString(username);

        if (this.plugin.getConfig().getString("log-data.log-logout-location") == "true") {
            Location location = player.getLocation();

            int X = (int) Math.round(location.getX());
            int Y = (int) Math.round(location.getY());
            int Z = (int) Math.round(location.getZ());
            String pos = X + ", " + Y + ", " + Z;

            String uuid = player.getUniqueId().toString();

            String dim = location.getWorld().getName();

            String pathToLocation = "players." + username + ".location";
            String pathToUuid = "players." + username + ".uuid";
            String pathToDimension = "players." + username + ".world";


            this.plugin.getCustomConfig().set(pathToLocation, pos);
            this.plugin.getCustomConfig().set(pathToUuid, uuid);
            this.plugin.getCustomConfig().set(pathToDimension, dim);
            this.plugin.saveCustomConfig();

        }

        // Log player quit in simple log

        if (this.plugin.getConfig().getString("logging.simple-log") == "true") {

            String message = "[PlayerQuit] " + username + " Has left the game";
            this.plugin.log("bugs-smp", message);
        }

        // Store player inventory and ender chest in data.yml
        Inventory inv = player.getInventory();
        Inventory ender = player.getEnderChest();
        this.plugin.saveInventory(inv, username);
        this.plugin.saveEnderInventory(ender, username);
    }
}
