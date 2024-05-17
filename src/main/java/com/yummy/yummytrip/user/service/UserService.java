package com.yummy.yummytrip.user.service;

import com.yummy.yummytrip.exception.EmptyDataException;
import com.yummy.yummytrip.exception.ErrorCode;
import com.yummy.yummytrip.exception.ExistDataException;
import com.yummy.yummytrip.user.mapper.UserMapper;
import com.yummy.yummytrip.user.model.JoinDto;
import com.yummy.yummytrip.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final BCryptPasswordEncoder encoder;

    public void signUp(JoinDto joinUser) {

        UserDto findUser = mapper.findByEmail(joinUser.getEmail());

        if (findUser != null) {
            throw new ExistDataException(ErrorCode.DATA_EXISTS);
        }

        UserDto user = UserDto.builder()
                .username(joinUser.getUsername())
                .email(joinUser.getEmail())
                .password(encoder.encode(joinUser.getPassword()))
                .birth(joinUser.getBirth())
                .usertype(joinUser.getUsertype())
                .build();

        mapper.signUp(user);
    }
}
