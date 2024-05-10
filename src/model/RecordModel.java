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


/**
 * Provides functionalities for managing and interacting with user records,
 * including saving new records and retrieving existing ones.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class RecordModel {


    /**
     * Save the record of player's performance.
     * It may also update the user's game level base on the result of attempt
     * @param hardLevel the level of difficulty
     *                  1 - easy level
     *                  2 - medium level
     *                  3 - hard level
     * @param level the level attempt by player.
     * @param score the score achieved in the game session.
     * @param status the status of attempt, it can be correct or incorrect.
     *               Only update levels on correct attempt.
     *               {@link entity.Leaf.Status} for status value.
     */
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


    /**
     * Retrives a list of records associated with the current user
     * @return a list of {@code Record} object if player successfully login
     */
    public static List<Record> getRecords(){
        User user = LocalStorage.get(LocalStorage.CURRENT_USER, User.class);
        if (user == null) {
            return null;
        }
        return user.getRecords();
    }


}
