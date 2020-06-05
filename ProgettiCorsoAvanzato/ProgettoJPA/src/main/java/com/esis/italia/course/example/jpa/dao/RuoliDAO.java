/**
 *
 */
package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import com.esis.italia.course.example.jpa.Ruoli;

public class RuoliDAO extends AbstractDAO<Ruoli,String> {


	public String insertRuolo(String nome, String descrizione) {
		String result = "";
		try {
			Ruoli ruolo = new Ruoli();
			ruolo.setNome(nome);
			ruolo.setDescrizione(descrizione);
			result = insert(ruolo);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public boolean deleteRuolo(String nome) {
		boolean result = false;
		try {
			Ruoli ruoli = selectByPK(Ruoli.class, nome);
			result = delete(ruoli);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public String updateRuolo(String nome, String descrizione) {
		String result = "";
		try {
			Ruoli ruolo = selectByPK(Ruoli.class, nome);
			ruolo.setNome(nome);
			ruolo.setDescrizione(descrizione);
			result=updateByPK(ruolo, nome);
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
