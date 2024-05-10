package utils;

import com.alibaba.fastjson2.JSON;
import entity.DataObject;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code FileUtils} class provides utility methods for reading from and writing to files,
 * specifically focusing on operations related to managing a JSON data file. It includes methods
 * to read the entire data file into a String, get or recreate the data file, write data objects
 * to the file, and read data objects from the file.
 *
 * @author Yujun Ma
 * @version 1.0
 * @since 2024/3/30
 */
public class FileUtils {
    public static final String DATA_PATH = "data/data.json";
    /**
     * Reads the entire content of the data file into a single String.
     * If the file does not exist, an empty string is returned.
     *
     * @return A {@link String} containing the content of the data file, or an empty string if the file does not exist.
     */
    public static String readDataToString() {
        File file = new File(DATA_PATH);
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Ensures the existence of the data file. If the file exists, it is deleted and a new file is created.
     * If it does not exist, a new file is simply created.
     *
     * @return The {@link File} object representing the newly created file.
     */
    public static File getNewFile() {
        File file = new File(DATA_PATH);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * Writes a {@link DataObject} to the data file in JSON format. If the file already exists,
     * it is replaced with a new file containing the serialized {@code DataObject}.
     *
     * @param data The {@link DataObject} to write to the file.
     */
    public static void writeData(DataObject data) {
        File file = getNewFile();

        String dataString = JSON.toJSONString(data);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(dataString);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    /**
     * Reads the content of the data file and converts it from JSON format into a {@link DataObject}.
     *
     * @return The {@link DataObject} read from the file.
     */
    public static DataObject readData() {
        return JSON.parseObject(readDataToString(), DataObject.class);
    }

    public static void main(String[] args) {

        DataObject data = readData();
        System.out.println(data.getUsers());

    }
}
