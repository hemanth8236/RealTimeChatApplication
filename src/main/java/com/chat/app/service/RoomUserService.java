package com.chat.app.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RoomUserService {
    private final Map<String, Set<String>> roomUsers = new ConcurrentHashMap<>();

    public void addUser(String roomId, String username) {
        roomUsers.computeIfAbsent(roomId, k -> ConcurrentHashMap.newKeySet()).add(username);
    }

    public void removeUser(String roomId, String username) {
        Set<String> users = roomUsers.get(roomId);
        if (users != null) {
            users.remove(username);
            if (users.isEmpty()) roomUsers.remove(roomId);
        }
    }

    public Set<String> getUsers(String roomId) {
        return roomUsers.getOrDefault(roomId, Collections.emptySet());
    }
}
