package com.idat.Reservar_Cita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.Reservar_Cita.model.Hospital;
import com.idat.Reservar_Cita.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {
	
	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardarHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		repository.save(hospital);
	}

	@Override
	public void actualizarHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(hospital);
	}

	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public List<Hospital> listarHospital() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
			
		
	@Override
	public Hospital obtenerHospitalId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}


}
