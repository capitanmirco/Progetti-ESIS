package com.esis.italia.course.example.rest.client;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.esis.italia.course.example.jpa.entity.Impiegato;

public class RestClientImpiegato {
	private static RestTemplate template = new RestTemplate();

	public static void main(String[] args) {
		try {

			ResponseEntity<Impiegato> responseEntity = select("test", "cognomeTest", "1234");

			Impiegato impiegato = responseEntity.getBody();

			System.out.println(impiegato);
			Impiegato pippo = new Impiegato();

			pippo.setId(impiegato.getId());
			pippo.setCitta("roma");
			pippo.setDataNascita(new Date());
			pippo.setIndirizzo("via roma 1");
			pippo.setCitta("roma");

			update(pippo);

			delete(pippo.getId().getNome(), pippo.getId().getCognome(), pippo.getId().getCodiceFiscale());

			insert(impiegato);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update(Impiegato impiegato) {
		template.put("http://localhost:8081/impiegato/", impiegato);
	}

	public static ResponseEntity<Impiegato> insert(Impiegato impiegato) {
		return template.postForEntity("http://localhost:8081/impiegato/", impiegato, Impiegato.class);
	}

	public static ResponseEntity<Impiegato> select(String nome, String cognome, String codiceFiscale) {
		return template.getForEntity("http://localhost:8081/impiegato/" + nome + "/" + cognome + "/" + codiceFiscale,
				Impiegato.class);
	}

	public static void delete(String nome, String cognome, String codiceFiscale) {
		template.delete("http://localhost:8081/impiegato/" + nome + "/" + cognome + "/" + codiceFiscale);
	}
}
