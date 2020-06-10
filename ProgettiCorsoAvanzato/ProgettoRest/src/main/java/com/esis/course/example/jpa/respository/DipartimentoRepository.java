
/**
 * 
 */
package com.esis.course.example.jpa.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Dipartimento;

/**
 * @author ambra
 *
 */
@Repository
public interface DipartimentoRepository extends JpaRepository<Dipartimento, String> {
	
	Dipartimento findByNome(String nome);
	
	List<Dipartimento> findByDescrizione(String descrizione);
	
	@Query(value = "select d from Dipartimento where nome = :nome")
	Dipartimento getQualcosa(@Param("nome")String nome);
	

}/**
 * 
 */
