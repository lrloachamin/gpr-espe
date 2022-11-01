package ec.edu.espe.gpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin(origins= {"https://gpr-espe.azurewebsites.net"})
@RestController
@RequestMapping("/api/v1")
public class GprEspeApplication {
	
	@GetMapping("/message")
	public String message() {
		return "Prueba inicial";
	}

	public static void main(String[] args) {
		SpringApplication.run(GprEspeApplication.class, args);
	}

}
