package io.github.guru2764.visedit;

import io.github.guru2764.visedit.CommandOperations;
import io.github.guru2764.visedit.operations.RedoOperation;
import io.github.guru2764.visedit.operations.SetOperation;
import io.github.guru2764.visedit.operations.UndoOperation;
import io.github.guru2764.visedit.blockdata.Validate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VisEditCommandExecutor implements CommandExecutor {
  private final VisEdit plugin;
  
  //Gets plugin for use below
  public VisEditCommandExecutor(VisEdit plugin) {
    this.plugin = plugin;
  }
  
  //Command parsing
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    
	//Vset command
	if (cmd.getName().equalsIgnoreCase("vset")) {
      
      //Puts all variables into SetOperation object
      SetOperation newOperation = new SetOperation(sender, ((Player)sender).getWorld(), (JavaPlugin)this.plugin);
      
      //Checks for valid command
      if (Validate.setValidate(args, newOperation)) {
        
    	//Execute command  
    	CommandOperations.vSet(newOperation);
        return true;
      } 
      return false;
    } 
	
	//Vundo command
    if (cmd.getName().equalsIgnoreCase("vundo")) {
    	
      //Puts all variables into UndoOperation object
      UndoOperation newOperation = new UndoOperation(((Player)sender).getWorld(), sender, (JavaPlugin)this.plugin);
      
      //Checks for valid command
      if (Validate.undoValidate(args, newOperation)) {
        
    	//Execute command n times
    	for (int i = 0; i < newOperation.getIterations(); i++) {
          newOperation.updateNumber();
          CommandOperations.vUndo(newOperation);
        } 
        return true;
      } 
      return false;
    } 
    if (cmd.getName().equalsIgnoreCase("vredo")) {
    	
      //Puts all variables into RedoOperation object
      RedoOperation newOperation = new RedoOperation(((Player)sender).getWorld(), sender, (JavaPlugin)this.plugin);
      
      //Checks for valid command
      if (Validate.redoValidate(args, newOperation)) {
        
    	//Execute command n times
    	for (int i = 0; i < newOperation.getIterations(); i++) {
          newOperation.updateNumber();
          CommandOperations.vRedo(newOperation);
        } 
        return true;
      } 
      return false;
    } 
    return false;
  }
}
