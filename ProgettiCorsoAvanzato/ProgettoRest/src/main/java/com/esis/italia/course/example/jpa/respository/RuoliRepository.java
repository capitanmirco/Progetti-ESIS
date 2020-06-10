/**
 * 
 */
package com.esis.italia.course.example.jpa.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Ruoli;

/**
 * @author giamp
 *
 */
@Repository
public interface RuoliRepository extends JpaRepository<Ruoli, String> {
	
	Ruoli findByNome(String nome);
	
	List<Ruoli> findByDescrizione(String descrizione);
	

}
