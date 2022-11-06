package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.response.DocenteResponseRest;
import ec.edu.espe.gpr.services.IDocenteService;


@RestController
@RequestMapping("/api/v1")
public class DocenteRestController {
	@Autowired
	private IDocenteService docenteservice;

	@PostMapping("/docentes")
	public ResponseEntity<DocenteResponseRest> saveCategories(@RequestBody Docente docente){
		ResponseEntity<DocenteResponseRest> responseEntity=docenteservice.save(docente);
		return responseEntity;
	}
}