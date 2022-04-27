/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author tiago
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    
    @NotBlank
    private String descricao;
    
    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime horario;
    
    @NotNull
    private Long usuarioId;
    
    
}
