package io.github.guru2764.visedit.blockdata;

import io.github.guru2764.visedit.operations.SetOperation;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.block.data.Attachable;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Bamboo;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.block.data.type.Bell;
import org.bukkit.block.data.type.BrewingStand;
import org.bukkit.block.data.type.BubbleColumn;
import org.bukkit.block.data.type.Cake;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.block.data.type.Chest;
import org.bukkit.block.data.type.CommandBlock;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.command.CommandSender;

public class DataCheck {
  public static boolean dataValidate(String data, SetOperation newOperation) {
    BlockData blockData = newOperation.getNewMaterial().createBlockData();
    CommandSender sender = newOperation.getSender();
    String[] dataArray = data.split("\\|");
    if (data.isEmpty())
      return false; 
    for (int i = 0; i < dataArray.length; i++) {
      String dataHeader = StringUtils.substringBeforeLast(dataArray[i], ":");
      String dataContent = StringUtils.substringAfterLast(dataArray[i], ":").toUpperCase();
      switch (dataHeader) {
        case "age":
          if (!validateAge(blockData, dataContent, sender))
            return false; 
          break;
        case "attached":
          if (!validateAttached(blockData, dataContent, sender))
            return false; 
          break;
        case "attachment":
          if (!validateAttachment(blockData, dataContent, sender))
            return false; 
          break;
        case "bites":
          if (!validateBites(blockData, dataContent, sender))
            return false; 
          break;
        case "charges":
          if (!validateCharges(blockData, dataContent, sender))
            return false; 
          break;
        case "conditional":
          if (!validateConditional(blockData, dataContent, sender))
            return false; 
          break;
        case "drag":
          if (!validateDrag(blockData, dataContent, sender))
            return false; 
          break;
        case "facing":
          if (!validateFacing(blockData, dataContent, sender))
            return false; 
          break;
        case "half":
          if (!validateHalf(blockData, dataContent, sender))
            return false; 
          break;
        case "has_bottle_0":
          if (!validateHasBottle(blockData, dataContent, sender, 0))
            return false; 
          break;
        case "has_bottle_1":
          if (!validateHasBottle(blockData, dataContent, sender, 1))
            return false; 
          break;
        case "has_bottle_2":
          if (!validateHasBottle(blockData, dataContent, sender, 2))
            return false; 
          break;
        case "honey_level":
          if (!validateHoneyLevel(blockData, dataContent, sender))
            return false; 
          break;
        case "leaves":
          if (!validateLeaves(blockData, dataContent, sender))
            return false; 
          break;
        case "part":
          if (!validatePart(blockData, dataContent, sender))
            return false; 
          break;
        case "power":
          if (!validatePower(blockData, dataContent, sender))
            return false; 
          break;
        case "signal_fire":
          if (!validateSignalFire(blockData, dataContent, sender))
            return false; 
          break;
        case "type":
          if (!validateType(blockData, dataContent, sender))
            return false; 
          break;
        default:
          return false;
      } 
    } 
    return true;
  }
  
  public static boolean validateAge(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Ageable)) {
      user.sendMessage(ChatColor.RED + "You cannot set an age for this block!");
      return false;
    } 
    try {
      ((Ageable)blockData).setAge(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid age for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateAttached(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Attachable)) {
      user.sendMessage(ChatColor.RED + "You cannot set attached for this block!");
      return false;
    } 
    try {
      ((Attachable)blockData).setAttached(Boolean.valueOf(dataContent).booleanValue());
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid attached for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateAttachment(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Bell)) {
      user.sendMessage(ChatColor.RED + "You cannot set an age for this block!");
      return false;
    } 
    try {
      ((Bell)blockData).setAttachment(Bell.Attachment.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid attachment for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateBites(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Cake)) {
      user.sendMessage(ChatColor.RED + "You cannot set bites for this block!");
      return false;
    } 
    try {
      ((Cake)blockData).setBites(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid bites for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateCharges(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof RespawnAnchor)) {
      user.sendMessage(ChatColor.RED + "You cannot set charges for this block!");
      return false;
    } 
    try {
      ((RespawnAnchor)blockData).setCharges(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid charges for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateConditional(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof CommandBlock)) {
      user.sendMessage(ChatColor.RED + "You cannot set conditional for this block!");
      return false;
    } 
    try {
      ((CommandBlock)blockData).setConditional(Boolean.valueOf(dataContent).booleanValue());
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid conditional for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateDrag(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof BubbleColumn)) {
      user.sendMessage(ChatColor.RED + "You cannot set a drag for this block!");
      return false;
    } 
    try {
      ((BubbleColumn)blockData).setDrag(Boolean.valueOf(dataContent).booleanValue());
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid drag for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateFacing(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Directional)) {
      user.sendMessage(ChatColor.RED + "You cannot set a direction for this block!");
      return false;
    } 
    try {
      ((Directional)blockData).setFacing(BlockFace.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid direction for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateHalf(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Bisected)) {
      user.sendMessage(ChatColor.RED + "You cannot set a half for this block!");
      return false;
    } 
    try {
      ((Bisected)blockData).setHalf(Bisected.Half.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid half for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateHasBottle(BlockData blockData, String dataContent, CommandSender user, int n) {
    if (!(blockData instanceof BrewingStand)) {
      user.sendMessage(ChatColor.RED + "You cannot set has_bottle for this block!");
      return false;
    } 
    try {
      ((BrewingStand)blockData).setBottle(n, Boolean.valueOf(dataContent).booleanValue());
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid has_bottle for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateHoneyLevel(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Beehive)) {
      user.sendMessage(ChatColor.RED + "You cannot set a honey_level for this block!");
      return false;
    } 
    try {
      ((Beehive)blockData).setHoneyLevel(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid honey_level for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateLeaves(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Bamboo)) {
      user.sendMessage(ChatColor.RED + "You cannot set leaves for this block!");
      return false;
    } 
    try {
      ((Bamboo)blockData).setLeaves(Bamboo.Leaves.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid leaves for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validatePart(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Bed)) {
      user.sendMessage(ChatColor.RED + "You cannot set a part for this block!");
      return false;
    } 
    try {
      ((Bed)blockData).setPart(Bed.Part.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid part for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validatePower(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof AnaloguePowerable)) {
      user.sendMessage(ChatColor.RED + "You cannot set an age for this block!");
      return false;
    } 
    try {
      ((AnaloguePowerable)blockData).setPower(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid power level for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateSignalFire(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Campfire)) {
      user.sendMessage(ChatColor.RED + "You cannot set a signal_fire for this block!");
      return false;
    } 
    try {
      ((Campfire)blockData).setSignalFire(Boolean.valueOf(dataContent).booleanValue());
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid signal_fire for this block!");
      return false;
    } 
    return true;
  }
  
  public static boolean validateType(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Chest)) {
      user.sendMessage(ChatColor.RED + "You cannot set a type for this block!");
      return false;
    } 
    try {
      ((Chest)blockData).setType(Chest.Type.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid type for this block!");
      return false;
    } 
    return true;
  }
}

