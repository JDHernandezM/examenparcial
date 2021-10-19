package vender_telefonos.service;


import java.util.List;

import vender_telefonos.model.Menu;



public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
