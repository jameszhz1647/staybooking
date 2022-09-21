package com.jameszhz.staybooking.service;

import com.jameszhz.staybooking.exception.UserAlreadyExistException;
import com.jameszhz.staybooking.model.Authority;
import com.jameszhz.staybooking.model.User;
import com.jameszhz.staybooking.model.UserRole;
import com.jameszhz.staybooking.repository.AuthorityRepository;
import com.jameszhz.staybooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE) // make sure同步add， atomic
    public void add(User user, UserRole role) throws UserAlreadyExistException {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistException("User already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); //加密
        user.setEnabled(true);

        userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), role.name()));
    }
}
