package be.diallo.Projet.Metier;


import java.util.ArrayList;

import be.diallo.Projet.Dao.AbstractDAOFactory;
import be.diallo.Projet.Dao.DAO;
import be.diallo.Projet.Dao.PersonneDAO;
import be.diallo.Projet.Pojo.PersonnePOJO;
import be.diallo.Projet.Utilitaire.SingletonConnection;

public class Personne {
	protected String 	nom;
	protected String 	prenom;
	protected String	adresse;
	protected String 	type;
	AbstractDAOFactory 	adf 		= AbstractDAOFactory.getFactory();
	DAO<PersonnePOJO> 	personneDAO = adf.getPersonneDAO();
	PersonneDAO			personneDAO2= new PersonneDAO(SingletonConnection.getInstance());
	
	/**
	 * GETTERS ET SETTERS
	 */
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
	public Personne() { }
	
	/**
	 * Constructeur de la classe Personne
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param type
	 */
	public Personne(String nom, String prenom, String adresse, String type) {
		this.nom 		= nom;
		this.prenom 	= prenom;
		this.adresse 	= adresse;
		this.type 		= type;
	}
	
	/**
	 * Constructeur qui permet de convertir un objet de la classe PersonnePOJO en un objet de la classe Personne
	 * @param personnePOJO
	 */
	public Personne(PersonnePOJO personnePOJO) {
		this.setNom			(personnePOJO.getNom());
		this.setPrenom		(personnePOJO.getPrenom());
		this.setAdresse		(personnePOJO.getAdresse());
		this.setTypePersonne(personnePOJO.getTypePersonne());
	}
	
	/**
	 * Je récupère la liste des personnes
	 * @return listPersonne : la liste des personnes présentes dans la base de données
	 */
	public ArrayList<Personne> getListPersonne(){
		ArrayList<PersonnePOJO>	 	listPersonnePOJO 	= personneDAO.getList();
		ArrayList<Personne> 		listPersonne 		= new ArrayList<Personne>();
		
		for(int i = 0; i < listPersonnePOJO.size(); i++){
			Personne personne = new Utilisateur();
			personne.setNom				(listPersonnePOJO.get(i).getNom());
			personne.setPrenom			(listPersonnePOJO.get(i).getPrenom());
			personne.setAdresse			(listPersonnePOJO.get(i).getAdresse());
			personne.setTypePersonne	(listPersonnePOJO.get(i).getTypePersonne());
			listPersonne.add			(personne);
		}
		return listPersonne;
	}
	
	
	
}
