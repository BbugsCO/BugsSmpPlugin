package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class playerinfo implements CommandExecutor {

    BugsSmpPlugin plugin;

    public playerinfo(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.plugin.getConfig().getString("commands.player-info") == "true") {
            if (command.getName().equalsIgnoreCase("playerinfo")) {
                if (sender instanceof Player) {
                    if (sender.hasPermission("bugs-smp.playerinfo")) {
                        if (args.length == 1) {
                            Player player = Bukkit.getPlayerExact(args[0]);
                            if (player.isOnline()) {
                                // online
                            } else {
                                // offline
                            }
                        } else {
                            sender.sendMessage("Not enough arguments: usage /playerinfo <username>");
                        }
                        }
                    } else {
                        this.plugin.getLogger().info("You do not have permission to run this command");
                    }
                }
                else {
                    sender.sendMessage("Cannot execute command from console");
                }
            }
        else {
            sender.sendMessage("Command is disabled, to enable it, change playerinfo value to true in config.yml");
        }
        return true;
    }
}