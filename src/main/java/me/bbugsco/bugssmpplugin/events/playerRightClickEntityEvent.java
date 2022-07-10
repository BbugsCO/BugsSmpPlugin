package me.bbugsco.bugssmpplugin.events;

import me.bbugsco.bugssmpplugin.BugsSmpPlugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.UUID;

public class playerRightClickEntityEvent implements Listener {

    BugsSmpPlugin plugin;

    public playerRightClickEntityEvent(BugsSmpPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onRightClickPlayer(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked().getType().equals(EntityType.PLAYER) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.KNOCKBACK) == 420) {
            UUID uuid = event.getRightClicked().getUniqueId();
            Player clickedPlayer = Bukkit.getPlayer(uuid);
            if (!clickedPlayer.hasPermission("bugs-smp.banstick.bypass")) {
                if (player.getGameMode() == GameMode.CREATIVE) {
                    clickedPlayer.banPlayer("bye bye");
                }
            }
        }
        if (event.getRightClicked().getType().equals(EntityType.PLAYER) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.FIRE_ASPECT) == 69) {
            UUID uuid = event.getRightClicked().getUniqueId();
            Player clickedPlayer = Bukkit.getPlayer(uuid);
            if (!clickedPlayer.hasPermission("bugs-smp.kickstick.bypass")) {
                if (player.getGameMode() == GameMode.CREATIVE) {
                    clickedPlayer.kickPlayer("nerd");
                }
            }
        }
    }
}
