package edu.unca.twreese.shuffle;

import java.text.MessageFormat;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/*
 * This is a sample event listener
 */
public class shuffleListener implements Listener {
    private final shuffle plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public shuffleListener(shuffle plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("shuffle.message"));
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        final EntityType entityType = event.getRightClicked().getType();

        event.getPlayer().sendMessage(MessageFormat.format(
                "You interacted with a {0} it has an id of {1}",
                entityType.getName(),
                entityType.getTypeId()));
    }
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
    	Location loc = new Location(event.getPlayer().getWorld(), 0, 0, 0);
    	Random rnd = new Random();
    	loc.setX(loc.getX() - 500 + (rnd.nextDouble() * 1000));
    	loc.setZ(loc.getZ() - 500 + (rnd.nextDouble() * 1000));
    	loc.setY(event.getPlayer().getWorld().getHighestBlockYAt(loc));
    	event.setRespawnLocation(loc);
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
    	Location dest = event.getTo();
    	if(dest.getBlockX() > 500 || dest.getBlockX() < -500 || dest.getBlockZ() > 500 || dest.getBlockZ() < -500){
    		event.getPlayer().teleport(event.getFrom());
    	}
    	
    }
}
