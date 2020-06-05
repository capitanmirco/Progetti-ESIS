package com.esis.italia.course.example.services;

import java.util.List;
import java.util.Map;

import com.esis.italia.course.example.dto.AziendaDTO;
import com.esis.italia.course.example.dto.DipartimentoDTO;
import com.esis.italia.course.example.jpa.Dipartimento;
import com.esis.italia.course.example.jpa.dao.DipartimentoDAO;

public class ServiceDipartimento extends AbstractService<DipartimentoDAO> {
	public ServiceDipartimento() {
		this.dao=new DipartimentoDAO();
	}

	public DipartimentoDTO getDipartimentoByName(String name) {
		DipartimentoDTO result=new DipartimentoDTO();
		List<Map> selectDipartimento = getDao().selectDipartimento(name, null);
		if(selectDipartimento.size()>0) {
			Map map = selectDipartimento.get(0);
			result.setDescrizione((String) map.get("descrizione"));
			result.setNome((String) map.get("nome"));
		}
		return result;
	}
	public Integer insertDipartimento(String name,String description, Integer idAzienda) {
		return getDao().insertDipartimento(name, description, idAzienda);

	}
	public Integer updateDipartimento(String name,String description,Integer idAzienda, Integer idDipartimento) {
		return getDao().updateDipartimento(name, description,idAzienda, idDipartimento);

	}
	public boolean deleteDipartimento(Integer idDipartimento) {
		return getDao().deleteDipartimento(idDipartimento);

	}

	public DipartimentoDTO getDipartimentoByPK(Integer idDipartimento) {
		Dipartimento d = getDao().selectByPK(Dipartimento.class, idDipartimento);
		DipartimentoDTO dto = new DipartimentoDTO();
		ServiceAzienda s = new ServiceAzienda();
		AziendaDTO aziendaId = s.selectAziendaId(d.getAzienda().getID());
		dto.setAzienda(aziendaId);
		dto.setDescrizione(d.getDescrizione());
		dto.setNome(d.getNome());
		return dto;
	}


}
