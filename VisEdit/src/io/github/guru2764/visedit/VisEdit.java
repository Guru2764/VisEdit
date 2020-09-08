package io.github.guru2764.visedit;

import org.bukkit.command.CommandExecutor;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public final class VisEdit extends JavaPlugin
{
    public void onEnable() {
        this.getLogger().info("VisEdit has been enabled!");
        if (!this.getDataFolder().exists()) {
            this.getLogger().info("No plugin folder detected...");
            this.getDataFolder().mkdir();
            this.getLogger().info("Made a new plugin folder!");
        }
        final File userFolder = new File(this.getDataFolder() + "/userdata");
        if (!userFolder.exists()) {
            this.getLogger().info("No users folder detected...");
            userFolder.mkdir();
            this.getLogger().info("Made a new users folder!");
        }
        final File usersFile = new File(this.getDataFolder() + "/config.yml");
        if (!usersFile.exists()) {
            this.getLogger().info("No config.yml file detected...");
            this.saveDefaultConfig();
            this.getLogger().info("Made a new config file!");
        }
        this.getCommand("vset").setExecutor((CommandExecutor)new VisEditCommandExecutor(this));
        this.getCommand("vundo").setExecutor((CommandExecutor)new VisEditCommandExecutor(this));
        this.getCommand("vredo").setExecutor((CommandExecutor)new VisEditCommandExecutor(this));
    }
    
    public void onDisable() {
        this.getLogger().info("VisEdit is shutting down...");
    }
}