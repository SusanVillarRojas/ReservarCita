package com.idat.Reservar_Cita.repository;

import java.util.List;

import com.idat.Reservar_Cita.model.Hospital;

public interface HospitalRepository {
	
	void guardarHospital();
	void actualizarHospital();
	void eliminarHospital();
	List<Hospital> listarHospital();
	Hospital obtenerHospitalId(Integer id);

}

