package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;

import carstov.multiplecommands.utilities.HomePoint;
import carstov.multiplecommands.utilities.MessageHelper;

public class CommandDelHome extends BasicCommand {

    @Override
    public String getCommandName() {
        return "delhome";
    }

    @Override
    protected void getArgLength() {
        this.argLength = 1;
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        MessageHelper.successMessage(sender, "Deleted " + args[0]);
        HomePoint.deleteHomePoints(this.world, this.playerUUID, args[0]);
    }
}
