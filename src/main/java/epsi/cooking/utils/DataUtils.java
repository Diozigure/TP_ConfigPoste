package epsi.cooking.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import epsi.cooking.entities.Recette;

public class DataUtils {
	public static List<Recette> getRecettes() {
		List<Recette> lRecette = null;
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			String sql = "Select r from Recette r";
			@SuppressWarnings("unchecked")
			Query<Recette> query = session.createQuery(sql);

			lRecette = query.getResultList();
		} catch (Exception e) {
			Logger.getLogger(DataUtils.class).log(Level.ERROR, e.getMessage());
			session.getTransaction().rollback();
		}
		return lRecette;
	}

	public static Recette getRecette(String idRecette) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Recette r = new Recette();
		try {
			session.getTransaction().begin();
			String sql = "Select r from Recette r where r.id = '" + idRecette + "'";
			@SuppressWarnings("unchecked")
			Query<Recette> query = session.createQuery(sql);

			r = query.getSingleResult();
		} catch (Exception e) {
			Logger.getLogger(DataUtils.class).log(Level.ERROR, e.getMessage());
			session.getTransaction().rollback();
		}
		return r;
	}

	public static File getPDF(String[] lIdRecette) {
		File file_pdf = new File("recettes.pdf");
		Document document = new Document();
		try {
			FileOutputStream fos = new FileOutputStream(file_pdf);
			PdfWriter writer = PdfWriter.getInstance(document, fos);
			document.open();
			document.add(new Paragraph("LISTE DES RECETTES"));
			document.add(new Paragraph(""));
			for (String idRecette : lIdRecette) {
				Recette r = getRecette(idRecette);
				document.add(new Paragraph(r.toString()));
			}
			writer.flush();
			document.close();
			writer.close();
		} catch (DocumentException e) {
			Logger.getLogger(DataUtils.class).log(Level.ERROR, e.getMessage());
		} catch (FileNotFoundException e) {
			Logger.getLogger(DataUtils.class).log(Level.ERROR, e.getMessage());
		}

		return file_pdf;
	}
}
