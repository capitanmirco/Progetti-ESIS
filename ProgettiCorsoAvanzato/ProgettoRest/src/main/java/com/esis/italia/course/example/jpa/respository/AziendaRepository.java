package com.esis.italia.course.example.jpa.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;


@Repository
public interface AziendaRepository extends JpaRepository<Azienda, AziendaPK> {

	
	
}
