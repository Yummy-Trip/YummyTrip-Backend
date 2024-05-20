package com.yummy.yummytrip.user.mapper;

import com.yummy.yummytrip.user.model.UpdateDto;
import com.yummy.yummytrip.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void signUp(UserDto user);

    public UserDto findByEmail(String email);

    public void signOut(String email);

    void update(UpdateDto updateDto);

    UserDto findEmail(UserDto userDto);

    UserDto findPassword(UserDto userDto);

    void updatePassword(UserDto findUser);
}
