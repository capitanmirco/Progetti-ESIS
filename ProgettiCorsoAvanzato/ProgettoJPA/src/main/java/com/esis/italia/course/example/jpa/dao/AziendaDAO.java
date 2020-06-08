package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import com.esis.italia.course.example.jpa.Azienda;
import com.esis.italia.course.example.jpa.Ruoli;

public class AziendaDAO extends AbstractDAO<Azienda, Integer> {

	public Integer insertAzienda(String nome, String descrizione) {
		Integer done = null;
		try {
			Azienda azienda = new Azienda();
			azienda.setNome(nome);
			azienda.setDescrizione(descrizione);
			done = insert(azienda);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return done;

	}

	public boolean deleteAzienda(Integer idAzienda) {
		boolean done = false;

		try {
			Azienda azienda = selectByPK(Azienda.class, idAzienda);
			done=delete(azienda);
			return done;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Integer updateAziendaDesc(String nome, String descrizione, Integer idAzienda) {

		Integer done = null;
		try {
			if ((nome != null && !nome.isEmpty()) || (descrizione != null && !descrizione.isEmpty())) {

				Azienda azienda = this.selectAziendaId(idAzienda);

				if (nome != null && !nome.isEmpty()) {
					azienda.setNome(nome);

				}
				if (descrizione != null && !descrizione.isEmpty()) {
					azienda.setDescrizione(descrizione);
				}
				done = updateByPK(azienda, idAzienda);
			}
			return done;
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	public Azienda selectAziendaId(Integer idAzienda) {

		Azienda azienda = getEntityManager().find(Azienda.class, idAzienda);
		return azienda;
	}
	
	public List<Map> selectAzienda(String nome, String descrizione) {
		List result = new ArrayList<>();
		HashMap appo = new HashMap<>();
		try {
			Azienda azienda = new Azienda();
			azienda.setNome(nome);

			Azienda testAzienda = getEntityManager().find(Azienda.class, nome);
			String tempQuery = "select r from Azienda r ";
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