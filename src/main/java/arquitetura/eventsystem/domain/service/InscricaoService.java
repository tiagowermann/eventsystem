package arquitetura.eventsystem.domain.service;

import arquitetura.eventsystem.domain.entity.Event;
import arquitetura.eventsystem.domain.entity.Inscricao;
import arquitetura.eventsystem.domain.entity.User;
import arquitetura.eventsystem.domain.repository.EventRepository;
import arquitetura.eventsystem.domain.repository.InscricaoRepository;
import arquitetura.eventsystem.exception.BusinessException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event;

@Service
@Transactional
@RequiredArgsConstructor
public class InscricaoService {

    private final InscricaoRepository repository;
    private final UserService userService;
    private final EventService eventService;

    public List<Inscricao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Inscricao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
    
    public Inscricao salvar(Inscricao inscricao) {
        //Optional<User> optUser = userService.buscarPorId(event.getUsuario().getId());

//        if (optUser.isEmpty()) {
//            throw new BusinessException("Usuário não encontrado!");
//        }
//        boolean existeMesmoHorario = false;
//        boolean existeMesmoLocal = false;
//        boolean localHorarioIguais = false;

        //Optional<Inscricao> optHorarioEvent = repository.findByDataHoraInicio(inscricao.getDataHoraInicio());
        // não aceita underline, somente nas variáveis

        //Optional<Inscricao> optLocalEvent = repository.findByLocalEvento(inscricao.getLocalEvento());

        
//        if (optLocalEvent.isPresent() && optHorarioEvent.isPresent()) {
//            existeMesmoLocal = true;
//            existeMesmoHorario = true;
//        }
//
//        if (existeMesmoHorario == true && existeMesmoLocal == true) {
//            existeMesmoHorario = false;
//            existeMesmoLocal = false;
//        throw new BusinessException("JÁ EXISTE EVENTO PARA MESMA DATA, HORÁRIO E LOCAL!");
//        }

        //event.setUsuario(optUser.get());
//        inscricao.setDataInscricao(LocalDate.now());
        //event.setId(Long.MAX_VALUE + 1);
        
        
//        Optional<Inscricao> optInscricao = userService.buscarPorId(inscricao.getUsuario().getId());

        
        


//        Optional<Inscricao> optInscricao = repository.findById(inscricao.getId());
        Optional<User> optUser = userService.buscarPorId(inscricao.getUsuario().getId());
        Optional<Event> optEvent = eventService.buscarPorId(inscricao.getUsuario().getId());

        if (optUser.isEmpty()) {
            throw new BusinessException("User não encontrado.");
        }

        if (optEvent.isEmpty()){
            throw new BusinessException("Evento não encontrado.");
        }

        Optional<Inscricao> optHorario = repository.findByDataInscricao(inscricao.getDataInscricao());

        if (optHorario.isPresent()) {
            throw new BusinessException("Já existe inscrição para este horário");
        }

        inscricao.setUsuario(optUser.get());
        inscricao.setDataInscricao(LocalDateTime.now());
        inscricao.setId(Long.MAX_VALUE);
        inscricao.setEvento(optEvent.get());
        
        return repository.save(inscricao);
    }

    
    
    
    
    
    public Inscricao alterar(Long id, Inscricao inscricao) {
        Optional<Inscricao> optInscricao = this.buscarPorId(id);

        if (optInscricao.isEmpty()) {
            throw new BusinessException("Inscricao não encontrado!");
        }

        inscricao.setId(id);

        return salvar(inscricao);
    }

}
