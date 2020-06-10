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
	
	@Autowired
	private AziendaPK idAzienda;
	
	@Autowired
	private Azienda result;
	
	
	@GetMapping("/azienda/get")
	public Azienda getAziendaById(@RequestParam String nome, @RequestParam String pIva) {
	
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		result = repository.getOne(idAzienda);
		return result; 
	}
	
	
	@PostMapping("/azienda/insert")
	public Azienda insertAzienda(
			@RequestParam String nome, 
			@RequestParam String pIva, 
			@RequestParam String descrizione) {
		
		
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		Azienda azienda = new Azienda();
		azienda.setId(idAzienda);
		azienda.setDescrizione(descrizione);
		
		result = repository.save(azienda);
		return result;
		
	}
	
	
	@PutMapping("/azienda/update")
	public boolean updateAzienda(
			@RequestParam String nome, 
			@RequestParam String pIva, 
			@RequestParam String descrizione) {
		
		
		idAzienda.setNome(nome);
		idAzienda.setpIva(pIva);
		
		if(repository.existsById(idAzienda)) {
			repository.updateDescrizione(nome, pIva, descrizione);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	@DeleteMapping("/azienda/delete")
	public boolean deleteAzienda(
			@RequestParam String nome, 
			@RequestParam String pIva) {
		
		
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