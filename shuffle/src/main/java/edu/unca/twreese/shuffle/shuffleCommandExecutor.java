package edu.unca.twreese.shuffle;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;

import com.google.common.base.Joiner;

/*
 * This is a sample CommandExectuor
 */
public class shuffleCommandExecutor implements CommandExecutor {
    private final shuffle plugin;

    /*
     * This command executor needs to know about its plugin from which it came from
     */
    public shuffleCommandExecutor(shuffle plugin) {
        this.plugin = plugin;
    }

    /*
     * On command set the sample message
     */
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
        	return false;
        }
        else if (args[0].equalsIgnoreCase("shuf") && sender instanceof Player){
        	sender.sendMessage("shuf was called again");
        	Player player = (Player) sender;
        	Location loc = player.getLocation();
        	Random rnd = new Random();
        	loc.setX(loc.getX() - 500 + (rnd.nextDouble() * 1000));
        	loc.setZ(loc.getZ() - 500 + (rnd.nextDouble() * 1000));
        	loc.setY(player.getWorld().getHighestBlockYAt(loc));
        	player.teleport(loc);
        	return true;
        }
        else if (args[0].equalsIgnoreCase("rain") && sender instanceof Player){
        	sender.sendMessage("MAKE It RAIN!!!");
        	Player player = (Player) sender;
        	player.getWorld().setStorm(true);
        	return true;
        }
        else if (args[0].equalsIgnoreCase("oprahpig") && args.length == 2){
        	Player player = Bukkit.getPlayer(args[1]);
        	player.getWorld().spawnCreature(player.getLocation(), CreatureType.PIG);
        	player.sendMessage("YOU GET A PIG!!!!");
        	return true;
        }
        return false;
    }

}
