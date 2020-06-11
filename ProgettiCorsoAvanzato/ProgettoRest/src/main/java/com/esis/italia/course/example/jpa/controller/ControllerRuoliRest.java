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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Ruoli;
import com.esis.italia.course.example.jpa.respository.RuoliRepository;

/**
 * @author giamp
 *
 */
@RestController
@RequestMapping("/ruoli")
public class ControllerRuoliRest {
	
	@Autowired
	private RuoliRepository repository;
	
	//private final RuoliDAO dao=new RuoliDAO();

	@GetMapping("/{id}")
	public Ruoli getRuoliById(@PathVariable String id) {
		Ruoli result=null;
		//result=dao.selectByPK(Ruoli.class, id);
		
		result=repository.findById(id).orElse(null);
		
		return result; 
	}

	@PostMapping("/")
	public Ruoli insertRuoli(@RequestParam String nome,@RequestParam String descrizione) {
		
		//String primaryKey = dao.updateRuolo(nome, descrizione);
		//ruoli=dao.selectByPK(Ruoli.class, primaryKey);
		
		Ruoli ruoli=new Ruoli();
		ruoli.setNome(nome);
		ruoli.setDescrizione(descrizione);
		repository.save(ruoli);
		
		
		return ruoli; 
	}
	@PutMapping("/{id}")
	public Ruoli updateRuoli(@RequestParam String nome,@RequestParam String descrizione) {
		Ruoli ruoli=repository.findById(nome).orElse(new Ruoli());
		
		//String primaryKey = dao.updateRuolo(nome, descrizione);
		//ruoli=dao.selectByPK(Ruoli.class, id);
		ruoli.setDescrizione(descrizione);
		ruoli.setNome(nome);
		repository.save(ruoli);
		return ruoli; 
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteRuoli(@PathVariable String id) {
		repository.deleteById(id);
		boolean result = true;
		return result; 
	}
}

