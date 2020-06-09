package com.esis.italia.course.example.services;

import com.esis.italia.course.example.dto.ImpiegatoDTO;
import com.esis.italia.course.example.dto.MansioneDTO;
import com.esis.italia.course.example.dto.RuoliDTO;
import com.esis.italia.course.example.jpa.Impiegato;
import com.esis.italia.course.example.jpa.Mansione;
import com.esis.italia.course.example.jpa.dao.MansioneDAO;

public class ServiceMansione extends AbstractService<MansioneDAO> {

	public ServiceMansione() {
		this.dao = new MansioneDAO();
	}

	public Integer insertMansione(RuoliDTO ruolo, ImpiegatoDTO impiegato) {
		return getDao().insertMansione(ruolo, impiegato);
	}

	public Integer updateMansione(Integer idMansione, ImpiegatoDTO impiegato, String idRuoli) {
		return getDao().updateMansioneDesc(idMansione, impiegato, idRuoli);
	}

	public boolean deleteMansione(Integer idMansione) {
		return getDao().deleteMansione(idMansione);
	}

//	public MansioneDTO selectMansioneId(Integer idMansione) {
//		MansioneDTO a1 = new MansioneDTO();
//		Mansione a = getDao().selectByPK(Mansione.class, idMansione);
//		a1.setDescrizione(a.getDescrizione());
//		a1.setNome(a.getNome());
//		return a1;
//	}
}
