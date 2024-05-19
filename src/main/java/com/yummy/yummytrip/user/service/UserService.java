package com.yummy.yummytrip.user.service;

import com.yummy.yummytrip.exception.EmptyDataException;
import com.yummy.yummytrip.exception.ErrorCode;
import com.yummy.yummytrip.exception.ExistDataException;
import com.yummy.yummytrip.user.mapper.UserMapper;
import com.yummy.yummytrip.user.model.JoinDto;
import com.yummy.yummytrip.user.model.UpdateDto;
import com.yummy.yummytrip.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

import static com.yummy.yummytrip.util.PasswordUtils.DATA_FOR_RANDOM_STRING;
import static com.yummy.yummytrip.util.PasswordUtils.LENGTH;

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

    public void modify(UpdateDto updateDto) {
        updateDto.setPassword(encoder.encode(updateDto.getPassword()));
        mapper.update(updateDto);
    }

    public String findEmail(UserDto userDto) {
        UserDto findUser = mapper.findEmail(userDto);

        if (findUser == null) {
            throw new EmptyDataException(ErrorCode.DATA_NOT_EXISTS);
        }

        return findUser.getEmail();
    }

    public String findPassword(UserDto userDto) {
        UserDto findUser = mapper.findPassword(userDto);
        if (findUser == null) {
            throw new EmptyDataException(ErrorCode.DATA_NOT_EXISTS);
        }
        String newPassword = generateTemporaryPassword();
        findUser.setPassword(encoder.encode(generateTemporaryPassword()));
        mapper.updatePassword(findUser);
        return newPassword;
    }

    public String generateTemporaryPassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
