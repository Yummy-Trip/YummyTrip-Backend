package com.yummy.yummytrip.user.model;

import com.yummy.yummytrip.util.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  UserDto {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private LocalDateTime birth;
    private Role usertype;
    //private boolean isExpired;
}
