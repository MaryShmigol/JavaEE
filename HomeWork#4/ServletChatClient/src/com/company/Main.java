package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 - login to chat");
        String string = scanner.readLine();
        while (true) {
            if (string.contains("1")) {
                System.out.println("Enter your login: ");
                String userName = scanner.readLine();

                System.out.println("Enter your password: ");
                String password = scanner.readLine();

                CheckedIn checkedIn = new CheckedIn();
                boolean isReq = checkedIn.checkIn(userName, password);
                if (isReq) {
                    try {
                        String login = checkedIn.getName();

                        Thread th = new Thread(new GetThread(login));
                        th.setDaemon(true);
                        th.start();

                        while (true) {
                            System.out.println("1: send private message");
                            System.out.println("2: send message");
                            System.out.println("3: check user status");
                            System.out.println("4: get users list");
                            System.out.println("5: exit");
                            System.out.print("-> ");
                            String menuItem2 = scanner.readLine();
                            switch (menuItem2) {
                                case "1":
                                    sendPrivateMessage(scanner);
                                    break;
                                case "2":
                                    sendMessage(scanner, login);
                                    break;
                                case "3":
                                    checkUserStatus(scanner);
                                    break;
                                case "4":
                                    getUsersList();
                                case "5":
                                    th.interrupt();
                                    break;
                            }
                        }
                    } catch (IOException ignored) {
                    }
                } else {
                    System.out.println("Enter to chat is failed.");
                }

            }
        }
    }

    private static void sendPrivateMessage(BufferedReader scanner) throws IOException {
        System.out.println("Enter name which to send private message");
        String fromName = scanner.readLine();
        System.out.println("Enter your private message: ");
        String text = scanner.readLine();
        Message m = new Message(fromName, text);
        int res = m.send(Utils.getURL() + "/add");

        if (res != 200) {
            System.out.println("HTTP error occured: " + res);
        }

    }

    private static void sendMessage(BufferedReader scanner, String login) throws IOException {
        System.out.println("Enter your message: ");
        String message = scanner.readLine();
        Message m = new Message(login, message);
        int res = m.send(Utils.getURL() + "/add");
        if (res != 200) {
            System.out.println("HTTP error occured: " + res);
        }

    }

    private static void checkUserStatus(BufferedReader scanner) throws IOException {
        System.out.println("Enter user login for check user status");
        String nameUserStatus = scanner.readLine();
        UserStatus userStatus = new UserStatus(nameUserStatus);
        userStatus.test();
        System.out.println(userStatus);

    }

    private static void getUsersList() throws IOException {
        Map<String, String> mapUser = AvailableUsers.getMapUser();
        for (Map.Entry entry : mapUser.entrySet()) {
            String name = (String) entry.getKey();
            UserStatus statusUser = new UserStatus(name);
            statusUser.test();
            System.out.println(statusUser);
        }
        System.out.println();
    }
}



