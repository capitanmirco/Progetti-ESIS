package com.esis.italia.course.example.jpa.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;



@Repository
public interface AziendaRepository extends JpaRepository<Azienda, AziendaPK> {

	/*
	 *	Modifica la descrizione dell'azienda con un certo id 
	 *	@return null
	 */
	@Modifying
	@Query("UPDATE AZIENDA a SET a.descrizione = ?3 WHERE a.nome = ?1 AND a.partita_iva = ?2")
	public void updateDescrizione(
			String nome, 
			String pIva, 
			String descrizione);
	
}
