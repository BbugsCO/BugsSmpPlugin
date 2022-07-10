package me.bbugsco.bugssmpplugin.utils;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class invUtil {

    BugsSmpPlugin plugin;

    public invUtil(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    public void saveInventory(Inventory inventory, String name) {
        String path = "players." + name + ".inventory.item";
        for(int i = 0; i < 41; i++) {
            ItemStack item = inventory.getItem(i);
            if(item == null) {
                this.plugin.getCustomConfig().set(path + i, "empty"); // if empty, save empty
            }
            else {
                this.plugin.getCustomConfig().set(path + i, item); // if not empty, save item
            }
        }
        this.plugin.saveCustomConfig();
    }

    public void saveEnderInventory(Inventory inventory, String name) {
        String path = "players." + name + ".enderinventory.item";
        for(int i = 0; i < 27; i++) {
            ItemStack item = inventory.getItem(i);
            if(item == null) {
                this.plugin.getCustomConfig().set(path + i, "empty"); // if empty, save empty
            }
            else {
                this.plugin.getCustomConfig().set(path + i, item); // if not empty, save item
            }
        }
        this.plugin.saveCustomConfig();
    }

    public ItemStack[] loadInventory(String username) {
        String path = "players." + username + ".inventory";
        ConfigurationSection cs = this.plugin.getCustomConfig().getConfigurationSection(path);
        if (cs == null) {
            ItemStack item1 = new ItemStack(Material.BARRIER, 1);
            ArrayList<String> lore = new ArrayList<>();
            lore.add("Could not load inventory");
            ItemStack[] items = {item1};
            return items;
        } else {
            List<ItemStack> items = new ArrayList<>();
            for (String key : cs.getKeys(false)) {
                Object o = cs.get(key);
                if (o instanceof ItemStack) {
                    items.add((ItemStack) o);
                } else {
                    items.add(null);
                }
            }

            ItemStack[] inv = items.toArray(new ItemStack[0]);
            return inv;
        }
    }

    public ItemStack[] loadEnderInventory(String username) {
        String path = "players." + username + ".enderinventory";
        ConfigurationSection cs = this.plugin.getCustomConfig().getConfigurationSection(path);
        if (cs == null) {
            ItemStack item1 = new ItemStack(Material.BARRIER, 1);
            ArrayList<String> lore = new ArrayList<>();
            lore.add("Could not load inventory");
            ItemStack[] items = {item1};
            return items;
        } else {
            List<ItemStack> items = new ArrayList<>();
            for (String key : cs.getKeys(false)) {
                Object o = cs.get(key);
                if (o instanceof ItemStack) {
                    items.add((ItemStack) o);
                } else {
                    items.add(null);
                }
            }

            ItemStack[] inv = items.toArray(new ItemStack[0]);
            return inv;
        }
    }
}

