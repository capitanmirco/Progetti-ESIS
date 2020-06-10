package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;

import com.esis.italia.course.example.jpa.entity.Azienda;
import com.esis.italia.course.example.jpa.entity.AziendaPK;

public class AziendaDAO extends AbstractDAO<Azienda, AziendaPK> {

	public AziendaPK insertAzienda(String nome, String descrizione, String pIva) {
		
		AziendaPK done = null;
		
		try {
			AziendaPK aziendaPk = new AziendaPK();
			aziendaPk.setNome(nome);
			aziendaPk.setpIva(pIva);
			
			Azienda azienda = new Azienda();
			azienda.setId(aziendaPk);
			azienda.setDescrizione(descrizione);
			done = insert(azienda);
			
			return done;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean deleteAzienda(AziendaPK idAzienda) {
		
		boolean done = false;

		try {
			Azienda azienda = selectByPK(Azienda.class, idAzienda);
			done = delete(azienda);
			
			return done;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public AziendaPK updateAziendaDesc(String descrizione, AziendaPK idAzienda) {

		AziendaPK done = new AziendaPK();
		Azienda azienda = new Azienda();
		
		try {
			if ( (idAzienda!= null) || (descrizione != null && !descrizione.isEmpty()) ) {
				
				if(idAzienda != null) {
					azienda.setId(idAzienda);
				}
					
				if (descrizione != null && !descrizione.isEmpty()) {
					azienda.setDescrizione(descrizione);
				}
				
				if (idAzienda != null) {
					done.setpIva(idAzienda.getpIva());
					done.setNome(idAzienda.getNome());
				}
				
				done = updateByPK(azienda, idAzienda);
			}
			return done;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	/*public Azienda selectAziendaId(AziendaPK idAzienda) {
		Azienda azienda = getEntityManager().find(Azienda.class, idAzienda);
		return azienda;
	}*/
	
	public Azienda selectAziendaId(Azienda azienda) {
		Azienda azienda2 = getEntityManager().find(Azienda.class, azienda);
		return azienda2;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> selectAzienda(String nome, String descrizione, String pIva) {
		
		List result = new ArrayList<>();
		HashMap appo = new HashMap<>();
		
		try {
			Azienda azienda = new Azienda();
			azienda.setDescrizione(descrizione);
			
			AziendaPK aziendaPk = new AziendaPK();
			aziendaPk.setNome(nome);
			aziendaPk.setpIva(pIva);
			
			String tempQuery = "select a from Azienda a ";
			String where = " ";

			
			if (nome != null && !nome.isEmpty()) {
				where += "a.nome = :nome";
				appo.put("nome", nome);
			}
			
			
			if (descrizione != null && !descrizione.isEmpty()) {
				
				if (appo.isEmpty()) {
					where += "a.descrizione = :descrizione";
				} 
				
				else if (!appo.isEmpty()) {
					where += " and a.descrizione = :descrizione";
				}
				
				appo.put("descrizione", descrizione);
			}
			
			
			if (!where.trim().isEmpty()) {
				tempQuery += "where " + where;
			}

			Query query = getEntityManager().createQuery(tempQuery);
			
			appo
			.entrySet()
			.forEach(
					action -> { 
						query.setParameter( 
								(String) ((Entry) action).getKey(), ((Entry) action).getValue());
			});

			List<Azienda> list = query.getResultList();
			
			for (Azienda a : list) {
				
				HashMap map = new HashMap();
				map.put("idAzienda", a.getID());
				map.put("descrizione", a.getDescrizione());
				
				result.add(map);
			}

			return result;
			
		} catch (Exception e) {
			throw e;
		}

	}
	
	public AziendaPK getIdByName(String nome) {
		
		String sql = "SELECT a FROM Azienda a WHERE nome = :nome";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("nome", nome);
		
		List<Azienda> lista = query.getResultList();
		
		if(lista.size() > 0) {
			return lista.get(0).getID();
		}
		else 
			return null;
		
	}

}