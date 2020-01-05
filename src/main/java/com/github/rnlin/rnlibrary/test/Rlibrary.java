package com.github.rnlin.rnlibrary.test;

import com.github.rnlin.MamiyaFumin;
import com.github.rnlin.rnlibrary.ConsoleLog;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Rlibrary extends JavaPlugin {

    MainCommand command;
    String[] commandNames = {"setfly"};
    public MamiyaFumin mamiyafumin = (MamiyaFumin) this.getServer().getPluginManager().getPlugin("MamiyaFumin");
    @Override
    public void onEnable() {
        // Plugin startup logic
        ConsoleLog.sendDebugMessage("onCommand");
        getLogger().info(ConsoleLog.getCyanMessage( "プラグインが有効になったよ!"));

        // コマンド生成
        command = new MainCommand(this, commandNames, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になったよ!");
    }

    public boolean setFly(Player player, boolean b) {
        if(!b) {
            if (player.getAllowFlight()) {
                if (player.isFlying()) player.setFlying(false);
                player.setAllowFlight(false);
            }
            return false;
        }
        else {
            if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                if (!player.isFlying()) player.setFlying(true);
            }
            return true;
        }
    }

}