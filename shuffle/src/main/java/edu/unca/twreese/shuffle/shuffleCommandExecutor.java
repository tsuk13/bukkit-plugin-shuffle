package edu.unca.twreese.shuffle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        if (args[0].equalsIgnoreCase("shuf")){
        	sender.sendMessage("shuf was called again");
        	return true;
        }
        return false;
    }

}
