package io.github.guru2764.visedit;

import io.github.guru2764.visedit.CommandOperations;
import io.github.guru2764.visedit.operations.RedoOperation;
import io.github.guru2764.visedit.operations.SetOperation;
import io.github.guru2764.visedit.operations.UndoOperation;
import io.github.guru2764.visedit.validate.Validate;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VisEditCommandExecutor implements CommandExecutor {
  private final VisEdit plugin;
  
  public VisEditCommandExecutor(VisEdit plugin) {
    this.plugin = plugin;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("vset")) {
      SetOperation newOperation = new SetOperation(sender, ((Player)sender).getWorld(), (JavaPlugin)this.plugin);
      if (Validate.setValidate(args, newOperation)) {
        CommandOperations.vSet(newOperation);
        return true;
      } 
      return false;
    } 
    if (cmd.getName().equalsIgnoreCase("vundo")) {
      UndoOperation newOperation = new UndoOperation(((Player)sender).getWorld(), sender, (JavaPlugin)this.plugin);
      if (Validate.undoValidate(args, newOperation)) {
        for (int i = 0; i < newOperation.getIterations(); i++) {
          newOperation.updateNumber();
          CommandOperations.vUndo(newOperation);
        } 
        return true;
      } 
      return false;
    } 
    if (cmd.getName().equalsIgnoreCase("vredo")) {
      RedoOperation newOperation = new RedoOperation(((Player)sender).getWorld(), sender, (JavaPlugin)this.plugin);
      if (Validate.redoValidate(args, newOperation)) {
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
