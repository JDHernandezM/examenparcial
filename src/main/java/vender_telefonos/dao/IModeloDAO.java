package vender_telefonos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import vender_telefonos.model.Modelo;

public interface IModeloDAO extends JpaRepository<Modelo , Integer> {

}
