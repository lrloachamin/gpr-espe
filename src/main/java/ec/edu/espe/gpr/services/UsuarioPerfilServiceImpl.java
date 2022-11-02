package ec.edu.espe.gpr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.IUsuarioPerfilDao;

import ec.edu.espe.gpr.model.Usuper;
import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;

@Service
public class UsuarioPerfilServiceImpl implements IUsuarioPerfilService {
	@Autowired
	private IUsuarioPerfilDao usuarioperfilDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioPerfilResponseRest> search() {
		UsuarioPerfilResponseRest response= new UsuarioPerfilResponseRest();
		try {
			List<Usuper> usuarioperfil= (List<Usuper>) usuarioperfilDao.findAll();
			
			response.getUsuarioPerfilResponse().setUsuarioPerfil(usuarioperfil);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.OK);
		
	}

	
	

}