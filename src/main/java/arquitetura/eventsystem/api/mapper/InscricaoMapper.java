package arquitetura.eventsystem.api.mapper;

import arquitetura.eventsystem.api.request.InscricaoRequest;
import arquitetura.eventsystem.api.response.InscricaoResponse;
import arquitetura.eventsystem.domain.entity.Inscricao;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InscricaoMapper {
    
    private final ModelMapper mapper;
    
    public Inscricao toInscricao(InscricaoRequest request){
        return mapper.map(request, Inscricao.class);
    }
    
    
    public InscricaoResponse toInscricaoResponse(Inscricao inscricao){
        return mapper.map(inscricao, InscricaoResponse.class);
    }
    
   public List<InscricaoResponse> toInscricaoResponseList(List<Inscricao> inscricoes){
      return inscricoes.stream()
              .map(this::toInscricaoResponse)
              .collect(Collectors.toList());
   }
    
}
