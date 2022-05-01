package arquitetura.eventsystem.api.controller;

import arquitetura.eventsystem.api.mapper.EventMapper;
import arquitetura.eventsystem.api.request.EventRequest;
import arquitetura.eventsystem.api.response.EventResponse;
import arquitetura.eventsystem.domain.entity.Event;
import arquitetura.eventsystem.domain.service.EventService;
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
@RequestMapping("/evento")
public class EventController {
    
    private final EventService service;
    private final EventMapper mapper;
    
    
    @GetMapping
    public ResponseEntity<List<EventResponse>> buscarTodos(){
        List<Event> event = service.listarTodos();
        List<EventResponse> eventResponse = mapper.toEventResponseList(event);
        
        return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> buscarPorId(@PathVariable("id") Long id){
        Optional<Event> optEvent = service.buscarPorId(id);
        
        if (optEvent.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        EventResponse eventResponse = mapper.toEventResponse(optEvent.get());
        
        return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }
    
    
    @PostMapping
    public ResponseEntity<EventResponse> salvar(@Valid @RequestBody EventRequest request){
        Event event = mapper.toEvent(request);
        Event eventSalvo = service.salvar(event);
        EventResponse eventResponse = mapper.toEventResponse(eventSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventResponse);
    }
    
    
    
    @PutMapping("/{id}")
    public ResponseEntity<EventResponse> alterar(@PathVariable("id") Long id, @RequestBody EventRequest request) {
        Event event = mapper.toEvent(request);
        Event eventSalvo = service.alterar(id, event);
        EventResponse eventResponse = mapper.toEventResponse(eventSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(eventResponse);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable("id") Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
