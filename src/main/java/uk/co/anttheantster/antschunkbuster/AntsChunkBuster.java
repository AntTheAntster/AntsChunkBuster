package uk.co.anttheantster.antschunkbuster;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.antschunkbuster.commands.ACB;
import uk.co.anttheantster.antschunkbuster.item.ChunkBuster;
import uk.co.anttheantster.antschunkbuster.listeners.ChunkBusterGUIInteract;
import uk.co.anttheantster.antschunkbuster.listeners.ChunkBusterInteract;
import uk.co.anttheantster.antschunkbuster.menu.ChunkBusterGUI;

//171201
public class AntsChunkBuster extends JavaPlugin {

    PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setup();
    }

    @Override
    public void onDisable() {

    }

    private void setup(){
        ChunkBuster chunkBuster = new ChunkBuster(this);
        ChunkBusterGUI chunkBusterGUI = new ChunkBusterGUI(this);
        ChunkBusterInteract chunkBusterInteract = new ChunkBusterInteract(this, chunkBuster, chunkBusterGUI);


        getCommand("acb").setExecutor(new ACB(this, chunkBuster));

        pm.registerEvents(new ChunkBusterInteract(this, chunkBuster, chunkBusterGUI), this);
        pm.registerEvents(new ChunkBusterGUIInteract(this, chunkBusterGUI, chunkBusterInteract), this);
        pm.registerEvents(new ChunkBusterInteract(this, chunkBuster, chunkBusterGUI), this);

        saveDefaultConfig();
    }
}
//040318
