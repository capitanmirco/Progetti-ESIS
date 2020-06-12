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

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;
import com.esis.italia.course.example.jpa.entity.Dipartimento;
import com.esis.italia.course.example.jpa.respository.DipartimentoRepository;
@RestController
@RequestMapping("/dipartimento")
public class ControllerDipartimentoRest {
	@Autowired
	private DipartimentoRepository repository;
	//private final DipartimentoDAO dao=new DipartimentoDAO();
	@GetMapping("/{id}")
	public @ResponseBody Dipartimento getDipartimentoById(@PathVariable Integer id) {
		Dipartimento result=null;
		result=repository.findById(id).orElse(null);
		return result; 
	}
	@PostMapping("/")
	public @ResponseBody Dipartimento insertDipartimento(@RequestBody Dipartimento d) {
		
		repository.save(d);
		return d; 
	}
	@PutMapping("/")
	public void updateDipartimento(@RequestBody Dipartimento d) {
		Dipartimento dip=repository.findById(d.getPrimaryKey()).orElse(null);
		
		dip.setAzienda(d.getAzienda());
		dip.setDescrizione(d.getDescrizione());
		repository.save(dip);
		
	}
	@DeleteMapping("/{idDipartimento}")
	public @ResponseBody boolean deleteDipartimento(@PathVariable Integer idDipartimento) {
		repository.deleteById(idDipartimento);
		boolean result = true;
		return result; 
	}
}
