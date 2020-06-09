/**
 *
 */
package com.esis.italia.course.example.services;

import java.util.List;
import java.util.Map;

import com.esis.italia.course.example.dto.RuoliDTO;
import com.esis.italia.course.example.jpa.dao.RuoliDAO;

/**
 * @author Giampiero Cicala
 *
 */
public class ServiceRuoli extends AbstractService<RuoliDAO> {
	public ServiceRuoli() {
		this.dao=new RuoliDAO();
	}

	public RuoliDTO getRuoliByName(String name) {
		RuoliDTO result=new RuoliDTO();
		List<Map> selectRuolo = getDao().selectRuolo(name, null);
		if(selectRuolo.size()>0) {
			Map map = selectRuolo.get(0);
			result.setDescrizione((String) map.get("descrizione"));
			result.setNome((String) map.get("nome"));
		}
		return result;
	}
	
	public String insertRuolo(String name,String description) {
		return getDao().insertRuolo(name, description);

	}
	public String updateRuolo(String name,String description) {
		return getDao().updateRuolo(name, description);

	}
	public boolean deleteRuolo(String name) {
		return getDao().deleteRuolo(name);

	}
}
