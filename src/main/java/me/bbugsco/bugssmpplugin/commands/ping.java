package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {
    BugsSmpPlugin plugin;

    public ping(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.plugin.getConfig().getString("commands.ping") == "true") {
            if (command.getName().equalsIgnoreCase("ping")) {
                if (sender instanceof Player) {
                    if (sender.hasPermission("bugs-smp.ping")) {
                        if (args.length == 1) {
                            Player player = Bukkit.getServer().getPlayerExact(args[0]);
                            if (player.isOnline()) {
                                int ping = player.getPing();
                                String username = player.getName();
                                String message = username + "'s ping is: " + ping;
                                sender.sendMessage(message);
                            }
                        } else {
                            sender.sendMessage("Not enough arguments: usage /ping <username>");
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
            sender.sendMessage("Command is disabled, to enable it, change ping value to true in config.yml");
        }
        return true;
    }
}
