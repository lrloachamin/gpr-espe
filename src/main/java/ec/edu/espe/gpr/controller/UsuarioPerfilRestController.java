package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;
import ec.edu.espe.gpr.services.IUsuarioPerfilService;


@RestController
@RequestMapping("/api/v1")
public class UsuarioPerfilRestController {
	@Autowired
	private IUsuarioPerfilService usuarioperfilService;
	
	@GetMapping("/usuarioperfil")
	public ResponseEntity<UsuarioPerfilResponseRest> searchUsuarios(){
		try {
			ResponseEntity<UsuarioPerfilResponseRest> responseEntity=usuarioperfilService.search();
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
	}
	
	@PostMapping("/usuarioperfil/{codigoperfil}/{codigousuario}/{idusuper}")
	
	public ResponseEntity<UsuarioPerfilResponseRest> saveUsuariosPerdfil(
			
			@PathVariable String codigoperfil,
			@PathVariable Integer codigousuario,
			@PathVariable String idusuper
			){
		
		try {
			ResponseEntity<UsuarioPerfilResponseRest> responseEntity=usuarioperfilService.save(codigoperfil, codigousuario,idusuper);
			return responseEntity;
		}catch(Exception c) {
			return null;
		}
	}
	
	@DeleteMapping("/usuarioperfil/{id}/{idusuper}")
	public ResponseEntity<UsuarioPerfilResponseRest> deleteCategories(@PathVariable String id,@PathVariable String idusuper){
		ResponseEntity<UsuarioPerfilResponseRest> responseEntity=usuarioperfilService.delete(id,idusuper);
		return responseEntity;
	}

}
