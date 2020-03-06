package com.github.rnlin.rnlibrary;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class PlayerMessage {
    private static final String PLUGIN_NAME = "mamiyafumin";
    private static boolean isDebugMassage = true;

    public static void sendDescription(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.AQUA + message);
    }
    public static void sendInfo(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.AQUA + "[" + PLUGIN_NAME + "]" + ChatColor.AQUA + message);
    }

    public static void debugMessage(CommandSender sender, String message) {
        if(!isDebugMassage) return;
        sender.sendMessage("[Debug] " + ChatColor.GRAY + message);
    }

    public static void warningMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.RED + message);
    }

    public static void cautionMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + message);
    }

    public static void activateDebugMassage(boolean b) {
        isDebugMassage = b;
    }
}
