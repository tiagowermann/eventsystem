package arquitetura.eventsystem.domain.service;

import arquitetura.eventsystem.domain.entity.Event;
import arquitetura.eventsystem.domain.repository.EventRepository;
import arquitetura.eventsystem.exception.BusinessException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;
    //private final UserService userService;

    public List<Event> listarTodos() {
        return repository.findAll();
    }

    public Optional<Event> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Event salvar(Event event) {
        //Optional<User> optUser = userService.buscarPorId(event.getUsuario().getId());

//        if (optUser.isEmpty()) {
//            throw new BusinessException("Usuário não encontrado!");
//        }
        boolean existeMesmoHorario = false;
        boolean existeMesmoLocal = false;
        boolean localHorarioIguais = false;

        Optional<Event> optHorarioEvent = repository.findByDataHoraInicio(event.getDataHoraInicio());
        // não aceita underline, somente nas variáveis

        Optional<Event> optLocalEvent = repository.findByLocalEvento(event.getLocalEvento());

        
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
        event.setDataCriacao(LocalDateTime.now());
//        event.setId(Long.MAX_VALUE + 1);

        return repository.save(event);
    }

    public Event alterar(Long id, Event event) {
        Optional<Event> optEvent = this.buscarPorId(id);

        if (optEvent.isEmpty()) {
            throw new BusinessException("Evento não encontrado!");
        }

        event.setId(id);

        return salvar(event);
    }
    
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
