package com.enexse.testjava.controller;

import com.enexse.testjava.model.User;
import com.enexse.testjava.repository.UserRepository;
import com.enexse.testjava.service.UserService;
import com.enexse.testjava.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/agents")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/agent")
    public ResponseEntity<User> saveUser(@RequestBody User U){
        User saveUser = userService.saveUser(U);
        return ResponseEntity.ok(saveUser);
    }

    @GetMapping("/agents/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId ){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId , @RequestBody User userDetails){
        User user = userService.getUser(userId);
        user.setUserName(userDetails.getUserName());
        user.setFullName(userDetails.getFullName());
        user.setGender(userDetails.getGender());
        user.setEmail(userDetails.getEmail());
        user.setEmailPec(userDetails.getEmailPec());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setLastLogin(userDetails.getLastLogin());
        user.setCreatedAt(userDetails.getCreatedAt());
        user.setActive(userDetails.getActive());
        user.setRole(userDetails.getRole());


        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable String userId){
        User userdelete = userService.getUser(userId);
        userService.deleteUser(userdelete);
        Map<String,Boolean> response = new HashMap<>();
        response.put("user deleted successfully",true);
        return ResponseEntity.ok(response);
    }







}
