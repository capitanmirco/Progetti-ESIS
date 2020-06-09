/**
 *
 */
package com.esis.italia.course.example.jpa;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Giampiero Cicala
 *
 */
public class HibernateStoreManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();
			Criteria criteria = session.createCriteria(Azienda.class);
			//criteria.add(Restrictions.eq("nome", "esis"));
			Azienda uniqueResult = (Azienda) criteria.uniqueResult();
//			uniqueResult.getNome();
//			NativeQuery autoreQuery = session.createNativeQuery("select * from Autore");
//			List<Autore> autors = autoreQuery.list();
//			for (Autore autore : autors) {
//				List<Libro> libros = autore.getLibros();
//				for (Libro libro : libros) {
//					System.out.println(libro.getId());
//					System.out.println(libro.getTitolo());
//					System.out.println(libro.getAutore());
//
//				}
//			}
//			NativeQuery libroQuery = session.createNativeQuery("select * from Libro");
//			List<Libro> list = libroQuery.list();














//			Transaction t = session.beginTransaction();
//
//			Employee e1 = new Employee();
//			e1.setId(101);
//			e1.setFirstName("Gaurav");
//			e1.setLastName("Chawla");
//
//			session.save(e1);
//			t.commit();
//			System.out.println("successfully saved");
			factory.close();
			session.close();

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}



}
