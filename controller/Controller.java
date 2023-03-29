package controller;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JOptionPane;

import model.*;
import view.View;

public class Controller {

	private ContactModel modele;
	private View vue;
	private ContactDAO contactDAO;
	private ArrayList<ContactModel> arrayContacts = null;
	private ArrayList<ContactModel> arrayRecherche = null;
	
	public Controller(View vue) {
		this.vue = vue;
		contactDAO = new ContactDAO();
		arrayContacts = contactDAO.getAllContacts();
		vue.getList().setListData(arrayContacts.toArray());
		initController();
	}
	
	public void initController() {
		vue.getBtnAjouter().addActionListener(e -> ajouterContact());
		vue.getBtnEffacer().addActionListener(e -> effacerContact());
		vue.getBtnSupprimer().addActionListener(e -> supprimerContact());
		vue.getBtnModifier().addActionListener(e -> modifierContact());
		vue.getList().addListSelectionListener(e -> selectionnerContact());
		vue.getBtnRechercher().addActionListener(e -> rechercherContact());
	}
	
	public void ajouterContact() {
		
		String nom = vue.getTextField_nom().getText();
		String prenom = vue.getTextField_prenom().getText();
		String email = vue.getTextField_email().getText();
		String tel = vue.getTextField_tel().getText();
		
		if(nom.equals("") || prenom.equals("") || email.equals("") || tel.equals("")) {
			vue.getLbl_message().setText("Ajout impossible, informations manquantes.");
		} else {
			modele = new ContactModel();
			modele.setNom(nom);
			modele.setPrenom(prenom);
			modele.setEmail(email);
			modele.setTel(tel);
			contactDAO.ajouterContact(modele);
			
			effacerContact();
			vue.getLbl_message().setText("Contact ajouté.");
			
			arrayContacts = contactDAO.getAllContacts();
			vue.getList().setListData(arrayContacts.toArray());
		}
	}
	
	public void selectionnerContact() {
		
		int index = vue.getList().getSelectedIndex();
		
		if(index < 0) {
			return;
		} else {
			ContactModel contact = arrayContacts.get(index);
			
			vue.getTextField_id().setText(Integer.toString(contact.getId()));
			vue.getTextField_nom().setText(contact.getNom());
			vue.getTextField_prenom().setText(contact.getPrenom());
			vue.getTextField_email().setText(contact.getEmail());
			vue.getTextField_tel().setText(contact.getTel());
		}
	}
	
	public void modifierContact() {
		
		int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir modifier ce contact ?");
		
		if(option == JOptionPane.OK_OPTION) { // == 0
			try {
				int id = Integer.parseInt(vue.getTextField_id().getText()); 
				
				String nom = vue.getTextField_nom().getText();
				String prenom = vue.getTextField_prenom().getText();
				String email = vue.getTextField_email().getText();
				String tel = vue.getTextField_tel().getText();
				
				modele = new ContactModel();
				modele.setNom(nom);
				modele.setPrenom(prenom);
				modele.setEmail(email);
				modele.setTel(tel);
				contactDAO.modifierContact(id, modele);
				
				effacerContact();
				vue.getLbl_message().setText("Contact modifié.");
		
				arrayContacts = contactDAO.getAllContacts();
				vue.getList().setListData(arrayContacts.toArray());
			} catch (Exception e) {
				return;
			}
		}
	}
		
	public void supprimerContact() {
		int option = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce contact ?");
		
		if(option == JOptionPane.OK_OPTION) { // == 0
			try {
				int id = Integer.parseInt(vue.getTextField_id().getText());
				contactDAO.supprimerContact(id);
				
				effacerContact();
				vue.getLbl_message().setText("Contact supprimé.");
				
				arrayContacts = contactDAO.getAllContacts();
				vue.getList().setListData(arrayContacts.toArray());
			} catch (Exception e) {
				return;
			}
		}
	}
	
	public void rechercherContact() {
		String recherche = vue.getTextField_rechercher().getText();
		
		arrayRecherche = contactDAO.searchContacts(recherche);
		
		vue.getList().setListData(arrayRecherche.toArray());
	}

	public void effacerContact() {
		vue.getTextField_id().setText("");
		vue.getTextField_nom().setText("");
		vue.getTextField_prenom().setText("");
		vue.getTextField_email().setText("");
		vue.getTextField_tel().setText("");
		vue.getLbl_message().setText("");
	}
}
