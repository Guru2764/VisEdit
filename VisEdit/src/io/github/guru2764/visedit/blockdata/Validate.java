package io.github.guru2764.visedit.blockdata;

import io.github.guru2764.visedit.blockdata.DataCheck;
import io.github.guru2764.visedit.operations.RedoOperation;
import io.github.guru2764.visedit.operations.SetOperation;
import io.github.guru2764.visedit.operations.UndoOperation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;

public class Validate {
  
  //Validates the set command
  public static boolean setValidate(String[] args, SetOperation newOperation) {
    
	//Ensures command is run by player 
	CommandSender sender = newOperation.getSender();
    if (!(sender instanceof org.bukkit.entity.Player)) {
      sender.sendMessage("This command can only be run by a player.");
      return false;
    } 
    switch (args.length) {
      
      //vset [material]
      case 1:
        if (savedPositions(newOperation) == 2) {
          if (validMaterial(args[0], newOperation))
            return true; 
          return false;
        } 
        sender.sendMessage("Please save two positions or specify coordinates!");
        return false;
        
      //vset [material] [data]
      case 2:
        if (savedPositions(newOperation) == 2) {
          if (validMaterial(args[0], newOperation)) {
            if (validData(args[1], newOperation))
              return true; 
            return false;
          } 
          return false;
        } 
        sender.sendMessage("Please save two positions or specify coordinates!");
        return false;
        
      //vset [x1] [y1] [z1] [material] 
      case 4:
        if (validCoords(args, 3, newOperation)) {
          newOperation.setOneBlock(true);
          if (validMaterial(args[3], newOperation))
            return true; 
          return false;
        } 
        return false;
        
      //vset [x1] [y1] [z1] [material] [data]
      case 5:
        if (validCoords(args, 3, newOperation)) {
          newOperation.setOneBlock(true);
          if (validMaterial(args[3], newOperation)) {
            if (validData(args[4], newOperation))
              return true; 
            return false;
          } 
          return false;
        } 
        return false;
      
      //vset [x1] [y1] [z1] [x2] [y2] [z2] [material] 
      case 7:
        if (validCoords(args, 6, newOperation)) {
          if (validMaterial(args[6], newOperation))
            return true; 
          return false;
        } 
        return false;
      
      //vset [x1] [y1] [z1] [x2] [y2] [z2] [material] [data]  
      case 8:
        if (validCoords(args, 6, newOperation)) {
          if (validMaterial(args[6], newOperation)) {
            if (validData(args[7], newOperation))
              return true; 
            return false;
          } 
          return false;
        } 
        return false;
    } 
    sender.sendMessage(ChatColor.RED + "Incorrect amount of arguments!");
    return false;
  }
  
  //Validates the undo command
  public static boolean undoValidate(String[] args, UndoOperation newOperation) {
    switch (args.length) {
      
      //vundo
      case 0:
        return true;
      
      //vundo [number]
      case 1:
        try {
          Integer.parseInt(args[0]);
        } catch (NumberFormatException|NullPointerException Exception) {
          newOperation.getSender().sendMessage(ChatColor.RED + "Not a valid number!");
          return false;
        } 
        if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[0]) > newOperation.getPlugin().getConfig().getInt("Settings.MaxOperations")) {
          newOperation.getSender().sendMessage(ChatColor.RED + "You cannot undo this many operations at once!");
          return false;
        } 
        newOperation.setIterations(Integer.parseInt(args[0]));
        return true;
    } 
    newOperation.getSender().sendMessage(ChatColor.RED + "Incorrect amount of arguments!");
    return false;
  }
  
  //Validates the redo command
  public static boolean redoValidate(String[] args, RedoOperation newOperation) {
    switch (args.length) {
      
      //vredo
      case 0:
        return true;
        
      //vredo [number]
      case 1:
        try {
          Integer.parseInt(args[0]);
        } catch (NumberFormatException|NullPointerException Exception) {
          newOperation.getSender().sendMessage(ChatColor.RED + "Not a valid number!");
          return false;
        } 
        if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[0]) > newOperation.getPlugin().getConfig().getInt("Settings.MaxOperations")) {
          newOperation.getSender().sendMessage(ChatColor.RED + "You cannot redo this many operations at once!");
          return false;
        } 
        newOperation.setIterations(Integer.parseInt(args[0]));
        return true;
    } 
    newOperation.getSender().sendMessage(ChatColor.RED + "Incorrect amount of arguments!");
    return false;
  }
  
  private static boolean validCoords(String[] coords, int n, SetOperation newOperation) {
    
	//Tests that each coordinate is an integer
	try {
      for (int k = 0; k < n; k++) {
        @SuppressWarnings("unused")
		int i = Integer.parseInt(coords[k]); 
      }
    } catch (NumberFormatException|NullPointerException Exception) {
      newOperation.getSender().sendMessage(ChatColor.RED + "One or more invalid coordinates!");
      return false;
    } 
	
	//For 3 coordinates
    if (n == 3) {
      if (Integer.parseInt(coords[1]) < 0 || Integer.parseInt(coords[1]) > 255) {
        newOperation.getSender().sendMessage(ChatColor.RED + "Invalid Y Coordinate!");
        return false;
      } 
      newOperation.setCoords(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]));
      return true;
    } 
    
    //For 6 coordinates
    if (Integer.parseInt(coords[1]) < 0 || Integer.parseInt(coords[1]) > 255 || Integer.parseInt(coords[4]) < 0 || Integer.parseInt(coords[4]) > 255) {
      newOperation.getSender().sendMessage(ChatColor.RED + "Invalid Y Coordinate!");
      return false;
    } 
    newOperation.setCoords(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), Integer.parseInt(coords[2]), 
        Integer.parseInt(coords[3]), Integer.parseInt(coords[4]), Integer.parseInt(coords[5]));
    return true;
  }
  
  //Checks how many locations are set
  private static int savedPositions(SetOperation newOperation) {
    int numOfPositions = 0;
    if (newOperation.getLoc1() != null) {
      numOfPositions++;
      newOperation.setUsingLocation(true);
    } 
    if (newOperation.getLoc2() != null) {
      numOfPositions++;
      newOperation.setUsingLocation(true);
    } 
    return numOfPositions;
  }
  
  //Checks if is valid material
  private static boolean validMaterial(String material, SetOperation newOperation) {
    
	//Checks if material is a block
	try {
      if (!Material.matchMaterial(material).isBlock()) {
        newOperation.getSender().sendMessage(ChatColor.RED + material + " is not a valid block!");
        return false;
      } 
    } catch (NullPointerException npe) {
      newOperation.getSender().sendMessage(ChatColor.RED + material + " is not a valid material!");
      return false;
    } 
    newOperation.setNewMaterial(Material.matchMaterial(material));
    return true;
  }
  
  //Sends data off to be validated
  private static boolean validData(String data, SetOperation newOperation) {
    if (!DataCheck.dataValidate(data, newOperation))
      return false; 
    newOperation.setValidData(true);
    newOperation.setNewData(data);
    return true;
  }
}

