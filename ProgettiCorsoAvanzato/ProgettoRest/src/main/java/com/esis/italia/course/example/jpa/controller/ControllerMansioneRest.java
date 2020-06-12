package com.esis.italia.course.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.Mansione;
import com.esis.italia.course.example.jpa.entity.Ruoli;
import com.esis.italia.course.example.jpa.dao.MansioneDAO;
import com.esis.italia.course.example.jpa.respository.MansioneRepository;

@RestController
@RequestMapping("/mansione")
public class ControllerMansioneRest {

	@Autowired
	private MansioneRepository repository;

	//private final MansioneDAO dao = new MansioneDAO();

	@GetMapping("/{id}")
	public @ResponseBody Mansione getMansioneById(@PathVariable Integer id) {
		Mansione result = null;

		result = repository.findById(id).orElse(new Mansione());

		return result;
	}

	@PostMapping("/")
	public @ResponseBody Mansione insertMansione(@RequestParam Mansione mansione) {
		repository.save(mansione);

		return mansione;
	}

	@PutMapping("/")
	public @ResponseBody Mansione updateMansione(@RequestBody Mansione man) {

		Mansione mansione = new Mansione();
		mansione = repository.findById(man.getIdMansione()).orElse(new Mansione());
        mansione.setImpiegato(man.getImpiegato());
        mansione.setRuoli(man.getRuoli());
		repository.save(mansione);
		return mansione;
	}

	@DeleteMapping("/{id}")
	public @ResponseBody boolean deleteMansione(@PathVariable Integer idMansione) {
		repository.deleteById(idMansione);
		boolean result = true;
		return result;
	}
}
