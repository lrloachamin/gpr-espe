package ec.edu.espe.gpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Cargo;
import ec.edu.espe.gpr.response.CargoResponseRest;
import ec.edu.espe.gpr.services.ICargoService;



@RestController
@RequestMapping("/api/v1")
public class CargoRestController {
	@Autowired
	private ICargoService cargoservice;
	

	@GetMapping("/cargos")
	public ResponseEntity<CargoResponseRest> buscarcargos(){
		ResponseEntity<CargoResponseRest> responseEntity=cargoservice.find();
		return responseEntity;
	}

	
	@GetMapping("/cargos/{id}")
	public ResponseEntity<CargoResponseRest> buscarCargosID(@PathVariable String id){
		ResponseEntity<CargoResponseRest> responseEntity=cargoservice.findById(id);
		return responseEntity;
	}
	

	
	@PostMapping("/cargos")
	public ResponseEntity<CargoResponseRest> saveCargos(@RequestBody Cargo cargo){
		ResponseEntity<CargoResponseRest> responseEntity=cargoservice.save(cargo);
		return responseEntity;
	}

}
