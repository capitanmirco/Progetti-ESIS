/**
 * 
 */
package com.esis.italia.course.example.jpa.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.Mansione;


@Repository
public interface MansioneRepository extends JpaRepository<Mansione, Integer> {
	
	public List<Mansione> findByImpiegato(Impiegato impiegato);
	
	public List<Mansione> findByImpiegatoIdNome(String nome);
	
	public List<Mansione> findByRuoliNome(String nome);
	
	
}
