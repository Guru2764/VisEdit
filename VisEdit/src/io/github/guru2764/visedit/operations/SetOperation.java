package io.github.guru2764.visedit.operations;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SetOperation extends BlockCommandOperation {
  private int[] coords = new int[6];
  private Location loc1,loc2;
  private Material newMaterial;
  private String newData;
  private boolean hasValidData = false, isOneBlock = false, usingLocation = false;
  
  //Constructor
  public SetOperation(CommandSender newSender, World newWorld, JavaPlugin newPlugin) {
    super(newSender, newPlugin, newWorld);
  }
  
  //Coordinates method
  public void setCoords(int x1, int y1, int z1, int x2, int y2, int z2) {
    if (x1 <= x2) {
      this.coords[0] = x1;
      this.coords[1] = x2;
    } else {
      this.coords[0] = x2;
      this.coords[1] = x1;
    } 
    if (y1 <= y2) {
      this.coords[2] = y1;
      this.coords[3] = y2;
    } else {
      this.coords[2] = y2;
      this.coords[3] = y1;
    } 
    if (z1 <= z2) {
      this.coords[4] = z1;
      this.coords[5] = z2;
    } else {
      this.coords[4] = z2;
      this.coords[5] = z1;
    } 
  }
  public void setCoords(int x, int y, int z) {
    this.coords[0] = x;
    this.coords[1] = y;
    this.coords[2] = z;
  }
  public int[] getCoords() {
    return this.coords;
  }
  
  //Location Methods
  public void setLoc(int n, int x, int y, int z) {
    if (n == 1) {
      this.loc1 = new Location(this.world, x, y, z);
    } else if (n == 2) {
      this.loc2 = new Location(this.world, x, y, z);
    } 
  }
  public Location getLoc1() {
    return this.loc1;
  }
  public Location getLoc2() {
    return this.loc2;
  }
  
  //Material Methods
  public void setNewMaterial(Material inputMaterial) {
    this.newMaterial = inputMaterial;
  }
  public Material getNewMaterial() {
    return this.newMaterial;
  }
  
  //Data Methods
  public void setNewData(String inputData) {
    this.newData = inputData;
  }
  public String getNewData() {
    return this.newData;
  }

  //ValidData Methods
  public void setValidData(boolean newValidData) {
    this.hasValidData = newValidData;
  }
  public boolean isValidData() {
    return this.hasValidData;
  }
  
  //IsOneBlock Methods
  public boolean isOneBlock() {
    return this.isOneBlock;
  }
  public void setOneBlock(boolean isOneBlock) {
    this.isOneBlock = isOneBlock;
  }
  
  //IsUsingLocation Methods
  public boolean isUsingLocation() {
    return this.usingLocation;
  }
  public void setUsingLocation(boolean usingLocation) {
    this.usingLocation = usingLocation;
  }
}
