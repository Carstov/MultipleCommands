package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandNight extends BasicCommand {

    @Override
    public String getCommandName() {
        return "night";
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        long time = 14000;
        WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
        worldserver.setWorldTime(time);
    }
}
