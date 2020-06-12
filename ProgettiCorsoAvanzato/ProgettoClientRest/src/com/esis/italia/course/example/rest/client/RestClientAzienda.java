/**
 * 
 */
package com.esis.italia.course.example.rest.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;

/**
 * @author giamp
 *
 */
public class RestClientAzienda {
	private static RestTemplate template=new RestTemplate();
	
	public static void main(String[] args) {
		try {
			
			ResponseEntity<Azienda> responseEntity = select("Esis33","12312312312");;
			Azienda azienda = responseEntity.getBody();
			
			Azienda azienda2=new Azienda();
			azienda2.setDescrizione("Nuova descrizione");
			azienda2.setId(azienda.getId());
			
			update(azienda2);
			
			delete(azienda2.getId().getNome(),azienda2.getId().getpIva());
			
			insert(azienda);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Azienda azienda) {
		template.put("http://localhost:8081/azienda/" ,azienda);
	}

	public static ResponseEntity<Azienda> insert(Azienda azienda) {
		return template.postForEntity("http://localhost:8081/azienda/" ,azienda,Azienda.class);
	}
	
	public static ResponseEntity<Azienda> select(String nome,String partitaIva) {
		return template.getForEntity("http://localhost:8081/azienda/"+nome+"/"+partitaIva, Azienda.class);
	}
	
	public static void delete(String nome,String partitaIva) {
		template.delete("http://localhost:8081/azienda/"+nome+"/"+partitaIva);
	}
}
