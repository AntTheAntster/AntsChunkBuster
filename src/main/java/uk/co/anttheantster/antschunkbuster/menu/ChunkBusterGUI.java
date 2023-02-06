package uk.co.anttheantster.antschunkbuster.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.anttheantster.antschunkbuster.AntsChunkBuster;

//050676
public class ChunkBusterGUI {

    private AntsChunkBuster plugin;
    public ChunkBusterGUI(AntsChunkBuster plugin){
        this.plugin = plugin;
    }

    public Inventory gui(Player player){
        Inventory inventory = Bukkit.createInventory(player, 9, ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ChunkBuster.GUIName")));
        for (int i = 0; i < 8; i++) {
            inventory.setItem(i, fillItem());
        }
        inventory.setItem(2, confirmItem());
        inventory.setItem(5, cancelItem());

        return inventory;
    }

    public ItemStack fillItem(){
        ItemStack fItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta fItemMeta = fItem.getItemMeta();

        fItemMeta.setDisplayName("");
        fItemMeta.setUnbreakable(true);
        fItemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        fItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        fItem.setItemMeta(fItemMeta);

        return fItem;
    }
    public ItemStack confirmItem(){
        ItemStack cItem = new ItemStack(Material.GREEN_TERRACOTTA);
        ItemMeta cItemMeta = cItem.getItemMeta();

        cItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lEnable"));
        cItemMeta.setUnbreakable(true);
        cItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        cItem.setItemMeta(cItemMeta);

        return cItem;
    }
    public ItemStack cancelItem(){
        ItemStack cItem = new ItemStack(Material.RED_TERRACOTTA);
        ItemMeta cItemMeta = cItem.getItemMeta();

        cItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lCancel"));
        cItemMeta.setUnbreakable(true);
        cItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cItemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        cItem.setItemMeta(cItemMeta);

        return cItem;
    }

}
