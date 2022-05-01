package arquitetura.eventsystem.api.request;

import java.time.LocalDateTime;
import javax.validation.constraints.Future;
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
public class EventRequest {
    
    @NotNull
    private String descricao;
    
    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime dataHoraInicio;
    
    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime dataHoraTermino;
    
    @NotNull
    private String localEvento;
    
    //@NotNull
    //private Long usuarioId;
    
    
}
