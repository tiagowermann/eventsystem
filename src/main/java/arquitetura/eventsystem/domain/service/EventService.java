/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.domain.service;

import arquitetura.eventsystem.domain.entity.Event;
import arquitetura.eventsystem.domain.entity.User;
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
    private final UserService userService;

    public List<Event> listarTodos() {
        return repository.findAll();
    }

    public Optional<Event> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Event salvar(Event event) {
        Optional<User> optUser = userService.buscarPorId(event.getUsuario().getId());

        if (optUser.isEmpty()) {
            throw new BusinessException("Usuário não encontrado!");
        }

        Optional<Event> optHorario = repository.findByHorario(event.getHorario());

        if (optHorario.isPresent()) {
            throw new BusinessException("Já existe horário!");
        }

        event.setUsuario(optUser.get());
        event.setDataCriacao(LocalDateTime.now());

        return repository.save(event);
    }

    public Event alterar(Long id, Event event) {
        Optional<Event> optEvent = this.buscarPorId(id);

        if (optEvent.isEmpty()) {
            throw new BusinessException("Usuário não encontrado!");
        }

        event.setId(id);

        return salvar(event);
    }

}
