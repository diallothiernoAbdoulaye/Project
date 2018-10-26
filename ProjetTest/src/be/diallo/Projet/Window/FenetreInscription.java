package be.diallo.Projet.Window;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import be.diallo.Projet.Metier.Utilisateur;

public class FenetreInscription extends JFrame {
	private static final long serialVersionUID = 8049097190863272687L;
	Utilisateur utilisateur = new Utilisateur();

	/**
	 * Launch the application.
	 */
	public static void fenetreInscription() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreInscription frame = new FenetreInscription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreInscription() {
		setResizable(false);
		setTitle("Inscription");
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\ProjetEcoleDeSki-v1.0.2-alpha\\img\\Snowboard-Cross-icon.png"));
		setTitle("Inscription à l'application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 580);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Partie ajout de widgets - changement de police - changement de position
		 * 
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 422, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInscription 				= new JLabel("INSCRIPTION");
		JLabel lblVotreAdresse 				= new JLabel("Adresse");
		lblVotreAdresse.setForeground(Color.CYAN);
		JLabel lblrueNumro 					= new JLabel("(Rue - numéro - ville - cp)");
		JTextField textFieldAdresse 		= new JTextField();
		JTextField textFieldPrenom 			= new JTextField();
		JLabel lblVotrePrnom 				= new JLabel("Prénom");
		lblVotrePrnom.setForeground(Color.CYAN);
		JButton btnQuitter 					= new JButton("Quitter");
		JButton btnValider 					= new JButton("Valider");
		JLabel lblVotrePseudo 				= new JLabel("Pseudo");
		lblVotrePseudo.setForeground(Color.CYAN);
		JTextField textFieldPseudo 			= new JTextField();
		JLabel lblVotreMotDe 				= new JLabel("Mot de passe");
		lblVotreMotDe.setForeground(Color.CYAN);
		JPasswordField passwordField 		= new JPasswordField();
		JLabel lblVotreNom 					= new JLabel("Nom");
		lblVotreNom.setForeground(Color.CYAN);
		JTextField textFieldNom 			= new JTextField();
		JRadioButton rdbtnClient 			= new JRadioButton("Client");
		rdbtnClient.setForeground(Color.CYAN);
		JRadioButton rdbtnMoniteur 			= new JRadioButton("Loueur");
		rdbtnMoniteur.setForeground(Color.CYAN);
		ButtonGroup btnGroupType			= new ButtonGroup();
		btnGroupType.add(rdbtnClient);
		btnGroupType.add(rdbtnMoniteur);
		JLabel lblVotreType 				= new JLabel("Type");
		lblVotreType.setForeground(Color.CYAN);
		
		btnQuitter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnValider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnMoniteur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblInscription.setForeground(Color.CYAN);
		lblInscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscription.setFont			(new Font("Agency FB", Font.BOLD, 45));
		btnQuitter.setFont				(new Font("Tahoma", Font.PLAIN, 14));
		btnValider.setFont				(new Font("Tahoma", Font.PLAIN, 14));
		lblVotrePseudo.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		textFieldPseudo.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		lblVotreMotDe.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		passwordField.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		lblVotreNom.setFont				(new Font("Century Gothic", Font.BOLD, 13));
		textFieldNom.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		lblVotreType.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		rdbtnClient.setFont				(new Font("Century Gothic", Font.BOLD, 13));
		rdbtnMoniteur.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		lblVotreAdresse.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		lblrueNumro.setFont				(new Font("Century Gothic", Font.PLAIN, 13));
		textFieldAdresse.setFont		(new Font("Century Gothic", Font.PLAIN, 13));
		lblVotrePrnom.setFont			(new Font("Century Gothic", Font.BOLD, 13));
		textFieldPrenom.setFont			(new Font("Century Gothic", Font.PLAIN, 13));
		
		btnQuitter.setBounds			(10, 476, 109, 42);
		btnValider.setBounds			(303, 476, 109, 42);
		lblVotrePseudo.setBounds		(30, 55, 109, 20);
		textFieldPseudo.setBounds		(30, 77, 142, 25);
		lblVotreMotDe.setBounds			(30, 102, 142, 20);
		passwordField.setBounds			(30, 121, 142, 25);		
		lblVotreNom.setBounds			(30, 147, 109, 20);
		textFieldNom.setBounds			(30, 168, 142, 25);
		lblInscription.setBounds		(115, 5, 191, 54);
		lblVotreType.setBounds			(30, 293, 86, 20);
		rdbtnClient.setBounds			(115, 294, 95, 23);
		rdbtnMoniteur.setBounds			(227, 294, 109, 23);
		lblVotreAdresse.setBounds		(30, 241, 128, 20);
		lblrueNumro.setBounds			(108, 241, 169, 20);
		textFieldAdresse.setBounds		(30, 262, 276, 25);
		lblVotrePrnom.setBounds			(30, 193, 128, 20);
		textFieldPrenom.setBounds		(30, 213, 142, 25);
		
		textFieldNom.setColumns(20);
		textFieldPseudo.setColumns(20);
		textFieldAdresse.setColumns(50);
		textFieldPrenom.setColumns(20);
		rdbtnClient.setBackground(Color.WHITE);
		rdbtnMoniteur.setBackground(Color.WHITE);

		panel.add(lblInscription);
		panel.add(btnQuitter);
		panel.add(btnValider);
		panel.add(lblVotrePseudo);
		panel.add(textFieldPseudo);
		panel.add(lblVotreMotDe);
		panel.add(passwordField);
		panel.add(lblVotreNom);
		panel.add(textFieldNom);
		panel.add(textFieldPrenom);
		panel.add(lblVotrePrnom);
		panel.add(textFieldAdresse);
		panel.add(lblVotreType);
		panel.add(rdbtnClient);
		panel.add(rdbtnMoniteur);
		panel.add(lblVotreAdresse);
		/**
		 * Partie onclick
		 */
		JLabel labelImage = new JLabel("");
		labelImage.setBounds(-14, 24, 391, 514);
		panel.add(labelImage);	
		labelImage.setIcon(new ImageIcon("..\\ProjetTest\\img\\A.jpg"));
		
		
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Je récupère les infos des textfields
				 */
				String pseudo = textFieldPseudo.getText();
				String motdepasse = String.valueOf(passwordField.getPassword());
				String nom = textFieldNom.getText();
				String prenom = textFieldPrenom.getText();
				String adresse = textFieldAdresse.getText();
				String typeUtilisateur;

				/**
				 * Si un checkbox est checked alors je l'ajoute dans l'arraylist
				 */
				
				
				// Si radio button client est checked et l'autre non alors type
				// = client etc
				if (rdbtnClient.isSelected() == true && rdbtnMoniteur.isSelected() == false) {
					typeUtilisateur = "Client";
				} else {
					typeUtilisateur = "Loueur";
				}

				//J'appelle la méthode inscription recevant en paramètre tous les éléments nécessaires à l'inscription d'un utilisateur
				if(utilisateur.inscription(pseudo, motdepasse, nom, prenom, adresse, typeUtilisateur) == true) {
					dispose();
					FenetreConnexion.main(null);
				}
			}
		});
		
		btnQuitter.addActionListener(e -> System.exit(0));
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
