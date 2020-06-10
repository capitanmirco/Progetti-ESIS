/**
 * 
 */
package com.esis.italia.course.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.dao.RuoliDAO;
import com.esis.italia.course.example.jpa.entity.Ruoli;
import com.esis.italia.course.example.jpa.respository.RuoliRepository;

/**
 * @author giamp
 *
 */
@RestController
public class ControllerRuoliRest {
	
	@Autowired
	private RuoliRepository repository;
	
	private final RuoliDAO dao=new RuoliDAO();

	@GetMapping("/ruoli/{id}")
	public Ruoli getRuoliById(@PathVariable String id) {
		Ruoli result=null;
		//result=dao.selectByPK(Ruoli.class, id);
		
		result=repository.findById(id).orElse(null);
		
		return result; 
	}

	@PostMapping("/ruoli/")
	public Ruoli insertRuoli(@RequestParam String nome,@RequestParam String descrizione) {
		
		//String primaryKey = dao.updateRuolo(nome, descrizione);
		//ruoli=dao.selectByPK(Ruoli.class, primaryKey);
		
		Ruoli ruoli=new Ruoli();
		ruoli.setNome(nome);
		ruoli.setDescrizione(descrizione);
		repository.save(ruoli);
		
		
		return ruoli; 
	}
	@PutMapping("/ruoli/{id}")
	public Ruoli updateRuoli(@PathVariable String id,@RequestParam String nome,@RequestParam String descrizione) {
		Ruoli ruoli=null;
		
		//String primaryKey = dao.updateRuolo(nome, descrizione);
		ruoli=dao.selectByPK(Ruoli.class, id);
		ruoli.setDescrizione(descrizione);
		ruoli.setNome(nome);
		repository.save(ruoli);
		return ruoli; 
	}
	
	@DeleteMapping("/ruoli/{id}")
	public boolean deleteRuoli(@PathVariable String id) {
		boolean result = dao.deleteRuolo(id);
		return result; 
	}
}

