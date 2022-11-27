package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import ec.edu.espe.gpr.dao.ICargoDao;
import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.response.CargoResponseRest;
import ec.edu.espe.gpr.response.UsuarioResponseRest;


@Service
public class ICargoServiceImpl implements ICargoService{
	@Autowired
	private ICargoDao cargodao;


	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CargoResponseRest> find() {
		CargoResponseRest response= new CargoResponseRest();
		try {
			List<Cargo> cargo= (List<Cargo>) cargodao.findAll();
			response.getCargoResponse().setCargo(cargo);
			response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar");
			e.getStackTrace();
			return new ResponseEntity<CargoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<CargoResponseRest>(response,HttpStatus.OK);
		
	}

	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<CargoResponseRest> findById(String codCargo) {
		CargoResponseRest response= new CargoResponseRest();
		List<Cargo> list= new ArrayList<>();
		try {
			Optional<Cargo> category=cargodao.findById(codCargo);
			if(category.isPresent()) {
				list.add(category.get());
				response.getCargoResponse().setCargo(list);
				response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
				
			}else {
				response.setMetadata("Respuesta nok", "000", "Error cargo no encontrada");
				return new ResponseEntity<CargoResponseRest>(response,HttpStatus.NOT_FOUND);
				
			}
				
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error Consultar por id");
			e.getStackTrace();
			
			
		}
		return new ResponseEntity<CargoResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CargoResponseRest> save(Cargo cargo) {
		CargoResponseRest response= new CargoResponseRest();
		List<Cargo> list= new ArrayList<>();
		try {
			
			Cargo cargosave=cargodao.save(cargo);
			if(cargosave!=null) {
			list.add(cargosave);
			
			response.getCargoResponse().setCargo(list);
			response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
			}else {
				response.setMetadata("Respuesta nok", "000", "Error categoria no guardada");
				return new ResponseEntity<CargoResponseRest>(response,HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error al guardar categoria");
			e.getStackTrace();
			return new ResponseEntity<CargoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<CargoResponseRest>(response,HttpStatus.OK);
	}
	
	

}
