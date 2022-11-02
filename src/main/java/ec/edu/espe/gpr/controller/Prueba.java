package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.response.UsuarioResponseRest;
import ec.edu.espe.gpr.services.IUsuarioService;

@RestController
@RequestMapping("/api/v1")
public class Prueba {
	@Autowired
	private IUsuarioService usuarioService;
	

	@GetMapping("/prueba")
	public String prueba(){

		return "Prueba 3";
	}
	
	

}
