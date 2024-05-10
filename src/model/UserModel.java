package model;

import entity.DataObject;
import entity.User;
import utils.FileUtils;
import utils.LocalStorage;
import utils.MusicUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The UserModel class is used to handle the user data.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class UserModel {
    /**
     * Register a new user.
     *
     * @param username the username
     * @param password the password
     * @return true if the user is registered successfully, false otherwise
     */
    public static boolean register(String username, String password) {
        DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
        List<User> users = dataObject.getUsers();
        if (users == null) {
            users = new ArrayList<>();
            dataObject.setUsers(users);
        }

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        User user = new User(username, password);
        users.add(user);

        LocalStorage.save(LocalStorage.CURRENT_USER, user);
        FileUtils.writeData(dataObject);
        MusicUtils.playMusicLoop();
        return true;
    }

    /**
     * Login a user.
     *
     * @param username the username
     * @param password the password
     * @return true if the user is logged in successfully, false otherwise
     */
    public static boolean login(String username, String password) {
        DataObject dataObject = LocalStorage.get(LocalStorage.DATA, DataObject.class);
        List<User> users = dataObject.getUsers();
        if (users == null) {
            return false;
        }

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                LocalStorage.save(LocalStorage.CURRENT_USER, user);
                if (user.isSetMusic()){
                    MusicUtils.playMusicLoop();
                }
                return true;
            }
        }
        return false;
 
    }
}
