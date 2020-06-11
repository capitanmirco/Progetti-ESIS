package com.esis.italia.course.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;
import com.esis.italia.course.example.jpa.respository.AziendaRepository;



@RestController
@RequestMapping("/azienda")
public class ControllerAziendaRest {
	

	@Autowired
	private AziendaRepository repository;
	
	
	@GetMapping("/{id}")
	public Azienda getAziendaById(@RequestParam AziendaPK id) {
		Azienda result = repository.findById(id).orElse(new Azienda());

		return result; 
	}
	
	
	@PostMapping("/")
	public Azienda insertAzienda(
			@RequestParam String nome, 
			@RequestParam String pIva, 
			@RequestParam String descrizione) {
		
		AziendaPK idAzienda = new AziendaPK();
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		Azienda azienda = new Azienda();
		azienda.setId(idAzienda);
		azienda.setDescrizione(descrizione);
		
		Azienda result = new Azienda();
		result = repository.save(azienda);
		return result;
	}
	
	
	@PutMapping("/{id}")
	public boolean updateAzienda(Integer id,
			@RequestParam String nome, 
			@RequestParam String pIva, 
			@RequestParam String descrizione) {
		
		AziendaPK idAzienda = new AziendaPK();
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		Azienda azienda = new Azienda();
		azienda.setId(idAzienda);
		azienda.setDescrizione(descrizione);
		
		if(repository.existsById(idAzienda)) {
			repository.save(azienda);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public boolean deleteAzienda(@RequestParam AziendaPK id) {
		
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}	
		else {
			return false;
		}
		
	}
	
	
}