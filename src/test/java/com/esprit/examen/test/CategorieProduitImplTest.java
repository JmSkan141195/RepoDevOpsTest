package com.esprit.examen.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.TpAchatProjectApplication;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.services.ICategorieProduitService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = TpAchatProjectApplication.class)
class CategorieProduitImplTest {

	@Autowired
    private ICategorieProduitService CategorieProduitService;
	
	 @Test 
	@Order(1)
	public void testAddCategorie() {
		CategorieProduit op = CategorieProduitService.addCategorieProduit(CategorieProduit.builder().codeCategorie("Door").libelleCategorie("chair").build());
		Assertions.assertNotNull(op);
	}
	
	@Test
	@Order(2)
	public void testRetrieveAllCategorie() {
		int listOperateur = CategorieProduitService.retrieveAllCategorieProduits().size();
		CategorieProduitService.addCategorieProduit(CategorieProduit.builder().codeCategorie("Door1").libelleCategorie("chair1").build());
		Assertions.assertEquals(listOperateur+1,CategorieProduitService.retrieveAllCategorieProduits().size());
	}
	
	 @Test 
	@Order(3)
	public void testUpdateCategorieProduit() {
		 CategorieProduit p = CategorieProduitService.updateCategorieProduit(CategorieProduit.builder().codeCategorie("Door2").libelleCategorie("chair2").build());
		Assertions.assertNotNull(p);
	}
	
}
