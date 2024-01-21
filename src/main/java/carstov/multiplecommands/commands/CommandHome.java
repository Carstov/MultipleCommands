package carstov.multiplecommands.commands;

import net.minecraft.command.ICommandSender;

public class CommandHome extends BasicCommand {

    @Override
    public String getCommandName() {
        return "home";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "home <home>";
    }

    @Override
    protected void getArgLength() {
        this.argLength = 1;
    }

    @Override
    void customProcessCommand(ICommandSender sender, String[] args) {
        if (!args[0].equals("back")) {
            this.teleportationPoint.teleport(args[0]);
        }
    }
}
