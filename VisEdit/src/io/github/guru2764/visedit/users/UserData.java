package io.github.guru2764.visedit.users;

import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class UserData {
  public static void incrementNumber(String userName, JavaPlugin plugin) throws IOException {
    Integer newNumber = Integer.valueOf(getNumber(userName, plugin) + 1);
    plugin.getConfig().set("Users." + userName, newNumber);
    plugin.saveConfig();
  }
  
  public static void decrementNumber(String userName, JavaPlugin plugin) throws IOException {
    Integer newNumber = Integer.valueOf(getNumber(userName, plugin) - 1);
    plugin.getConfig().set("Users." + userName, newNumber);
    plugin.saveConfig();
  }
  
  public static int getNumber(String userName, JavaPlugin plugin) throws IOException {
    FileConfiguration config = plugin.getConfig();
    if (config.contains("Users." + userName))
      return config.getInt("Users." + userName); 
    config.set("Users." + userName, Integer.valueOf(0));
    plugin.saveConfig();
    return 0;
  }
}

