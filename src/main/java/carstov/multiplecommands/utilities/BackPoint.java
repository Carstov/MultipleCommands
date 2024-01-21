package carstov.multiplecommands.utilities;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BackPoint {

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        World world = event.entity.worldObj;
        EntityPlayer player;
        UUID playerUUID;

        if (!world.isRemote && event.entity instanceof EntityPlayer) {
            player = (EntityPlayer) event.entity;
            playerUUID = player.getGameProfile()
                .getId();

            TeleportationPoint teleportationPoint = new TeleportationPoint(world, player, playerUUID, new FileHelper());
            teleportationPoint.createTelportationPoint("back");
        }
    }
}
