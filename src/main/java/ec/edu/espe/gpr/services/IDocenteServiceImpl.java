package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.gpr.dao.IDocenteDao;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.response.DocenteResponseRest;



@Service
public class IDocenteServiceImpl implements IDocenteService  {
	
	@Autowired
	private IDocenteDao docenteDao;
	
	@Transactional
	@Override
	public ResponseEntity<DocenteResponseRest> save(Docente docente) {
		
		DocenteResponseRest response= new DocenteResponseRest();
		List<Docente> list= new ArrayList<>();
		try {
			
			
			Docente docentesave=docenteDao.save(docente);
			if(docentesave!=null) {
				
				
			list.add(docentesave);
			
			response.getDocenteResponse().setDocente(list);
			response.setMetadata("Respuesta 0k", "000", "Respuesta exitosa");
			}else {
				response.setMetadata("Respuesta nok", "000", "Error docente no guardada");
				return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.NOT_FOUND);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta nok", "000", "Error al guardar el docente");
			e.getStackTrace();
			return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<DocenteResponseRest>(response,HttpStatus.OK);
		
	
	}

}
