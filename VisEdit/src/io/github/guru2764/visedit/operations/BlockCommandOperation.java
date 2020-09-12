package io.github.guru2764.visedit.operations;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

//Common Class all block-related commands can share
public class BlockCommandOperation {
  
  //Variables
  private CommandSender sender;
  protected JavaPlugin plugin;
  World world;
  
  //Constructor
  public BlockCommandOperation(CommandSender newSender, JavaPlugin newPlugin, World newWorld) {
    setSender(newSender);
    setPlugin(newPlugin);
    setWorld(newWorld);
  }
  
  //Sender Methods
  public void setSender(CommandSender newSender) {
    this.sender = newSender;
  }
  public CommandSender getSender() {
    return this.sender;
  }
  
  //Username Method
  public String getUserName() {
    return this.sender.getName();
  }
  
  //Plugin Methods
  public void setPlugin(JavaPlugin newPlugin) {
    this.plugin = newPlugin;
  }
  public JavaPlugin getPlugin() {
    return this.plugin;
  }
  
  //World Methods
  public void setWorld(World newWorld) {
    this.world = newWorld;
  }
  public World getWorld() {
    return this.world;
  }
}

