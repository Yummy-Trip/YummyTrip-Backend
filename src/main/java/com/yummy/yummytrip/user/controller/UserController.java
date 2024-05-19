package com.yummy.yummytrip.user.controller;

import com.yummy.yummytrip.user.model.JoinDto;
import com.yummy.yummytrip.user.model.UpdateDto;
import com.yummy.yummytrip.user.model.UserDto;
import com.yummy.yummytrip.user.service.UserService;
import com.yummy.yummytrip.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final JWTUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody JoinDto joinUser) {
        service.signUp(joinUser);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/user")
    public ResponseEntity modify(HttpServletRequest request, @RequestBody UpdateDto updateDto) {
        String authorization = request.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        String email = jwtUtil.getUsername(token);
        updateDto.setEmail(email);
        service.modify(updateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/email")
    public String findEmail(@RequestBody UserDto userDto) {
        return service.findEmail(userDto);
    }

    @GetMapping("/user/password")
    public String findPassword(@RequestBody UserDto userDto) {
        return service.findPassword(userDto);
    }
}
