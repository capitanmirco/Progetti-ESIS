package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;
import com.esis.italia.course.example.jpa.entity.Dipartimento;
import com.esis.italia.course.example.jpa.entity.Ruoli;

public class DipartimentoDAO extends AbstractDAO<Dipartimento, Integer> {

	public Integer insertDipartimento(String nome, String descrizione, AziendaPK idAzienda, String descrizioneAzienda) {

		Integer result = null;

		try {
			
			Dipartimento d = new Dipartimento();

			Azienda b = new Azienda();
			b.setDescrizione(descrizioneAzienda);
			b.setId(idAzienda);
			
			d.setNomeDipartimento(nome);
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

	public Integer updateDipartimento(String descrizione, AziendaPK aziendaPk, Integer idDipartimento) {

		Integer result = null;
		
		try {
			if ((descrizione != null && !descrizione.isEmpty())) {
				Dipartimento d = this.selectDipartimentoId(idDipartimento);
				
				if (descrizione != null && !descrizione.isEmpty()) {
					d.setDescrizione(descrizione);
				}
				
				if (aziendaPk != null) {
					AziendaDAO aziendaDao = new AziendaDAO();
					Azienda azienda = aziendaDao.selectByPK(Azienda.class, aziendaPk);
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

	public Integer getIdByName(String nome) {

		String sql = "SELECT d FROM Dipartimento d WHERE nome = :nome";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("nome", nome);

		List<Dipartimento> lista = query.getResultList();

		if (lista.size() > 0) {
			return lista.get(0).getPrimaryKey();
		} else
			return null;

	}

}