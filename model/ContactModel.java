package model;

/**
 * 
 * Objet Contact
 * @author Jonathan Cayrol
 *
 */

public class ContactModel {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	
	public ContactModel() {
		this.id = 0;
		this.nom = "";
		this.prenom = "";
		this.email = "";
		this.tel = "";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return id + ", " + nom + ", " + prenom + ", " + email + ", " + tel;
	}
	
	
}
