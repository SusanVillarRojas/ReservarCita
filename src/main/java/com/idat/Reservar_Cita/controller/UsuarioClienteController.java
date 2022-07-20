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

import com.idat.Reservar_Cita.model.UsuarioCliente;
import com.idat.Reservar_Cita.service.UsuarioClienteService;

@Controller
@RequestMapping( path = "/usuariocliente/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<UsuarioCliente>>  listar() {
		
		return new ResponseEntity<List<UsuarioCliente>>(service.listarUsuarioCliente(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente usuariocliente) {
		service.guardarUsuarioCliente(usuariocliente);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		UsuarioCliente u =service.obtenerUsuarioClienteId(id);
		
		if(u != null) {
			service.eliminarUsuarioCliente(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody UsuarioCliente usuariocliente) {

		UsuarioCliente u =service.obtenerUsuarioClienteId(usuariocliente.getIdUsuario());
		
		if(u != null) {
			service.actualizarUsuarioCliente(usuariocliente);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioCliente> obtenerId(@PathVariable Integer id) {

		UsuarioCliente u =service.obtenerUsuarioClienteId(id);
		
		if(u != null) {
			return  new ResponseEntity<UsuarioCliente>(service.obtenerUsuarioClienteId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);

	}
}

