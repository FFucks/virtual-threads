package com.ffucks.Service;

import com.ffucks.Models.User;
import com.ffucks.Repository.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repo) {
        this.repository = repo;
    }

    public User getUser(int id) {
        try {
            return repository.findUser(id);

            //It could be do this but spring boot manage the threads for me
            /*Thread.startVirtualThread(() -> {
                var user = repo.findUser(1);
                System.out.println(user);
            });*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(int id, String name) {
        try {
            repository.saveUser(new User(id, name));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
