package lab7.administracijaNaCetSistem;

import java.util.*;

public class ChatSystem {
    private final Map<String, ChatRoom> map;
    private final Set<String> set;

    public ChatSystem() {
        this.map = new TreeMap<>();
        this.set = new TreeSet<>();
    }

    public void addRoom(String name) {
        map.put(name, new ChatRoom(name));
    }

    public void removeRoom(String name) {
        map.remove(name);
    }

    public ChatRoom getRoom(String name) throws NoSuchRoomException {
        if (!map.containsKey(name)) {
            throw new NoSuchRoomException(name);
        }

        return map.get(name);
    }

    public void register(String name) {
        ChatRoom cr = map.values().stream().min(Comparator.comparing(ChatRoom::numUsers).thenComparing(ChatRoom::getName)).orElse(null);

        set.add(name);

        if (cr != null) {
            cr.addUser(name);
        }
    }

    public void registerAndJoin(String user, String room) {
        if (map.containsKey(room)) {
            map.get(room).addUser(user);
        }

        set.add(user);
    }

    public void joinRoom(String user, String room) throws NoSuchRoomException, NoSuchUserException {
        if (!map.containsKey(room)) {
            throw new NoSuchRoomException(room);
        }

        if (!set.contains(user)) {
            throw new NoSuchUserException(user);
        }

        map.get(room).addUser(user);
    }

    public void leaveRoom(String user, String room) throws NoSuchRoomException, NoSuchUserException {
        if (!map.containsKey(room)) {
            throw new NoSuchRoomException(room);
        }

        if (!set.contains(user)) {
            throw new NoSuchUserException(user);
        }

        map.get(room).removeUser(user);
    }

    public void followFriend(String user, String friend) throws NoSuchUserException {
        if (!set.contains(user)) {
            throw new NoSuchUserException(friend);
        }

        for (ChatRoom cr : map.values()) {
            if (cr.hasUser(friend)) {
                cr.addUser(user);
            }
        }
    }
}