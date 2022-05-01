package arquitetura.eventsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsystemApplication.class, args);
	}
        
        //CustomAuthenticationFilterConfig
        //customização para o tempo de validade do token
        //.withExpiresAt(new Date(System.currentTimeMillis() + 120 * 60 * 1000))
}
