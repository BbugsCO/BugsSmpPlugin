package me.bbugsco.bugssmpplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class kickStick {
    public static ItemStack getKickStick() {
        ItemStack kickStick = new ItemStack(Material.STICK);
        ItemMeta kickStickMeta = kickStick.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();
        lore.add("stop being annoying");
        kickStickMeta.addEnchant(Enchantment.FIRE_ASPECT, 69, true);
        kickStickMeta.setLore(lore);
        kickStickMeta.setDisplayName("Kick Stick");
        kickStick.setItemMeta(kickStickMeta);

        return kickStick;
    }
}
