package ec.edu.espe.gpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Tarea;

public interface ITareaDao extends JpaRepository<Tarea, Integer> {
}