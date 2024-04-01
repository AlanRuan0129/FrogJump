package utils;

import com.alibaba.fastjson2.JSON;
import entity.DataObject;
import entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static final String DATA_PATH = "data/data.json";
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
    public static DataObject readData() {
        return JSON.parseObject(readDataToString(), DataObject.class);
    }

    public static void main(String[] args) {

        DataObject data = readData();
        System.out.println(data.getUsers());

    }
}
