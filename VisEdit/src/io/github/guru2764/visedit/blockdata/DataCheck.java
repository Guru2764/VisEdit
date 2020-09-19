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
import org.bukkit.block.data.FaceAttachable;
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
import org.bukkit.block.data.type.Comparator;
import org.bukkit.block.data.type.DaylightDetector;
import org.bukkit.block.data.type.Dispenser;
import org.bukkit.block.data.type.Door;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.block.data.type.Farmland;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.command.CommandSender;

public class DataCheck {
  
  //Main validation method
  public static boolean dataValidate(String data, SetOperation newOperation) {
    
	//Variable gathering 
	BlockData blockData = newOperation.getNewMaterial().createBlockData();
    CommandSender sender = newOperation.getSender();
    
    //Splits data pieces
    String[] dataArray = data.split("\\|");
    if (data.isEmpty())
      return false; 
    
    //Splits data and sends each piece to be validated
    for (int i = 0; i < dataArray.length; i++) {
      String dataHeader = StringUtils.substringBeforeLast(dataArray[i], ":");
      String dataContent = StringUtils.substringAfterLast(dataArray[i], ":").toUpperCase();
      
      //Big switch statement for each possible input
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
        case "distance":
          if (!validateDistance(blockData, dataContent, sender))
            return false; 
          break;
        case "drag":
          if (!validateDrag(blockData, dataContent, sender))
            return false; 
          break;
        case "enabled":
          if (!validateEnabled(blockData, dataContent, sender))
            return false; 
          break;
        case "eye":
          if (!validateEye(blockData, dataContent, sender))
            return false; 
          break;
        case "face":
          if (!validateFace(blockData, dataContent, sender))
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
        case "has_book":
          if (!validateHasBook(blockData, dataContent, sender))
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
        case "has_record":
          if (!validateHasRecord(blockData, dataContent, sender))
            return false; 
          break;
        case "hanging":
          if (!validateHanging(blockData, dataContent, sender))
            return false; 
          break;
        case "hinge":
          if (!validateHinge(blockData, dataContent, sender))
            return false; 
          break;
        case "honey_level":
          if (!validateHoneyLevel(blockData, dataContent, sender))
            return false; 
          break;
        case "inverted":
          if (!validateInverted(blockData, dataContent, sender))
            return false; 
          break;
        case "in_wall":
          if (!validateInWall(blockData, dataContent, sender))
            return false; 
          break;
        case "leaves":
          if (!validateLeaves(blockData, dataContent, sender))
            return false; 
          break;
        case "level":
            if (!validateLevel(blockData, dataContent, sender))
              return false; 
            break;
        case "lit":
            if (!validateLit(blockData, dataContent, sender))
              return false; 
            break;
        case "mode":
          if (!validateMode(blockData, dataContent, sender))
            return false; 
          break;
        case "moisture":
          if (!validateMoisture(blockData, dataContent, sender))
            return false; 
          break;
        case "orientation":
          if (!validateOrientation(blockData, dataContent, sender))
            return false; 
          break;
        case "part":
          if (!validatePart(blockData, dataContent, sender))
            return false; 
          break;
        case "persistent":
          if (!validatePersistant(blockData, dataContent, sender))
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
        case "triggered":
          if (!validateTriggered(blockData, dataContent, sender))
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
  
  //Validates age:
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
  
  //Validates attached:
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
  
  //Validates attachment:
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
  
  //Validates bites:
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
  
  //Validates charges:
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
  
  //Validates conditional:
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
  
  //Validates drag:
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
  
  //Validates eye:
  public static boolean validateEye(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof EndPortalFrame)) {
      user.sendMessage(ChatColor.RED + "You cannot set an eye for this block!");
      return false;
    } 
    try {
      ((EndPortalFrame)blockData).setEye(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid eye for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates face:
  public static boolean validateFace(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof FaceAttachable)) {
      user.sendMessage(ChatColor.RED + "You cannot set a face for this block!");
      return false;
    } 
    try {
      ((FaceAttachable)blockData).setAttachedFace(FaceAttachable.AttachedFace.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid face for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates facing:
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
  
  //Validates half:
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
  
  //Validates has_bottle_x:
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
  
  //Validates hinge:
  public static boolean validateHinge(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Door)) {
      user.sendMessage(ChatColor.RED + "You cannot set a hinge for this block!");
      return false;
    } 
    try {
      ((Door)blockData).setHinge(Door.Hinge.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid honey_level for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates honey_level:
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
  
  //Validates inverted:
  public static boolean validateInverted(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof DaylightDetector)) {
      user.sendMessage(ChatColor.RED + "You cannot set inverted for this block!");
      return false;
    } 
    try {
      ((DaylightDetector)blockData).setInverted(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid inverted for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates leaves:
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
  
  //Validates mode:
  public static boolean validateMode(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Comparator)) {
      user.sendMessage(ChatColor.RED + "You cannot set a mode for this block!");
      return false;
    } 
    try {
      ((Comparator)blockData).setMode(Comparator.Mode.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid mode for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates moisture:
  public static boolean validateMoisture(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Farmland)) {
      user.sendMessage(ChatColor.RED + "You cannot set a moisture for this block!");
      return false;
    } 
    try {
      ((Farmland)blockData).setMoisture(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid moisture for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates part:
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
  
  //Validates power:
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
  
  //Validates signal_fire:
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
  
  //Validates triggered:
  public static boolean validateTriggered(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Dispenser)) {
      user.sendMessage(ChatColor.RED + "You cannot set triggered for this block!");
      return false;
    } 
    try {
      ((Dispenser)blockData).setTriggered(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid triggered for this block!");
      return false;
    } 
    return true;
  }
  
  //validates type:
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

