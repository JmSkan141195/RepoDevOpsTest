package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.*;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperateurServiceImplTest {
	@Autowired
	IOperateurService opService;

	
	@Test
	public void testAddOperateur() throws ParseException {

		Operateur operateur = new Operateur("Iskander", "Jouini", "000000");
		Operateur o = opService.addOperateur(operateur);
		System.out.print("operateur "+o);
		assertNotNull(o.getIdOperateur());
		assertTrue(o.getPassword().length() > 0);
		opService.deleteOperateur(o.getIdOperateur());

	}
	@Test
	public void testDeleteOperateur() throws ParseException {
		Operateur op = new Operateur("Mohammed", "Ben Ali", "000000");
		Operateur o = opService.addOperateur(op);
		opService.deleteOperateur(o.getIdOperateur());
		assertNull(opService.retrieveOperateur(o.getIdOperateur()));
	}

	@Test
	public void testRetrieveAllOperateurs() throws ParseException {
		List<Operateur> operateurs = opService.retrieveAllOperateurs();
		int expected = operateurs.size();
		Operateur op = new Operateur("Melek", "Jouini", "111111");
		Operateur operateur = opService.addOperateur(op);
		assertEquals(expected + 1, opService.retrieveAllOperateurs().size());
		opService.deleteOperateur(operateur.getIdOperateur());

	}

}