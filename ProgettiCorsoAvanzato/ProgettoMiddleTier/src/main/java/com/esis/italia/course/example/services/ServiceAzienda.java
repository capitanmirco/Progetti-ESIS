package com.esis.italia.course.example.services;

import com.esis.italia.course.example.dto.AziendaDTO;
import com.esis.italia.course.example.jpa.Azienda;
import com.esis.italia.course.example.jpa.dao.AziendaDAO;

public class ServiceAzienda extends AbstractService<AziendaDAO> {

	public ServiceAzienda() {
		this.dao = new AziendaDAO();
	}

	public Integer insertAzienda(String nome,String descrizione) {
		return getDao().insertAzienda(nome, descrizione);
	}

	public Integer updateAzienda(String nome,String descrizione, Integer idAzienda) {
		return getDao().updateAziendaDesc(nome, descrizione, idAzienda);
	}

	public boolean deleteAzienda(Integer idAzienda) {
		return getDao().deleteAzienda(idAzienda);
	}

	public AziendaDTO selectAziendaId(Integer idAzienda) {
		AziendaDTO a1 = new AziendaDTO();
		Azienda a = getDao().selectByPK(Azienda.class, idAzienda);
		a1.setDescrizione(a.getDescrizione());
		a1.setNome(a.getNome());
		return a1;
	}

}