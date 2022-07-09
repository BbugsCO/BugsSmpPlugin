package me.bbugsco.bugssmpplugin.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class banStick {
    public static ItemStack getBanStick() {
        ItemStack banStick = new ItemStack(Material.BLAZE_ROD);
        ItemMeta banStickMeta = banStick.getItemMeta();

        ArrayList<String> lore = new ArrayList<>();
        lore.add("Makes bye bye");
        banStickMeta.addEnchant(Enchantment.KNOCKBACK, 420, true);
        banStickMeta.setLore(lore);
        banStickMeta.setDisplayName("Ban Stick");
        banStick.setItemMeta(banStickMeta);

        return banStick;
    }
}
