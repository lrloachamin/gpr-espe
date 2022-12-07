package ec.edu.espe.gpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Indicador;
import ec.edu.espe.gpr.model.Tarea;
import ec.edu.espe.gpr.model.TareaDocente;
import ec.edu.espe.gpr.model.TareaDocenteProyecto;
import ec.edu.espe.gpr.model.TareaIndicador;
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
    public ResponseEntity<List<TareaDocenteProyecto>> listarTareas() {
        try {
            List<TareaDocenteProyecto> tareas = this.tareaDocenteService.listarTareasDocentes();
            return ResponseEntity.ok(tareas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarDocentes")
    public ResponseEntity<List<Docente>> listarDocentes() {
        try {
            List<Docente> docentes = this.tareaDocenteService.listarDocentes();
            return ResponseEntity.ok(docentes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarDocentesPorCargo/{codigoCargo}")
    public ResponseEntity<List<Docente>> listarDocentesPorCargo(@PathVariable String codigoCargo) {
        try {
            List<Docente> docentes = this.tareaDocenteService.obtenerDocentesPorCargo(codigoCargo);
            return ResponseEntity.ok(docentes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarIndicadores")
    public ResponseEntity<List<Indicador>> listarIndicadores() {
        try {
            List<Indicador> indicadores = this.tareaDocenteService.listarIndicadores();
            return ResponseEntity.ok(indicadores);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarDocentesTareaAsignada")
    public ResponseEntity<List<Docente>> listarDocentesTareaAsignada(@RequestBody Tarea codigoTarea) {
        try {
            List<Docente> docentes = this.tareaDocenteService.listarDocentesTareaAsignada(codigoTarea);
            return ResponseEntity.ok(docentes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarTareaAsignadaPorDocente/{codigoDocente}")
    public ResponseEntity<List<TareaDocente>> listarTareaAsignadaPorDocente(@PathVariable Integer codigoDocente) {
        try {
            List<TareaDocente> tareaDocente = this.tareaDocenteService.listarTareaAsignadaPorDocente(codigoDocente);
            return ResponseEntity.ok(tareaDocente);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarIndicadoresPorTarea/{codigoTareaDocente}")
    public ResponseEntity<List<TareaIndicador>> listarIndicadoresPorTarea(@PathVariable Integer codigoTareaDocente) {
        try {
            List<TareaIndicador> tareaIndicador = this.tareaDocenteService.listarIndicadoresPorTarea(codigoTareaDocente);
            return ResponseEntity.ok(tareaIndicador);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/listarTareasEntregadas")
    public ResponseEntity<List<TareaDocente>> listarTareasEntregadas() {
        try {
            List<TareaDocente> tareaDocentes = this.tareaDocenteService.listarTareasEntregadas();
            return ResponseEntity.ok(tareaDocentes);
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
    public ResponseEntity<TareaDocente> modificar(@RequestBody TareaDocenteProyecto tareaDocenteProyecto) {
        try {
            TareaDocente tareaDocente = this.tareaDocenteService.modificarDatos(tareaDocenteProyecto);
            return ResponseEntity.ok(tareaDocente);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/guardarTareaAsignadaAlProfesor")
    public ResponseEntity<TareaDocente> guardarTareaAsignadaAlProfesor(@RequestBody List<TareaIndicador> tareaIndicadors) {
        try {
            this.tareaDocenteService.guardarTareaAsignadaAlProfesor(tareaIndicadors);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/guardarArchivoTareaAsignadaAlProfesor")
    public ResponseEntity<String> guardarArchivoTareaAsignadaAlProfesor(@RequestParam("file") MultipartFile file,@RequestParam("codigoTareaDocente") String codigoTareaDocente){
        try{
            this.tareaDocenteService.guardarArchivoTareaAsignadaAlProfesor(file,Integer.parseInt(codigoTareaDocente));
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/aprobarTareaDocente")
    public ResponseEntity<String> aprobarTareaDocente(@RequestBody TareaDocente tareaDocente){
        try{
            this.tareaDocenteService.aprobarTareaDocente(tareaDocente);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/denegarTareaDocente")
    public ResponseEntity<String> denegarTareaDocente(@RequestBody TareaDocente tareaDocente){
        try{
            this.tareaDocenteService.denegarTareaDocente(tareaDocente);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
