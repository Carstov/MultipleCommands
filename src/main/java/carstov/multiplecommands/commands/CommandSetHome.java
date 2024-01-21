package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;

import carstov.multiplecommands.utilities.MessageHelper;

public class CommandSetHome extends BasicCommand {

    @Override
    public String getCommandName() {
        return "sethome";
    }

    @Override
    protected void getArgLength() {
        this.argLength = 1;
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        if (args[0].equalsIgnoreCase("back")) {
            MessageHelper.errorMessage(sender, "Invalid name");
        }

        else {
            teleportationPoint.createTelportationPoint(args[0]);
            MessageHelper.successMessage(sender, "Set home " + args[0]);
        }
    }
}
