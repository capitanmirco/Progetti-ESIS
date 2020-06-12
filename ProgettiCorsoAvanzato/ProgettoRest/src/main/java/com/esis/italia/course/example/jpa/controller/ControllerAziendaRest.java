package com.esis.italia.course.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;
import com.esis.italia.course.example.jpa.respository.AziendaRepository;

@RestController
@RequestMapping("/azienda")
public class ControllerAziendaRest {

	@Autowired
	private AziendaRepository repository;

	@GetMapping("/{nome}/{partitaIva}")
	public @ResponseBody Azienda getAziendaById(@PathVariable String nome, @PathVariable String partitaIva) {
		AziendaPK aziendaPK = new AziendaPK();
		aziendaPK.setNome(nome);
		aziendaPK.setpIva(partitaIva);
		Azienda result = repository.findById(aziendaPK).orElse(new Azienda());

		return result;
	}

	@PostMapping("/")
	public @ResponseBody Azienda insertAzienda(@RequestBody Azienda azienda) {

		Azienda result = repository.save(azienda);
		return result;
	}

	@PutMapping("/")
	public @ResponseBody boolean updateAzienda(@RequestBody Azienda azienda) {
		if (repository.existsById(azienda.getId())) {
			repository.save(azienda);
			return true;
		} else {
			return false;
		}

	}

	@DeleteMapping("/{nome}/{partitaIva}")
	public @ResponseBody boolean deleteAzienda(@PathVariable String nome, @PathVariable String partitaIva) {
		AziendaPK aziendaPK = new AziendaPK();
		aziendaPK.setNome(nome);
		aziendaPK.setpIva(partitaIva);
		if (repository.existsById(aziendaPK)) {
			repository.deleteById(aziendaPK);
			return true;
		} else {
			return false;
		}

	}

}