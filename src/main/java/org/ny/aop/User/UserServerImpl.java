package org.ny.aop.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public void update(User user) throws Exception {
        repository.save(user);
    }
}
