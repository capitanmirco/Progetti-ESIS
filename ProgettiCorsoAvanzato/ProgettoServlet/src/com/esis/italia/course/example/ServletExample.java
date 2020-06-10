package com.esis.italia.course.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esis.italia.course.example.dto.AziendaDTO;
import com.esis.italia.course.example.dto.GenericDTO;
import com.esis.italia.course.example.dto.ImpiegatoDTO;
import com.esis.italia.course.example.dto.MansioneDTO;
import com.esis.italia.course.example.dto.RuoliDTO;
import com.esis.italia.course.example.enumeration.CallType;
import com.esis.italia.course.example.jpa.AziendaPK;
import com.esis.italia.course.example.jpa.ImpiegatoPK;
import com.esis.italia.course.example.services.ServiceAzienda;
import com.esis.italia.course.example.services.ServiceDipartimento;
import com.esis.italia.course.example.services.ServiceMansione;
import com.esis.italia.course.example.services.ServiceRuoli;


@WebServlet("/service")
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GenericDTO dto = null;

		AziendaDTO aziendaDTO = new AziendaDTO();
		RuoliDTO ruoliDTO = new RuoliDTO();
		ImpiegatoDTO impiegatoDTO = new ImpiegatoDTO();
		MansioneDTO mansioneDTO = new MansioneDTO();

		String message="";
		String dispatcherPath="";

		ServiceRuoli serviceRuoli = new ServiceRuoli();
		ServiceDipartimento serviceDipartimento = new ServiceDipartimento();
		ServiceAzienda serviceAzienda = new ServiceAzienda();
		ServiceMansione serviceMansione = new ServiceMansione();

		String nome = request.getParameter("nome");
		String descrizione=request.getParameter("descrizione");

		AziendaPK idAzienda = null;
		Integer idDipartimento = null;
		Integer idRuoli = null;
		Integer idMansioni = null;
		ImpiegatoPK idImpiegato = null;

		String callType = request.getParameter("callType");

		switch (CallType.valueOf(callType)) {
		
			//Inizio Giovanni e Tullio
			case INSERTAZIENDA:
				String partitaIva = request.getParameter("partitaiva");
				
				serviceAzienda.insertAzienda(nome, descrizione, partitaIva);

				aziendaDTO.setNome(nome);
				aziendaDTO.setDescrizione(descrizione);
				aziendaDTO.setPartitaIva(partitaIva);

				dto = aziendaDTO;

				dispatcherPath="azienda.jsp";
				message="Azienda inserita con successo";
				break;
			
			case DELETEAZIENDA:
			
				String partitaIva2 = request.getParameter("partitaiva");
				AziendaPK aziendaPK2 = new AziendaPK();
				aziendaPK2.setNome(nome);
				aziendaPK2.setpIva(partitaIva2);

				serviceAzienda.deleteAzienda(aziendaPK2);

				dispatcherPath="azienda.jsp";
				message="Azienda eliminata con successo";
				break;

			case UPDATEAZIENDA:

				String partitaIva3 = request.getParameter("partitaiva");
				AziendaPK aziendaPK3 = new AziendaPK();
				aziendaPK3.setNome(nome);
				aziendaPK3.setpIva(partitaIva3);

				serviceAzienda.updateAzienda(descrizione, aziendaPK3);
				dto = serviceAzienda.selectAziendaId(aziendaPK3);

				dispatcherPath="azienda.jsp";
				message="Aggiornato Azienda con successo";
				break;

			case SELECTAZIENDA:

				dto = serviceAzienda.getAziendaByName(nome);

				dispatcherPath="azienda.jsp";
				message="Selezionata Azienda con successo";
				break;

				//Fine Giovanni e Tullio
				
				//Inizio Amra e Sara
			case INSERTDIPARTIMENTO:
				
				String partitaIva4 = request.getParameter("partitaIva");
				String nomeAzienda = request.getParameter("nomeAzienda");
				idDipartimento = serviceDipartimento.insertDipartimento(nome, descrizione, nomeAzienda, partitaIva4);

				if(idDipartimento != -1) {

					dto = serviceDipartimento.getDipartimentoByPK(idDipartimento);
					dispatcherPath="dipartimento.jsp";
					message="Inserito Dipartimento con successo";

				}

				else {

					message="Dipartimento non inserito";
				}

				break;

			case DELETEDIPARTIMENTO:

				idDipartimento = serviceDipartimento.getIdDipartimento(nome);
				serviceDipartimento.deleteDipartimento(idDipartimento);
				dispatcherPath="dipartimento.jsp";
				message="Eliminato Ruolo con successo";
				break;

			case UPDATEDIPARTIMENTO:

				String partitaIva5 = request.getParameter("partitaIva");
				String nomeAzienda2 = request.getParameter("nomeAzienda");

				idDipartimento = serviceDipartimento.getIdDipartimento(nome);
				serviceDipartimento.updateDipartimento(nome, descrizione, nomeAzienda2, partitaIva5, idDipartimento);

				dto = serviceDipartimento.getDipartimentoByPK(idDipartimento);

				dispatcherPath="dipartimento.jsp";
				message="Aggiornato Dipartimento con successo";
				break;

			case SELECTDIPARTIMENTO:
				dispatcherPath="dipartimento.jsp";
				message="Selezionato Dipartimento con successo";
				break;
				//Fine Amra e Sara

				//Inizio Mirko e Mario
			case INSERTIMPIEGATO:


				dispatcherPath="impiegato.jsp";
				message="Inserito Impiegato con successo";
				break;
			case DELETEIMPIEGATO:

				dispatcherPath="impiegato.jsp";
				message="Eliminato Impiegato con successo";
				break;
			case UPDATEIMPIEGATO:
				dispatcherPath="impiegato.jsp";
				message="Aggiornato Impiegato con successo";
				break;
			case SELECTIMPIEGATO:
				dispatcherPath="impiegato.jsp";
				message="Selezionato Impiegato con successo";
				break;
				//Fine Mirko e Mario

				//Inizio Giampiero e Maurizio
			case INSERTMANSIONE:

				String nomeRuolo = request.getParameter("nomeRuolo");
				String nomeImp = request.getParameter("nome");
				String cognomeImp = request.getParameter("cognome");
				String codFiscImp = request.getParameter("codiceFiscale");
				ruoliDTO.setNome(nomeRuolo);
				impiegatoDTO.setNome(nomeImp);
				impiegatoDTO.setCognome(cognomeImp);
				impiegatoDTO.setCodice_fiscale(codFiscImp);

				serviceMansione.insertMansione(ruoliDTO, impiegatoDTO);

				dto = mansioneDTO;

				dispatcherPath="mansione.jsp";
				message="Inserito Mansione con successo";
				break;
			case DELETEMANSIONE:
				String idMansione = request.getParameter("IdMansione");
				int id = Integer.parseInt(idMansione);
				serviceMansione.deleteMansione(id);

				dispatcherPath="mansione.jsp";
				message="Eliminato Mansione con successo";
				break;
			case UPDATEMANSIONE:

				String idMansione1 = request.getParameter("IdMansione");
				int id1 = Integer.parseInt(idMansione1);
				serviceMansione.deleteMansione(id1);

				String nomeRuolo1 = request.getParameter("nomeRuolo");
				String nomeImp1 = request.getParameter("nome");
				String cognomeImp1 = request.getParameter("cognome");
				String codFiscImp1 = request.getParameter("codiceFiscale");
				impiegatoDTO.setNome(nomeImp1);
				impiegatoDTO.setCognome(cognomeImp1);
				impiegatoDTO.setCodice_fiscale(codFiscImp1);

				serviceMansione.updateMansione(id1, impiegatoDTO, nomeRuolo1);

				dispatcherPath="mansione.jsp";
				message="Aggiornato Mansione con successo";
				break;
			case SELECTMANSIONE:
				break;
				//Fine Giampiero e Maurizio

				//Inizio Giampiero e Maurizio
			case INSERTRUOLO:
				serviceRuoli.insertRuolo(nome,descrizione);
				ruoliDTO.setNome(nome);
				ruoliDTO.setDescrizione(descrizione);
				dto=ruoliDTO;
				dispatcherPath="ruoli.jsp";
				message="Inserito Ruolo con successo";
				break;
			case DELETERUOLO:
				serviceRuoli.deleteRuolo(nome);
				dispatcherPath="ruoli.jsp";
				message="Eliminato Ruolo con successo";
				break;
			case UPDATERUOLO:
				serviceRuoli.updateRuolo(nome,descrizione);
				dto=serviceRuoli.getRuoliByName(nome);
				dispatcherPath="ruoli.jsp";
				message="Aggiornato Ruolo con successo";
				break;
			case SELECTRUOLO:

				dispatcherPath="ruoli.jsp";
				message="Selezionato Ruoli con successo";
				break;
		}
		//Fine Giampiero e Maurizio
		request.setAttribute("message", message);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher(dispatcherPath).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("user");
		request.setAttribute("responsePostText", "Ciao hai eseguito la POST "+parameter);
		request.getRequestDispatcher("/post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
