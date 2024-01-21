package carstov.multiplecommands.utilities;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TeleportationPoint {

    private final World world;
    private final EntityPlayer player;
    private final UUID playerUUID;
    private final FileHelper fileHelper;

    public TeleportationPoint(World world, EntityPlayer player, UUID playerUUID, FileHelper fileHelper) {
        this.world = world;
        this.player = player;
        this.playerUUID = playerUUID;
        this.fileHelper = fileHelper;
    }

    public TeleportationPoint(World world, UUID playerUUID, FileHelper fileHelper) {
        this.world = world;
        this.playerUUID = playerUUID;
        this.fileHelper = fileHelper;
        player = null;
    }

    public void teleport(String location) {
        this.fileHelper.setPath(
            this.world.getSaveHandler()
                .getWorldDirectory()
                .getAbsolutePath());

        ArrayList<String[]> data = fileHelper.getData();
        String[] list;
        UUID uuid;
        String locations;
        int x;
        int y;
        int z;
        int dimensionID;

        for (int i = 0; i < data.size(); i++) {
            list = data.get(i);
            uuid = UUID.fromString(list[0]);
            locations = list[1];

            if (uuid.equals(this.playerUUID)) {
                if (locations.toLowerCase()
                    .equals(location)) {
                    x = Integer.parseInt(list[2]);
                    y = Integer.parseInt(list[3]);
                    z = Integer.parseInt(list[4]);
                    dimensionID = Integer.parseInt(list[5]);

                    if (!location.equals("back")) {
                        createTelportationPoint("back");
                    }

                    if (this.player.dimension == dimensionID) {
                        this.player.setPositionAndUpdate(x, y, z);
                    }

                    else {
                        this.player.travelToDimension(dimensionID);
                        this.player.setPositionAndUpdate(x, y, z);
                    }
                }
            }
        }
    }

    public void createTelportationPoint(String location) {
        String data;

        data = (playerUUID.toString() + ","
            + location
            + ","
            + player.getPlayerCoordinates().posX
            + ","
            + player.getPlayerCoordinates().posY
            + ","
            + player.getPlayerCoordinates().posZ
            + ","
            + player.worldObj.provider.dimensionId);

        FileHelper fileHelper = new FileHelper(world, playerUUID, data, location);
    }

    public boolean telportationPointExist(String location) {
        this.fileHelper.setPath(
            world.getSaveHandler()
                .getWorldDirectory()
                .getAbsolutePath());

        ArrayList<String[]> data = fileHelper.getData();
        String[] list;
        UUID uuid;
        String locations;

        for (int i = 0; i < data.size(); i++) {
            list = data.get(i);
            uuid = UUID.fromString(list[0]);
            locations = list[1];

            if (uuid.equals(playerUUID)) {
                if (locations.equals(location)) {
                    return true;
                }
            }
        }

        return false;
    }
}
