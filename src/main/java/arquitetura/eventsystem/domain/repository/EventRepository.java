package arquitetura.eventsystem.domain.repository;

import arquitetura.eventsystem.domain.entity.Event;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    
    Optional<Event> findByDataHoraInicio(LocalDateTime data_hora_inicio);
    // não aceita underline, somente nas variáveis
    
    Optional<Event> findByLocalEvento (String localEvento);
}
