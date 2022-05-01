package arquitetura.eventsystem.domain.service;

import arquitetura.eventsystem.domain.entity.Login;
import arquitetura.eventsystem.domain.repository.LoginRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class LoginService implements UserDetailsService{

    private final LoginRepository repository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Login> optLogin = repository.findByUsuario(login);
    
        if (optLogin.isEmpty()){
            throw new UsernameNotFoundException("Login não encontrado");
        }
        
        Login log = optLogin.get();
        
        return new User (log.getUsuario(), log.getSenha(), new ArrayList<>());
        
    }
    
    
    public List<Login> getAll(){
        return repository.findAll();
    }
    
    
    public Login save(Login login){
        login.setSenha(passwordEncoder.encode(login.getSenha()));
        return repository.save(login);
    }
    
}
