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
	public Integer insertRuolo(String nome, String descrizione) {

		Integer result = -1;
		try {
			Mansione mansione = new Mansione();
			mansione.setImpiegato(null);
			mansione.setRuoli(null);
			result = insert(mansione);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public boolean deleteRuolo(String nome) {

		boolean result = false;
		try {
			Ruoli ruolo = new Ruoli();
			ruolo.setNome(nome);

			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			getEntityManager().remove(ruolo);
			transaction.commit();
			result = true;
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Integer updateMansione(Integer idMansione, ImpiegatoPK impiegatoPK, String idRuoli) {

		Integer result = -1;
		try {
			if (idMansione != null && (impiegatoPK != null || idRuoli != null)) {
				Mansione mansione = selectByPK(Mansione.class, idMansione);
				ImpiegatoDAO impiegatoDAO = new ImpiegatoDAO();
				RuoliDAO ruoliDAO = new RuoliDAO();
				if (impiegatoPK != null) {
					Impiegato impiegato = impiegatoDAO.selectByPK(Impiegato.class, impiegatoPK);
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

	public List<Map> selectRuolo(String nome, String descrizione) {
		List result = new ArrayList<>();
		HashMap appo = new HashMap<>();
		try {
			Ruoli ruolo = new Ruoli();
			ruolo.setNome(nome);

			Ruoli testRuolo = getEntityManager().find(Ruoli.class, nome);
			String tempQuery = "select r from Ruoli r ";
			String where = " ";

			if (nome != null && !nome.isEmpty()) {
				where += "r.nome = :nome";
				appo.put("nome", nome);

			}
			if (descrizione != null && !descrizione.isEmpty()) {
				if (appo.isEmpty()) {
					where += "r.descrizione = :descrizione";
				} else if (!appo.isEmpty()) {
					where += " and r.descrizione = :descrizione";
				}
				appo.put("descrizione", descrizione);
			}
			if (!where.trim().isEmpty()) {
				tempQuery += "where " + where;
			}

			Query query = getEntityManager().createQuery(tempQuery);
			appo.entrySet().forEach(action -> {
				query.setParameter((String) ((Entry) action).getKey(), ((Entry) action).getValue());
			});

			List<Ruoli> list = query.getResultList();
			for (Ruoli r : list) {
				HashMap map = new HashMap();
				map.put("nome", r.getNome());
				map.put("descrizione", r.getDescrizione());
				result.add(map);
			}

			return result;
		} catch (Exception e) {
			throw e;
		}

	}

}
