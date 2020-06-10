package com.esis.italia.course.example.jpa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.dao.AziendaDAO;
import com.esis.italia.course.example.jpa.dao.DipartimentoDAO;
import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;
import com.esis.italia.course.example.jpa.entity.Dipartimento;
import com.esis.italia.course.example.jpa.respository.DipartimentoRepository;
@RestController
public class ControllerDipartimentoRest {
	@Autowired
	private DipartimentoRepository repository;
	private final DipartimentoDAO dao=new DipartimentoDAO();
	@GetMapping("/dipartimento/{id}")
	public Dipartimento getDipartimentoById(@PathVariable String id_dipartimento) {
		Dipartimento result=null;
		result=repository.findById(id_dipartimento).orElse(null);
		return result; 
	}
	@PostMapping("/dipartimento/")
	public Dipartimento insertDipartimento(@RequestParam String nome,@RequestParam String descrizione, @RequestParam AziendaPK idAzienda, @RequestParam String descrizioneAzienda) {
		Dipartimento d = new Dipartimento();
		Azienda b = new Azienda();
		b.setDescrizione(descrizioneAzienda);
		b.setId(idAzienda);
		d.setNomeDipartimento(nome);
		d.setDescrizione(descrizione);
		d.setAzienda(b);
		repository.save(d);
		return d; 
	}
	@PutMapping("/dipartimento/{id}")
	public Dipartimento updateDipartimento(@RequestParam String descrizione,@RequestParam AziendaPK aziendaPk,@RequestParam Integer idDipartimento) {
		Dipartimento d=null;
		//d=dao.selectByPK(d.class, idDipartimento);
		AziendaDAO aziendaDao = new AziendaDAO();
		Azienda azienda = aziendaDao.selectByPK(Azienda.class, aziendaPk);
		d.setAzienda(azienda);
		d.setDescrizione(descrizione);
		repository.save(d);
		return d; 
	}
	@DeleteMapping("/dipartimento/{id}")
	public boolean deleteDipartimento(@PathVariable Integer idDipartimento) {
		boolean result = dao.deleteDipartimento(idDipartimento);
		return result; 
	}
}
