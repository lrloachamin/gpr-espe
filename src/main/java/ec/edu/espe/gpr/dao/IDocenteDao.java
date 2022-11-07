package ec.edu.espe.gpr.dao;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.gpr.model.Docente;

public interface IDocenteDao extends CrudRepository<Docente, Long> {
}
