package com.picpaysimplificado.Controllers;

import com.picpaysimplificado.DTOS.UserDTO;
import com.picpaysimplificado.domain.user.User;

import com.picpaysimplificado.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(UserDTO user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED).getBody();
    }

    @PostMapping
    public ResponseEntity<List<User>> getAllUsers(){
      List<User> users = this.userService.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
