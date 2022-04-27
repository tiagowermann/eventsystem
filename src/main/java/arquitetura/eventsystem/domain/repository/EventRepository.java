/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.domain.repository;

import arquitetura.eventsystem.domain.entity.Event;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tiago
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    Optional<Event> findByHorario(LocalDateTime horario);
    
}
