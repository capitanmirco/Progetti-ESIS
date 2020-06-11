package com.esis.italia.course.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.Mansione;
import com.esis.italia.course.example.jpa.entity.Ruoli;
import com.esis.italia.course.example.jpa.dao.MansioneDAO;
import com.esis.italia.course.example.jpa.respository.MansioneRepository;

@RestController
public class ControllerMansioneRest {

	@Autowired
	private MansioneRepository repository;

	//private final MansioneDAO dao = new MansioneDAO();

	@GetMapping("/mansione/{id}")
	public Mansione getMansioneById(@PathVariable Integer id) {
		Mansione result = null;

		result = repository.findById(id).orElse(new Mansione());

		return result;
	}

	@PostMapping("/mansione/")
	public Mansione insertMansione(@RequestParam int idMansione, @RequestParam Impiegato impiegato, @RequestParam Ruoli ruolo) {


		Mansione mansione = new Mansione();
		mansione.setIdMansione(idMansione);
		mansione.setImpiegato(impiegato);
		mansione.setRuoli(ruolo);
		repository.save(mansione);

		return mansione;
	}

	@PutMapping("/mansione/{id}")
	public Mansione updateMansione(@RequestParam Integer idMansione, @RequestParam Impiegato impiegato, @RequestParam Ruoli ruolo) {
		Mansione mansione = null;

		mansione = repository.findById(idMansione).orElse(new Mansione());
        mansione.setImpiegato(impiegato);
        mansione.setRuoli(ruolo);
		repository.save(mansione);
		return mansione;
	}

	@DeleteMapping("/mansione/{id}")
	public boolean deleteMansione(@PathVariable Integer idMansione) {
		repository.deleteById(idMansione);
		boolean result = true;
		return result;
	}
}
