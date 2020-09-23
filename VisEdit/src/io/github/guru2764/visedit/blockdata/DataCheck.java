package io.github.guru2764.visedit.blockdata;

import io.github.guru2764.visedit.operations.SetOperation;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Axis;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.block.data.Attachable;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.FaceAttachable;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.Lightable;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.Orientable;
import org.bukkit.block.data.Powerable;
import org.bukkit.block.data.Rail;
import org.bukkit.block.data.Waterlogged;
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
import org.bukkit.block.data.type.Gate;
import org.bukkit.block.data.type.Hopper;
import org.bukkit.block.data.type.Jigsaw;
import org.bukkit.block.data.type.Lantern;
import org.bukkit.block.data.type.Leaves;
import org.bukkit.block.data.type.NoteBlock;
import org.bukkit.block.data.type.Piston;
import org.bukkit.block.data.type.PistonHead;
import org.bukkit.block.data.type.RedstoneWire;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.block.data.type.StructureBlock;
import org.bukkit.block.data.type.TechnicalPiston;
import org.bukkit.block.data.type.Wall;
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
        case "axis":
            if (!validateAxis(blockData, dataContent, sender))
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
        case "east":
            if (!validateEast(blockData, dataContent, sender))
              return false; 
            break;
        case "enabled":
          if (!validateEnabled(blockData, dataContent, sender))
            return false; 
          break;
        case "extended":
            if (!validateExtended(blockData, dataContent, sender))
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
        case "north":
            if (!validateNorth(blockData, dataContent, sender))
              return false; 
            break;
        case "open":
            if (!validateOpen(blockData, dataContent, sender))
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
          if (!validatePersistent(blockData, dataContent, sender))
            return false; 
          break;
        case "power":
          if (!validatePower(blockData, dataContent, sender))
            return false; 
          break;
        case "powered":
            if (!validatePowered(blockData, dataContent, sender))
              return false; 
            break;
        case "shape":
            if (!validateShape(blockData, dataContent, sender))
              return false; 
            break;
        case "short":
            if (!validateShort(blockData, dataContent, sender))
              return false; 
            break;
        case "signal_fire":
          if (!validateSignalFire(blockData, dataContent, sender))
            return false; 
          break;
        case "south":
            if (!validateSouth(blockData, dataContent, sender))
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
        case "up":
            if (!validateUp(blockData, dataContent, sender))
              return false; 
            break;
        case "west":
            if (!validateWest(blockData, dataContent, sender))
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
      ((Attachable)blockData).setAttached(Boolean.valueOf(dataContent));
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
  
  //Validates axis:
  public static boolean validateAxis(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Orientable)) {
      user.sendMessage(ChatColor.RED + "You cannot set an axis for this block!");
      return false;
    } 
    try {
      ((Orientable)blockData).setAxis(Axis.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid axis for this block!");
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
      ((CommandBlock)blockData).setConditional(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid conditional for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates distance:
  public static boolean validateDistance(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Leaves)) {
      user.sendMessage(ChatColor.RED + "You cannot set a distance for this block!");
      return false;
    } 
    try {
      ((Leaves)blockData).setDistance(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid distance for this block!");
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
      ((BubbleColumn)blockData).setDrag(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid drag for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates east:
  public static boolean validateEast(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof MultipleFacing)&&!(blockData instanceof RedstoneWire)&&!(blockData instanceof Wall)) {
      user.sendMessage(ChatColor.RED + "You cannot set east for this block!");
      return false;
    } 
    if(blockData instanceof MultipleFacing) {
      try {
        ((MultipleFacing)blockData).setFace(BlockFace.EAST,Boolean.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid east for this block!");
        return false;
      }
    }
    else if(blockData instanceof RedstoneWire) {
      try {
        ((RedstoneWire)blockData).setFace(BlockFace.EAST,RedstoneWire.Connection.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid east for this block!");
        return false;
      }
    }
    else if(blockData instanceof Wall) {
      try {
        ((Wall)blockData).setHeight(BlockFace.EAST,Wall.Height.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid east for this block!");
        return false;
      }
    	
    }
    return true;
  }
  
  //Validates enabled:
  public static boolean validateEnabled(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Hopper)) {
      user.sendMessage(ChatColor.RED + "You cannot set an enabled for this block!");
      return false;
    } 
    try {
      ((Hopper)blockData).setEnabled(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid enabled for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates extended:
  public static boolean validateExtended(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Piston)) {
      user.sendMessage(ChatColor.RED + "You cannot set extended for this block!");
      return false;
    } 
    try {
      ((Piston)blockData).setExtended(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid extended for this block!");
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
      ((BrewingStand)blockData).setBottle(n, Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid has_bottle for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates hanging:
  public static boolean validateHanging(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Lantern)) {
      user.sendMessage(ChatColor.RED + "You cannot set hanging for this block!");
      return false;
    } 
    try {
      ((Lantern)blockData).setHanging(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid hanging for this block!");
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
  
  //Validates instrument:
  public static boolean validateInstrument(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof NoteBlock)) {
      user.sendMessage(ChatColor.RED + "You cannot set an instrument for this block!");
      return false;
    } 
    try {
      ((NoteBlock)blockData).setInstrument(Instrument.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid instrument for this block!");
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
  
  //Validates in_wall:
  public static boolean validateInWall(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Gate)) {
      user.sendMessage(ChatColor.RED + "You cannot set an in_wall for this block!");
      return false;
    } 
    try {
      ((Gate)blockData).setInWall(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid in_wall for this block!");
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
  
  //Validates level:
  public static boolean validateLevel(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Levelled)) {
      user.sendMessage(ChatColor.RED + "You cannot set a level for this block!");
      return false;
    } 
    try {
      ((Levelled)blockData).setLevel(Integer.parseInt(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid level for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates lit:
  public static boolean validateLit(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Lightable)) {
      user.sendMessage(ChatColor.RED + "You cannot set lit for this block!");
      return false;
    } 
    try {
      ((Lightable)blockData).setLit(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid lit for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates mode:
  public static boolean validateMode(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Comparator)&&!(blockData instanceof StructureBlock)) {
      user.sendMessage(ChatColor.RED + "You cannot set a mode for this block!");
      return false;
    } 
    if(blockData instanceof Comparator) {
        try {
          ((Comparator)blockData).setMode(Comparator.Mode.valueOf(dataContent));
        } catch (Exception ec) {
          user.sendMessage(ChatColor.RED + dataContent + " is not a valid mode for this block!");
          return false;
        }
      }
      else if(blockData instanceof StructureBlock) {
        try {
          ((StructureBlock)blockData).setMode(StructureBlock.Mode.valueOf(dataContent));
        } catch (Exception ec) {
          user.sendMessage(ChatColor.RED + dataContent + " is not a valid mode for this block!");
          return false;
        }
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
  
  //Validates north:
  public static boolean validateNorth(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof MultipleFacing)&&!(blockData instanceof RedstoneWire)&&!(blockData instanceof Wall)) {
      user.sendMessage(ChatColor.RED + "You cannot set north for this block!");
      return false;
    } 
    if(blockData instanceof MultipleFacing) {
      try {
        ((MultipleFacing)blockData).setFace(BlockFace.NORTH,Boolean.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid north for this block!");
        return false;
      }
    }
    else if(blockData instanceof RedstoneWire) {
      try {
        ((RedstoneWire)blockData).setFace(BlockFace.NORTH,RedstoneWire.Connection.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid north for this block!");
        return false;
      }
    }
    else if(blockData instanceof Wall) {
      try {
        ((Wall)blockData).setHeight(BlockFace.NORTH,Wall.Height.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid north for this block!");
        return false;
      }
    	
    }
    return true;
  }
  
  //Validates open:
  public static boolean validateOpen(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Openable)) {
      user.sendMessage(ChatColor.RED + "You cannot set open for this block!");
      return false;
    } 
    try {
      ((Openable)blockData).setOpen(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid open for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates orientation:
  public static boolean validateOrientation(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Jigsaw)) {
      user.sendMessage(ChatColor.RED + "You cannot set an orientation for this block!");
      return false;
    } 
    try {
      ((Jigsaw)blockData).setOrientation(Jigsaw.Orientation.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid orientation for this block!");
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
  
  //Validates persistent:
  public static boolean validatePersistent(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Leaves)) {
      user.sendMessage(ChatColor.RED + "You cannot set leaves for this block!");
      return false;
    } 
    try {
      ((Leaves)blockData).setPersistent(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid leaves for this block!");
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
  
  //Validates powered:
  public static boolean validatePowered(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Powerable)) {
      user.sendMessage(ChatColor.RED + "You cannot set a powered for this block!");
      return false;
    } 
    try {
      ((Powerable)blockData).setPowered(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid powered for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates shape:
  public static boolean validateShape(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Rail)&&!(blockData instanceof Stairs)) {
      user.sendMessage(ChatColor.RED + "You cannot set a shape for this block!");
      return false;
    } 
    if(blockData instanceof Rail) {
      try {
        ((Rail)blockData).setShape(Rail.Shape.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid shape for this block!");
        return false;
      }
    }
    else if(blockData instanceof Stairs) {
      try {
        ((Stairs)blockData).setShape(Stairs.Shape.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid shape for this block!");
        return false;
      }
    }
    return true;
  }
  
  //Validates short:
  public static boolean validateShort(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof PistonHead)) {
      user.sendMessage(ChatColor.RED + "You cannot set short for this block!");
      return false;
    } 
    try {
      ((PistonHead)blockData).setShort(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid short for this block!");
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
      ((Campfire)blockData).setSignalFire(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid signal_fire for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates south:
  public static boolean validateSouth(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof MultipleFacing)&&!(blockData instanceof RedstoneWire)&&!(blockData instanceof Wall)) {
      user.sendMessage(ChatColor.RED + "You cannot set south for this block!");
      return false;
    } 
    if(blockData instanceof MultipleFacing) {
      try {
        ((MultipleFacing)blockData).setFace(BlockFace.SOUTH,Boolean.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid south for this block!");
        return false;
      }
    }
    else if(blockData instanceof RedstoneWire) {
      try {
        ((RedstoneWire)blockData).setFace(BlockFace.SOUTH,RedstoneWire.Connection.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid south for this block!");
        return false;
      }
    }
    else if(blockData instanceof Wall) {
      try {
        ((Wall)blockData).setHeight(BlockFace.SOUTH,Wall.Height.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid south for this block!");
        return false;
      }
    	
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
    if (!(blockData instanceof Chest)&&!(blockData instanceof Slab)&&!(blockData instanceof TechnicalPiston)) {
      user.sendMessage(ChatColor.RED + "You cannot set a type for this block!");
      return false;
    } 
    if(blockData instanceof Chest) {
      try {
        ((Chest)blockData).setType(Chest.Type.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid type for this block!");
        return false;
      }
    }
    else if(blockData instanceof Slab) {
      try {
        ((Slab)blockData).setType(Slab.Type.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid type for this block!");
        return false;
      }
    }
    else if(blockData instanceof TechnicalPiston) {
      try {
        ((TechnicalPiston)blockData).setType(TechnicalPiston.Type.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid type for this block!");
        return false;
      }
    }
    return true;
  }

  //Validates up:
  public static boolean validateUp(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Wall)) {
      user.sendMessage(ChatColor.RED + "You cannot set up for this block!");
      return false;
    } 
    try {
      ((Wall)blockData).setUp(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid up for this block!");
      return false;
    } 
    return true;
  }
  
  //Validates west:
  public static boolean validateWest(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof MultipleFacing)&&!(blockData instanceof RedstoneWire)&&!(blockData instanceof Wall)) {
      user.sendMessage(ChatColor.RED + "You cannot set west for this block!");
      return false;
    } 
    if(blockData instanceof MultipleFacing) {
      try {
        ((MultipleFacing)blockData).setFace(BlockFace.WEST,Boolean.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid west for this block!");
        return false;
      }
    }
    else if(blockData instanceof RedstoneWire) {
      try {
        ((RedstoneWire)blockData).setFace(BlockFace.WEST,RedstoneWire.Connection.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid west for this block!");
        return false;
      }
    }
    else if(blockData instanceof Wall) {
      try {
        ((Wall)blockData).setHeight(BlockFace.WEST,Wall.Height.valueOf(dataContent));
      } catch (Exception ec) {
        user.sendMessage(ChatColor.RED + dataContent + " is not a valid west for this block!");
        return false;
      }
    	
    }
    return true;
  }

  //Validates waterlogged:
  public static boolean validateWaterlogged(BlockData blockData, String dataContent, CommandSender user) {
    if (!(blockData instanceof Waterlogged)) {
      user.sendMessage(ChatColor.RED + "You cannot set waterlogged for this block!");
      return false;
    } 
    try {
      ((Waterlogged)blockData).setWaterlogged(Boolean.valueOf(dataContent));
    } catch (Exception ec) {
      user.sendMessage(ChatColor.RED + dataContent + " is not a valid waterlogged for this block!");
      return false;
    } 
    return true;
  }
}

