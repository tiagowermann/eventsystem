/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.domain.service;

import arquitetura.eventsystem.domain.entity.User;
import arquitetura.eventsystem.domain.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository repository;
    
    public User salvar(User user){
        return repository.save(user);
    }
    public List<User> listarTodos() {
        return repository.findAll();
    }
    public Optional<User> buscarPorId(Long id) {
        return repository.findById(id);
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
