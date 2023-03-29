package view;

import javax.swing.*;
import java.awt.Color;

public class View {

	public JFrame frame;
	private JTextField textField_id;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_email;
	private JTextField textField_tel;
	private JTextField textField_rechercher;
	private JButton btnAjouter;
	private JButton btnEffacer;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnRechercher;
	private JLabel lbl_message;
	private JLabel lbl_id;
	private JLabel lbl_nom;
	private JLabel lbl_prenom;
	private JLabel lbl_email;
	private JLabel lbl_tel;
	private JLabel lbl_rechercher;
	private JPanel panel_liste;
	private JPanel panel_contact;
	private JScrollPane list_scroll;
	private JList list;
	
	
	
	/**
	 * Launch the application.
	 * Voir Launch.java
	 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Carnet de contacts");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel_contact = new JPanel();
		panel_contact.setBounds(10, 10, 360, 240);
		panel_contact.setBorder(BorderFactory.createTitledBorder("Les données du contact :"));
		frame.getContentPane().add(panel_contact);
		panel_contact.setLayout(null);
		
		lbl_id = new JLabel("ID :");
		lbl_id.setBounds(22, 30, 64, 13);
		lbl_id.setHorizontalAlignment(SwingConstants.LEFT);
		panel_contact.add(lbl_id);
		
		textField_id = new JTextField();
		textField_id.setBounds(96, 30, 180, 19);
		textField_id.setEditable(false);
		panel_contact.add(textField_id);
		textField_id.setColumns(10);
		
		lbl_nom = new JLabel("Nom :");
		lbl_nom.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_nom.setBounds(22, 53, 64, 13);
		panel_contact.add(lbl_nom);
		
		textField_nom = new JTextField();
		textField_nom.setColumns(10);
		textField_nom.setBounds(96, 53, 180, 19);
		panel_contact.add(textField_nom);
		
		lbl_prenom = new JLabel("Prénom :");
		lbl_prenom.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_prenom.setBounds(22, 76, 64, 13);
		panel_contact.add(lbl_prenom);
		
		textField_prenom = new JTextField();
		textField_prenom.setColumns(10);
		textField_prenom.setBounds(96, 76, 180, 19);
		panel_contact.add(textField_prenom);
		
		lbl_email = new JLabel("E-mail :");
		lbl_email.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_email.setBounds(22, 99, 64, 13);
		panel_contact.add(lbl_email);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(96, 99, 180, 19);
		panel_contact.add(textField_email);
		
		lbl_tel = new JLabel("Tel :");
		lbl_tel.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_tel.setBounds(22, 122, 64, 13);
		panel_contact.add(lbl_tel);
		
		textField_tel = new JTextField();
		textField_tel.setColumns(10);
		textField_tel.setBounds(96, 122, 180, 19);
		panel_contact.add(textField_tel);
		
		panel_liste = new JPanel();
		panel_liste.setBounds(380, 10, 380, 420);
		panel_liste.setBorder(BorderFactory.createTitledBorder("Liste des contacts :"));
		frame.getContentPane().add(panel_liste);
		panel_liste.setLayout(null);
		
		list_scroll = new JScrollPane();
		list_scroll.setBounds(10, 20, 360, 400);
		panel_liste.add(list_scroll);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_scroll.setViewportView(list);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(64, 276, 118, 32);
		btnAjouter.setIcon(new ImageIcon("img\\add.png"));
		frame.getContentPane().add(btnAjouter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(192, 276, 118, 32);
		btnModifier.setIcon(new ImageIcon("img\\edit.png"));
		frame.getContentPane().add(btnModifier);
		
		btnEffacer = new JButton("Effacer");
		btnEffacer.setBounds(64, 324, 118, 32);
		btnEffacer.setIcon(new ImageIcon("img\\erase.png"));
		frame.getContentPane().add(btnEffacer);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(192, 324, 118, 32);
		btnSupprimer.setIcon(new ImageIcon("img\\delete.png"));
		frame.getContentPane().add(btnSupprimer);
		
		lbl_rechercher = new JLabel("Rechercher un contact :");
		lbl_rechercher.setBounds(10, 490, 380, 13);
		frame.getContentPane().add(lbl_rechercher);
		
		textField_rechercher = new JTextField();
		textField_rechercher.setBounds(10, 512, 600, 24);
		frame.getContentPane().add(textField_rechercher);
		textField_rechercher.setColumns(10);
		
		btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(620, 512, 120, 24);
		btnRechercher.setIcon(new ImageIcon("img\\search.png"));
		frame.getContentPane().add(btnRechercher);		
		
		lbl_message = new JLabel("");
		lbl_message.setForeground(new Color(0, 128, 0));
		lbl_message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_message.setBounds(64, 390, 246, 13);
		frame.getContentPane().add(lbl_message);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField_id() {
		return textField_id;
	}

	public void setTextField_id(JTextField textField_id) {
		this.textField_id = textField_id;
	}

	public JTextField getTextField_nom() {
		return textField_nom;
	}

	public void setTextField_nom(JTextField textField_nom) {
		this.textField_nom = textField_nom;
	}

	public JTextField getTextField_prenom() {
		return textField_prenom;
	}

	public void setTextField_prenom(JTextField textField_prenom) {
		this.textField_prenom = textField_prenom;
	}

	public JTextField getTextField_email() {
		return textField_email;
	}

	public void setTextField_email(JTextField textField_email) {
		this.textField_email = textField_email;
	}

	public JTextField getTextField_tel() {
		return textField_tel;
	}

	public void setTextField_tel(JTextField textField_tel) {
		this.textField_tel = textField_tel;
	}

	public JTextField getTextField_rechercher() {
		return textField_rechercher;
	}

	public void setTextField_rechercher(JTextField textField_rechercher) {
		this.textField_rechercher = textField_rechercher;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	public JButton getBtnEffacer() {
		return btnEffacer;
	}

	public void setBtnEffacer(JButton btnEffacer) {
		this.btnEffacer = btnEffacer;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	public JButton getBtnRechercher() {
		return btnRechercher;
	}

	public void setBtnRechercher(JButton btnRechercher) {
		this.btnRechercher = btnRechercher;
	}

	public JLabel getLbl_message() {
		return lbl_message;
	}

	public void setLbl_message(JLabel lbl_message) {
		this.lbl_message = lbl_message;
	}

	public JLabel getLbl_id() {
		return lbl_id;
	}

	public void setLbl_id(JLabel lbl_id) {
		this.lbl_id = lbl_id;
	}

	public JLabel getLbl_nom() {
		return lbl_nom;
	}

	public void setLbl_nom(JLabel lbl_nom) {
		this.lbl_nom = lbl_nom;
	}

	public JLabel getLbl_prenom() {
		return lbl_prenom;
	}

	public void setLbl_prenom(JLabel lbl_prenom) {
		this.lbl_prenom = lbl_prenom;
	}

	public JLabel getLbl_email() {
		return lbl_email;
	}

	public void setLbl_email(JLabel lbl_email) {
		this.lbl_email = lbl_email;
	}

	public JLabel getLbl_tel() {
		return lbl_tel;
	}

	public void setLbl_tel(JLabel lbl_tel) {
		this.lbl_tel = lbl_tel;
	}

	public JLabel getLbl_rechercher() {
		return lbl_rechercher;
	}

	public void setLbl_rechercher(JLabel lbl_rechercher) {
		this.lbl_rechercher = lbl_rechercher;
	}

	public JPanel getPanel_liste() {
		return panel_liste;
	}

	public void setPanel_liste(JPanel panel_liste) {
		this.panel_liste = panel_liste;
	}

	public JPanel getPanel_contact() {
		return panel_contact;
	}

	public void setPanel_contact(JPanel panel_contact) {
		this.panel_contact = panel_contact;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JScrollPane getList_scroll() {
		return list_scroll;
	}

	public void setList_scroll(JScrollPane list_scroll) {
		this.list_scroll = list_scroll;
	}
	
}
