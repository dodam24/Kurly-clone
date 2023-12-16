package com.example.market.service;


import com.example.market.dto.request.SignupRequestDto;
import com.example.market.dto.request.UserRequestDto;
import com.example.market.exception.ApiRequestException;
import com.example.market.repository.UserRepository;
import com.example.market.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.market.domain.User;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;


    public boolean checkUsernameDuplicate(String userName){
        return userRepository.existsByUserName(userName);

    }


    public void registerUser(SignupRequestDto requestDto){
        String username = requestDto.getUserName();
        String email =  requestDto.getEmail();
        String nickname = requestDto.getNickname();
        String phoneNumber = requestDto.getPhoneNumber();
        String address = requestDto.getAddress();
        String birthday = requestDto.getBirthday();
        String password = requestDto.getPassword();
        String passwordConfirm = requestDto.getConfirmPassword();

        if (!password.isEmpty() && !passwordConfirm.isEmpty()) {
            if (password.length() >= 6 && password.length() <= 20) {
                if (!password.equals(passwordConfirm)) {
                    throw new ApiRequestException("패스워드가 일치하지 않습니다!");
                }
            } else {
                throw new ApiRequestException("비밀번호는  6~20자리를 사용해야 합니다.");
            }
        } else {
            throw new ApiRequestException("패스워드를 입력해 주세요.");
        }
        // 패스워드 인코딩
        password = passwordEncoder.encode(password);

        User user = new User(username, password, nickname, phoneNumber, address);
        userRepository.save(user);


    }


    public String createToken(UserRequestDto user) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.createToken(authentication);
    }

    public User findUser(UserRequestDto userRequestDto) {
        String username= userRequestDto.getUserName();
        User user = userRepository.findByUserName(username).orElseThrow(
                ()-> new IllegalArgumentException("유저를 찾을 수 없습니다")
        );
        return user;
    }


}
