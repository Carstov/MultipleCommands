package carstov.multiplecommands;

import net.minecraftforge.common.MinecraftForge;

import com.myname.mymodid.Tags;

import carstov.multiplecommands.commands.*;
import carstov.multiplecommands.utilities.BackPoint;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(
    modid = MultipleCommands.MODID,
    version = Tags.VERSION,
    name = "Multiple Commands",
    acceptedMinecraftVersions = "[1.7.10]")
public class MultipleCommands {

    public static final String MODID = "multiplecommands";

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandDay());
        event.registerServerCommand(new CommandNight());
        event.registerServerCommand(new CommandSun());
        event.registerServerCommand(new CommandSetHome());
        event.registerServerCommand(new CommandHomeList());
        event.registerServerCommand(new CommandHome());
        event.registerServerCommand(new CommandBack());
        event.registerServerCommand(new CommandRain());
        event.registerServerCommand(new CommandDelHome());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new BackPoint());
    }
}
