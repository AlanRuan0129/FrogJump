package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for list of {@code User} object.
 * This class allow the storage and find of user in a list.
 * @ author rwang828
 * @ version 1.0
 * @since 2024 - 03 - 29
 */
public class DataObject {
    private List<User> users = new ArrayList<>();


    /**
     * Find the list of user.
     * @return a list of {@code User} object and allow
     */
    public List<User> getUsers() {
        return users;
    }


    /**
     * Set the user(s) into list and allow the replace current list with new list.
     * @param users, can not be {@code NULL}
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
}

