package com.yummy.yummytrip.user.model;

import com.yummy.yummytrip.util.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JoinDto {
    private String username;
    private String email;
    private String password;
    private LocalDate birth;
    private Role usertype;
}
