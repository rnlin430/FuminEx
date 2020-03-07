package com.github.rnlin.fuminex;

import com.github.rnlin.MamiyaFumin;
import com.github.rnlin.mamiyafumin.api.MamiyaFuminAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.rnlin.rnlibrary.PlayerMessage;

import java.util.UUID;

// 残り不眠ポイントを確認し不眠ポイントを減らす。
// 残り不眠ポイントの閾値を下回ったらプレイヤーに警告メッセージを送信
// 不眠ポイントが0になったらフライをオフにする
public class FlyScheduler extends BukkitRunnable {

    MamiyaFumin mf;
    FuminExPlugin fuminExPlugin;
    UUID uuid;
    Boolean messageFlag;
    int DECREASE_VALUE = -100;

    public FlyScheduler(MamiyaFumin mf, FuminExPlugin fuminExPlugin, UUID uuid) {
        super();
        this.mf = mf;
        this.fuminExPlugin = fuminExPlugin;
        this.uuid = uuid;
        messageFlag = true;

    }

    @Override
    public void run() {
        int currentscore = mf.getMamiyaFuminAPI().getCurrentScore(uuid);
        if(currentscore <= Math.abs(DECREASE_VALUE)) {
            Player player = Bukkit.getServer().getPlayer(uuid);
            fuminExPlugin.setFly(player, false);
            this.cancel();
        }
        if(messageFlag && currentscore <= FuminExPlugin.CAUTION_BOARDER_FLY) {
            Player player = Bukkit.getServer().getPlayer(uuid);
            int s = (currentscore / Math.abs(DECREASE_VALUE)) * FuminExPlugin.DECREASE_FREQUENCY_TICK / 20;
            PlayerMessage.sendInfo(player, String.format(FuminExPlugin.BOARDER_FLY_MESSAGE, s));
            messageFlag = false;
        }
        mf.getMamiyaFuminAPI().addScore(uuid, MamiyaFuminAPI.ScoreType.CURRENT, DECREASE_VALUE);
    }
}
