package vender_telefonos.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vender_telefonos.dao.IModeloDAO;
import vender_telefonos.model.Modelo;
import vender_telefonos.service.IModeloService;

@Service
public class ModeloServiceImpl implements IModeloService {

	@Autowired
	private IModeloDAO dao;	
	
	@Override
	public Modelo registrar(Modelo t) {
		return dao.save(t);
	}

	@Override
	public Modelo modificar(Modelo t) {
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);		
	}

	@Override
	public Optional<Modelo> listarPorId(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Modelo> listar() {
		return dao.findAll();
	}

}
