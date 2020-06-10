/**
 * 
 */
package com.esis.italia.course.example.jpa.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.Mansione;


@Repository
public interface MansioneRepository extends JpaRepository<Mansione, Integer> {
	
	Mansione findById(int id);
	
	
	List<Mansione> findByImpiegato(Impiegato impiegato);
	
	@Query(value = "select a from Mansione where idMansione = :id")
	Mansione getQualcosa(@Param("idMansione")int id);
	

}
