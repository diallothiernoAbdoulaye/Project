package be.diallo.Projet.Pojo;

public class UtilisateurPOJO extends PersonnePOJO {
	private int 		id;
	private String 		pseudo;
	private String 		motdepasse;
	
	/**
	 * GETTERS ET SETTERS
	 */
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
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
	public UtilisateurPOJO(){ }
	
	/**
	 * Constructeur de la classe UtilisateurPOJO
	 * @param id
	 * @param pseudo
	 * @param motdepasse
	 * @param typePersonne
	 * @param nom
	 * @param prenom
	 * @param adresse
	 */
	public UtilisateurPOJO(int id, String pseudo, String motdepasse, String typePersonne, String nom, String prenom, String adresse){
		super(id, nom, prenom, adresse, typePersonne);
		this.id 		= id;
		this.pseudo 	= pseudo;
		this.motdepasse = motdepasse;
	}
}
