/**
 *
 */
package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.esis.italia.course.example.jpa.Impiegato;
import com.esis.italia.course.example.jpa.ImpiegatoPK;
import com.esis.italia.course.example.jpa.Mansione;
import com.esis.italia.course.example.jpa.Ruoli;

/**
 * @author Giampiero Cicala
 *
 */
public class MansioneDAO extends AbstractDAO<Mansione, Integer> {

	public Integer insertMansione(Ruoli ruolo, Impiegato impiegato) {

		Integer result = -1;
		try {
			Mansione mansione = new Mansione();
			mansione.setImpiegato(impiegato);
			mansione.setRuoli(ruolo);
			result = insert(mansione);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public boolean deleteMansione(int idMansione) {

		boolean result = false;
		try {
			Mansione mansione = new Mansione();
			mansione.setIdMansione(idMansione);

			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			getEntityManager().remove(mansione);
			transaction.commit();
			result = true;
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Integer updateMansione(Integer idMansione, Impiegato impiegato, String idRuoli) {

		Integer result = -1;
		try {
			if (idMansione != null && (impiegato != null || idRuoli != null)) {
				Mansione mansione = selectByPK(Mansione.class, idMansione);
				ImpiegatoDAO impiegatoDAO = new ImpiegatoDAO();
				RuoliDAO ruoliDAO = new RuoliDAO();
				if (impiegato != null) {
					mansione.setImpiegato(impiegato);
				}
				if (idRuoli != null) {
					Ruoli ruoli = ruoliDAO.selectByPK(Ruoli.class, idRuoli);
					mansione.setRuoli(ruoli);
				}
				result = updateByPK(mansione, idMansione);
			}
			return result;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public List<Map> selectRuolo(Mansione mansione) {
		List result = new ArrayList<>();
		HashMap appo = new HashMap<>();
		try {

			Mansione mansioneTest = getEntityManager().find(Mansione.class, mansione.getID());

			return result;
		} catch (Exception e) {
			throw e;
		}

	}

}
