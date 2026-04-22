package com.example.demo.controllers;

import com.example.demo.User;
import com.example.demo.userRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "User saved";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updateUser = userRepo.findById(id).orElse(null);

        if (updateUser != null) {
            updateUser.setFirstName(userDetails.getFirstName());
            updateUser.setLastName(userDetails.getLastName());
            updateUser.setAge(userDetails.getAge());
            updateUser.setOccupation(userDetails.getOccupation());
            userRepo.save(updateUser);
            return "User updated";
        }

        return "User not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "User deleted";
    }
}