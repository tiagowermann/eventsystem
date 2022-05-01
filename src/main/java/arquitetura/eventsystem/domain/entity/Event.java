package arquitetura.eventsystem.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "evento")
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;
    
    @Column(name = "data_hora_termino")
    private LocalDateTime dataHoraTermino;
    
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    
    @Column(name = "local_evento")
    private String localEvento;
    
    //@ManyToOne
    //private User usuario;
}
