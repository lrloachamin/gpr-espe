package ec.edu.espe.gpr.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import ec.edu.espe.gpr.dao.IUsuarioDao;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.UsuarioResponseRest;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDao usuarioDao;

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

	
	

}
