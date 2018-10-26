package be.diallo.Projet.Pojo;


import be.diallo.Projet.Metier.Client;

public class ClientPOJO extends UtilisateurPOJO {
	private int 						id;
	
	/**
	 *  GETTERS ET SETTERS
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Constructeur vide
	 */
	public ClientPOJO() {

	}

	/**
	 * Je convertis une instance de la classe Client en une instance de la classe ClientPOJO
	 * @param client
	 */
	public ClientPOJO(Client client) {
		this.setPseudo		(client.getPseudo());
		this.setMotdepasse	(client.getMotdepasse());
		this.setNom			(client.getNom());
		this.setPrenom		(client.getPrenom());
		this.setAdresse		(client.getAdresse());
		this.setTypePersonne(client.getTypePersonne());
		
	}
}
