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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping("/{id}")
	public @ResponseBody Ruoli getRuoliById(@PathVariable String id) {
		Ruoli result=null;
		
		result=repository.findById(id).orElse(null);
		
		return result; 
	}

	@PostMapping(path ="/")
	public @ResponseBody Ruoli insertRuoli(@RequestBody Ruoli ruoli) {
		//@RequestParam String nome,@RequestParam String descrizione
		//String primaryKey = dao.updateRuolo(nome, descrizione);
		//ruoli=dao.selectByPK(Ruoli.class, primaryKey);
		
//		Ruoli ruoli=new Ruoli();
//		ruoli.setNome(nome);
//		ruoli.setDescrizione(descrizione);
		repository.save(ruoli);
		
		
		return ruoli; 
	}
	@PutMapping(path ="/")
	public @ResponseBody Ruoli updateRuoli(@RequestBody Ruoli ruoli) {
//		public Ruoli updateRuoli(@RequestParam String nome,@RequestParam String descrizione) {
//		Ruoli ruoli=repository.findById(nome).orElse(new Ruoli());
		Ruoli ruoliId=repository.findById(ruoli.getNome()).orElse(new Ruoli());
		
		//String primaryKey = dao.updateRuolo(nome, descrizione);
		//ruoli=dao.selectByPK(Ruoli.class, id);
		ruoliId.setDescrizione(ruoli.getDescrizione());
		repository.save(ruoli);
		return ruoli; 
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody boolean deleteRuoli(@PathVariable String id) {
		repository.deleteById(id);
		boolean result = true;
		return result; 
	}
}

