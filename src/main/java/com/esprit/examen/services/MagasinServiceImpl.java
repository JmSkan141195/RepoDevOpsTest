package com.esprit.examen.services;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MagasinServiceImpl implements IMagasinService {

	@Autowired
	MagasinRepository magasinRepository;

	@Override
	public List<Magasin> retrieveAllMagasins() {
		List<Magasin> magasins = magasinRepository.findAll();
		for (Magasin magasin : magasins) {
			log.info(" magasin : " + magasin);
		}
		return magasins;
	}


	@Override
	public Magasin addMagasin(Magasin m) {
		magasinRepository.save(m);
		return m;
	}
	


	public Magasin updateMagasin(Magasin m) {
		magasinRepository.save(m);
		return m;
	}

	@Override
	public void deleteMagasin(Long id) {
		magasinRepository.deleteById(id);

	}

	@Override
	public Magasin retrieveMagasin(Long id) {

		Magasin magasin = magasinRepository.findById(id).orElse(null);
		return magasin;
	}

}