package com.yummy.yummytrip.user.controller;

import com.yummy.yummytrip.user.model.JoinDto;
import com.yummy.yummytrip.user.service.UserService;
import com.yummy.yummytrip.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final JWTUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody JoinDto joinUser){
        service.signUp(joinUser);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/signout")
    public ResponseEntity signout(HttpServletRequest request, @RequestBody Map<String, String> map){
        String authorization = request.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        String email = jwtUtil.getUsername(token);
        service.signOut(email, map.get("password"));
        return new ResponseEntity(HttpStatus.OK);
    }
}
