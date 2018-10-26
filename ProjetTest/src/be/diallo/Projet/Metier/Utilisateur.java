package be.diallo.Projet.Metier;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import be.diallo.Projet.Dao.AbstractDAOFactory;
import be.diallo.Projet.Dao.DAO;
import be.diallo.Projet.Pojo.ClientPOJO;
import be.diallo.Projet.Pojo.UtilisateurPOJO;
import be.diallo.Projet.Window.FenetreMenuClient;

public class Utilisateur extends Personne{
	private String 			pseudo;
	private String 			motdepasse;
	AbstractDAOFactory 		adf 			= AbstractDAOFactory.getFactory();
	DAO<ClientPOJO> 		clientDAO 		= adf.getClientDAO();
	DAO<UtilisateurPOJO> 	utilisateurDAO 	= adf.getUtilisateurDAO();
	
	/**
	 * GETTERS ET SETTERS
	 */
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	/**
	 * Constructeur vide
	 */
	public Utilisateur(){ }
	
	/**
	 * Constructeur de la classe Utilisateur
	 * @param pseudo
	 * @param motdepasse
	 * @param typePersonne
	 * @param nom
	 * @param prenom
	 * @param adresse
	 */
	public Utilisateur(String pseudo, String motdepasse, String typePersonne, String nom, String prenom, String adresse){
		super(nom, prenom, adresse, typePersonne);
		this.pseudo 		= pseudo;
		this.motdepasse 	= motdepasse;
	}
	
	/**
	 * Je récupère la liste des utilisateurs
	 * @return listUtilisateur : la liste des utilisateurs présents dans la base de données
	 */
	public ArrayList<Utilisateur> getListUtilisateur(){
		ArrayList<UtilisateurPOJO>	 listUtilisateurPOJO 	= utilisateurDAO.getList();
		ArrayList<Utilisateur> 		 listUtilisateur 		= new ArrayList<Utilisateur>();
		
		for(int i = 0; i < listUtilisateurPOJO.size(); i++){
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setPseudo		(listUtilisateurPOJO.get(i).getPseudo());
			utilisateur.setMotdepasse	(listUtilisateurPOJO.get(i).getMotdepasse());
			listUtilisateur.add			(utilisateur);
		}
		return listUtilisateur;
	}
	
	/**
	 * Se connecte à l'application grâce au pseudo et mot de passe de l'utilisateur, 
	 * en utilisant une liste et des lambdas
	 * 
	 * @param pseudo : le pseudo de l'utilisateur
	 * @param motdepasse : le mot de passe de l'utilisateur
	 * @return true si c'est ok sinon false
	 */
	public boolean connexion(String pseudo, String motdepasse){
		ArrayList<Utilisateur> 	listUtilisateur = this.getListUtilisateur();
		List<Utilisateur> 		utilisateurList = listUtilisateur;
		
		//Je filtre la liste en utilisant des lambdas
		//findAny -> si il trouve, il stock dans l'objet
		//orElse(null) -> si il trouve rien il stock null
		Utilisateur utilisateurTrouve = utilisateurList.stream()
				.filter(x -> x.getPseudo().equals(pseudo) && x.getMotdepasse().equals(motdepasse))
				.findAny()
				.orElse(null);
		
		//Si null est stocké alors mauvais identifiants
		if(utilisateurTrouve == null){
			JOptionPane.showMessageDialog(null, "Identifiants incorrects.");
			return false;
		} else {
			//Je vérifie le type de personne (Moniteur/Client) pour ouvrir le bon menu
			if(verificationType(pseudo).equals("Client"))
				FenetreMenuClient.menuClient(pseudo);
			else {}
			
			return true;
		}
	}
	
	public boolean inscription(String pseudo, String motdepasse, String nom, String prenom, String adresse, String typePersonne) {
			
		// Si les champs sont vides, alors erreur
		if (pseudo.equals("") 
				|| motdepasse.equals("") 
				|| nom.equals("") 
				|| prenom.equals("")
				|| adresse.equals("")) {
			JOptionPane.showMessageDialog(null, "Veuillez remplir les champs nécessaires.");
			return false;
		} else {
			ArrayList<Utilisateur> 	listUtilisateur = getListUtilisateur();
			List<Utilisateur> 		utilisateurList = listUtilisateur;
			
			//Si il trouve qlq chose, ça veut dire qu'il existe déjà ce pseudo dans la db
			Utilisateur utilisateurTrouve = utilisateurList.stream()
					.filter(x -> x.getPseudo().equals(pseudo))
					.findAny()
					.orElse(null);
			
			if (!(utilisateurTrouve == null)) {
				JOptionPane.showMessageDialog(null,
						"Le pseudo que vous avez entré existe déjà, veuillez en choisir un autre.");
				return false;
			} else {
				// Sinon, et que le type d'utilisateur = client alors on enregistre
				// un client
				if (typePersonne.equals("Client")) {
					// On crée l'objet avec les données reçues avec des setters
					ClientPOJO client = new ClientPOJO();
					client.setPseudo			(pseudo);
					client.setMotdepasse		(motdepasse);
					client.setNom				(nom);
					client.setPrenom			(prenom);
					client.setAdresse			(adresse);
					client.setTypePersonne		(typePersonne);
					
					// Ajout dans la database, si cela s'est bien passé alors (== 1)
					if (clientDAO.create(client) == 1) {
						JOptionPane.showMessageDialog(null, "Inscription réussie!");
						return true;
					} else {
						JOptionPane.showMessageDialog(null, "Erreur, veuillez recommencer.");
						
					}
				}
				return false;
			}
		}
	}
	
	
	
	/**
	 * Vérifie le type de l'utilisateur grâce à son pseudo
	 * @param pseudo
	 * @return String : Client ou Moniteur
	 */
	public String verificationType(String pseudo){
		if(utilisateurDAO.get(pseudo).getTypePersonne().equals("Client"))
			return "Client";
		else
			return "Loueur";
	}
}
