package com.example.market.dto.request;

import com.example.market.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResDto {
    private String jwtToken;
    private User user;
}
