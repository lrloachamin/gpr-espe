package ec.edu.espe.gpr;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GprEspeApplication {
	
	@GetMapping("/")
	public String index() {
		return "Prueba inicial";
	}
	


}
