/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquitetura.eventsystem.api.mapper;

import arquitetura.eventsystem.api.request.UserRequest;
import arquitetura.eventsystem.api.response.UserResponse;
import arquitetura.eventsystem.domain.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author tiago
 */
@Component
@RequiredArgsConstructor
public class UserMapper {
    
    private final ModelMapper mapper;
    
    
    
    public User toUser(UserRequest request){
        return mapper.map(request, User.class);
    }
    
    
    public UserResponse toUserResponse(User user){
        return mapper.map(user, UserResponse.class);
    }
    
   public List<UserResponse> toUserResponseList(List<User> users){
      return users.stream()
              .map(this::toUserResponse)
              .collect(Collectors.toList());
   }
    
    
}
