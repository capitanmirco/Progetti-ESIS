/**
 * 
 */
package com.esis.italia.course.example.rest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.esis.italia.course.example.jpa.entity.Dipartimento;
import com.esis.italia.course.example.jpa.entity.Ruoli;

/**
 * @author Sara
 *
 */
public class RestClientiDipartimento {
	private static RestTemplate template=new RestTemplate();
	
	public static void main(String[] args) {
		try {
			
			ResponseEntity<Dipartimento> responseEntity = select(402);
			Dipartimento d = responseEntity.getBody();
			System.out.println(d);
			
			Dipartimento appo=new Dipartimento();
			appo.setIdDipartimento(d.getPrimaryKey());
			appo.setNome(d.getNome());
			appo.setDescrizione("Test update description dipartimento");
			update(appo);
			
			delete(appo.getPrimaryKey());
			
			insert(d);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Dipartimento d) {
		template.put("http://localhost:8081/dipartimento/" ,d);
	}

	public static ResponseEntity<Dipartimento> insert(Dipartimento d) {
		return template.postForEntity("http://localhost:8081/dipartimento/" ,d,Dipartimento.class);
	}
	
	public static ResponseEntity<Dipartimento> select(Integer idDipartimento) {
		return template.getForEntity("http://localhost:8081/dipartimento/"+idDipartimento, Dipartimento.class);
	}
	
	public static void delete(Integer idDipartimento ) {
		template.delete("http://localhost:8081/dipartimento/"+idDipartimento);
	}
}
