package com.github.rnlin.rnlibrary;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Commands implements CommandExecutor {

    private final JavaPlugin plugin;
    // コマンド処理
    private Runnable func;
    // コマンド名
    private String commandName;
    // パーミッション
    private String permission;

    public Commands(JavaPlugin plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase(commandName)) {
            func.run();
        }
        return true;
    }

    public void setCommand(@NotNull final Runnable func, @NotNull String commandName) throws NullPointerException {
        this.func = func;
        this.commandName = commandName;
        Objects.requireNonNull(this.plugin.getCommand(commandName)).setExecutor(this);
    }

}
