package lab7.administracijaNaCetSistem;

import java.util.*;

public class ChatRoom {
    private final String name;
    private final Set<String> users;

    public ChatRoom(String name) {
        this.name = name;
        this.users = new TreeSet<>();
    }

    public String getName() {
        return name;
    }

    public void addUser(String username) {
        users.add(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public boolean hasUser(String username) {
        return users.contains(username);
    }

    public int numUsers() {
        return users.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append("\n");

        if (users.isEmpty()) {
            sb.append("EMPTY\n");
        } else {
            users.forEach(sb::append);
        }

        return sb.toString();
    }
}