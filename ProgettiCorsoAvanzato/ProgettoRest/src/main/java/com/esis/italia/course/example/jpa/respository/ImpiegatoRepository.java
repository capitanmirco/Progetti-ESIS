package com.esis.italia.course.example.jpa.respository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.ImpiegatoPK;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, ImpiegatoPK>{
	
	public Impiegato findByIdNome(String nome);
	
	public Impiegato findByIdCognome(String cognome);
	
	public Impiegato findByIdCodiceFiscale(String codiceFiscale);
	
	
	
	
	
	
	public Impiegato findByIndirizzo(String indirizzo);
	
	public Impiegato findByDataNascita(Date dataNascita);
	
	public Impiegato findByTitoloStudio(String titoloStudio);
	
	public Impiegato findByCitta(String citta);
	
}
