package com.esis.italia.course.example.services;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.esis.italia.course.example.dto.AziendaDTO;
import com.esis.italia.course.example.jpa.Azienda;
import com.esis.italia.course.example.jpa.dao.AziendaDAO;

public class ServiceAzienda extends AbstractService<AziendaDAO> {

	public ServiceAzienda() {
		this.dao = new AziendaDAO();
	}
	
	public Integer getId(String nome) {
		return getDao().getIdByName(nome);
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
	
	public 	AziendaDTO getAziendaByName(String name) {
		
		AziendaDTO result = new AziendaDTO();
		List<Map> selectAzienda = getDao().selectAzienda(name, null);
		
		if(selectAzienda.size()>0) {
			Map map = selectAzienda.get(0);
			result.setDescrizione((String) map.get("descrizione"));
			result.setNome((String) map.get("nome"));
		}
		
		return result;
	}
	
}