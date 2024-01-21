package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandDay extends BasicCommand {

    @Override
    public String getCommandName() {
        return "day";
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        long time = 1000;
        WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
        worldserver.setWorldTime(time);
    }
}
