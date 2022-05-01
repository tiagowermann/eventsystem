package arquitetura.eventsystem.domain.repository;

import arquitetura.eventsystem.domain.entity.Event;
import arquitetura.eventsystem.domain.entity.Inscricao;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    
    Optional<Inscricao> findById(String id);
    // não aceita underline, somente nas variáveis
    
    Optional<Inscricao> findByDataInscricao (LocalDateTime inscricao);
}
