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
@CrossOrigin("http://localhost:8080")
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
		Magasin ms = magasinService.retrieveMagasin(magasinId);
		return ms;
	}

	@PostMapping("/add-magasin")
	@ResponseBody
	public Magasin addMagasin(@RequestBody Magasin mag) {
		Magasin magasin = new Magasin();
		magasin = mag;
		magasinService.addMagasin(magasin);
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
