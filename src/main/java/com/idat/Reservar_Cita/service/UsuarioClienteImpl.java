package com.idat.Reservar_Cita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.Reservar_Cita.model.UsuarioCliente;
import com.idat.Reservar_Cita.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteImpl implements UsuarioClienteService {
	
	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public void guardarUsuarioCliente(UsuarioCliente usuariocliente) {
		// TODO Auto-generated method stub
		repository.save(usuariocliente);
	}

	@Override
	public void actualizarUsuarioCliente(UsuarioCliente usuariocliente) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(usuariocliente);
	}

	@Override
	public void eliminarUsuarioCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<UsuarioCliente> listarUsuarioCliente() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
			
		
	@Override
	public UsuarioCliente obtenerUsuarioClienteId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}


}


