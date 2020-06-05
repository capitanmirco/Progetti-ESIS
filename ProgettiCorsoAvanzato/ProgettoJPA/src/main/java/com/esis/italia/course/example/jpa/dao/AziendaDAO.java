package com.esis.italia.course.example.jpa.dao;

import com.esis.italia.course.example.jpa.Azienda;

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

		// String tempQuery = "SELECT a from Azienda a WHERE nome = :nome";
		// Query query = getEntityManager().createQuery(tempQuery);

		// query.setParameter("nome", idAzienda);
		// azienda = (Azienda) query.getSingleResult();

		return azienda;

	}

}