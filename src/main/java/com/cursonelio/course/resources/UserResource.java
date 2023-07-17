package com.cursonelio.course.resources;

import com.cursonelio.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//RestController, fala que é um recurso web controlado pelo rest
//RequestMapping mostra o caminho que vai ser acessado
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Kirmct", "kirmct@gmail.com", "999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
