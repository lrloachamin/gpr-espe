package ec.edu.espe.gpr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.gpr.model.Docente;

public interface IDocenteDao extends JpaRepository<Docente, Long> {
    Optional<Docente> findByCodigoDocente(Integer codigoDocente);
}
