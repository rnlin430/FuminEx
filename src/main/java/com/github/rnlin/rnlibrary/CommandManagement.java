package com.github.rnlin.rnlibrary;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class CommandManagement implements CommandExecutor {

    protected final JavaPlugin plugin;
    private String[] commandNames;

    public CommandManagement(JavaPlugin plugin) {
        ConsoleLog.sendDebugMessage("CommandManagement.constructor");
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // ConsoleLog.sendDebugMessage("CommandManagement.onCommand()");
        switch (args.length) {
            case 0:
                if (command.getName().equals(commandNames[0])) {
                    return onSingleCommand(sender, command, label);
                }
            case 1:
                if (command.getName().equals(commandNames[0])) {
                    return onMultiCommand(sender, command, label, args);
                }
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                PlayerMessage.debugMessage(sender, "onCommand()");
                return false;
        }
    }

    public boolean onSingleCommand(CommandSender sender, Command command, String label) {
        return true;
    }

    public boolean onMultiCommand(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

    protected void setCommandNames(String[] names) {
        this.commandNames = names;
        for (String command : names) {
            Objects.requireNonNull(plugin.getCommand(command)).setExecutor(this);
        }
    }
}
