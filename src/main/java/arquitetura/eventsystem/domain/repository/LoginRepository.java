/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.domain.repository;

import arquitetura.eventsystem.domain.entity.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tiago
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long>{
    
    Optional<Login> findByUsuario(String usuario);
    
}
