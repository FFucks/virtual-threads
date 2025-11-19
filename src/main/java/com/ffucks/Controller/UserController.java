package com.ffucks.Controller;

import com.ffucks.Models.User;
import com.ffucks.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @PostMapping
    public void createUser(@RequestParam int id, @RequestParam String name) {
        service.createUser(id, name);
    }
}
