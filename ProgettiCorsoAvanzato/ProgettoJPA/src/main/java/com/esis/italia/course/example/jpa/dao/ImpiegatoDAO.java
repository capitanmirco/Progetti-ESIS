package com.esis.italia.course.example.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.esis.italia.course.example.jpa.Impiegato;
import com.esis.italia.course.example.jpa.ImpiegatoPK;

public class ImpiegatoDAO extends AbstractDAO<Impiegato,ImpiegatoPK> {

	public boolean addImpiegato(String codiceFiscale, String nome, String cognome, String citta, Date dataNascita,
			String indirizzo, String titoloStudio) {
		try {
			Impiegato i = new Impiegato();
			ImpiegatoPK pk = new ImpiegatoPK();
			i.setCitta(citta);
			i.setDataNascita(dataNascita);
			i.setIndirizzo(indirizzo);
			i.setTitoloStudio(titoloStudio);
			pk.setCodiceFiscale(codiceFiscale);
			pk.setNome(nome);
			pk.setCognome(cognome);
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(i);
			getEntityManager().getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteImpiegato(String codiceFiscale, String nome, String cognome, String citta, Date dataNascita,
			String indirizzo, String titoloStudio) {
		try {
			Impiegato i = new Impiegato();
			ImpiegatoPK pk = new ImpiegatoPK();
			i.setCitta(citta);
			i.setDataNascita(dataNascita);
			i.setIndirizzo(indirizzo);
			i.setTitoloStudio(titoloStudio);
			pk.setCodiceFiscale(codiceFiscale);
			pk.setNome(nome);
			pk.setCognome(cognome);
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(i);
			getEntityManager().getTransaction().commit();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateImpiegato(String codiceFiscale, String nome, String cognome, String citta, Date dataNascita,
			String indirizzo, String titoloStudio) {
		boolean result = false;
		try {

			Impiegato i = new Impiegato(); // o rimane a false,o fa l'update o torna l'eccezzione
			ImpiegatoPK pk = new ImpiegatoPK();
			i.setCitta(citta);
			i.setDataNascita(dataNascita);
			i.setIndirizzo(indirizzo);
			i.setTitoloStudio(titoloStudio);
			pk.setCodiceFiscale(codiceFiscale);
			pk.setNome(nome);
			pk.setCognome(cognome);
			Impiegato temp = getEntityManager().find(Impiegato.class, pk); // restituisce istanza di impiegato
			if (temp != null) {
				getEntityManager().getTransaction().begin();
				getEntityManager().merge(i);
				getEntityManager().getTransaction().commit();
				result = true;
			}
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Impiegato> getListaImpiegato() {
		Query q = getEntityManager().createNamedQuery("Impiegato.findAll");
		try {
			List<Impiegato> listaImpiegato = q.getResultList();
			return listaImpiegato;
		} catch (Exception e) {
			return null;
		}
	}

	public ImpiegatoDAO getImpiegatoByCF(String codice_fiscale) {
		Query q = getEntityManager().createQuery("SELECT u FROM Impiegato u WHERE u.codiceFiscale=:cf");
		q.setParameter("cf", codice_fiscale);
		try {
			ImpiegatoDAO impiegato = (ImpiegatoDAO) q.getSingleResult();
			return impiegato;
		} catch (Exception e) {
			return null;
		}
	}
	
}
