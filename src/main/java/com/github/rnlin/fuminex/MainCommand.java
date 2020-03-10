package com.github.rnlin.fuminex;

import com.github.rnlin.MamiyaFumin;
import com.github.rnlin.rnlibrary.CommandManagement;
import com.github.rnlin.rnlibrary.PlayerMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class MainCommand extends CommandManagement {

    private final FuminExPlugin fuminExPlugin;

    public MainCommand(JavaPlugin plugin, String[] commandNames, FuminExPlugin fuminExPlugin) {
        super(plugin);
        this.fuminExPlugin = fuminExPlugin;
        setCommandNames(commandNames);
    }

    @Override
    public boolean onSingleCommand(CommandSender sender, Command command, String label) {


        if(sender instanceof Player) {

             Player player = (Player) sender;
             if(!player.isOnline()) return true;
             /*
             if(!FuminExPlugin.playersData.contains(player.getUniqueId(), "IsFly")){
                 FuminExPlugin.playersData.saveData(player.getUniqueId(), "IsFly", true);
                 PlayerMessage.debugMessage(player, "設定なし -> true");
             } else {
                 if(FuminExPlugin.playersData.getBool(player.getUniqueId(), "IsFly")) {
                     FuminExPlugin.playersData.saveData(player.getUniqueId(), "IsFly", false);
                     PlayerMessage.debugMessage(player, "true -> false");
                 } else {
                     FuminExPlugin.playersData.saveData(player.getUniqueId(), "IsFly", true);
                     PlayerMessage.debugMessage(player, "false -> true");
                 }
             }

              */
//            MamiyaFumin mamiyafumin = (MamiyaFumin) rlibrary.getServer().getPluginManager().getPlugin("MamiyaFumin");
//            PlayerFumin pf = Objects.requireNonNull(mamiyafumin).getPlayerFumin(player);
//            ConsoleLog.sendDebugMessage(String.valueOf(pf.getCurrentScore()));
            // プレイヤーがフライかどうかを判定

            boolean isFly = FuminExPlugin.isFly(player);
            if(!isFly) {
                MamiyaFumin mamiyafumin = (MamiyaFumin) Bukkit.getServer().getPluginManager().getPlugin("MamiyaFumin");
                int cpoint = Objects.requireNonNull(mamiyafumin).getMamiyaFuminAPI().getCurrentScore(player);
                PlayerMessage.debugMessage(player, Integer.toString(cpoint));
                Boolean result = FuminExPlugin.setFly(player, true);
                new FlyScheduler(mamiyafumin, fuminExPlugin,  player.getUniqueId()).runTaskTimer(fuminExPlugin, 0, FuminExPlugin.DECREASE_FREQUENCY_TICK);
            }
            else {

            }

        }
        return true;
    }

    @Override
    public boolean onMultiCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
