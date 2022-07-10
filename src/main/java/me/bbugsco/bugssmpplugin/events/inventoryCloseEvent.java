package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class inventoryCloseEvent implements Listener {
    BugsSmpPlugin plugin;

    public inventoryCloseEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
                Inventory inv = event.getInventory();
                this.plugin.saveInventory(inv, event.getPlayer().getName());
                this.plugin.saveEnderInventory(inv, event.getPlayer().getName());

    }
}
