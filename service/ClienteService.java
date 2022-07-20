package com.idat.Reservar_Cita.service;

import java.util.List;

import com.idat.Reservar_Cita.model.Cliente;

public interface ClienteService {

	void guardarCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	void eliminarCliente(Integer id);
	List<Cliente> listarCliente();
	Cliente obtenerClienteId(Integer id);

}
