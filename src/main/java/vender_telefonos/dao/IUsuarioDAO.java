package vender_telefonos.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import vender_telefonos.model.Usuario;



//import com.mitocode.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {

	Usuario findOneByUsername(String username);
}
