package arquitetura.eventsystem.api.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    
    @NotBlank(message = "Nome do usuário é obrigatório.")
    private String nome;
    @NotBlank(message = "Sobrenome do usuário é obrigatório.")
    private String sobrenome;
    @NotBlank(message = "Email do usuário é obrigatório.")
    @Email
    private String email;
    @NotBlank(message = "CFP do usuário é obrigatório.")
    private String cpf;
    
    
}
