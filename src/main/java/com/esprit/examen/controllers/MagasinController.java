package com.esprit.examen.controllers;

import com.esprit.examen.entities.Magasin;
import com.esprit.examen.services.IMagasinService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Gestion des magasins")
@RequestMapping("/magasin")
@CrossOrigin("*")
public class MagasinController {

	@Autowired
	IMagasinService magasinService;

	@GetMapping("/retrieve-all-magasins")
	@ResponseBody
	public List<Magasin> getMagasins() {
		List<Magasin> listM = magasinService.retrieveAllMagasins();
		return listM;
	}

	@GetMapping("/retrieve-magasin/{magasin-id}")
	@ResponseBody
	public Magasin retrieveMagasin(@PathVariable("magasin-id") Long magasinId) {
		return magasinService.retrieveMagasin(magasinId);
	}

	@PostMapping("/add-magasin")
	@ResponseBody
	public Magasin addMagasin(@RequestBody Magasin mag) {
		Magasin magasin = magasinService.addMagasin(mag);
		return magasin;
	}

	@DeleteMapping("/remove-magasin/{magasin-id}")
	@ResponseBody
	public void removeMagasin(@PathVariable("magasin-id") Long magasinId) {
		magasinService.deleteMagasin(magasinId);
	}

	@PutMapping("/modify-magasin")
	@ResponseBody
	public Magasin modifyMagasin(@RequestBody Magasin magasin) {
		return magasinService.updateMagasin(magasin);
	}

	
}
