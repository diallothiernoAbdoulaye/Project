package be.diallo.Projet.Pojo;

public class PersonnePOJO {
	protected int 		id;
	protected String 	nom;
	protected String 	prenom;
	protected String 	adresse;
	protected String 	type;

	/**
	 *  GETTERS ET SETTERS
	 */
	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTypePersonne() {
		return type;
	}

	public void setTypePersonne(String type) {
		this.type = type;
	}	
	
	/**
	 * Constructeur vide
	 */
	public PersonnePOJO() { }
	
	/**
	 * Constructeur de la classe PersonnePOJO
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param type
	 */
	public PersonnePOJO(int id, String nom, String prenom, String adresse, String type) {
		this.id 		= id;
		this.nom 		= nom;
		this.prenom 	= prenom;
		this.adresse 	= adresse;
		this.type 		= type;
	}
}
