package carstov.multiplecommands.commands;

import java.util.UUID;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import carstov.multiplecommands.utilities.FileHelper;
import carstov.multiplecommands.utilities.MessageHelper;
import carstov.multiplecommands.utilities.TeleportationPoint;

abstract class BasicCommand extends CommandBase {

    protected World world = null;
    protected EntityPlayer player = null;
    protected UUID playerUUID = null;
    protected TeleportationPoint teleportationPoint = null;
    protected short argLength = 0;

    protected BasicCommand() {
        this.getArgLength();
    }

    protected void getArgLength() {
        this.argLength = 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return this.getCommandName();
    }

    abstract void customProcessCommand(ICommandSender sender, String[] args);

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        this.world = sender.getEntityWorld();
        this.player = world.getPlayerEntityByName(sender.getCommandSenderName());
        this.playerUUID = player.getGameProfile()
            .getId();
        this.teleportationPoint = new TeleportationPoint(world, player, playerUUID, new FileHelper());

        if (world.isRemote) MessageHelper.errorMessage(sender, "Invalid argument");

        else {
            if (checkArgLength(sender, (short) args.length)) {
                customProcessCommand(sender, args);
            }
        }
    }

    private boolean checkArgLength(ICommandSender sender, short argLength) {
        if (this.argLength == argLength) return true;

        else if (argLength < this.argLength) {
            MessageHelper.errorMessage(sender, this.getCommandName() + " takes " + this.argLength + " argument");
        }

        else {
            MessageHelper.errorMessage(sender, "Too many arguments");
        }

        return false;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
