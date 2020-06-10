/**
 *
 */
package com.esis.italia.course.example.jpa.entity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Giampiero Cicala
 *
 */
public class EntityManagerStoreManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HashMap appo=new HashMap<>();
			appo.entrySet().forEach(action->((Entry)action).getKey());

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProgettoJPA");

			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			Query query = entityManager.createQuery("select a from Azienda a where id_azienda=:id");
//			query.setParameter("id", 1);
//			Azienda azienda = (Azienda) query.getSingleResult();

			CriteriaQuery<Dipartimento> criteria = entityManager.getCriteriaBuilder().createQuery(Dipartimento.class);
			Root<Dipartimento> root = criteria.from(Dipartimento.class);
			criteria.select(root);
			entityManager.createQuery(criteria).getResultStream().forEach(dip->{
				System.out.println("<----------------------------------------->");
				System.out.println(dip.getNome());
				System.out.println(dip.getDescrizione());
//				System.out.println(dip.getAzienda().getNome());
				System.out.println(dip.getAzienda().getDescrizione());

			});


			ImpiegatoPK pk=new ImpiegatoPK();
			pk.setCognome("Rossi");
			pk.setNome("mario");
			pk.setCodiceFiscale("");
			Impiegato impiegato=new Impiegato();
			impiegato.setCitta("Roma");
			impiegato.setDataNascita(Calendar.getInstance().getTime());
			impiegato.setId(pk);
			impiegato.setIndirizzo("Via della mia casa");
			impiegato.setTitoloStudio("Diploma");

//			Azienda azienda = entityManager.find(Azienda.class, 1);
//			Dipartimento dipartimento=new Dipartimento();
//			dipartimento.setIdDipartimento(2);
//			dipartimento.setAzienda(azienda);
//			dipartimento.setDescrizione("Insicurezza Informatica");
//			dipartimento.setNome("Insicurezza");
			EntityTransaction transaction = entityManager.getTransaction();
			try {
				transaction.begin();
				entityManager.persist(impiegato);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
			}


		} catch (Throwable e) {
			e.printStackTrace();
		}

	}



}
