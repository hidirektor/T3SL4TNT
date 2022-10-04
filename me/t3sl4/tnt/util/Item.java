package me.t3sl4.tnt.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    public ItemStack advancedTNT;
    public ItemMeta advancedTNTMeta;
    public ItemStack extraAdvancedTNT;
    public ItemMeta extraAdvancedTNTMeta;

    public static void loadItem(Item item) {
        item.advancedTNT = new ItemStack(Material.TNT);
        item.advancedTNTMeta = item.advancedTNT.getItemMeta();
        item.advancedTNTMeta.setDisplayName(MessageUtil.ANAME);
        item.advancedTNTMeta.setLore(MessageUtil.ALORE);
        item.advancedTNTMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        item.advancedTNTMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.advancedTNT.setItemMeta(item.advancedTNTMeta);

        item.extraAdvancedTNT = new ItemStack(Material.TNT);
        item.extraAdvancedTNTMeta = item.extraAdvancedTNT.getItemMeta();
        item.extraAdvancedTNTMeta.setDisplayName(MessageUtil.EANAME);
        item.extraAdvancedTNTMeta.setLore(MessageUtil.EALORE);
        item.extraAdvancedTNTMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        item.extraAdvancedTNTMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.extraAdvancedTNT.setItemMeta(item.extraAdvancedTNTMeta);
    }

    public static boolean checkInventory(Player p) {
        int kontrol=0;
        for(ItemStack i : p.getInventory()) {
            if(i == null) {
                kontrol ++;
            }
        }
        if(kontrol != 0) {
            return true;
        }
        return false;
    }
}