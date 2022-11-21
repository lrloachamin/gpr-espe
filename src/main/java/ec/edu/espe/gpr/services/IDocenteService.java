package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.response.DocenteResponseRest;


public interface IDocenteService {
	public ResponseEntity<DocenteResponseRest> serach();
	public ResponseEntity<DocenteResponseRest> save(Docente docente, String id);
	public Docente getDocentByCodeUser(Integer codeUser);

}
