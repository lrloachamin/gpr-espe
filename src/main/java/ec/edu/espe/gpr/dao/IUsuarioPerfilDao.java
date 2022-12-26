package ec.edu.espe.gpr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.gpr.model.Usuario;
import ec.edu.espe.gpr.model.Usuper;

public interface IUsuarioPerfilDao extends CrudRepository<Usuper, String>{
    List<Usuper> findByCodigoUsuario(Usuario codigoUsuario);
}
