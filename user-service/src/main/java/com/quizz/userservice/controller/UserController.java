package com.quizz.userservice.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/{email}")
    public ResponseEntity<?> getUser(@PathVariable("email") String email){
        Map<String,String> map = new HashMap<>();
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
