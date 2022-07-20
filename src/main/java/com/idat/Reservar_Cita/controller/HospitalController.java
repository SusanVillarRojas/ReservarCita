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

import com.idat.Reservar_Cita.model.Hospital;
import com.idat.Reservar_Cita.service.HospitalService;

@Controller
@RequestMapping( path = "/hospital/v1")
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Hospital>>  listar() {
		
		return new ResponseEntity<List<Hospital>>(service.listarHospital(), HttpStatus.OK) ;
	}
	
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Hospital hospital) {
		service.guardarHospital(hospital);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	

	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

		Hospital h =service.obtenerHospitalId(id);
		
		if(h != null) {
			service.eliminarHospital(id);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Hospital hospital) {

		Hospital h =service.obtenerHospitalId(hospital.getIdHospital());
		
		if(h != null) {
			service.actualizarHospital(hospital);
			return  new ResponseEntity<Void>(HttpStatus.OK);

		}
		
		return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hospital> obtenerId(@PathVariable Integer id) {

		Hospital h =service.obtenerHospitalId(id);
		
		if(h != null) {
			return  new ResponseEntity<Hospital>(service.obtenerHospitalId(id),HttpStatus.OK);

		}
		
		return  new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);

	}
}

