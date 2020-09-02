package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AvailableUsers {
    private static Map<String, String> mapUser = new HashMap<>();
    private static AvailableUsers availableUsers = new AvailableUsers();

    private AvailableUsers() {
        mapUser.put("user1", "userUser");
        mapUser.put("user2", "userUserUser");
    }

    public static Set<String> getUserName() {
        return mapUser.keySet();
    }

    public static AvailableUsers getInstance(){
        return availableUsers;
    }

    public static Map getMapUser(){
        return mapUser;
    }

}
