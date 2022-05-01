package arquitetura.eventsystem.api.mapper;

import arquitetura.eventsystem.api.request.EventRequest;
import arquitetura.eventsystem.api.response.EventResponse;
import arquitetura.eventsystem.domain.entity.Event;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventMapper {
    
    private final ModelMapper mapper;
    
    public Event toEvent(EventRequest request){
        return mapper.map(request, Event.class);
    }
    
    
    public EventResponse toEventResponse(Event event){
        return mapper.map(event, EventResponse.class);
    }
    
   public List<EventResponse> toEventResponseList(List<Event> events){
      return events.stream()
              .map(this::toEventResponse)
              .collect(Collectors.toList());
   }
    
}
