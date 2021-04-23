package helpers;

import java.io.*;
import java.util.Scanner;

public class JsonDb {

    static public String get() {
        File file = new File(System.getProperty("user.dir") + "/src/resource/database.json");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String fileContent = "";
        while (scan.hasNextLine()) {
            fileContent = fileContent.concat(scan.nextLine() + "\n");
        }
        return fileContent;
    }

    static public void set(String json) {
        try {
            Writer writer = new FileWriter(System.getProperty("user.dir") + "/src/resource/database.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
