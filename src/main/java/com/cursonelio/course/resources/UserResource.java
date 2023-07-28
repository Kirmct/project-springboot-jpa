package com.cursonelio.course.resources;

import com.cursonelio.course.entities.User;
import com.cursonelio.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


//RestController, fala que é um recurso web controlado pelo rest
//RequestMapping mostra o caminho que vai ser acessado
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping//pois é um método de insercao
    public ResponseEntity<User> insert(@RequestBody User obj){//falar que no corpo teremos um obj
        obj = service.insert(obj);
        //fazemos deste modo para na resposta da request venha o codigo 201, nao o 200
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ //Void pois nao retorna nada
        service.delete(id);
        return ResponseEntity.noContent().build(); //pois nao temos corpo/conteudo de resposta
    }
}
