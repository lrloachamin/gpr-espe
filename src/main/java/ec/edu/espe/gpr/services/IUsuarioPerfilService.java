package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;



import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;


public interface IUsuarioPerfilService {
	public ResponseEntity<UsuarioPerfilResponseRest> search();
	public ResponseEntity<UsuarioPerfilResponseRest> save(String codigoperfil,Integer codigousuario );
	public ResponseEntity<UsuarioPerfilResponseRest> delete(String idUsuPer );

}
