package ec.edu.espe.gpr.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.ITareaDao;
import ec.edu.espe.gpr.dao.ITareaDocenteDao;
import ec.edu.espe.gpr.dao.IndicadorDao;
import ec.edu.espe.gpr.dao.TareaIndicadorDao;
import ec.edu.espe.gpr.enums.EstadoTareaDocenteEnum;
import ec.edu.espe.gpr.enums.EstadoTareaEnum;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Indicador;
import ec.edu.espe.gpr.model.Tarea;
import ec.edu.espe.gpr.model.TareaDocente;
import ec.edu.espe.gpr.model.TareaDocenteProyecto;
import ec.edu.espe.gpr.model.TareaIndicador;

@Service
public class TareaDocenteService {
	
	@Autowired
	private ITareaDao tareaDao;
    @Autowired
	private ITareaDocenteDao tareaDocenteDao;
    @Autowired
	private IDocenteDao docenteDao;
    @Autowired
	private IndicadorDao indicadorDao;
    @Autowired
	private TareaIndicadorDao tareaIndicadorDao;

	public Tarea obtenerTareaPorCodigoTarea(Integer codTarea) {	
		Optional<Tarea> tareaOpt = this.tareaDao.findById(codTarea);
		if (tareaOpt.isPresent())
			return tareaOpt.get();
		else 
			return null;
	}

    public Docente obtenerDocentePorCodigoDocente(Integer codigoDocente) {	
		Optional<Docente> docenteOpt = this.docenteDao.findByCodigoDocente(codigoDocente);
		if (docenteOpt.isPresent())
			return docenteOpt.get();
		else 
			return null;
	}

	public List<TareaDocente> listarTareasDocentes() {
        return this.tareaDocenteDao.findAll();
    }

    public List<Docente> listarDocentes() {
        return this.docenteDao.findAll();
    }

    public List<Indicador> listarIndicadores() {
        return this.indicadorDao.findAll();
    }

    public List<Docente> listarDocentesTareaAsignada(Tarea codigoTarea) {
        List<TareaDocente> tareas=this.tareaDocenteDao.findByCodigoTarea(codigoTarea);
        List<Docente> docentes = new ArrayList<>();
        for(TareaDocente tarea : tareas){
            docentes.add(tarea.getCodigoDocente());
        } 
        return docentes;
    }

    public List<TareaDocente> listarTareaAsignadaPorDocente(Integer codigoDocente) {
        Docente docente = this.obtenerDocentePorCodigoDocente(codigoDocente);
        List<TareaDocente> tareas=this.tareaDocenteDao.findByCodigoDocente(docente);
        return tareas;
    }
	
    public void crear(TareaDocenteProyecto tareaDocenteProyecto) {
        tareaDocenteProyecto.getTarea().setFechaCreaciontarea(new Date());
        tareaDocenteProyecto.getTarea().setEstadoTarea(EstadoTareaEnum.ACTIVE.getValue().charAt(0));
        
        Tarea tarea =this.tareaDao.save(tareaDocenteProyecto.getTarea());
        for(Docente docente :tareaDocenteProyecto.getDocentes()){
            TareaDocente t = new TareaDocente();
            t.setEstadoTareaDocente(EstadoTareaDocenteEnum.ACTIVE.getValue());
            t.setCodigoDocente(docente);
            t.setCodigoTarea(tarea);
            TareaDocente tDocenteBD=this.tareaDocenteDao.save(t);
            for (Indicador indicador : tareaDocenteProyecto.getIndicadors()) {
                TareaIndicador indicadorBD = new TareaIndicador();
                indicadorBD.setFechaCreacionIndicador(new Date());
                indicadorBD.setIndicadorCODIGOINDICADOR(indicador);
                indicadorBD.setTareadocenteCODIGOTAREADOCENTE(tDocenteBD);  
                this.tareaIndicadorDao.save(indicadorBD);          
            }
        }
    }

    public TareaDocente modificarDatos(TareaDocente tareaDocente) {
        this.tareaDocenteDao.save(tareaDocente);
        this.tareaDao.save(tareaDocente.getCodigoTarea());
        return tareaDocente;
    }

}
