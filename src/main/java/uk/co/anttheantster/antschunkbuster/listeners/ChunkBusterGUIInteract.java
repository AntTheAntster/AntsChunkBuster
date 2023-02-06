package uk.co.anttheantster.antschunkbuster.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import uk.co.anttheantster.antschunkbuster.AntsChunkBuster;
import uk.co.anttheantster.antschunkbuster.menu.ChunkBusterGUI;

//060504
public class ChunkBusterGUIInteract implements Listener {

    private AntsChunkBuster plugin;
    private ChunkBusterGUI gui;
    private ChunkBusterInteract interact;
    public ChunkBusterGUIInteract(AntsChunkBuster plugin, ChunkBusterGUI gui, ChunkBusterInteract interact){
        this.plugin = plugin;
        this.gui = gui;
        this.interact = interact;
    }

    @EventHandler
    public void guiInteract(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();

        if (!e.getInventory().equals(gui.gui(null))){
            return;
        }
        if (e.getCurrentItem().equals(gui.fillItem())){
            e.setCancelled(true);
            return;
        }
        if (e.getCurrentItem().equals(gui.confirmItem())){
            e.setCancelled(true);
            e.getWhoClicked().closeInventory();
            interact.destroyChunk(player);
        }
        if (e.getCurrentItem().equals(gui.cancelItem())){
            e.setCancelled(true);
            e.getWhoClicked().closeInventory();
        }
    }

}
