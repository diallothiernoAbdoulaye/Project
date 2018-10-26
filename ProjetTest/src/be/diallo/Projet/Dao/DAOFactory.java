package be.diallo.Projet.Dao;

import java.sql.Connection;


import be.diallo.Projet.Pojo.PersonnePOJO;
import be.diallo.Projet.Pojo.UtilisateurPOJO;
import be.diallo.Projet.Pojo.ClientPOJO;
import be.diallo.Projet.Utilitaire.SingletonConnection;

public class DAOFactory extends AbstractDAOFactory {

	protected static final Connection conn = SingletonConnection.getInstance();
	public DAO<UtilisateurPOJO> getUtilisateurDAO() { return new UtilisateurDAO(conn); }
	public DAO<ClientPOJO> getClientDAO() { return new ClientDAO(conn); }
	public DAO<PersonnePOJO> getPersonneDAO() { return new PersonneDAO(conn); }
}

