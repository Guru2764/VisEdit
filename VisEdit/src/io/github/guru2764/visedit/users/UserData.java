package io.github.guru2764.visedit.users;

import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

//Methods for interacting with user number (the state of the world they are currently in)
public class UserData {

  //Adds one to current number (redo/set)
  public static void incrementNumber(String userName, JavaPlugin plugin) throws IOException {
    Integer newNumber = Integer.valueOf(getNumber(userName, plugin) + 1);
    plugin.getConfig().set("Users." + userName, newNumber);
    plugin.saveConfig();
  }
  
  //Subtracts one from current number (undo)
  public static void decrementNumber(String userName, JavaPlugin plugin) throws IOException {
    Integer newNumber = Integer.valueOf(getNumber(userName, plugin) - 1);
    plugin.getConfig().set("Users." + userName, newNumber);
    plugin.saveConfig();
  }
  
  //Gets current number
  public static int getNumber(String userName, JavaPlugin plugin) throws IOException {
    FileConfiguration config = plugin.getConfig();
    if (config.contains("Users." + userName))
      return config.getInt("Users." + userName); 
    config.set("Users." + userName, Integer.valueOf(0));
    plugin.saveConfig();
    return 0;
  }
}

