package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import ec.edu.espe.gpr.dao.IPerfilDao;
import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.dao.IUsuarioPerfilDao;

import ec.edu.espe.gpr.model.Usuper;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Perfil;
import ec.edu.espe.gpr.response.DocenteResponseRest;
import ec.edu.espe.gpr.response.UsuarioPerfilResponse;
import ec.edu.espe.gpr.response.UsuarioPerfilResponseRest;

@Service
public class UsuarioPerfilServiceImpl implements IUsuarioPerfilService {
	@Autowired
	private IUsuarioPerfilDao usuarioperfilDao;
	@Autowired
	private IUsuarioDao usuarioDao;
	@Autowired
	private IPerfilDao perfilDao;

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

	@Override
	public ResponseEntity<UsuarioPerfilResponseRest> save(String codigoperfil,Integer codigousuario) {
		UsuarioPerfilResponseRest response = new UsuarioPerfilResponseRest();
		List<Usuper> list= new ArrayList<>();
		try {
			
			Usuper usuper= new Usuper();
			Optional<Usuario> usuario=usuarioDao.findById(codigousuario);
			if(usuario.isPresent()) {
				usuper.setCodigoUsuario(usuario.get());

			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el usuario");
				return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
			
			Optional<Perfil> perfil=perfilDao.findById(codigoperfil);
			if(perfil.isPresent()) {
				usuper.setCodigoPerfil(perfil.get());
			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el perfil");
				return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
			
			usuper.setFechaAsgUsuper(new Date());
			usuper.setFechRetiroUsuperOpcper(new Date());
			
			Long idLocUsuPer=usuarioperfilDao.count()+1;
			usuper.setCodUsuper(idLocUsuPer.toString());
			Usuper usupersave=usuarioperfilDao.save(usuper);
			
			if(usupersave!=null) {
				list.add(usupersave);
				response.getUsuarioPerfilResponse().setUsuarioPerfil(list); 
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				
			}else {
				response.setMetadata("Respuesta nok", "000", "Error docente no guardado");
				return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.BAD_REQUEST);
				
			}
			
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al el perfil del usuario");
			e.getStackTrace();
			
		}
		
		return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<UsuarioPerfilResponseRest> delete(String idUsuPer) {
		UsuarioPerfilResponseRest response= new UsuarioPerfilResponseRest();
		
		try {
			usuarioperfilDao.deleteById(idUsuPer);
			response.setMetadata("Respuesta nok", "000", "Registro eliminado");
		
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error eliminar por id");
			e.getStackTrace();
			
			
		}
		return new ResponseEntity<UsuarioPerfilResponseRest>(response,HttpStatus.OK);
	}

	
	

}