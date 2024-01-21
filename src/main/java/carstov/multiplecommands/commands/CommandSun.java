package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class CommandSun extends BasicCommand {

    @Override
    public String getCommandName() {
        return "sun";
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
        WorldInfo worldinfo = worldserver.getWorldInfo();

        worldinfo.setRainTime(0);
        worldinfo.setThunderTime(0);
        worldinfo.setRaining(false);
        worldinfo.setThundering(false);
    }
}
