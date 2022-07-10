package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import me.bbugsco.bugssmpplugin.items.banStick;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.bbugsco.bugssmpplugin.items.kickStick;

public class kickstickcmd implements CommandExecutor {

    BugsSmpPlugin plugin;

    public kickstickcmd(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.plugin.getConfig().getString("commands.kickstick") == "true") {
            if (command.getName().equalsIgnoreCase("kickstick")) {
                if (sender instanceof Player) {
                    if (sender.hasPermission("bugs-smp.kickstick")) {
                        Player player = ((Player) sender).getPlayer();
                        ItemStack stick = kickStick.getKickStick();
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
