package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import com.esis.italia.course.example.jpa.Azienda;
import com.esis.italia.course.example.jpa.Dipartimento;
import com.esis.italia.course.example.jpa.Ruoli;

public class DipartimentoDAO extends AbstractDAO<Dipartimento, Integer> {

	public Integer insertDipartimento(String nome, String descrizione, Integer idAzienda) {

		Integer result = null;
		try {
			Dipartimento d = new Dipartimento();
			AziendaDAO a = new AziendaDAO();
			Azienda b = a.selectAziendaId(idAzienda);
			d.setNome(nome);
			d.setDescrizione(descrizione);
			d.setAzienda(b);
			result = insert(d);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public boolean deleteDipartimento(Integer idDipartimento) {

		boolean result = false;
		try {
			Dipartimento dipartimento = selectByPK(Dipartimento.class, idDipartimento);
			result = delete(dipartimento);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public Integer updateDipartimento(String nome, String descrizione,Integer idAzienda,Integer idDipartimento) {

		Integer result = null;

		try {
			if ((nome != null && !nome.isEmpty()) || (descrizione != null && !descrizione.isEmpty())){
				Dipartimento d = this.selectDipartimentoId(idDipartimento);
				if (nome != null && !nome.isEmpty()) {
					d.setNome(nome);

				}
				if (descrizione != null && !descrizione.isEmpty()) {
					d.setDescrizione(descrizione);
				}
				if (idAzienda != null ) {
					AziendaDAO aziendaDAO=new AziendaDAO();
					Azienda azienda = aziendaDAO.selectByPK(Azienda.class, idAzienda);
					d.setAzienda(azienda);
				}
				result = updateByPK(d, idDipartimento);
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	private Dipartimento selectDipartimentoId(Integer idDipartimento) {
		Dipartimento d = getEntityManager().find(Dipartimento.class, idDipartimento);

		// String tempQuery = "SELECT a from Azienda a WHERE nome = :nome";
		// Query query = getEntityManager().createQuery(tempQuery);

		// query.setParameter("nome", idAzienda);
		// azienda = (Azienda) query.getSingleResult();

		return d;
	}

	public List<Map> selectDipartimento(String nome, String descrizione) {
		List result = new ArrayList<>();
		HashMap appo = new HashMap<>();
		try {
			Ruoli ruolo = new Ruoli();
			ruolo.setNome(nome);

			Dipartimento testDipartimento = getEntityManager().find(Dipartimento.class, nome);
			String tempQuery = "select d from Dipartimento d ";
			String where = " ";

			if (nome != null && !nome.isEmpty()) {
				where += "d.nome = :nome";
				appo.put("nome", nome);

			}
			if (descrizione != null && !descrizione.isEmpty()) {
				if (appo.isEmpty()) {
					where += "d.descrizione = :descrizione";
				} else if (!appo.isEmpty()) {
					where += " and d.descrizione = :descrizione";
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

			List<Dipartimento> list = query.getResultList();
			for (Dipartimento d : list) {
				HashMap map = new HashMap();
				map.put("nome", d.getNome());
				map.put("descrizione", d.getDescrizione());
				result.add(map);
			}

			return result;
		} catch (Exception e) {
			throw e;
		}

	}

}
