package be.diallo.Projet.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.diallo.Projet.Pojo.PersonnePOJO;
public class PersonneDAO extends DAO<PersonnePOJO> {
	public PersonneDAO(Connection conn) {
		super(conn);
	}

	/**
	 * Récupère une personne de la bd grâce à son id
	 * @param id
	 * @return objet personne avec les infos de la bd
	 */
	@Override
	public PersonnePOJO find(int id) {
		PersonnePOJO 		personnePOJO 	= new PersonnePOJO();
		ResultSet 			rs 				= null;
		PreparedStatement 	pst 			= null;
		try {			
			pst = this.connect.prepareStatement("SELECT * FROM Personne "
											+ "WHERE idPersonne = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				personnePOJO = new PersonnePOJO
						(
								rs.getInt	("idPersonne"),
								rs.getString("nom"),
								rs.getString("prenom"),
								rs.getString("adresse"),
								rs.getString("type")
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
		return personnePOJO;
	}
	
	/**
	 * Récupère la liste des personnes dans la bd
	 * @return liste : liste des personnes
	 */
	@Override
	public ArrayList<PersonnePOJO> getList() { 
		PersonnePOJO personnePOJO;
		ArrayList<PersonnePOJO> liste = new ArrayList<PersonnePOJO>();
		PreparedStatement pst = null;
		try {
			pst = this.connect.prepareStatement("SELECT * FROM Personne");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				personnePOJO = new PersonnePOJO();
				personnePOJO.setID			(rs.getInt		("idPersonne"));
				personnePOJO.setNom			(rs.getString	("nom"));
				personnePOJO.setPrenom		(rs.getString	("prenom"));
				personnePOJO.setAdresse		(rs.getString	("adresse"));
				personnePOJO.setTypePersonne(rs.getString	("type"));
				liste.add(personnePOJO);
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
	public int create(PersonnePOJO obj) { return 0; }

	@Override
	public void delete(int id) { }

	@Override
	public void update(int id) { }
	
	@Override
	public PersonnePOJO get(String string) { return null; }
}

