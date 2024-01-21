package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;

import carstov.multiplecommands.utilities.HomePoint;
import carstov.multiplecommands.utilities.MessageHelper;

public class CommandHomeList extends BasicCommand {

    @Override
    public String getCommandName() {
        return "homelist";
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        if (HomePoint.getHomePoints(world, playerUUID)
            .isEmpty()) {
            MessageHelper.errorMessage(sender, "You don't have any homes");
        }

        else {
            MessageHelper.message(sender, HomePoint.getHomePoints(world, playerUUID), EnumChatFormatting.GOLD);
        }
    }
}
