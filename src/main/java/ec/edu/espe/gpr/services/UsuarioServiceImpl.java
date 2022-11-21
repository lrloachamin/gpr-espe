package ec.edu.espe.gpr.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.UsuarioResponseRest;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDao usuarioDao;
	@Autowired
	private IEmailService emservice;
	@Autowired
	private IDocenteDao docentedao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponseRest> search() {
		UsuarioResponseRest response= new UsuarioResponseRest();
		try {
			List<Usuario> category= (List<Usuario>) usuarioDao.findAll();
			
			response.getCategoryResponse().setCategory(category);
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			System.out.println("Entra");
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.OK);
		
	}


	@Override
	public ResponseEntity<UsuarioResponseRest> save(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<UsuarioResponseRest> login(String usuario, String pass) {
		UsuarioResponseRest response= new UsuarioResponseRest();
		try {
			List<Usuario> category= (List<Usuario>) usuarioDao.findAll();
			
			for(Usuario u: category ) {
				if(usuario.equals(u.getNombreUsuario())) {
					
					if(pass.equals(u.getPasswUsuario())) {
						category.add(u);
						response.getCategoryResponse().setCategory(category);
						response.getCategoryResponse().setCategory(category);
						response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");			
					}
					
				}else {
					
					
				}
				
			}
			
			
			System.out.println("Entra");
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.OK);
	}


	@Override
	public ResponseEntity<UsuarioResponseRest> update(Usuario usuario, Integer id) {
		UsuarioResponseRest response= new UsuarioResponseRest();
		List<Usuario> list= new ArrayList<>();
		try {
			Optional<Usuario> usuarioF=usuarioDao.findById(id);
			if(usuarioF.isPresent()) {
				usuarioF.get().setNombreUsuario(usuario.getNombreUsuario());
				usuarioF.get().setPasswUsuario(usuario.getPasswUsuario());
				usuarioF.get().setFechaCreUsu(usuario.getFechaCreUsu());
				usuarioF.get().setFechaModUsuario(usuario.getFechaModUsuario());
				usuarioF.get().setEstadoUsuario(usuario.getEstadoUsuario());
				
				
			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro el usuario");
				return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
	
			Usuario usuuariosave=usuarioDao.save(usuarioF.get());
			String correo="";
			
			if(usuuariosave!=null) {
				for(Docente d: usuarioF.get().getDocenteList()) {
						correo=d.getCorreoDocente();						
					
				}
				
				list.add(usuuariosave);
				
				response.getCategoryResponse().setCategory(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				emservice.enviarCorreo(correo, "Registro completo", "Bienvenido el administrador a aceptado su solicitud, su usuario es "
						+usuarioF.get().getNombreUsuario()+ " y su contraseña es: "+usuarioF.get().getPasswUsuario());
				
				
				}else {
					response.setMetadata("Respuesta nok", "000", "Error usuario no guardado");
					return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.BAD_REQUEST);
				}
			
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al guardar el usuario");
			e.getStackTrace();
			return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		return new ResponseEntity<UsuarioResponseRest>(response,HttpStatus.OK);
	}

	public Usuario getUserByCOdeUser(Integer codeUser) {	
		Optional<Usuario> user = this.usuarioDao.findById(codeUser);
		if (user.isPresent())
			return user.get();
		else 
			return null;
	}

	public Docente getDocentByCodeUserSearch(Integer codeUser) {	
		Usuario user = getUserByCOdeUser(codeUser);
		Optional<Docente> docenteOpt = this.docentedao.findByCodigoUsuario(user);
		if (docenteOpt.isPresent())
			return docenteOpt.get();
		else 
			return null;
	}

	@Override
	public Docente getDocentByCodeUser(Integer codeUser) {
		return this.getDocentByCodeUserSearch(codeUser);
	}
	
	

}
