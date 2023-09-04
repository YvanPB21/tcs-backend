package com.example.tata;

import com.example.tata.database.entities.UserEntity;
import com.example.tata.database.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableWebMvc
public class TataApplication {

    //ONLY FOR TESTING!!!!!!
    @Autowired
    private UserRepository repository;
    @PostConstruct
    public void initUsers() {
        List<UserEntity> users = Stream.of(
                new UserEntity(102, "user1", "pwd1", "user1@gmail.com"),
                new UserEntity(103, "user2", "pwd2", "user2@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(TataApplication.class, args);
    }

}
