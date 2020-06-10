package com.esis.italia.course.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;
import com.esis.italia.course.example.jpa.respository.AziendaRepository;



@RestController
public class ControllerAziendaRest {
	

	@Autowired
	private AziendaRepository repository;
	
	
	@GetMapping("/azienda")
	public Azienda getAziendaById(
			@RequestParam String nome, 
			@RequestParam String pIva) {
	
		AziendaPK idAzienda = new AziendaPK();
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		Azienda result = new Azienda();
		result = repository.getOne(idAzienda);
		return result; 
	}
	
	
	@PostMapping("/azienda")
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
	
	
	@PutMapping("/azienda")
	public boolean updateAzienda(
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
	
	
	@DeleteMapping("/azienda")
	public boolean deleteAzienda(
			@RequestParam String nome, 
			@RequestParam String pIva) {
		
		AziendaPK idAzienda = new AziendaPK();
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		Azienda azienda = new Azienda();
		azienda.setId(idAzienda);
		
		if(repository.existsById(idAzienda)) {
			repository.deleteById(idAzienda);
			return true;
		}	
		else {
			return false;
		}
		
	}
	
	
}