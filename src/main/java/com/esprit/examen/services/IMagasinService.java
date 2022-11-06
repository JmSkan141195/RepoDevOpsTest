package com.esprit.examen.services;

import com.esprit.examen.entities.Magasin;

import java.util.List;

public interface IMagasinService {

	List<Magasin> retrieveAllMagasins();

	Magasin addMagasin(Magasin f);

	void deleteMagasin(Long id);

	Magasin updateMagasin(Magasin f);

	Magasin retrieveMagasin(Long id);

}
