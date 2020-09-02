package com.company;

import java.util.Map;

public class CheckedIn {
    private String name;
    private String password;

    public boolean checkIn(String nameUser, String passwordUser) {
        Map<String, String> mapUser = AvailableUsers.getMapUser();

        name = nameUser;
        password = passwordUser;

        for (Map.Entry entry : mapUser.entrySet()) {
            if (entry.getKey().equals(name) && entry.getValue().equals(password)) {
                System.out.println(String.format("Hello, %s , welcome to chat!", name));
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

}
