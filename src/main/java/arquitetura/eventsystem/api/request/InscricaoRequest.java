package arquitetura.eventsystem.api.request;

import arquitetura.eventsystem.domain.entity.Event;
import arquitetura.eventsystem.domain.entity.User;
import java.time.LocalDateTime;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoRequest {

    @NotBlank(message = "Id do usuário é obrigatório.")
    private Long idUsuario;

    @NotBlank(message = "Id do evento é obrigatório.")
    private Long idEvento;

//    @NotBlank(message = "Data de inscriçao é obrigatório.")
//    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
//    private LocalDateTime dataInscricao;

    
    @NotNull
    private Long usuarioId;
    
    @NotNull
    private Long eventoId;
}
