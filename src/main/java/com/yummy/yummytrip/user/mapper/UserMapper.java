package com.yummy.yummytrip.user.mapper;

import com.yummy.yummytrip.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void signUp(UserDto user);

    public UserDto findByEmail(String email);
}
