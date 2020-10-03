package io.github.guru2764.visedit.blockdata;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.block.Block;
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
import org.bukkit.block.data.Rotatable;
import org.bukkit.block.data.Snowable;
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
import org.bukkit.block.data.type.Repeater;
import org.bukkit.block.data.type.RespawnAnchor;
import org.bukkit.block.data.type.Sapling;
import org.bukkit.block.data.type.Scaffolding;
import org.bukkit.block.data.type.SeaPickle;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Snow;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.block.data.type.StructureBlock;
import org.bukkit.block.data.type.TNT;
import org.bukkit.block.data.type.TechnicalPiston;
import org.bukkit.block.data.type.Tripwire;
import org.bukkit.block.data.type.TurtleEgg;
import org.bukkit.block.data.type.Wall;
import org.bukkit.command.CommandSender;

public class DataSet {
  
  //Main switch statement function
  public static void dataSet(Block currentBlock, String data) {
    String[] dataArray = data.split("\\|");
    
    //Goes through each data piece and sets that data for each block
    for (int i = 0; i < dataArray.length; i++) {
      String dataHeader = StringUtils.substringBeforeLast(dataArray[i], ":");
      String dataContent = StringUtils.substringAfterLast(dataArray[i], ":").toUpperCase();
      if (currentBlock.isEmpty() && !currentBlock.isLiquid()) {
    	
    	//Big switch statement for each possible input
        switch (dataHeader) {
          case "age":
            setAge(currentBlock, dataContent);
            break;
          case "attached":
            setAttached(currentBlock, dataContent);
            break;
          case "attachment":
            setAttachment(currentBlock, dataContent);
            break;
          case "axis":
            setAxis(currentBlock, dataContent);
            break;
          case "bites":
            setBites(currentBlock, dataContent);
            break;
          case "bottom":
            setBottom(currentBlock, dataContent);
            break;
          case "charges":
            setCharges(currentBlock, dataContent);
            break;
          case "conditional":
            setConditional(currentBlock, dataContent);
            break;
          case "delay":
            setDelay(currentBlock, dataContent);
            break;
          case "disarmed":
            setDisarmed(currentBlock, dataContent);
            break;
          case "distance":
            setDistance(currentBlock, dataContent);
            break;
          case "drag":
            setDrag(currentBlock, dataContent);
            break;
          case "east":
            setEast(currentBlock, dataContent);
            break;
          case "eggs":
            setEggs(currentBlock, dataContent);
            break;
          case "enabled":
            setEnabled(currentBlock, dataContent);
            break;
          case "extended":
            setExtended(currentBlock, dataContent);
            break;
          case "eye":
            setEye(currentBlock, dataContent);
            break;
          case "face":
            setFace(currentBlock, dataContent);
            break;
          case "facing":
            setFacing(currentBlock, dataContent);
            break;
          case "half":
            setHalf(currentBlock, dataContent);
            break;
          case "has_bottle_0":
            setHasBottle(currentBlock, dataContent, 0);
            break;
          case "has_bottle_1":
            setHasBottle(currentBlock, dataContent, 1);
            break;
          case "has_bottle_2":
            setHasBottle(currentBlock, dataContent, 2);
            break;
          case "hanging":
            setHanging(currentBlock, dataContent);
            break;
          case "hatch":
            setHatch(currentBlock, dataContent);
            break;
          case "hinge":
            setHinge(currentBlock, dataContent);
            break;
          case "honey_level":
            setHoneyLevel(currentBlock, dataContent);
            break;
          case "inverted":
            setInverted(currentBlock, dataContent);
            break;
          case "in_wall":
            setInWall(currentBlock, dataContent);
            break;
          case "layers":
            setLayers(currentBlock, dataContent);
            break;
          case "leaves":
            setLeaves(currentBlock, dataContent);
            break;
          case "level":
            setLevel(currentBlock, dataContent);
            break;
          case "lit":
            setLit(currentBlock, dataContent);
            break;
          case "locked":
            setLocked(currentBlock, dataContent);
            break;
          case "mode":
            setMode(currentBlock, dataContent);
            break;
          case "moisture":
            setMoisture(currentBlock, dataContent);
            break;
          case "north":
            setNorth(currentBlock, dataContent);
            break;
          case "open":
            setOpen(currentBlock, dataContent);
            break;
          case "orientation":
            setOrientation(currentBlock, dataContent);
            break;
          case "part":
            setPart(currentBlock, dataContent);
            break;
          case "persistent":
            setPersistent(currentBlock, dataContent);
            break;
          case "power":
            setPower(currentBlock, dataContent);
            break;
          case "powered":
            setPowered(currentBlock, dataContent);
            break;
          case "rotation":
            setRotation(currentBlock, dataContent);
            break;
          case "shape":
            setShape(currentBlock, dataContent);
            break;
          case "short":
            setShort(currentBlock, dataContent);
            break;
          case "signal_fire":
            setSignalFire(currentBlock, dataContent);
            break;
          case "snowy":
              setSnowy(currentBlock, dataContent);
              break;
          case "south":
            setSouth(currentBlock, dataContent);
            break;
          case "stage":
            setStage(currentBlock, dataContent);
            break;
          case "triggered":
            setTriggered(currentBlock, dataContent);
            break;
          case "type":
            setType(currentBlock, dataContent);
            break;
          case "unstable":
            setUnstable(currentBlock, dataContent);
            break;
          case "up":
            setUp(currentBlock, dataContent);
            break;
          case "west":
            setWest(currentBlock, dataContent);
            break;
          default:
            break;
        } 
      }
    } 
  }
  
  //Sets age:
  public static void setAge(Block currentBlock, String dataContent) {
	Ageable age = (Ageable)currentBlock.getBlockData();
	age.setAge(Integer.parseInt(dataContent));
    currentBlock.setBlockData((BlockData)age);
  }

  //Sets attached:
  public static void setAttached(Block currentBlock, String dataContent) {
    
  }

  //Sets attachment:
  public static void setAttachment(Block currentBlock, String dataContent){
  
  }

  //Sets axis:
  public static void setAxis(Block currentBlock, String dataContent) {
    
  }

  //Sets bites:
  public static void setBites(Block currentBlock, String dataContent) {
    
  }

  //Sets bottom:
  public static void setBottom(Block currentBlock, String dataContent) {
    
  }

  //Sets charges:
  public static void setCharges(Block currentBlock, String dataContent) {
    
  }

  //Sets conditional:
  public static void setConditional(Block currentBlock, String dataContent) {
    
  }

  //Sets delay:
  public static void setDelay(Block currentBlock, String dataContent) {
    
  }

  //Sets disarmed:
  public static void setDisarmed(Block currentBlock, String dataContent) {
    
  }

  //Sets distance:
  public static void setDistance(Block currentBlock, String dataContent) {
    
  }

  //Sets drag:
  public static void setDrag(Block currentBlock, String dataContent) {
    
  }

  //Sets east:
  public static void setEast(Block currentBlock, String dataContent) {
    
  }

  //Sets eggs:
  public static void setEggs(Block currentBlock, String dataContent) {
    
  }

  //Sets enabled:
  public static void setEnabled(Block currentBlock, String dataContent) {
    
  }

  //Sets extended:
  public static void setExtended(Block currentBlock, String dataContent) {
    
  }
  
  //Sets eye:
  public static void setEye(Block currentBlock, String dataContent) {
    
  }

  //Sets face:
  public static void setFace(Block currentBlock, String dataContent) {
    
  }

  //Sets facing:
  public static void setFacing(Block currentBlock, String dataContent) {
	Directional dir = (Directional)currentBlock.getBlockData();
	dir.setFacing(BlockFace.valueOf(dataContent));
	currentBlock.setBlockData((BlockData)dir);
  }

  //Sets half:
  public static void setHalf(Block currentBlock, String dataContent) {
    
  }

  //Sets has_bottle_x:
  public static void setHasBottle(Block currentBlock, String dataContent, int n) {
    
  }

  //Sets hatch:
  public static void setHatch(Block currentBlock, String dataContent) {
    
  }

  //Sets hanging:
  public static void setHanging(Block currentBlock, String dataContent) {
    
  }

  //Sets hinge:
  public static void setHinge(Block currentBlock, String dataContent) {
    
  }

  //Sets honey_level:
  public static void setHoneyLevel(Block currentBlock, String dataContent) {
    
  }

  //Sets instrument:
  public static void setInstrument(Block currentBlock, String dataContent) {
    
  }

  //Sets inverted:
  public static void setInverted(Block currentBlock, String dataContent) {
    
  }

  //Sets in_wall:
  public static void setInWall(Block currentBlock, String dataContent) {
    
  }

  //Sets layers:
  public static void setLayers(Block currentBlock, String dataContent) {
    
  }

  //Sets leaves:
  public static void setLeaves(Block currentBlock, String dataContent) {
    
  }

  //Sets level:
  public static void setLevel(Block currentBlock, String dataContent) {
    
  }

  //Sets lit:
  public static void setLit(Block currentBlock, String dataContent) {
    
  }

  //Sets locked:
  public static void setLocked(Block currentBlock, String dataContent) {
    
  }

  //Sets mode:
  public static void setMode(Block currentBlock, String dataContent) {
    
  }

  //Sets moisture:
  public static void setMoisture(Block currentBlock, String dataContent) {
    
  }

  //Sets north:
  public static void setNorth(Block currentBlock, String dataContent) {
    
  }

  //Sets open:
  public static void setOpen(Block currentBlock, String dataContent) {
    
  }

  //Sets orientation:
  public static void setOrientation(Block currentBlock, String dataContent) {
    
  }

  //Sets part:
  public static void setPart(Block currentBlock, String dataContent) {
    
  }

  //Sets persistent:
  public static void setPersistent(Block currentBlock, String dataContent) {
    
  }

  //Sets pickles:
  public static void setPickles(Block currentBlock, String dataContent) {
    
  }

  //Sets power:
  public static void setPower(Block currentBlock, String dataContent) {
	AnaloguePowerable ana = (AnaloguePowerable)currentBlock.getBlockData();
	ana.setPower(Integer.parseInt(dataContent));
	currentBlock.setBlockData((BlockData)ana);
  }

  //Sets powered:
  public static void setPowered(Block currentBlock, String dataContent) {
    
  }

  //Sets rotation:
  public static void setRotation(Block currentBlock, String dataContent) {
    
  }

  //Sets shape:
  public static void setShape(Block currentBlock, String dataContent) {
    
  }

  //Sets short:
  public static void setShort(Block currentBlock, String dataContent) {
    
  }

  //Sets signal_fire:
  public static void setSignalFire(Block currentBlock, String dataContent) {
    
  }

  //Sets snowy:
  public static void setSnowy(Block currentBlock, String dataContent) {
    
  }

  //Sets stage:
  public static void setStage(Block currentBlock, String dataContent) {
    
  }

  //Sets south:
  public static void setSouth(Block currentBlock, String dataContent) {
    
  }

  //Sets triggered:
  public static void setTriggered(Block currentBlock, String dataContent) {
    
  }

  //Sets type:
  public static void setType(Block currentBlock, String dataContent) {
    
  }

  //Sets unstable:
  public static void setUnstable(Block currentBlock, String dataContent) {
    
  }

  //Sets up:
  public static void setUp(Block currentBlock, String dataContent) {
    
  }

  //Sets west:
  public static void setWest(Block currentBlock, String dataContent) {
    
  }

  //Sets waterlogged:
  public static void setWaterlogged(Block currentBlock, String dataContent) {
    
  }

}