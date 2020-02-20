package epsi.cooking.utils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import epsi.cooking.entities.Recette;

public class DataUtils {
	// public static List<Recette> getRecettes() {
	// List<Recette> lRecette = null;
	// SessionFactory factory = HibernateUtils.getSessionFactory();
	// Session session = factory.getCurrentSession();
	// try {
	// session.getTransaction().begin();
	// String sql = "Select r from Recette r";
	// Query<Recette> query = session.createQuery(sql);
	//
	// lRecette = query.getResultList();
	// } catch (Exception e) {
	// e.printStackTrace();
	// session.getTransaction().rollback();
	// }
	// return lRecette;
	// }
	public static List<Recette> getRecettes() {
		List<Recette> lRecette = new ArrayList<Recette>();
		Recette r1 = new Recette(1, "Tarte aux pommes", "Une délicieuse tarte aux pommes");
		Recette r2 = new Recette(2, "Tarte aux abricots", "Une délicieuse tarte aux abricots");
		Recette r3 = new Recette(3, "Tarte aux fraises", "Une délicieuse tarte aux fraises");
		lRecette.add(r1);
		lRecette.add(r2);
		lRecette.add(r3);
		return lRecette;
	}
}
