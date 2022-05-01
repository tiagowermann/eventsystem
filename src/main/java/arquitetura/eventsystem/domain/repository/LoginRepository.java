package arquitetura.eventsystem.domain.repository;

import arquitetura.eventsystem.domain.entity.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
    
    Optional<Login> findByUsuario(String usuario);
    
}
