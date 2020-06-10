package com.esis.italia.course.example.jpa.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.ImpiegatoPK;
import com.esis.italia.course.example.jpa.entity.Ruoli;

public interface ImpiegatoRepository extends JpaRepository<Impiegato, String>{
	Impiegato findByNome(String nome);
	Impiegato findByCognome(String cognome);
	Impiegato findByCodiceFiscale(String codiceFiscale);
	Impiegato findByIndirizzo(String indirizzo);
	Impiegato findByDataNascita(Date dataNascita);
	Impiegato findByTitoloStudio(String titoloStudio);
	Impiegato findByCitta(String citta);
	
	List<ImpiegatoPK> findByDescrizione(String nome,String cognome,String codiceFiscale);
	@Query(value = "select a from Impiegato where nome = :nome and cognome = :cognome and codice_fiscale = :codiceFiscale")
	Impiegato getQualcosa(@Param("nome")String nome,@Param("cognome")String cognome,@Param("codice_fiscale")String codiceFiscale);
	
}
