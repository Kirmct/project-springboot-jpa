package com.cursonelio.course.config;

import com.cursonelio.course.entities.User;
import com.cursonelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")//so vai rodar quando no application estivermos usando o perfil de test
public class TestConfig implements CommandLineRunner {//tudo sera executado quando app iniciada

    @Autowired
    private UserRepository userRepository; //injetando dependencia implicito/automatico


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
