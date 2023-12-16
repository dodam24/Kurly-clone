package com.example.market.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SignupRequestDto {
    private String userName;
    private String password;
    private String email;
    private String nickname;
    private String phoneNumber;
    private String address;
    private String birthday;
    private String confirmPassword;

}
