
/**
 * 
 */
package com.esis.italia.course.example.jpa.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Dipartimento;

/**
 * @author ambra
 *
 */
@Repository
public interface DipartimentoRepository extends JpaRepository<Dipartimento, Integer> {
	
	Dipartimento findByNome(String nome);
	
	List<Dipartimento> findByDescrizione(String descrizione);
	

}/**
 * 
 */
