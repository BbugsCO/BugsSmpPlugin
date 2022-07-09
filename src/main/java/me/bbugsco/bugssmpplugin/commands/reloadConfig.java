package me.bbugsco.bugssmpplugin.commands;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reloadConfig implements CommandExecutor {

    BugsSmpPlugin plugin;

    public reloadConfig(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("bugssmpreload")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("bugs-smp.reload")) {
                    this.plugin.reloadConfig();
                }
                else {
                    sender.sendMessage("You do not have permission to run this command");
                }
            }
            else {
                this.plugin.getLogger().info("Cannot execute command from console");
            }
        }
        return true;
    }
}
