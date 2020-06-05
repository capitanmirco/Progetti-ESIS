package com.esis.italia.course.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esis.italia.course.example.dto.GenericDTO;
import com.esis.italia.course.example.dto.RuoliDTO;
import com.esis.italia.course.example.enumeration.CallType;
import com.esis.italia.course.example.jpa.ImpiegatoPK;
import com.esis.italia.course.example.services.ServiceAzienda;
import com.esis.italia.course.example.services.ServiceDipartimento;
import com.esis.italia.course.example.services.ServiceRuoli;

/**
 * Servlet implementation class ServletExample
 */
@WebServlet("/service")
public class ServletExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public ServletExample() {
//    	try {
//			Context context=new InitialContext();
//			DataSource datasource=(DataSource) context.lookup("java:comp/env/jdbc/postgres");
//			Connection connection = datasource.getConnection();
//			ResultSet result=connection.createStatement().executeQuery("select 1");
//			while(result.next()) {
//				Object object = result.getObject(1);
//				System.out.println(object);
//			}
//
//    	} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HTTPMethod appo=HTTPMethod.DELETE;
//		switch(request.getMethod()) {
//		case "GET":
//			doGet(request, response);
//			break;
//		case "POST":
//			doPost(request, response);
//			break;
//		case "PUT":
//			doPut(request, response);
//			break;
//		case "DELETE":
//			doDelete(request, response);
//			break;
//		}
//
////
////		// switch con enum com.esis.italia.course.example.enumeration.HTTPMethod
//		switch(HTTPMethod.valueOf(request.getMethod())) {
//		case GET:
//			break;
//		case POST:
//			break;
//		case PUT:
//			break;
//		case DELETE:
//			break;
//		}
//		request.setAttribute("", "");
//		request.getRequestDispatcher("").forward(request, response);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenericDTO dto=null;

		String message="";
		String dispatcherPath="";
		ServiceRuoli service=new ServiceRuoli();
		ServiceDipartimento serviceDipartimento=new ServiceDipartimento();
		ServiceAzienda serviceAzienda=new ServiceAzienda();


		String nome = request.getParameter("nome");
		String descrizione=request.getParameter("descrizione");

		Integer idAzienda = null;
		Integer idDipartimento = null;
		Integer idRuoli=null;
		Integer idManzioni=null;
		ImpiegatoPK idImpiegato=null;


		String callType = request.getParameter("callType");
		switch (CallType.valueOf(callType)) {

		//Inizio Giovanni e Tullio
		case INSERTAZIENDA:

			break;
		case DELETEAZIENDA:
			break;
		case UPDATEAZIENDA:
			break;
		case SELECTAZIENDA:
			break;
		//Fine Giovanni e Tullio

		//Inizio Amra e Sara
		case INSERTDIPARTIMENTO:
			idAzienda = Integer.parseInt(request.getParameter("idAzienda"));
			idDipartimento = serviceDipartimento.insertDipartimento(nome,descrizione,idAzienda);
			dto = serviceDipartimento.getDipartimentoByPK(idDipartimento);
			message="Inserito Dipartimento con successo";
			break;
		case DELETEDIPARTIMENTO:
			idDipartimento = Integer.parseInt(request.getParameter("idDipartimento"));
			serviceDipartimento.deleteDipartimento(idDipartimento);
			message="Eliminato Ruolo con successo";
			break;
		case UPDATEDIPARTIMENTO:
			idAzienda = Integer.parseInt(request.getParameter("idAzienda"));
			idDipartimento = Integer.parseInt(request.getParameter("idDipartimento"));
			serviceDipartimento.updateDipartimento(nome, descrizione,idAzienda, idDipartimento);
			dto = serviceDipartimento.getDipartimentoByPK(idDipartimento);
			message="Inserito Dipartimento con successo";
			break;
		case SELECTDIPARTIMENTO:
			break;
		//Fine Amra e Sara

		//Inizio Mirko e Mario
		case INSERTIMPIEGATO:
			break;
		case DELETEIMPIEGATO:
			break;
		case UPDATEIMPIEGATO:
			break;
		case SELECTIMPIEGATO:
			break;
		//Fine Mirko e Mario

		//Inizio Giampiero e Maurizio
		case INSERTMANSIONE:
			break;
		case DELETEMANSIONE:
			break;
		case UPDATEMANSIONE:
			break;
		case SELECTMANSIONE:
			break;
		//Fine Giampiero e Maurizio

		//Inizio Giampiero e Maurizio
		case INSERTRUOLO:
			RuoliDTO ruoliDTO=new RuoliDTO();
			service.insertRuolo(nome,descrizione);
			ruoliDTO.setNome(nome);
			ruoliDTO.setDescrizione(descrizione);
			dto=ruoliDTO;
			message="Inserito Ruolo con successo";
			break;
		case DELETERUOLO:
			service.deleteRuolo(nome);
			message="Eliminato Ruolo con successo";
			break;
		case UPDATERUOLO:
			service.updateRuolo(nome,descrizione);
			dto=service.getRuoliByName(nome);
			message="Aggiornato Ruolo con successo";
			break;
		case SELECTRUOLO:
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
