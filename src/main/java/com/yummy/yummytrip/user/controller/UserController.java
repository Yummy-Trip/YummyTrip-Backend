package com.yummy.yummytrip.user.controller;

import com.yummy.yummytrip.user.model.JoinDto;
import com.yummy.yummytrip.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody JoinDto joinUser){
        System.out.println("joinUser = " + joinUser);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
