package ec.edu.espe.gpr.services;

import org.springframework.http.ResponseEntity;


import ec.edu.espe.gpr.response.PerfilResponseRest;

public interface IPerfilService {
	
	public ResponseEntity<PerfilResponseRest> findAll();

}
