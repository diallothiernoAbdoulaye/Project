package be.diallo.Projet.Dao;

import be.diallo.Projet.Pojo.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	
	public abstract DAO<UtilisateurPOJO> 	getUtilisateurDAO();
	public abstract DAO<ClientPOJO> 		getClientDAO();
	public abstract DAO<PersonnePOJO> 		getPersonneDAO();
	public static AbstractDAOFactory getFactory(){
		return new DAOFactory();
	}
}
