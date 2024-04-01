package model;

import entity.DataObject;
import entity.Leaf;
import entity.Record;
import entity.User;
import utils.FileUtils;
import utils.LocalStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecordModel {
    public static void saveRecord(int hardLevel, int level, int score, Leaf.Status status) {
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user == null) {
            return;
        }

        if (status == Leaf.Status.CORRECT) {
            if (hardLevel == 1 && level >= user.getEasyLevel()) {
                user.setEasyLevel(level+1);
            } else if (hardLevel == 2 && level >= user.getMediumLevel()) {
                user.setMediumLevel(level+1);
            } else if (hardLevel == 3 && level >= user.getHardLevel()) {
                user.setHardLevel(level+1);
            }
        }


        LocalDate date = LocalDate.now();
        String time = date.toString();
        Record record = new Record(time,hardLevel, level, score);
        user.getRecords().add(record);
        LocalStorage.save(LocalStorage.CURRENT_USER, user);
        DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
        FileUtils.writeData(dataObject);
    }

    public static List<Record> getRecords(){
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user == null) {
            return null;
        }
        return user.getRecords();
    }


}
