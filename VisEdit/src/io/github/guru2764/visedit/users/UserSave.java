package io.github.guru2764.visedit.users;

import io.github.guru2764.visedit.blockdata.BlockCheck;
import io.github.guru2764.visedit.operations.RedoOperation;
import io.github.guru2764.visedit.operations.SetOperation;
import io.github.guru2764.visedit.operations.UndoOperation;
import io.github.guru2764.visedit.users.UserData;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

public class UserSave {
	
  //Saves selection when doing select
  public static void userSave(SetOperation newOperation) throws IOException {
    
	//Variable gathering  
	JavaPlugin plugin = newOperation.getPlugin();
    World world = newOperation.getWorld();
    int[] coords = newOperation.getCoords();
    String userName = newOperation.getUserName();
    Integer currentNumber = Integer.valueOf(UserData.getNumber(userName, plugin));
    File playerFile = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + currentNumber + ".yml");
    
    //Checks if there is a user file
    if (!playerFile.exists())
      try {
        playerFile.createNewFile();
      } catch (IOException e) {
        Bukkit.getLogger().info("[VisEdit] There was a problem making the save file for " + userName + "!");
      }  
    
    //For loop to write to file
    PrintWriter writer = new PrintWriter(playerFile);
    writer.println(world.getName());
    for (int y = coords[2]; y <= coords[3]; y++) {
      for (int z = coords[4]; z <= coords[5]; z++) {
        for (int x = coords[0]; x <= coords[1]; x++) {
          Block currentBlock = world.getBlockAt(x, y, z);
          edit(writer, currentBlock, userName);
        } 
      } 
    } 
    UserData.incrementNumber(userName, plugin);
    writer.close();
  }
  
  //Saves selection when doing undo
  public static void userSave(UndoOperation newOperation) throws IOException {
	  
	//Variable gathering
    JavaPlugin plugin = newOperation.getPlugin();
    World world = newOperation.getWorld();
    int[] coords = newOperation.getCoords();
    String userName = newOperation.getUserName();
    Integer currentNumber = Integer.valueOf(UserData.getNumber(userName, plugin));
    File playerFile = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + currentNumber + ".yml");
    
    //Checks to see if player file exists
    if (!playerFile.exists())
      try {
        playerFile.createNewFile();
      } catch (IOException e) {
        Bukkit.getLogger().info("[VisEdit] There was a problem making the save file for " + userName + "!");
      }
    
    //For loop to write blocks to file
    PrintWriter writer = new PrintWriter(playerFile);
    writer.println(world.getName());
    for (int y = coords[2]; y <= coords[3]; y++) {
      for (int z = coords[4]; z <= coords[5]; z++) {
        for (int x = coords[0]; x <= coords[1]; x++) {
          Block currentBlock = world.getBlockAt(x, y, z);
          edit(writer, currentBlock, userName);
        } 
      } 
    } 
    UserData.incrementNumber(userName, plugin);
    Bukkit.getLogger().info("[VisEdit] Save was successful for " + userName + "!");
    writer.close();
  }
  
  //Saves selection when doing redo
  public static void userSave(RedoOperation newOperation) throws IOException {
    
	//Variable gathering  
	JavaPlugin plugin = newOperation.getPlugin();
    World world = newOperation.getWorld();
    int[] coords = newOperation.getCoords();
    String userName = newOperation.getUserName();
    Integer currentNumber = Integer.valueOf(UserData.getNumber(userName, plugin));
    File playerFile = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + currentNumber + ".yml");
    
    //Checks to see if player file exists
    if (!playerFile.exists())
      try {
        playerFile.createNewFile();
      } catch (IOException e) {
        Bukkit.getLogger().info("[VisEdit] There was a problem making the save file for " + userName + "!");
      }  
    
    //For loop to write blocks to file
    PrintWriter writer = new PrintWriter(playerFile);
    writer.println(world.getName());
    for (int y = coords[2]; y <= coords[3]; y++) {
      for (int z = coords[4]; z <= coords[5]; z++) {
        for (int x = coords[0]; x <= coords[1]; x++) {
          Block currentBlock = world.getBlockAt(x, y, z);
          edit(writer, currentBlock, userName);
        } 
      } 
    } 
    UserData.incrementNumber(userName, plugin);
    Bukkit.getLogger().info("[VisEdit] Save was successful for " + userName + "!");
    writer.close();
  }
  
  
  //Writes to file 
  protected static void edit(PrintWriter writer, Block block, String user) {
    writer.println(block.getX() + " " + block.getY() + " " + block.getZ() + " " + block
        .getBlockData().getMaterial().toString() + BlockCheck.getData(block));
  }
}

