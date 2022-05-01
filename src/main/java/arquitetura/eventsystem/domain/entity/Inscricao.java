package arquitetura.eventsystem.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inscricao")
public class Inscricao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name = "id_usuario")
    private int idUsuario;
    
    @Column(name = "id_evento")
    private int idEvento;
    
    
    @Column(name = "data_inscricao")
    private LocalDateTime dataInscricao;
    
    @ManyToOne
    private User usuario;
    
    @ManyToOne
    private Event evento;
    
}
