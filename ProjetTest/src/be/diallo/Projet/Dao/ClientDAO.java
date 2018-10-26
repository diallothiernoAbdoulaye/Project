package be.diallo.Projet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.diallo.Projet.Pojo.*;

public class ClientDAO extends DAO<ClientPOJO> {
	public ClientDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Créer un client (insère les informations dans la base de données)
	 * @param client : objet de la classe Client
	 * @return 1 si réussi sinon 0
	 */
	@SuppressWarnings("resource")
	@Override
	public int create(ClientPOJO client) {
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			// On ajoute les données nécessaires dans la table Personne
			pst = connect
					.prepareStatement("INSERT INTO Personne (nom, prenom, adresse, type) "
										+ "VALUES (?,?,?,?)");

			pst.setString(1, client.getNom());
			pst.setString(2, client.getPrenom());
			pst.setString(3, client.getAdresse());
			pst.setString(4, client.getTypePersonne());

			pst.executeUpdate();

			// On récupère l'id crée en dernier dans la table Personne et on
			// l'assigne à l'idUtilisateur
			pst = connect
					.prepareStatement("SELECT MAX(idPersonne) FROM Personne");
			rs = pst.executeQuery();
			
			int idUtilisateur;
			if (rs.next()) {
				idUtilisateur = rs.getInt(1);
			} else {
				return 0;
			}

			// On ajoute les données nécessaires dans la table Utilisateur
			pst = connect
					.prepareStatement("INSERT INTO Utilisateur (idUtilisateur, pseudo, motdepasse) "
										+ "VALUES (?,?,?)");
			pst.setInt(1, idUtilisateur);
			pst.setString(2, client.getPseudo());
			pst.setString(3, client.getMotdepasse());

			pst.executeUpdate();

			// On ajoute les données nécessaires dans la table Client
			pst = connect
					.prepareStatement("INSERT INTO Client (idClient) VALUES (?)");
			pst.setInt(1, idUtilisateur);

			pst.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
	}

	/**
	 * Recherche un client dans la database par son id
	 * 
	 * @param id : id du client
	 * @return client : l'objet client trouvé
	 */
	/**
	 * Récupère l'objet du client par rapport à son pseudo
	 * @param pseudo : pseudo du client utilisateur
	 * @return client : l'objet
	 */

	@SuppressWarnings("resource")
	@Override
	public ClientPOJO get(String pseudo) {
		ClientPOJO 				clientPOJO 		= new ClientPOJO();
		AbstractDAOFactory 		adf				= AbstractDAOFactory.getFactory();
		DAO<PersonnePOJO> 		personneDAO 	= adf.getPersonneDAO();
		DAO<UtilisateurPOJO> 	utilisateurDAO 	= adf.getUtilisateurDAO();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = connect.prepareStatement("SELECT idUtilisateur FROM Utilisateur WHERE pseudo = ?");
			pst.setString(1, pseudo);
			ResultSet resultSet = pst.executeQuery();
			//pst.close();
			int idUtilisateur = 0;
			if(resultSet.next()){
				idUtilisateur = resultSet.getInt(1);
			}
			
			pst = connect.prepareStatement("SELECT * FROM Client WHERE idClient = ?");
			pst.setInt(1, idUtilisateur);
			rs = pst.executeQuery();
			
			if(rs.next()){
				PersonnePOJO personne 		= personneDAO.find(idUtilisateur);
				UtilisateurPOJO utilisateur = utilisateurDAO.find(idUtilisateur);
				//Je set tout sauf la liste car je ne l'ai pas encore récupérée
				clientPOJO = new ClientPOJO();
				clientPOJO.setId			(personne.getID());
				clientPOJO.setNom			(personne.getNom());
				clientPOJO.setPrenom		(personne.getPrenom());
				clientPOJO.setAdresse		(personne.getAdresse());
				clientPOJO.setTypePersonne	(personne.getTypePersonne());
				clientPOJO.setPseudo		(utilisateur.getPseudo());
				clientPOJO.setMotdepasse	(utilisateur.getMotdepasse());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return clientPOJO;
	}

	/**
	 * Je récupère l'id du client grâce à son pseudo et je vérifie si son id
	 * existe déjà dans la table Eleve
	 * 
	 * @param pseudo : pseudo du client
	 * @return true si il trouve un eleve dans la db sinon false
	 */

	
	@Override
	public void delete(int id) { }

	@Override
	public void update(int id) { }

	@Override
	public ArrayList<ClientPOJO> getList() { return null; }

	@Override
	public ClientPOJO find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
