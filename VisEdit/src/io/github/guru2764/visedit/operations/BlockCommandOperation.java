package io.github.guru2764.visedit.operations;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockCommandOperation {
  private CommandSender sender;
  
  protected JavaPlugin plugin;
  
  World world;
  
  public BlockCommandOperation(CommandSender newSender, JavaPlugin newPlugin, World newWorld) {
    setSender(newSender);
    setPlugin(newPlugin);
    setWorld(newWorld);
  }
  
  public void setSender(CommandSender newSender) {
    this.sender = newSender;
  }
  
  public CommandSender getSender() {
    return this.sender;
  }
  
  public String getUserName() {
    return this.sender.getName();
  }
  
  public void setPlugin(JavaPlugin newPlugin) {
    this.plugin = newPlugin;
  }
  
  public JavaPlugin getPlugin() {
    return this.plugin;
  }
  
  public void setWorld(World newWorld) {
    this.world = newWorld;
  }
  
  public World getWorld() {
    return this.world;
  }
}

