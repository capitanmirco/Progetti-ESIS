package com.esis.italia.course.example.rest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.ImpiegatoPK;
import com.esis.italia.course.example.jpa.entity.Mansione;
import com.esis.italia.course.example.jpa.entity.Ruoli;

/**
 * @author giamp
 *
 */
public class RestClientMansione {
	private static RestTemplate template=new RestTemplate();
	
	public static void main(String[] args) {
		try {
			
			ResponseEntity<Mansione> responseEntity = select(1);
			Mansione mansione = responseEntity.getBody();
			System.out.println(mansione);
			
			Ruoli ruolo = new Ruoli();
			ruolo.setNome("NuovoRuolo4");
			
			Mansione man = new Mansione();
			
			man.setIdMansione(mansione.getIdMansione());
			man.setImpiegato(mansione.getImpiegato());
			man.setRuoli(ruolo);
			update(man);
			
			ResponseEntity<Mansione> responseEntity2 = select(mansione.getIdMansione());
			
			delete(responseEntity2.getBody().getIdMansione());
			
			insert(mansione);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Mansione mansione) {
		template.put("http://localhost:8081/mansione/" ,mansione);
	}

	public static ResponseEntity<Integer> insert(Mansione mansione) {
		return template.postForEntity("http://localhost:8081/mansione/" ,mansione,Integer.class);
	}
	
	public static ResponseEntity<Mansione> select(Integer id) {
		return template.getForEntity("http://localhost:8081/mansione/"+id, Mansione.class);
	}
	
	public static void delete(Integer id) {
		template.delete("http://localhost:8081/mansione/"+id, id);
	}
}
