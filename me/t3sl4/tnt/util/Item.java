package me.t3sl4.tnt.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    public ItemStack tnt;
    public ItemMeta tntMeta;

    public static void loadItem(Item item) {
        item.tnt = new ItemStack(Material.SNOW_BALL);
        item.tntMeta = item.tnt.getItemMeta();
        item.tntMeta.setDisplayName(MessageUtil.ITEMNAME);
        item.tntMeta.setLore(MessageUtil.ITEMLORE);
        item.tntMeta.addEnchant(Enchantment.DURABILITY, 10, true);
        item.tntMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.tnt.setItemMeta(item.tntMeta);
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