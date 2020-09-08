package io.github.guru2764.visedit;

import io.github.guru2764.visedit.blockdata.DataSet;
import io.github.guru2764.visedit.operations.RedoOperation;
import io.github.guru2764.visedit.operations.SetOperation;
import io.github.guru2764.visedit.operations.UndoOperation;
import io.github.guru2764.visedit.users.UserData;
import io.github.guru2764.visedit.users.UserSave;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandOperations {
	
  //vset command
  public static void vSet(SetOperation newOperation) {
	  
	//Variable gathering
    JavaPlugin plugin = newOperation.getPlugin();
    String userName = newOperation.getUserName();
    World world = newOperation.getWorld();
    Material material = newOperation.getNewMaterial();
    FileConfiguration config = plugin.getConfig();
    int tempNumber = 0;
    boolean fileExists = true;
    
    //Checks if is using locations or if coordinates inputted
    if (newOperation.isUsingLocation())
      newOperation.setCoords((int)newOperation.getLoc1().getX(), (int)newOperation.getLoc1().getY(), 
          (int)newOperation.getLoc1().getZ(), (int)newOperation.getLoc2().getX(), 
          (int)newOperation.getLoc2().getY(), (int)newOperation.getLoc2().getZ()); 
    int[] coords = newOperation.getCoords();
    
    //Gets the total number of blocks being replaced
    int count = (coords[1] - coords[0] + 1) * (coords[3] - coords[2] + 1) * (coords[5] - coords[4] + 1);
    config.set("PlayerCoords." + userName + ".world", world.getName());
    config.set("PlayerCoords." + userName + ".x1", Integer.valueOf(coords[0]));
    config.set("PlayerCoords." + userName + ".y1", Integer.valueOf(coords[2]));
    config.set("PlayerCoords." + userName + ".z1", Integer.valueOf(coords[4]));
    config.set("PlayerCoords." + userName + ".x2", Integer.valueOf(coords[1]));
    config.set("PlayerCoords." + userName + ".y2", Integer.valueOf(coords[3]));
    config.set("PlayerCoords." + userName + ".z2", Integer.valueOf(coords[5]));
    plugin.saveConfig();
    
    //Deletes any saves after this one (Undo/Redo Logic)
    try {
      tempNumber = UserData.getNumber(userName, plugin);
      while (fileExists) {
        File newFile = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + tempNumber + ".yml");
        if (newFile.exists()) {
          Files.delete(newFile.toPath());
          tempNumber++;
          continue;
        } 
        fileExists = false;
      } 
    } catch (IOException ioe) {
      Bukkit.getLogger().warning("[VisEdit] Error While Cleaning Up Files! - Command Issued By User: " + userName);
    } 
    
    //Attempts to save the existing world blocks (Undo/Redo Logic)
    try {
      UserSave.userSave(newOperation);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } 
    
    //Console message
    Bukkit.getLogger().info("[VisEdit] " + userName + " is attempting to replace " + count + " blocks from (" + coords[0] + ", " + coords[2] + ", " + coords[4] + ") to (" + coords[1] + ", " + coords[3] + ", " + coords[5] + ") with " + material
        .toString());
    
    //Triple For Loop to set each block, with or without data
    if (newOperation.isValidData()) {
      for (int y = coords[2]; y <= coords[3]; y++) {
        for (int z = coords[4]; z <= coords[5]; z++) {
          for (int x = coords[0]; x <= coords[1]; x++) {
            Block currentBlock = world.getBlockAt(x, y, z);
            currentBlock.setType(material);
            DataSet.dataSet(currentBlock, newOperation.getNewData());
          } 
        } 
      } 
    } else {
      for (int y = coords[2]; y <= coords[3]; y++) {
        for (int z = coords[4]; z <= coords[5]; z++) {
          for (int x = coords[0]; x <= coords[1]; x++) {
            Block currentBlock = world.getBlockAt(x, y, z);
            currentBlock.setType(material);
          } 
        } 
      } 
    } 
    
    //Success messages
    Bukkit.getLogger().info("[VisEdit] " + userName + " successfully replaced " + count + " blocks.");
    newOperation.getSender().sendMessage(ChatColor.DARK_AQUA + "You successfully replaced " + count + " blocks!");
  }
  
  //vundo command
  public static void vUndo(UndoOperation newOperation) {
	  
	//Variable gathering
    String userName = newOperation.getUserName();
    JavaPlugin plugin = newOperation.getPlugin();
    CommandSender sender = newOperation.getSender();
    int newNumber = newOperation.getNumber() - 1;
    
    //Saves the current world blocks if they have not been saved before (Undo/Redo Logic)
    try {
      File newFile = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + UserData.getNumber(userName, plugin) + ".yml");
      if (!newFile.exists()) {
        UserSave.userSave(newOperation);
        UserData.decrementNumber(userName, plugin);
      } 
      
      //Reads the file and performs the undo operation
      if (newNumber >= 0) {
        readFile(newOperation, newNumber);
        UserData.decrementNumber(userName, plugin);
        
      //No saved files found
      } else {
        sender.sendMessage(ChatColor.RED + "Nothing left to undo!");
      } 
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  //vredo command
  public static void vRedo(RedoOperation newOperation) {
	  
	//Variable gathering
    String userName = newOperation.getUserName();
    JavaPlugin plugin = newOperation.getPlugin();
    CommandSender sender = newOperation.getSender();
    int newNumber = newOperation.getNumber() + 1;
    try {
      File playerFile = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + newNumber + ".yml");
      if (playerFile.exists()) {
        readFile(newOperation, newNumber);
        UserData.incrementNumber(userName, plugin);
        File file = new File(plugin.getDataFolder() + "/userdata/" + userName + "-" + (newNumber + 1) + ".yml");
        if (!file.exists())
          Files.delete(playerFile.toPath()); 
        
      //No save files found
      } else {
        sender.sendMessage(ChatColor.RED + "Nothing left to redo!");
      } 
    } catch (IOException e) {
      Bukkit.getLogger().info("[VisEdit] Something went wrong trying to redo operations for " + userName + "!");
      e.printStackTrace();
    } 
  }
  
  public static void readFile(UndoOperation newOperation, int number) {
    File playerFile = new File(newOperation.getPlugin().getDataFolder() + "/userdata/" + newOperation.getUserName() + "-" + number + ".yml");
    Integer x = Integer.valueOf(0), y = Integer.valueOf(0), z = Integer.valueOf(0);
    try {
      Scanner input = new Scanner(playerFile);
      World world = Bukkit.getServer().getWorld(input.nextLine());
      String line;
      while (input.hasNextLine() && !(line = input.nextLine()).isEmpty()) {
        Scanner lineScanner = new Scanner(line);
        x = Integer.valueOf(lineScanner.nextInt());
        y = Integer.valueOf(lineScanner.nextInt());
        z = Integer.valueOf(lineScanner.nextInt());
        Material material = Material.matchMaterial(lineScanner.next());
        Block currentBlock = world.getBlockAt(x.intValue(), y.intValue(), z.intValue());
        String dataLine;
        if (lineScanner.hasNext() && !(dataLine = lineScanner.next()).isEmpty()) {
          currentBlock.setType(material);
          DataSet.dataSet(currentBlock, dataLine);
        } else {
          currentBlock.setType(material);
        } 
        lineScanner.close();
      } 
      input.close();
    } catch (FileNotFoundException e) {
      Bukkit.getLogger().info("[VisEdit] Something went wrong trying to read file for undo!");
      e.printStackTrace();
    } 
  }
  
  public static void readFile(RedoOperation newOperation, int number) {
    File playerFile = new File(newOperation.getPlugin().getDataFolder() + "/userdata/" + newOperation.getUserName() + "-" + number + ".yml");
    Integer x = Integer.valueOf(0), y = Integer.valueOf(0), z = Integer.valueOf(0);
    try {
      Scanner input = new Scanner(playerFile);
      World world = Bukkit.getServer().getWorld(input.nextLine());
      String line;
      while (input.hasNextLine() && !(line = input.nextLine()).isEmpty()) {
        Scanner lineScanner = new Scanner(line);
        x = Integer.valueOf(lineScanner.nextInt());
        y = Integer.valueOf(lineScanner.nextInt());
        z = Integer.valueOf(lineScanner.nextInt());
        Material material = Material.matchMaterial(lineScanner.next());
        Block currentBlock = world.getBlockAt(x.intValue(), y.intValue(), z.intValue());
        String dataLine;
        if (lineScanner.hasNext() && !(dataLine = lineScanner.next()).isEmpty()) {
          currentBlock.setType(material);
          DataSet.dataSet(currentBlock, dataLine);
        } else {
          currentBlock.setType(material);
        } 
        lineScanner.close();
      } 
      input.close();
    } catch (FileNotFoundException e) {
      Bukkit.getLogger().info("[VisEdit] Something went wrong trying to read file for redo!");
      e.printStackTrace();
    } 
  }
}

