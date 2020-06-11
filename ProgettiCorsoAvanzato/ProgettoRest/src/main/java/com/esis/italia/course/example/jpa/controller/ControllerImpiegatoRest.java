/**
 * 
 */
package com.esis.italia.course.example.jpa.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.ImpiegatoPK;
import com.esis.italia.course.example.jpa.respository.ImpiegatoRepository;

/**
 * @author giamp
 *
 */
@RestController
@RequestMapping("/impiegato")
public class ControllerImpiegatoRest {

	@Autowired
	private ImpiegatoRepository repository;

	@GetMapping("/{id}")
	public Impiegato getImpiegatoById(@PathVariable ImpiegatoPK id) {
		Impiegato result = repository.findById(id).orElse(new Impiegato());

		return result;
	}

	@PostMapping("/impiegato")
	public Impiegato insertImpiegato(@RequestParam String nome, @RequestParam String cognome,
			@RequestParam String codiceFiscale, @RequestParam String citta, @RequestParam String titoloStudio,
			@RequestParam String indirizzo, @RequestParam Date dataNascita) {
		Impiegato impiegato = new Impiegato();
		ImpiegatoPK impiegatoPK = new ImpiegatoPK();
		impiegatoPK.setNome(nome);
		impiegatoPK.setCognome(cognome);
		impiegatoPK.setCodiceFiscale(codiceFiscale);
		impiegato.setCitta(citta);
		impiegato.setTitoloStudio(titoloStudio);
		impiegato.setIndirizzo(indirizzo);
		impiegato.setDataNascita(dataNascita);
		repository.save(impiegato);
		return impiegato;
	}

	@PutMapping("/impiegato/")
	public Impiegato updateImpiegato(@RequestParam String nome, @RequestParam String cognome,
			@RequestParam String codiceFiscale, @RequestParam String citta, @RequestParam String titoloStudio,
			@RequestParam String indirizzo, @RequestParam Date dataNascita) {
		
		ImpiegatoPK impiegatoPK = new ImpiegatoPK();
		impiegatoPK.setNome(nome);
		impiegatoPK.setCognome(cognome);
		impiegatoPK.setCodiceFiscale(codiceFiscale);
		
		Impiegato impiegato = repository.findById(impiegatoPK).orElse(new Impiegato());
		impiegato.setCitta(citta);
		impiegato.setTitoloStudio(titoloStudio);
		impiegato.setIndirizzo(indirizzo);
		impiegato.setDataNascita(dataNascita);
		repository.save(impiegato);
		
		return impiegato;
	}

	@DeleteMapping("/{id}")
	public boolean deleteImpiegato(@PathVariable ImpiegatoPK id) {
		
//		ImpiegatoPK impiegatoPK = new ImpiegatoPK();
//		impiegatoPK.setNome(nome);
//		impiegatoPK.setCognome(cognome);
//		impiegatoPK.setCodiceFiscale(codiceFiscale);
		
		boolean result=false;
		repository.deleteById(id);
		result=true;
		return result;
	}
}
