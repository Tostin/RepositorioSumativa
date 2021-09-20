package com.everis.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.Registro;
import com.everis.data.models.Venta;

public interface RegistroRepository extends JpaRepository<Registro, Long>{
	

}
