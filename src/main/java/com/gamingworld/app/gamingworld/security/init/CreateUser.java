package com.gamingworld.app.gamingworld.security.init;

import com.gamingworld.app.gamingworld.security.domain.model.entity.User;
import com.gamingworld.app.gamingworld.security.domain.persistence.AuthorityRepository;
import com.gamingworld.app.gamingworld.security.domain.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CreateUser implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

//        User juan = new User();
//        juan.setUsername("juan");
//        juan.setPassword(passwordEncoder.encode("juan"));
//        juan.setEnable(true);
//        juan.setLastName("XXXX");
//        juan.setName("YYYYY");
//        juan.setRole("STUDENT");
//
//        juan.addAuthority("ROLE_USER");
//
//        User admin = new User();
//        admin.setUsername("antonio");
//        admin.setPassword(passwordEncoder.encode("antonio"));
//        admin.setEnable(true);
//        admin.setLastName("XXXX");
//        admin.setName("YYYYY");
//        admin.setRole("ADMIN");
//
//        admin.addAuthority("ROLE_ADMIN");
//
//
//        List<User> users = Arrays.asList(juan, admin);
//        this.userRepository.saveAll(users);

    }
}
