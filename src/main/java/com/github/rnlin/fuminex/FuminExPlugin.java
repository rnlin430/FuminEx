package com.github.rnlin.fuminex;

import com.github.rnlin.MamiyaFumin;
import com.github.rnlin.rnlibrary.ConsoleLog;
import com.github.rnlin.rnlibrary.*;
import com.github.rnlin.rnlibrary.PlayersData;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class FuminExPlugin extends JavaPlugin implements Listener{

    MainCommand command;
    String[] commandNames = {"setfly"};
    public static int CAUTION_BOARDER_FLY = 1100;
    public static final int DECREASE_FREQUENCY_TICK = 20;
    public static final String BOARDER_FLY_MESSAGE = "残り %d 秒で浮遊効果が切れます。";
    public MamiyaFumin mamiyafumin = (MamiyaFumin) this.getServer().getPluginManager().getPlugin("MamiyaFumin");
    public static PlayersData playersData;

    private static final String PLAYER_DATA_FILE_NAME = "playerData.yml";
    @Override
    public void onEnable() {
        // Plugin startup logic
        ConsoleLog.sendDebugMessage("onCommand");
        // getLogger().info(ConsoleLog.getCyanMessage( "プラグインが有効になったよ!"));

        // コマンド生成
        command = new MainCommand(commandNames, this);

        // CreatePlayerData
        playersData = new PlayersData(this, PLAYER_DATA_FILE_NAME);

        PlayerMessage.setPluginName(this.getDescription().getName());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // getLogger().info("プラグインが無効になったよ!");
    }

    public PlayersData getPlayersData(){
        if(playersData == null) {
            playersData = new PlayersData(this, PLAYER_DATA_FILE_NAME);
        }
        return playersData;
    }

    public static boolean setFly(Player player, boolean b) {
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

    public static boolean isFly(Player player) {
        return player.getAllowFlight();
    }

}