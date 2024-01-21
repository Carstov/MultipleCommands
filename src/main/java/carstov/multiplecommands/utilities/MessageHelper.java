package carstov.multiplecommands.utilities;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class MessageHelper {

    public static void errorMessage(ICommandSender sender, String message) {
        sender.addChatMessage(
            new ChatComponentText(message).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
    }

    public static void successMessage(ICommandSender sender, String message) {
        sender.addChatMessage(
            new ChatComponentText(message).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    }

    public static void message(ICommandSender sender, String message, EnumChatFormatting color) {
        sender.addChatMessage(new ChatComponentText(message).setChatStyle(new ChatStyle().setColor(color)));
    }
}
