package com.yummy.yummytrip.user.controller;

import com.yummy.yummytrip.user.model.JoinDto;
import com.yummy.yummytrip.user.model.UpdateDto;
import com.yummy.yummytrip.user.model.UserDto;
import com.yummy.yummytrip.user.service.UserService;
import com.yummy.yummytrip.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private final UserService service;
    private final JWTUtil jwtUtil;

    @PostMapping("/join")
    public ResponseEntity signup(@RequestBody JoinDto joinUser) {
        service.signUp(joinUser);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/leave")
    public ResponseEntity signout(HttpServletRequest request, @RequestBody Map<String, String> map){
        String authorization = request.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        String email = jwtUtil.getUsername(token);
        service.signOut(email, map.get("password"));
        return new ResponseEntity(HttpStatus.OK);
    }
  
    @PatchMapping("/update")
    public ResponseEntity modify(HttpServletRequest request, @RequestBody UpdateDto updateDto) {
        String authorization = request.getHeader("Authorization");
        String token = authorization.split(" ")[1];
        String email = jwtUtil.getUsername(token);
        updateDto.setEmail(email);
        service.modify(updateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/email")
    public String findEmail(@RequestBody UserDto userDto) {
        return service.findEmail(userDto);
    }

    @GetMapping("/password")
    public String findPassword(@RequestBody UserDto userDto) {
        return service.findPassword(userDto);
    }
}
