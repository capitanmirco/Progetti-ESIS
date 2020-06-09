/**
 * 
 */
package com.esis.course.example.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.Ruoli;
import com.esis.italia.course.example.jpa.dao.RuoliDAO;

/**
 * @author giamp
 *
 */
@RestController
public class ControllerRuoliRest {

	@GetMapping("/getRuoli/{id}")
	public Ruoli getRuoliById(@PathVariable String id) {
		Ruoli result=null;
		RuoliDAO dao=new RuoliDAO();
		result=dao.selectByPK(Ruoli.class, id);
		return result; 
	}

	@PostMapping("/insertRuoli/")
	public Ruoli insertRuoli(@PathVariable String id) {
		Ruoli ruoli=new Ruoli();
		ruoli.setDescrizione("proprietaDescrizione");
		ruoli.setNome("proprietaNome");
		return ruoli; 
	}
	@PutMapping("/updateRuoli/{id}")
	public Ruoli updateRuoli(@PathVariable String id) {
		Ruoli ruoli=new Ruoli();
		ruoli.setDescrizione("proprietaDescrizione");
		ruoli.setNome("proprietaNome");
		return ruoli; 
	}
	
	@DeleteMapping("/deleteRuoli/{id}")
	public Ruoli deleteRuoli(@PathVariable String id) {
		Ruoli ruoli=new Ruoli();
		ruoli.setDescrizione("proprietaDescrizione");
		ruoli.setNome("proprietaNome");
		return ruoli; 
	}
}

