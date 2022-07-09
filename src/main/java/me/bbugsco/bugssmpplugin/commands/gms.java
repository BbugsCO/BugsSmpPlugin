package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gms implements CommandExecutor {

    BugsSmpPlugin plugin;

    public gms(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (this.plugin.getConfig().getString("commands.gms") == "true") {
            if (command.getName().equalsIgnoreCase("gms")) {
                if (sender instanceof Player) {
                    if (sender.hasPermission("bugs-smp.gms")) {
                        Player player = (Player) sender;
                        player.setGameMode(GameMode.SURVIVAL);

                    } else {
                        sender.sendMessage("You do not have permission to run this command");
                    }
                } else {
                    this.plugin.getLogger().info("Cannot execute command from console");
                }
            }
        }
        else {
            sender.sendMessage("Command is disabled, to enable it, change gms value to true in config.yml");
        }
        return true;
    }
}
