package epsi.cooking.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import epsi.cooking.entities.Recette;

public class DataUtils {
	public static List<Recette> getRecettes() {
		List<Recette> lRecette = null;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			String sql = "Select r from Recette r";
			Query<Recette> query = session.createQuery(sql);

			lRecette = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return lRecette;
	}
}
