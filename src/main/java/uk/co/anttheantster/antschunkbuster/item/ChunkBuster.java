package uk.co.anttheantster.antschunkbuster.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.anttheantster.antschunkbuster.AntsChunkBuster;

public class ChunkBuster {

    private AntsChunkBuster plugin;
    public ChunkBuster(AntsChunkBuster plugin){
        this.plugin = plugin;
    }

    public ItemStack chunkBuster(int amount) {
        ItemStack cBuster = new ItemStack(Material.getMaterial(plugin.getConfig().getString("ChunkBuster.BlockItem")), amount);
        ItemMeta cBusterMeta = cBuster.getItemMeta();
        cBusterMeta.setUnbreakable(true);
        cBusterMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ChunkBuster.Name")));
        cBusterMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        cBusterMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cBusterMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        cBusterMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        cBuster.setItemMeta(cBusterMeta);

        return cBuster;
    }

}
