/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author tiago
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    
    
}
