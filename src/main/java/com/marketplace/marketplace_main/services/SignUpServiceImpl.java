package com.marketplace.marketplace_main.services;

import com.marketplace.marketplace_main.dto.SignUpForm;
import com.marketplace.marketplace_main.models.User;
import com.marketplace.marketplace_main.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService{

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm signUpForm) {
        User user = User.builder()
                .email(signUpForm.getEmail())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .build();

        usersRepository.save(user);
    }
}
