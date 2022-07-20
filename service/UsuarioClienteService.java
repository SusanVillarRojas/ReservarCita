package com.idat.Reservar_Cita.service;

import java.util.List;
import com.idat.Reservar_Cita.model.UsuarioCliente;

public interface UsuarioClienteService {
	
	void guardarUsuarioCliente(UsuarioCliente usuariocliente);
	void actualizarUsuarioCliente(UsuarioCliente usuariocliente);
	void eliminarUsuarioCliente(Integer id);
	List<UsuarioCliente> listarUsuarioCliente();
	UsuarioCliente obtenerUsuarioClienteId(Integer id);

}
