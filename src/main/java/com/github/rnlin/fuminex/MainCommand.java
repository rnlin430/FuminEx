package com.github.rnlin.fuminex;

import com.github.rnlin.rnlibrary.CommandManagement;
import com.github.rnlin.rnlibrary.PlayerMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCommand extends CommandManagement {

    private final FuminExtends fuminExtends;

    public MainCommand(JavaPlugin plugin, String[] commandNames, FuminExtends fuminExtends) {
        super(plugin);
        this.fuminExtends = fuminExtends;
        setCommandNames(commandNames);
    }

    @Override
    public boolean onSingleCommand(CommandSender sender, Command command, String label) {


        if(sender instanceof Player) {

             Player player = (Player) sender;
             if(!player.isOnline()) return true;
             if(!FuminExtends.playersData.contains(player.getUniqueId(), "IsFly")){
                 FuminExtends.playersData.setData(player.getUniqueId(), "IsFly", true);
                 PlayerMessage.debugMessage(player, "設定なし -> true");
             } else {
                 if(FuminExtends.playersData.getBool(player.getUniqueId(), "IsFly")) {
                     FuminExtends.playersData.setData(player.getUniqueId(), "IsFly", false);
                     PlayerMessage.debugMessage(player, "true -> false");
                 } else {
                     FuminExtends.playersData.setData(player.getUniqueId(), "IsFly", true);
                     PlayerMessage.debugMessage(player, "false -> true");
                 }
             }
//            MamiyaFumin mamiyafumin = (MamiyaFumin) rlibrary.getServer().getPluginManager().getPlugin("MamiyaFumin");
//            PlayerFumin pf = Objects.requireNonNull(mamiyafumin).getPlayerFumin(player);
//            ConsoleLog.sendDebugMessage(String.valueOf(pf.getCurrentScore()));
            // プレイヤーがフライかどうかを判定
            /*
            boolean isFly = rlibrary.isFly(player);
            if(!isFly) {
                MamiyaFumin mamiyafumin = (MamiyaFumin) Bukkit.getServer().getPluginManager().getPlugin("MamiyaFumin");
                int cpoint = Objects.requireNonNull(mamiyafumin).getMamiyaFuminAPI().getCurrentScore(player);
                PlayerMessage.debugMessage(player, Integer.toString(cpoint));
                Boolean result = rlibrary.setFly(player, true);
                new FlyScheduler(mamiyafumin, rlibrary,  player.getUniqueId()).runTaskTimer(rlibrary, 0, Rlibrary.DECREASE_FREQUENCY_TICK);
            }
            else {

            }
*/
        }
        return true;
    }
}
