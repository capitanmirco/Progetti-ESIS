//package com.esis.italia.course.example.services;
//
//import java.util.List;
//import java.util.Map;
//
//import com.esis.italia.course.example.dto.ImpiegatoDTO;
//import com.esis.italia.course.example.jpa.dao.ImpiegatoDAO;
//
//
//
//public class ServiceImpiegato extends AbstractService<ImpiegatoDAO> {
//	public ServiceImpiegato() {
//		this.dao=new ImpiegatoDAO();
//	}
//
//	public ImpiegatoDTO getRuoliByName(String name) {
//		ImpiegatoDTO result=new ImpiegatoDTO();
//		List<Map> selectImpiegato = getDao().selectImpiegato(name, null);
//		if(selectImpiegato.size()>0) {
//			Map map = selectImpiegato.get(0);
//			result.setDescrizione((String) map.get("descrizione"));
//			result.setNome((String) map.get("nome"));
//		}
//		return result;
//	}
//	public String insertImpiegato(String name,String description) {
//		return getDao().insertImpiegato(name, description);
//
//	}
//	public String updateImpiegato(String name,String description) {
//		return getDao().updateImpiegato(name, description);
//
//	}
//	public boolean deleteImpiegato(String name) {
//		return getDao().deleteImpiegato(name);
//
//	}
//}
//
