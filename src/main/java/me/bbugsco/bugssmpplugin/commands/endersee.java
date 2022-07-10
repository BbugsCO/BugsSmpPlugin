package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class endersee implements CommandExecutor {

    BugsSmpPlugin plugin;

    public endersee(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.plugin.getConfig().getString("commands.invsee") == "true") {
            if (command.getName().equalsIgnoreCase("endersee")) {
                if (sender instanceof Player) {
                    if (sender.hasPermission("bugs-smp.invsee")) {
                        if (args.length == 1) {
                            String username = args[0];
                            Player sendPlayer = ((Player) sender).getPlayer();
                            Player player = Bukkit.getPlayerExact(args[0]);
                            if (player == null) {
                                // When player is offline
                                String title = "offline." + username;
                                String path = "players." + args[0] + ".enderinventory";
                                if (this.plugin.getCustomConfig().getString(path) == null) {
                                    sender.sendMessage("Player's inventory does not exist in storage");
                                } else {
                                    ItemStack[] items = this.plugin.loadEnderInventory(username);
                                    Inventory inv = Bukkit.createInventory(sendPlayer, 27, title);
                                    inv.setContents(items);
                                    sendPlayer.openInventory(inv);
                                }
                            } else {
                                // When player is online
                                Player invPlayer = this.plugin.getServer().getPlayer(username);
                                Inventory inv = invPlayer.getEnderChest();
                                sendPlayer.openInventory(inv);
                            }
                        } else {
                            sender.sendMessage("Not enough arguments: usage /endersee <username>");
                        }
                    } else {
                        sender.sendMessage("You do not have permission to run this command");
                    }
                } else {
                    this.plugin.getLogger().info("Cannot execute command from console");
                }
            }
        }
        else {
            sender.sendMessage("Command is disabled, to enable it, change invsee value to true in config.yml");
        }
        return true;
    }
}
