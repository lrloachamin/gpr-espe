package ec.edu.espe.gpr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1")
public class Prueba {
	

	@GetMapping("/categories")
	public String categories(){

		return "Hola";
	}
	

}
