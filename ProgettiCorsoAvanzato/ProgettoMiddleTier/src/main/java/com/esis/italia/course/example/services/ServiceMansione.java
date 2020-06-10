package com.esis.italia.course.example.services;

import com.esis.italia.course.example.dto.AziendaDTO;
import com.esis.italia.course.example.dto.DipartimentoDTO;
import com.esis.italia.course.example.dto.ImpiegatoDTO;
import com.esis.italia.course.example.dto.MansioneDTO;
import com.esis.italia.course.example.dto.RuoliDTO;
import com.esis.italia.course.example.jpa.dao.MansioneDAO;
import com.esis.italia.course.example.jpa.entity.Dipartimento;
import com.esis.italia.course.example.jpa.entity.Impiegato;
import com.esis.italia.course.example.jpa.entity.ImpiegatoPK;
import com.esis.italia.course.example.jpa.entity.Mansione;
import com.esis.italia.course.example.jpa.entity.Ruoli;

public class ServiceMansione extends AbstractService<MansioneDAO> {

	
	public ServiceMansione() {
		this.dao = new MansioneDAO();
	}
	
	private Ruoli convertRuoli(RuoliDTO ruolo) {
		Ruoli ruolo2 = new Ruoli();
		ruolo2.setDescrizione(ruolo.getDescrizione());
		ruolo2.setNome(ruolo.getNome());
		return ruolo2;
	}
	
	private Impiegato convertImpiegato(ImpiegatoDTO impiegato) {
		Impiegato impiegato2 = new Impiegato();
		impiegato2.setCitta(impiegato.getCitta());
		impiegato2.setDataNascita(impiegato.getDataNascita());
		impiegato2.setIndirizzo(impiegato.getIndirizzo());
		impiegato2.setTitoloStudio(impiegato.getTitoloStudio());
		ImpiegatoPK impPK = new ImpiegatoPK();
		impPK.setCodiceFiscale(impiegato.getCodice_fiscale());
		impPK.setCognome(impiegato.getCognome());
		impPK.setNome(impiegato.getNome());
		impiegato2.setId(impPK);
		
		return impiegato2;
	}
	
	private Mansione convertMansione(MansioneDTO mansione) {
		Mansione man = new Mansione();
		ImpiegatoDTO impiegato = mansione.getImpiegato();
		RuoliDTO ruoli = mansione.getRuoli();
		Impiegato convertImpiegato = convertImpiegato(impiegato);
		Ruoli convertRuoli = convertRuoli(ruoli);
		man.setIdMansione(mansione.getIdMansione());
		man.setImpiegato(convertImpiegato);
		man.setRuoli(convertRuoli);
		return man;
	}
	
	private MansioneDTO convertMansioneDTO(Mansione mansione) {
		MansioneDTO man = new MansioneDTO();
		ImpiegatoDTO impiegato = convertImpiegatoDTO(mansione.getImpiegato());
		RuoliDTO ruoli = convertRuoliDTO(mansione.getRuoli());
		man.setIdMansione(mansione.getIdMansione());
		man.setImpiegato(impiegato);
		man.setRuoli(ruoli);
		return man;
	}
	
	
	private ImpiegatoDTO convertImpiegatoDTO(Impiegato impiegato) {
		ImpiegatoDTO impiegato2 = new ImpiegatoDTO();
		impiegato2.setCitta(impiegato.getCitta());
		impiegato2.setDataNascita(impiegato.getDataNascita());
		impiegato2.setIndirizzo(impiegato.getIndirizzo());
		impiegato2.setTitoloStudio(impiegato.getTitoloStudio());
        impiegato2.setCodice_fiscale(impiegato.getId().getCodiceFiscale());
        impiegato2.setCognome(impiegato.getId().getCognome());
        impiegato2.setNome(impiegato.getId().getNome());
		
		return impiegato2;
	}
	
	
	private RuoliDTO convertRuoliDTO(Ruoli ruolo) {
		RuoliDTO ruolo2 = new RuoliDTO();
		ruolo2.setDescrizione(ruolo.getDescrizione());
		ruolo2.setNome(ruolo.getNome());
		return ruolo2;
	}

	public Integer insertMansione(RuoliDTO ruolo, ImpiegatoDTO impiegato) {
		Ruoli ruolo2 = convertRuoli(ruolo);
        Impiegato impiegato2 = convertImpiegato(impiegato);

		return getDao().insertMansione(ruolo2, impiegato2);
	}
	
	public MansioneDTO getMansioneByPK(Integer idMansione) {
		
		Mansione m = getDao().selectByPK(Mansione.class, idMansione);
		MansioneDTO convertMansioneDTO = convertMansioneDTO(m);
		
		return convertMansioneDTO;
	}

	public Integer updateMansione(Integer idMansione, ImpiegatoDTO impiegato, String idRuoli) {
        Impiegato impiegato2 = convertImpiegato(impiegato);
		return getDao().updateMansione(idMansione, impiegato2, idRuoli);
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
