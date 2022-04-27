/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.api.controller;

import arquitetura.eventsystem.api.mapper.UserMapper;
import arquitetura.eventsystem.api.request.UserRequest;
import arquitetura.eventsystem.api.response.UserResponse;
import arquitetura.eventsystem.domain.entity.User;
import arquitetura.eventsystem.domain.service.UserService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {
    
    private final UserService service;
    private final UserMapper mapper;
    
    @PostMapping        //com segurança de dados(Request/Response/Mapper)
    public ResponseEntity<UserResponse> salvar(@Valid @RequestBody UserRequest request) {
        // recebe a request e transforma para usuario
        User user = mapper.toUser(request);
        //retorna o usuario salvo com o ID
        User userSalvo = service.salvar(user);
        // transforma o paciente para o response para retornar
        UserResponse userResponse = mapper.toUserResponse(userSalvo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
    
    @GetMapping
    public ResponseEntity<List<UserResponse>> listarTodos() {
        List<User> pacientes = service.listarTodos();
        List<UserResponse> pacienteResponses = mapper.toUserResponseList(pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponses);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable("id") Long id) {
        Optional<User> optUser = service.buscarPorId(id);
        
        if(optUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
       
        return ResponseEntity.status(HttpStatus.OK).body(optUser.get());
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> alterar(@PathVariable("id") Long id, @RequestBody UserRequest request) {
        User user = mapper.toUser(request);
        User userSalvo = service.alterar(id, user);
        UserResponse pacienteResponse = mapper.toUserResponse(userSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponse);
    }
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}