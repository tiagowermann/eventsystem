package arquitetura.eventsystem.domain.service;

import arquitetura.eventsystem.domain.entity.User;
import arquitetura.eventsystem.domain.repository.UserRepository;
import arquitetura.eventsystem.exception.BusinessException;
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
        
        boolean existeCpf = false;
        
        //Seria buscar um usuario por cpf
        Optional<User> optUser = repository.findByCpf(user.getCpf());
        
        if(optUser.isPresent()){
            if(!optUser.get().getId().equals(user.getId())){
                existeCpf = true;
            }
        }
        
        if(existeCpf){
            throw new BusinessException("CPF já cadastrado!");
        }
        
        return repository.save(user);
    }
    
    public User alterar(Long id, User user) {
        Optional<User> optUser = this.buscarPorId(id);

        if (optUser.isEmpty()) {
            throw new BusinessException("Usuário não cadastrado!");
        }

        user.setId(id);

        return salvar(user);
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
