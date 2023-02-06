package uk.co.anttheantster.antschunkbuster.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import uk.co.anttheantster.antschunkbuster.AntsChunkBuster;
import uk.co.anttheantster.antschunkbuster.item.ChunkBuster;
import uk.co.anttheantster.antschunkbuster.menu.ChunkBusterGUI;

//110507
public class ChunkBusterInteract implements Listener {

    private AntsChunkBuster plugin;
    private ChunkBuster chunkBuster;
    private ChunkBusterGUI gui;
    public ChunkBusterInteract(AntsChunkBuster plugin, ChunkBuster chunkBuster, ChunkBusterGUI gui){
        this.plugin = plugin;
        this.chunkBuster = chunkBuster;
        this.gui = gui;
    }
    public Block block;

    @EventHandler
    public void playerInteract(PlayerInteractEvent e){
        block = e.getClickedBlock();
        ItemStack cBuster = chunkBuster.chunkBuster(1);
        if (block.equals(cBuster)){
            e.getPlayer().openInventory(gui.gui(e.getPlayer()));
        }
    }

    public void destroyChunk(Player player){
        Chunk chunk = block.getChunk();
        World world = chunk.getWorld();
        player.sendMessage(ChatColor.GREEN + "Chunk Destroying in " + plugin.getConfig().getInt("ChunkBuster.Timer") + " seconds");

        new BukkitRunnable() {
            @Override
            public void run(){
                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        for (int y = 0; y < 255; y++) {
                            if (!plugin.getConfig().getBoolean("ChunkBuster.DestroyBedrock")) {
                                if (world.getBlockAt(chunk.getBlock(x, 0, z).getLocation().add(0, y, 0)).getType() != Material.BEDROCK) {
                                    world.getBlockAt(chunk.getBlock(x, 0, z).getLocation().add(0, y, 0)).setType(Material.AIR);
                                }
                            }
                            world.getBlockAt(chunk.getBlock(x, 0, z).getLocation().add(0, y, 0)).setType(Material.AIR);
                        }
                    }
                }
            }
        }.runTaskLater(plugin, plugin.getConfig().getInt("ChunkBuster.Timer") * 20);

    }

}
