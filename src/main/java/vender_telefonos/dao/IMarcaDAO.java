package vender_telefonos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vender_telefonos.model.Marca;

public interface IMarcaDAO extends JpaRepository<Marca , Integer> {

}
