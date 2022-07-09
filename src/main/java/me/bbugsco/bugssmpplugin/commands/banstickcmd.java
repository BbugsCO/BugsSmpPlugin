package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.items.banStick;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class banstickcmd implements CommandExecutor {

    BugsSmpPlugin plugin;

    public banstickcmd(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.plugin.getConfig().getString("commands.banstick") == "true") {
            if (command.getName().equalsIgnoreCase("banstick")) {
                if (sender instanceof Player) {
                    if (sender.hasPermission("bugs-smp.banstick")) {
                        Player player = ((Player) sender).getPlayer();
                        ItemStack stick = banStick.getBanStick();
                        player.getInventory().addItem(stick);
                    } else {
                        sender.sendMessage("You do not have permission to run this command");
                    }
                } else {
                    this.plugin.getLogger().info("Cannot execute command from console");
                }
            }
        }
        else {
            sender.sendMessage("Command is disabled, to enable it, change banstick value to true in config.yml");
        }
        return true;
    }
}
