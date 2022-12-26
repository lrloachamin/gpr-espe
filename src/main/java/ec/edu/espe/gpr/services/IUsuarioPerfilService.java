package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;


public interface IUsuarioPerfilService {
	public ResponseEntity<UsuarioPerfilResponseRest> search();
	public ResponseEntity<UsuarioPerfilResponseRest> save(String codigoperfil,Integer codigousuario , String codusuper);
	public ResponseEntity<UsuarioPerfilResponseRest> delete(String idUsuPer,String codusuper );
	public Perfil obtenerPerfil(Integer codUser);
}
