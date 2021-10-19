package vender_telefonos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vender_telefonos.dao.ITelefonoDAO;
import vender_telefonos.model.Telefono;
import vender_telefonos.service.ITelefonoService;

@Service
public class TelefonoServiceImpl implements ITelefonoService {

	@Autowired
	private ITelefonoDAO dao;	
	
	@Override
	public Telefono registrar(Telefono t) {
		return dao.save(t);
	}

	@Override
	public Telefono modificar(Telefono t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Telefono> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Telefono> listar() {
		return dao.findAll();
	}

}
