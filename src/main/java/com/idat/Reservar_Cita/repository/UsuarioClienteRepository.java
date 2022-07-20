package com.idat.Reservar_Cita.repository;

import java.util.List;

import com.idat.Reservar_Cita.model.UsuarioCliente;

public interface UsuarioClienteRepository {
	
	void guardarUsuarioCliente();
	void actualizarUsuarioCliente();
	void eliminarUsuarioCliente();
	List<UsuarioCliente> listarUsuarioCliente();
	UsuarioCliente obtenerUsuarioClienteId(Integer id);

}


