package carstov.multiplecommands.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.world.World;

public class FileHelper {

    private final String folderName = "multiplecommands";
    private final String fileName = "multiplecommands.txt";
    private String path;
    private String data;

    public FileHelper(World world, UUID playerUUID, String data, String location) {
        setPath(
            world.getSaveHandler()
                .getWorldDirectory()
                .getAbsolutePath());
        createFiles();
        setData(data);

        TeleportationPoint teleportationPoint = new TeleportationPoint(world, playerUUID, new FileHelper());

        if (!teleportationPoint.telportationPointExist(location)) {
            writeToFile(data);
        }

        else {
            overwriteFile(playerUUID, data, location);
            replaceFiles();
        }
    }

    public FileHelper() {

    }

    public void setPath(String path) {
        this.path = path.replace("\\\\", File.separator);
    }

    public void setData(String data) {
        this.data = data;
    }

    private void createFiles() {
        File file = new File(this.path + File.separator + folderName);
        if (!file.exists()) {
            file.mkdir();

            file = new File(this.path + File.separator + folderName + File.separator + folderName);
            if (!file.exists()) {

            }
        }
    }

    private void writeToFile(String data) {
        File file = new File(this.path + File.separator + this.folderName + File.separator + this.fileName);
        FileWriter fileWriter;
        PrintWriter printWriter;

        try {
            fileWriter = new FileWriter(file, true);
            printWriter = new PrintWriter(fileWriter);

            printWriter.println(data);

            fileWriter.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void overwriteFile(UUID playerUUID, String data, String location) {
        File file = new File(this.path + File.separator + this.folderName + File.separator + this.fileName);
        File newFile = new File(this.path + File.separator + this.folderName + File.separator + "NEW.txt");
        String[] list;
        String locations;
        UUID uuid;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            PrintWriter printWriter = new PrintWriter(newFile);
            for (String currentWord = bufferedReader.readLine(); currentWord
                != null; currentWord = bufferedReader.readLine()) {
                list = currentWord.split(",");
                uuid = UUID.fromString(list[0]);
                locations = list[1];

                if (uuid.equals(playerUUID) && locations.equals(location)) {
                    printWriter.println(data);
                }

                else {
                    printWriter.println(currentWord);
                }
            }

            printWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteData(UUID playerUUID, String location) {
        File file = new File(this.path + File.separator + this.folderName + File.separator + this.fileName);
        File newFile = new File(this.path + File.separator + this.folderName + File.separator + "NEW.txt");
        String[] list;
        String locations;
        UUID uuid;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            PrintWriter printWriter = new PrintWriter(newFile);
            for (String currentWord = bufferedReader.readLine(); currentWord
                != null; currentWord = bufferedReader.readLine()) {
                list = currentWord.split(",");
                uuid = UUID.fromString(list[0]);
                locations = list[1];

                if (uuid.equals(playerUUID) && !locations.equals(location)) {
                    printWriter.println(currentWord);
                }
            }

            printWriter.close();
            bufferedReader.close();
            replaceFiles();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> getData() {
        ArrayList<String[]> data = new ArrayList<String[]>();

        File file = new File(this.path + File.separator + this.folderName + File.separator + this.fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
                data.add(currentWord.split(","));
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    private void replaceFiles() {
        File oldFile = new File(this.path + File.separator + this.folderName + File.separator + this.fileName);
        File newFile = new File(this.path + File.separator + this.folderName + File.separator + "NEW.txt");

        oldFile.delete();
        newFile.renameTo(oldFile);
    }
}
