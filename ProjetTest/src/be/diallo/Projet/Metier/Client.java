package be.diallo.Projet.Metier;

import be.diallo.Projet.Dao.AbstractDAOFactory;
import be.diallo.Projet.Dao.DAO;
import be.diallo.Projet.Pojo.*;

public class Client extends Utilisateur {
	private int 					id;
	
	AbstractDAOFactory 				adf 			= AbstractDAOFactory.getFactory();
	DAO<ClientPOJO> 				clientDAO 		= adf.getClientDAO();

	/**
	 * GETTERS ET SETTERS
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	/**
	 * Constructeur vide*/
public Client(String pseudo, String motdepasse, String typeUtilisateur, String nom, String prenom, String adresse) {
		super(pseudo, motdepasse, "Client", nom, prenom, adresse);
	}
	public Client() { }
	
	public Client(ClientPOJO clientPOJO) {
		this.setId			(clientPOJO.getId());
		this.setPseudo		(clientPOJO.getPseudo());
		this.setMotdepasse	(clientPOJO.getMotdepasse());
		this.setNom			(clientPOJO.getNom());
		this.setPrenom		(clientPOJO.getPrenom());
		this.setAdresse		(clientPOJO.getAdresse());
		this.setTypePersonne(clientPOJO.getTypePersonne());
	}
		
	
	/**
	 * Crée un client (lors de l'inscription) et ajoute les infos dans la db
	 * @param client : objet client
	 */
	public int creerClient(ClientPOJO client){
		if(clientDAO.create(client)==1)
			return 1;
		else
			return 0;
	}
	/**
	 * Je récupère les informations d'un client grâce à son pseudo
	 * @param pseudo : pseudo du client
	 * @return client : objet client 
	 */
	public Client get(String pseudo){
		//Je récupère les infos du client connecté grâce à son pseudo et je l'assigne à un objet
		ClientPOJO clientPOJO = clientDAO.get(pseudo);
		Client client = new Client(clientPOJO);
		return client;
	}
}

