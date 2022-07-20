package com.idat.Reservar_Cita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.idat.Reservar_Cita.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

}
