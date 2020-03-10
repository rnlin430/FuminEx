package com.github.rnlin.rnlibrary;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class PlayerMessage {
    private static String PLUGIN_NAME = null;
    private static boolean isDebugMassage = true;


    public static void sendDescription(final CommandSender sender, final String message) {
        sender.sendMessage(ChatColor.AQUA + message);
    }
    public static void sendInfo(final CommandSender sender, final String message) {
        sender.sendMessage(ChatColor.AQUA + "[" + PLUGIN_NAME + "]" + ChatColor.AQUA + message);
    }

    public static void debugMessage(final CommandSender sender, final String message) {
        if(!isDebugMassage) return;
        sender.sendMessage("[Debug] " + ChatColor.GRAY + message);
    }

    public static void warningMessage(final CommandSender sender, final String message) {
        sender.sendMessage(ChatColor.RED + message);
    }

    public static void cautionMessage(final CommandSender sender, final String message) {
        sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + message);
    }


    public static void setPluginName(final String name) {
        PLUGIN_NAME = name;
    }

    public static void activateDebugMassage(final boolean b) {
        isDebugMassage = b;
    }
}
