package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;

import carstov.multiplecommands.utilities.MessageHelper;

public class CommandBack extends BasicCommand {

    @Override
    public String getCommandName() {
        return "back";
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        if (!teleportationPoint.telportationPointExist("back")) {
            MessageHelper.errorMessage(sender, "You don't have a BackPoint");
        }

        else {
            teleportationPoint.teleport(this.getCommandName());
        }
    }
}
