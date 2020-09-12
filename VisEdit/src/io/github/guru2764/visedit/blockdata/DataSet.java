package io.github.guru2764.visedit.blockdata;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;

public class DataSet {
  public static void dataSet(Block currentBlock, String data) {
    String[] dataArray = data.split("\\|");
    
    //Goes through each data piece and sets that data for each block
    for (int i = 0; i < dataArray.length; i++) {
      String dataHeader = StringUtils.substringBeforeLast(dataArray[i], ":");
      String dataContent = StringUtils.substringAfterLast(dataArray[i], ":").toUpperCase();
      if (!currentBlock.isEmpty() && !currentBlock.isLiquid())
        switch (dataHeader) {
          case "age":
            setAge(currentBlock, dataContent);
            break;
          case "facing":
            setFacing(currentBlock, dataContent);
            break;
          case "power":
            setPower(currentBlock, dataContent);
            break;
          default:
            Bukkit.getLogger().warning("[VisEdit] Error Processing Data: " + data);
            break;
        }  
    } 
  }
  
  public static void setAge(Block currentBlock, String dataContent) {
    Ageable age = (Ageable)currentBlock.getBlockData();
    age.setAge(Integer.parseInt(dataContent));
    currentBlock.setBlockData((BlockData)age);
  }
  
  public static void setFacing(Block currentBlock, String dataContent) {
    Directional dir = (Directional)currentBlock.getBlockData();
    dir.setFacing(BlockFace.valueOf(dataContent));
    currentBlock.setBlockData((BlockData)dir);
  }
  
  public static void setPower(Block currentBlock, String dataContent) {
    AnaloguePowerable ana = (AnaloguePowerable)currentBlock.getBlockData();
    ana.setPower(Integer.parseInt(dataContent));
    currentBlock.setBlockData((BlockData)ana);
  }
}

