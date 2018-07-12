package org.ny.aop.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    public void update(User user) throws Exception;
}

