package uk.co.anttheantster.antschunkbuster.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.anttheantster.antschunkbuster.AntsChunkBuster;
import uk.co.anttheantster.antschunkbuster.item.ChunkBuster;


public class ACB implements CommandExecutor {

    private AntsChunkBuster plugin;
    private ChunkBuster chunkBuster;
    public ACB(AntsChunkBuster plugin, ChunkBuster chunkBuster){
        this.plugin = plugin;
        this.chunkBuster = chunkBuster;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //020513
        if (!(sender instanceof Player)){
            if (!sender.hasPermission("acb.give.others")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bACB&7]") + ChatColor.RED + "No Permission!");
                return false;
            }
            if (args.length == 2){
                Player target; //040318
                try {
                    target = Bukkit.getPlayerExact(args[0]);
                } catch (Exception e){
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bACB&7]") + ChatColor.RED + "That player is not online or doesn't exist!");
                    return false;
                }

                if (target != null){
                    try {
                        int amount = Integer.parseInt(args[1]);
                        target.getInventory().addItem(chunkBuster.chunkBuster(amount));
                        return false;
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bACB&7]") + ChatColor.RED + "Inventory Full or Invalid Amount!");
                        return false;
                    }
                }

            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bACB&7]") + ChatColor.RED + "Usage: /acb <Player> <Amount>");
            return false;
        }

        //060539
        Player player = (Player) sender;
        try {
            int amount = Integer.parseInt(args[1]);
            if (amount == 0){
                amount = 1;
            }
            player.getInventory().addItem(chunkBuster.chunkBuster(amount));
        } catch (Exception e) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&bACB&7]") + ChatColor.RED + "Inventory Full!");
            return false;
        }
        return false;
    }
}
