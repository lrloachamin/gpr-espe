package ec.edu.espe.gpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.gpr.model.Tarea;
import ec.edu.espe.gpr.model.TareaDocente;
import ec.edu.espe.gpr.model.TareaDocenteProyecto;
import ec.edu.espe.gpr.services.TareaDocenteService;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins= {"https://mango-rock-08c52cc10.2.azurestaticapps.net","http://localhost:4200"})
@RestController
@RequestMapping(path = "/tareaDocente")
@RequiredArgsConstructor
public class TareaDocenteRestController {

    @Autowired
    private TareaDocenteService tareaDocenteService;

    @GetMapping(path = "/listarTareas")
    public ResponseEntity<List<TareaDocente>> listarTareas() {
        try {
            List<TareaDocente> tareas = this.tareaDocenteService.listarTareasDocentes();
            return ResponseEntity.ok(tareas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody TareaDocenteProyecto tareaDocenteProyecto) {
        try {
            this.tareaDocenteService.crear(tareaDocenteProyecto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<Tarea> modificar(@RequestBody Tarea tarea) {
        try {
            tarea = this.tareaDocenteService.modificarDatos(tarea);
            return ResponseEntity.ok(tarea);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
