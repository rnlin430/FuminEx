package com.github.rnlin.rnlibrary;

import org.bukkit.plugin.java.JavaPlugin;

public class Rlibrary extends JavaPlugin {

    public Commands commands;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(ConsoleLog.getCyanMessage( "プラグインが有効になったよ!"));
        commands = new Commands(this);
        try{
            commands.setCommand(() -> { ConsoleLog.sendDebugMessage("l.15.setCommand()");}, "fly");
        }catch (NullPointerException e){
            getLogger().info(ConsoleLog.getCyanMessage("プラグインが有効になったよ!"));
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になったよ!");
    }
}
