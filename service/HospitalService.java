package com.idat.Reservar_Cita.service;

import java.util.List;
import com.idat.Reservar_Cita.model.Hospital;

public interface HospitalService {
	
	void guardarHospital(Hospital hospital);
	void actualizarHospital(Hospital hospital);
	void eliminarHospital(Integer id);
	List<Hospital> listarHospital();
	Hospital obtenerHospitalId(Integer id);

}
