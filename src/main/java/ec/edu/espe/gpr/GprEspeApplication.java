package ec.edu.espe.gpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GprEspeApplication {
	
	@GetMapping("/message")
	public String message() {
		return "Prueba inicial";
	}

	public static void main(String[] args) {
		SpringApplication.run(GprEspeApplication.class, args);
	}

}
