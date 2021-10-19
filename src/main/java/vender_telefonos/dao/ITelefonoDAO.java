package vender_telefonos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vender_telefonos.model.Telefono;

public interface ITelefonoDAO extends JpaRepository<Telefono , Integer> {

}
