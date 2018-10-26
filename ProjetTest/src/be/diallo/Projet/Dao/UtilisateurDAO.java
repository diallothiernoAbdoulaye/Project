package be.diallo.Projet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.diallo.Projet.Pojo.PersonnePOJO;
import be.diallo.Projet.Pojo.UtilisateurPOJO;

public class UtilisateurDAO extends DAO<UtilisateurPOJO> {

	public UtilisateurDAO(Connection conn) {
		super(conn);
	}
	
	/**
	 * Recherche un utilisateur dans la database par son id
	 * @param id : id de l'utilisateur
	 * @return utilisateur : l'objet utilisateur trouvé
	 */
	@Override
	public UtilisateurPOJO find(int id) {
		UtilisateurPOJO 	utilisateurPOJO = new UtilisateurPOJO();
		ResultSet 			rs 				= null;
		PreparedStatement 	pst 			= null;
		AbstractDAOFactory 	adf 			= AbstractDAOFactory.getFactory();
		DAO<PersonnePOJO> 	personneDAO 	= adf.getPersonneDAO();
		
		try {			
			pst = this.connect.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			PersonnePOJO personnePOJO = personneDAO.find(id);
			if (rs.next()) {
				utilisateurPOJO = new UtilisateurPOJO
						(
								id,
								rs.getString("pseudo"),
								rs.getString("motdepasse"),
								personnePOJO.getTypePersonne(),
								personnePOJO.getNom(),
								personnePOJO.getPrenom(),
								personnePOJO.getAdresse()
						);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return utilisateurPOJO;
	}

	/**
	 * Recherche un utilisateur dans la database par son pseudo
	 * @param pseudo : pseudo de l'utilisateur
	 * @return utilisateur : l'objet utilisateur trouvé
	 */
	public UtilisateurPOJO find(String pseudo) {
		UtilisateurPOJO utilisateur = new UtilisateurPOJO();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = this.connect.prepareStatement("SELECT * FROM Utilisateur WHERE pseudo = ?");
			preparedStatement.setString(1, pseudo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				utilisateur.setPseudo			(resultSet.getString("pseudo"));
				utilisateur.setMotdepasse		(resultSet.getString("motdepasse"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		return utilisateur;
	}

	/** 
	 * Récupère les informations d'un utilisateur grâce à son pseudo
	 * @param pseudo : pseudo de l'utilisateur
	 * @return objet utilisateur
	 */
	@Override
	public UtilisateurPOJO get(String pseudo){
		UtilisateurPOJO utilisateurPOJO = new UtilisateurPOJO();
		try {
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM Utilisateur WHERE pseudo = ?");
			preparedStatement.setString(1, pseudo);
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
			
			AbstractDAOFactory adf 			= AbstractDAOFactory.getFactory();
			DAO<PersonnePOJO> personneDAO 	= adf.getPersonneDAO();
			//Je récupère les infos de la personne grâce à son id et je remplis le constructeur grâce à ça
			if(resultSet.next()){
				PersonnePOJO personne = personneDAO.find(resultSet.getInt("idUtilisateur"));
				utilisateurPOJO = new UtilisateurPOJO
								(
									resultSet.getInt("idUtilisateur"),
									resultSet.getString("pseudo"),
									resultSet.getString("motdepasse"),
									personne.getTypePersonne(),
									personne.getNom(),
									personne.getPrenom(),
									personne.getAdresse()	
								);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateurPOJO;
	}
	
	/**
	 * Récupère la liste des utilisateurs présents dans la bd
	 * @return liste : liste des utilisateurs
	 */
	@Override
	public ArrayList<UtilisateurPOJO> getList() {
		UtilisateurPOJO utilisateurPOJO;
		ArrayList<UtilisateurPOJO> liste = new ArrayList<UtilisateurPOJO>();
		PreparedStatement pst = null;
		try {
			pst = this.connect.prepareStatement("SELECT * FROM Utilisateur");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				utilisateurPOJO = new UtilisateurPOJO();
				utilisateurPOJO.setID(rs.getInt("idUtilisateur"));
				utilisateurPOJO.setPseudo(rs.getString("pseudo"));
				utilisateurPOJO.setMotdepasse(rs.getString("motdepasse"));
				liste.add(utilisateurPOJO);
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
		return liste;
	}

	@Override
	public int create(UtilisateurPOJO obj) { return 0; }

	@Override
	public void delete(int id) { }

	@Override
	public void update(int id) { }
}
