package ec.edu.espe.gpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class GprEspeApplication {
	/*
	@Autowired
	private IEmailService emservice;

*/
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
