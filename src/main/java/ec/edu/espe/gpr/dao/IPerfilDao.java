package ec.edu.espe.gpr.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.gpr.model.Perfil;

public interface IPerfilDao extends CrudRepository<Perfil, String> {
	Optional <Perfil> findByCodigoPerfilPadre(Perfil codigoPerfilPadre);
}
