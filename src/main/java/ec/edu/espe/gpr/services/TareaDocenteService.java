package ec.edu.espe.gpr.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.espe.gpr.dao.IDocenteDao;
import ec.edu.espe.gpr.dao.ITareaDao;
import ec.edu.espe.gpr.dao.ITareaDocenteDao;
import ec.edu.espe.gpr.enums.EstadoTareaDocenteEnum;
import ec.edu.espe.gpr.enums.EstadoTareaEnum;
import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Tarea;
import ec.edu.espe.gpr.model.TareaDocente;
import ec.edu.espe.gpr.model.TareaDocenteProyecto;

@Service
public class TareaDocenteService {
	
	@Autowired
	private ITareaDao tareaDao;
    @Autowired
	private ITareaDocenteDao tareaDocenteDao;
    @Autowired
	private IDocenteDao docenteDao;

	public Tarea obtenerTareaPorCodigoTarea(Integer codTarea) {	
		Optional<Tarea> tareaOpt = this.tareaDao.findById(codTarea);
		if (tareaOpt.isPresent())
			return tareaOpt.get();
		else 
			return null;
	}

    public Tarea obtenerDocentePorCodigoDocente(Integer codTarea) {	
		Optional<Tarea> tareaOpt = this.tareaDao.findById(codTarea);
		if (tareaOpt.isPresent())
			return tareaOpt.get();
		else 
			return null;
	}

	public List<TareaDocente> listarTareasDocentes() {
        return this.tareaDocenteDao.findAll();
    }

    public List<Docente> listarDocentes() {
        return this.docenteDao.findAll();
    }
	
    public void crear(TareaDocenteProyecto tareaDocenteProyecto) {
        Long codTarea = tareaDao.count()+1;
        tareaDocenteProyecto.getTarea().setCodigoTarea(codTarea.intValue());
        tareaDocenteProyecto.getTarea().setFechaCreaciontarea(new Date());
        tareaDocenteProyecto.getTarea().setEstadoTarea(EstadoTareaEnum.ACTIVE.getValue().charAt(0));
        this.tareaDao.save(tareaDocenteProyecto.getTarea());

        Long codTareaDocente = tareaDocenteDao.count()+1;
        tareaDocenteProyecto.getTareaDocente().setCodigoTareaDocente(codTareaDocente.intValue());
        tareaDocenteProyecto.getTareaDocente().setCodigoTarea(tareaDocenteProyecto.getTarea());
        tareaDocenteProyecto.getTareaDocente().setArchivoTareaDocente("");
        tareaDocenteProyecto.getTareaDocente().setDescripcionTareadocente("");
        tareaDocenteProyecto.getTareaDocente().setArchivoTareaDocente("");
        tareaDocenteProyecto.getTareaDocente().setEstadoTareaDocente(EstadoTareaDocenteEnum.ACTIVE.getValue());

        this.tareaDocenteDao.save(tareaDocenteProyecto.getTareaDocente());
    }

    public Tarea modificarDatos(Tarea tarea) {
        this.tareaDao.save(tarea);
        return tarea;
    }

}
