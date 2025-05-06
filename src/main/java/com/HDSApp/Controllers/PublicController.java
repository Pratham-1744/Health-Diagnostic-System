package com.HDSApp.Controllers;

import com.HDSApp.Service.UserService;
import com.HDSApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/web-check")
    public String webCheck(){
        return "OK";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody User user){
            userService.saveNewUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
