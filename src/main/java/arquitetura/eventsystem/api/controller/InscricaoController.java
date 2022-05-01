package arquitetura.eventsystem.api.controller;

import arquitetura.eventsystem.api.mapper.InscricaoMapper;
import arquitetura.eventsystem.api.request.InscricaoRequest;
import arquitetura.eventsystem.api.response.InscricaoResponse;
import arquitetura.eventsystem.domain.entity.Inscricao;
import arquitetura.eventsystem.domain.service.InscricaoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inscricao")
public class InscricaoController {
    
    private final InscricaoService service;
    private final InscricaoMapper mapper;
    
    @PostMapping        //com segurança de dados(Request/Response/Mapper)
    public ResponseEntity<InscricaoResponse> salvar(@Valid @RequestBody InscricaoRequest request) {
        Inscricao inscricao = mapper.toInscricao(request);
        Inscricao inscricaoSalva = service.salvar(inscricao);
        InscricaoResponse inscricaoResponse = mapper.toInscricaoResponse(inscricaoSalva);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoResponse);
    }
    
    @GetMapping
    public ResponseEntity<List<InscricaoResponse>> listarTodos() {
        List<Inscricao> inscricoes = service.listarTodos();
        List<InscricaoResponse> inscricaoResponse = mapper.toInscricaoResponseList(inscricoes);
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoResponse);
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> buscarPorId(@PathVariable("id") Long id) {
        Optional<Inscricao> optInscricao = service.buscarPorId(id);
        
        if(optInscricao.isEmpty()){
            return ResponseEntity.notFound().build();
        }
       
        return ResponseEntity.status(HttpStatus.OK).body(optInscricao.get());
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<InscricaoResponse> alterar(@PathVariable("id") Long id, @RequestBody InscricaoRequest request) {
        Inscricao inscricao = mapper.toInscricao(request);
        Inscricao inscricaoSalva = service.alterar(id, inscricao);
        InscricaoResponse inscricaoResponse = mapper.toInscricaoResponse(inscricaoSalva);
        return ResponseEntity.status(HttpStatus.OK).body(inscricaoResponse);
    }
    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}