/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.api.controller;

import arquitetura.eventsystem.domain.entity.User;
import arquitetura.eventsystem.domain.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping()
public class UserController {
    
    private final UserService service;
    
    @PostMapping
    public ResponseEntity<User> salvar(@RequestBody User user) {
        User userSalvo = service.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSalvo);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> procurarTodos() {
        List<User> users = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
