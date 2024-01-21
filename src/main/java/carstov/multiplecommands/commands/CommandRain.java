package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class CommandRain extends BasicCommand {

    @Override
    public String getCommandName() {
        return "rain";
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
        WorldInfo worldinfo = worldserver.getWorldInfo();
        int ticksUntilRain = 24000;

        worldinfo.setRainTime(ticksUntilRain);
        worldinfo.setRaining(true);
        worldinfo.setThundering(false);
    }
}
