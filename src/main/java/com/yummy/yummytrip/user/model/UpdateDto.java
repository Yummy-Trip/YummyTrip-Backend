package com.yummy.yummytrip.user.model;

import com.yummy.yummytrip.util.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class UpdateDto {
    private String username;
    private String email;
    private String password;
    private LocalDate birth;
    private Role usertype;
}
