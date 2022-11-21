package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.ICargoDao;
import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.DocenteResponseRest;




@Service
public class IDocenteServiceImpl implements IDocenteService  {
	
	@Autowired
	private IDocenteDao docenteDao;
	@Autowired
	private ICargoDao cargoDao;
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Transactional
	@Override
	public ResponseEntity<DocenteResponseRest> save(Docente docente, String id) {
		// TODO Auto-generated method stub
		DocenteResponseRest response= new DocenteResponseRest();
		List<Docente> list= new ArrayList<>();
		try {
			Optional<Cargo> cargo=cargoDao.findById(id);
			if(cargo.isPresent()) {
				docente.setCodCargo(cargo.get());
			}else {
				response.setMetadata("Respuesta nok", "-1", "No se encontro la categoria");
				return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
			
			Usuario usuario =new Usuario();
			
			Long idLoc=usuarioDao.count()+1;
			usuario.setCodigoUsuario(idLoc.intValue());
			String[] parts = docente.getApellidoDocente().split(" ");
			String nombreUsuario=(docente.getNombreDocente().substring(0,1).concat(parts[0])).toLowerCase();
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setPasswUsuario(docente.getCedulaDocente());
			usuario.setFechaCreUsu(new Date());
			usuario.setFechaModUsuario(new Date());
			usuario.setEstadoUsuario('0');
			usuarioDao.save(usuario);
			
			Long idLocDoc=docenteDao.count()+1;
			
			docente.setCodigoDocente(idLocDoc.intValue());
			docente.setCodigoUsuario(usuario);
			Docente docentesave=docenteDao.save(docente);
			
			if(docentesave!=null) {
				
				
				list.add(docentesave);
				
				response.getDocenteResponse().setDocente(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				}else {
					response.setMetadata("Respuesta nok", "000", "Error docente no guardado");
					return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.BAD_REQUEST);
				}
			
			
		}catch(Exception e) {
			response.setMetadata("Respuesta nok", "000", "Error al guardar el docente");
			e.getStackTrace();
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}
	
	public Usuario getUserByCOdeUser(Integer codeUser) {	
		Optional<Usuario> user = this.usuarioDao.findById(codeUser);
		if (user.isPresent())
			return user.get();
		else 
			return null;
	}

	public Docente getDocentByCOdeUser(Integer codeUser) {	
		Usuario user = getUserByCOdeUser(codeUser);
		Optional<Docente> docenteOpt = this.docenteDao.findByCodigoUsuario(user);
		if (docenteOpt.isPresent())
			return docenteOpt.get();
		else 
			return null;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<DocenteResponseRest> serach() {
		DocenteResponseRest response= new DocenteResponseRest();
		try {
			List<Docente> usuarioperfil= (List<Docente>) docenteDao.findAll();
			
			response.getDocenteResponse().setDocente(usuarioperfil);
			response.setMetadata("Respuesta 0k", "200", "Respuesta exitosa");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			System.out.println("Sale");
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
	}
	
	@Override
	public Docente getDocentByCodeUser(Integer codeUser) {
		return this.getDocentByCodeUser(codeUser);
	}
}
