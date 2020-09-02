package ma.saj.piglinkiller;

import java.util.Iterator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		getLogger().info("Piglin Killer is ready!");
	}

	public void onDisable() {
		getLogger().info("Piglin killer is disabled!");
	}

	
	public void sajtry(CommandSender sender, Command cmd, String label, String[] args) {//doesn't work!
		if(cmd.getName().equalsIgnoreCase("kp")) {
			String world = ((Entity)sender).getWorld().getName();
			for (Iterator<Entity> iterator = getServer().getWorld(world).getEntities().iterator(); iterator.hasNext();) {
				Entity entity = iterator.next();
				String target_name = entity.getName();
				if(target_name == "Piglin") {
					entity.remove();
				}
			}
		}
	}

	
	public void forkfromkam(CommandSender sender, Command cmd, String label, String[] args) {
		//public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof org.bukkit.entity.Player) {
			if (cmd.getName().equalsIgnoreCase("kp")) {
				String world = ((Entity)sender).getWorld().getName();
				for (Iterator<Entity> iterator = getServer().getWorld(world).getEntities().iterator(); iterator.hasNext(); ) {
					Entity entity = iterator.next();
					String mob = entity.getType().toString();
					if (getConfig().getStringList("Hostile").contains(mob))
						entity.remove(); 
				} 
				sender.sendMessage("PiglinKiller was just used.");
				//  return true;
			}
		}
		else {
			sender.sendMessage("You must be a player to use this command!");
		}
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		//sajtry(sender, cmd, label, args);
		forkfromkam(sender, cmd, label, args);
		return true;
	}
	
}