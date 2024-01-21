package carstov.multiplecommands.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import net.minecraft.world.World;

public class HomePoint {

    public static String getHomePoints(World world, UUID playerUUID) {
        FileHelper fileHelper = new FileHelper();
        fileHelper.setPath(
            world.getSaveHandler()
                .getWorldDirectory()
                .getAbsolutePath());

        ArrayList<String[]> data = fileHelper.getData();
        String[] list;
        ArrayList<String> homePoints = new ArrayList<String>();
        UUID uuid;
        String location;

        for (int i = 0; i < data.size(); i++) {
            list = data.get(i);
            uuid = UUID.fromString(list[0]);
            location = list[1];

            if (uuid.equals(playerUUID) && !location.equals("back")) {
                homePoints.add(location);
            }
        }

        Collections.sort(homePoints);

        return String.valueOf(homePoints);
    }

    public static void deleteHomePoints(World world, UUID playerUUID, String location) {
        FileHelper fileHelper = new FileHelper();
        fileHelper.setPath(
            world.getSaveHandler()
                .getWorldDirectory()
                .getAbsolutePath());
        ArrayList<String[]> data = fileHelper.getData();

        fileHelper.deleteData(playerUUID, location);
    }
}
