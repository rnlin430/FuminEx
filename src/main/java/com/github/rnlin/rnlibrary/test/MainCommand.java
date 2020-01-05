package com.github.rnlin.rnlibrary.test;

import com.github.rnlin.rnlibrary.CommandManagement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCommand extends CommandManagement {

    private final Rlibrary rlibrary;

    public MainCommand(JavaPlugin plugin, String[] commandNames, Rlibrary rlibrary) {
        super(plugin);
        this.rlibrary = rlibrary;
        setCommandNames(commandNames);
    }

    @Override
    public boolean onSingleCommand(CommandSender sender, Command command, String label) {

        if(sender instanceof Player) {

            Player player = (Player) sender;
//            MamiyaFumin mamiyafumin = (MamiyaFumin) rlibrary.getServer().getPluginManager().getPlugin("MamiyaFumin");
//            PlayerFumin pf = Objects.requireNonNull(mamiyafumin).getPlayerFumin(player);
//            ConsoleLog.sendDebugMessage(String.valueOf(pf.getCurrentScore()));

            Boolean result = rlibrary.setFly(player, true);
        }
        return true;
    }
}
