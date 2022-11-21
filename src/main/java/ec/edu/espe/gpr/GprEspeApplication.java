package ec.edu.espe.gpr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ec.edu.espe.gpr.services.IEmailService;


@SpringBootApplication

public class GprEspeApplication {
	/*
	@Autowired
	private IEmailService emservice;

*/
@Bean
public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
		}
	};
}
	public static void main(String[] args) {
		SpringApplication.run(GprEspeApplication.class, args);
		//System.out.println("Correo");
		
		
	}
	/*
	@EventListener(ApplicationReadyEvent.class)
	public void sendmail(){
		emservice.enviarCorreo("lrloachamin@espe.edu.ec", "Mensaje confirmaicon", "body");
	}
	*/
		
	

}
