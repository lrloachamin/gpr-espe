package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Docente;
import ec.edu.espe.gpr.model.Tarea;
import ec.edu.espe.gpr.model.TareaDocente;

public interface ITareaDocenteDao extends JpaRepository<TareaDocente, Integer>{
    List<TareaDocente> findByCodigoTarea(Tarea codigoTarea);
    List<TareaDocente> findByCodigoDocente(Docente codigoDocente);
}
