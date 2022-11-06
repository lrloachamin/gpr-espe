package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.UsuarioResponseRest;



public interface IUsuarioService {
	
	public ResponseEntity<UsuarioResponseRest> search();
	public ResponseEntity<UsuarioResponseRest> save(Usuario usuario);

	
			

}
