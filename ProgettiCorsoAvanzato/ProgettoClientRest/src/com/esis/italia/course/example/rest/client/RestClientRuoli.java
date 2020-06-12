/**
 * 
 */
package com.esis.italia.course.example.rest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.esis.italia.course.example.jpa.entity.Ruoli;

/**
 * @author giamp
 *
 */
public class RestClientRuoli {
	private static RestTemplate template=new RestTemplate();
	
	public static void main(String[] args) {
		try {
			
			ResponseEntity<Ruoli> responseEntity = select("NuovoRuolo5");;
			Ruoli ruoli = responseEntity.getBody();
			System.out.println(ruoli);
			
			Ruoli appo=new Ruoli();
			appo.setNome(ruoli.getNome());
			appo.setDescrizione("Test update description");
			update(appo);
			
			ResponseEntity<Ruoli> responseEntity2 = select(ruoli.getNome());
			
			delete(responseEntity2.getBody().getNome());
			
			insert(ruoli);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Ruoli ruoli) {
		template.put("http://localhost:8081/ruoli/" ,ruoli);
	}

	public static ResponseEntity<String> insert(Ruoli ruoli) {
		return template.postForEntity("http://localhost:8081/ruoli/" ,ruoli,String.class);
	}
	
	public static ResponseEntity<Ruoli> select(String nome) {
		return template.getForEntity("http://localhost:8081/ruoli/"+nome, Ruoli.class);
	}
	
	public static void delete(String nome) {
		template.delete("http://localhost:8081/ruoli/"+nome, nome);
	}
}
