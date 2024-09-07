package org.progettipersonali.videochat.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

    private static final List<User> users = new ArrayList<User>();

    public void register(User user) {
        user.setStatus("ONLINE");
        users.add(user);
    }

    public User login(User user) {

        var userIndex = IntStream.range(0, users.size())
                .filter(i -> users.get(i).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
        var cUser = users.get(userIndex);
        if(!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
        cUser.setStatus("ONLINE");
        return cUser;
    }

    public void logout(User email) {

        var userIndex = IntStream.range(0, users.size())
                .filter(i -> users.get(i).getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
        users.get(userIndex).setStatus("OFFLINE");
    }

    public List<User> getUsers() {
        return users;
    }
}
