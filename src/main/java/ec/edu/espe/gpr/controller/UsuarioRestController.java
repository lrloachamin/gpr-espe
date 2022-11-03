package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.response.UsuarioResponseRest;
import ec.edu.espe.gpr.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class UsuarioRestController {
	@Autowired
	private IUsuarioService usuarioService;
	

	
	/**
	 * 
	 * Obtener todas las usuarios del sistema gpr 
	 */
	
	@GetMapping("/usuario")
	public ResponseEntity<UsuarioResponseRest> searchUsuarios(){
		try {
			ResponseEntity<UsuarioResponseRest> responseEntity=usuarioService.search();
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
		
		
	}
	
}

