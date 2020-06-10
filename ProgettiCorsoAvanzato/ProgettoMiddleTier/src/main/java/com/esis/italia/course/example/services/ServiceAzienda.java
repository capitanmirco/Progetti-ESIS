package com.esis.italia.course.example.services;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.esis.italia.course.example.dto.AziendaDTO;
import com.esis.italia.course.example.jpa.dao.AziendaDAO;
import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;

public class ServiceAzienda extends AbstractService<AziendaDAO> {

	public ServiceAzienda() {
		this.dao = new AziendaDAO();
	}
	
	public AziendaPK getId(String nome) {
		return getDao().getIdByName(nome);
	}
	
	public AziendaPK insertAzienda(String nome,String descrizione, String pIva) {
		return getDao().insertAzienda(nome, descrizione, pIva);
	}
	
	public AziendaPK updateAzienda(String descrizione, AziendaPK idAzienda) {
		return getDao().updateAziendaDesc(descrizione, idAzienda);
	}
	
	public boolean deleteAzienda(AziendaPK idAzienda) {
		return getDao().deleteAzienda(idAzienda);
	}
	
	public AziendaDTO selectAziendaId(AziendaPK idAzienda) {
		
		AziendaDTO a1 = new AziendaDTO();
		Azienda a = getDao().selectByPK(Azienda.class, idAzienda);
		
		a1.setNome(a.getId().getNome());
		a1.setDescrizione(a.getDescrizione());
		a1.setPartitaIva(a.getId().getpIva());
		return a1;
	}
	
	public 	AziendaDTO getAziendaByName(String name) {
		
		AziendaDTO result = new AziendaDTO();
		List<Map> selectAzienda = getDao().selectAzienda(name, null, null);
		
		if(selectAzienda.size()>0) {
			Map map = selectAzienda.get(0);
			result.setDescrizione((String) map.get("descrizione"));
			result.setNome((String) map.get("nome"));
		}
		
		return result;
	}
	
}