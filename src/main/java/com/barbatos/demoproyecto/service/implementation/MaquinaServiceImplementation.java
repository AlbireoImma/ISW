package com.barbatos.demoproyecto.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.barbatos.demoproyecto.commons.GenericServiceImplementation;
import com.barbatos.demoproyecto.dao.api.MaquinaDaoAPI;
import com.barbatos.demoproyecto.model.Maquina;
import com.barbatos.demoproyecto.service.api.MaquinaServiceAPI;

@Service
public class MaquinaServiceImplementation extends GenericServiceImplementation<Maquina,Long> implements MaquinaServiceAPI{

	@Autowired
	private MaquinaDaoAPI maquinaDaoApi; 
	
	@Override
	public CrudRepository<Maquina, Long> getDao() {
		return maquinaDaoApi;
	}
	
}
