package com.idat.Reservar_Cita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.Reservar_Cita.model.Cliente;
import com.idat.Reservar_Cita.service.ClienteService;

@Controller
@RequestMapping( path = "/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Cliente>>  listar() {
		
		return new ResponseEntity<List<Cliente>>(service.listarCliente(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Cliente cliente) {
		service.guardarCliente(cliente);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		Cliente c =service.obtenerClienteId(id);
		
		if(c != null) {
			service.eliminarCliente(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Cliente cliente) {

		Cliente c =service.obtenerClienteId(cliente.getIdCliente());
		
		if(c != null) {
			service.actualizarCliente(cliente);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> obtenerId(@PathVariable Integer id) {

		Cliente c =service.obtenerClienteId(id);
		
		if(c != null) {
			return  new ResponseEntity<Cliente>(service.obtenerClienteId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

	}
}
