/**
 *
 */
package com.esis.italia.course.example.jpa.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.esis.italia.course.example.jpa.entity.GenericEntity;
import com.esis.italia.course.example.jpa.entity.Ruoli;

/**
 * @author Giampiero Cicala
 *
 */
abstract class AbstractDAO<T extends GenericEntity<ID>, ID> implements GenericDAO {

	private final EntityManager entityManager;

	public AbstractDAO() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ProgettoJPA");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * @return the entityManager
	 */
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected ID insert(T entity) {

		ID result = null;
		try {
			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			getEntityManager().persist(entity);
			transaction.commit();
			result = entity.getID();
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	protected boolean delete(T entity) {

		boolean result = false;
		try {
			EntityTransaction transaction = getEntityManager().getTransaction();
			transaction.begin();
			getEntityManager().remove(entity);
			transaction.commit();
			result = true;
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	protected ID updateByPK(T entity, ID id) {

		ID result = null;
		try {

			T testRuolo = (T) getEntityManager().find(entity.getClass(), id);
			if (testRuolo != null) {
				EntityTransaction transaction = getEntityManager().getTransaction();
				transaction.begin();
				getEntityManager().merge(entity);
				transaction.commit();
				result = entity.getID();
			}

			return result;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public T selectByPK(Class<? extends T> clazz, ID id) {

		T result = null;
		
		try {
			result = getEntityManager().find(clazz, id);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected List<Map> select(String nome, String descrizione) {
		List result = new ArrayList<>();
		HashMap appo = new HashMap<>();
		try {
			Ruoli ruolo = new Ruoli();
			ruolo.setNome(nome);

			Ruoli testRuolo = getEntityManager().find(Ruoli.class, nome);
			String tempQuery = "select r from Ruoli r ";
			String where = " ";

			if (nome != null && !nome.isEmpty()) {
				where += "r.nome = :nome";
				appo.put("nome", nome);

			}
			if (descrizione != null && !descrizione.isEmpty()) {
				if (appo.isEmpty()) {
					where += "r.descrizione = :descrizione";
				} else if (!appo.isEmpty()) {
					where += " and r.descrizione = :descrizione";
				}
				appo.put("descrizione", descrizione);
			}
			if (!where.trim().isEmpty()) {
				tempQuery += "where " + where;
			}

			Query query = getEntityManager().createQuery(tempQuery);
			appo.entrySet().forEach(action -> {
				query.setParameter((String) ((Entry) action).getKey(), ((Entry) action).getValue());
			});

			List<Ruoli> list = query.getResultList();
			for (Ruoli r : list) {
				HashMap map = new HashMap();
				map.put("nome", r.getNome());
				map.put("descrizione", r.getDescrizione());
				result.add(map);
			}

			return result;
		} catch (Exception e) {
			throw e;
		}

	}

}
