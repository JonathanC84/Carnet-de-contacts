package model;

import java.sql.*;
import java.util.*;
/**
 * DATA ACCESS OBJECT
 * Contact
 * @author Jonathan Cayrol
 *
 */

public class ContactDAO {

	private Connection conn;
	
	// constructeur
	public ContactDAO() {
		conn = Connexion.getConnection();
	}
	
	public ArrayList<ContactModel> getAllContacts() {
		
		ArrayList<ContactModel> contactListe = new ArrayList<ContactModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from contacts order by id_cont");
			while(resultats.next()) {
				ContactModel contact = new ContactModel();
				contact.setId(resultats.getInt("id_cont"));
				contact.setNom(resultats.getString("nom_cont"));
				contact.setPrenom(resultats.getString("prenom_cont"));
				contact.setEmail(resultats.getString("mail_cont"));
				contact.setTel(resultats.getString("tel_cont"));
				contactListe.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactListe;
	}
	
	public ArrayList<ContactModel> searchContacts(String recherche) {
		
		ArrayList<ContactModel> contactSearch = new ArrayList<ContactModel>();
		try {
			Statement statement = conn.createStatement();
			ResultSet resultats = statement.executeQuery("select * from contacts where nom_cont like '%"+recherche+"%' or prenom_cont like '%"+recherche+"%';");
			while(resultats.next()) {
				ContactModel contact = new ContactModel();
				contact.setId(resultats.getInt("id_cont"));
				contact.setNom(resultats.getString("nom_cont"));
				contact.setPrenom(resultats.getString("prenom_cont"));
				contact.setEmail(resultats.getString("mail_cont"));
				contact.setTel(resultats.getString("tel_cont"));
				contactSearch.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactSearch;
	}
		
	public void ajouterContact(ContactModel contact) {
		try {
			
			PreparedStatement preparedStatement = conn.prepareStatement("insert into contacts(nom_cont, prenom_cont, mail_cont, tel_cont) values (?,?,?,?)");
			
			preparedStatement.setString(1, contact.getNom());
			preparedStatement.setString(2, contact.getPrenom());
			preparedStatement.setString(3, contact.getEmail());
			preparedStatement.setString(4, contact.getTel());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException ex) {
		
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	public void modifierContact(int id, ContactModel contact) {
		try {
			
			PreparedStatement preparedStatement = conn.prepareStatement("update contacts set nom_cont = ?, prenom_cont = ?, mail_cont = ?, tel_cont = ? where id_cont="+id);
			
			preparedStatement.setString(1, contact.getNom());
			preparedStatement.setString(2, contact.getPrenom());
			preparedStatement.setString(3, contact.getEmail());
			preparedStatement.setString(4, contact.getTel());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException ex) {
		
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
	
	public void supprimerContact(int id) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("delete from contacts where id_cont="+id);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException ex) {
		
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ((SQLException) ex).getSQLState());
			System.out.println("VendorError: " + ((SQLException) ex).getErrorCode());
		}
	}
}
