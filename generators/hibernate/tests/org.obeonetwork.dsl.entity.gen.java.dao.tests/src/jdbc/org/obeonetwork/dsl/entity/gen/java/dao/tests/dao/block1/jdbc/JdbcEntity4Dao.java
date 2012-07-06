package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.jdbc;

// Start of user code for import 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc.Dsl.entity.gen.java.dao.testsConnectionUtils;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block1.Entity4;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block1.Entity6;

import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao;

// End of user code for import 

/**
 * This class provides the data access layer to the Entity4 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity4Dao implements IEntity4Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity4Dao.class);;


	protected final static String TABLE_NAME = "ENTITY4";

	protected final static String REFERENCE3 = "FK_ENTITY6_REFERENCE3_ID";
	
	// Start of user code specifics queries
	protected static final String CREATE_QUERY = 
		"INSERT INTO " + TABLE_NAME + 
		" (ID) VALUES (?)";
		
	protected static final String UPDATE_QUERY = 
		"UPDATE " + TABLE_NAME + 
		" SET  " +
		" WHERE ID = ?";
	
	protected static final String DELETE_QUERY = 
		"DELETE FROM " + TABLE_NAME + 
		" WHERE ID = ?";
		
	protected static final String FIND_ALL_QUERY = 
		"SELECT * FROM " + TABLE_NAME;
		
	protected static final String FIND_BY_ID = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE ID = ?";
		
	
	
	// End of user code

	protected Collection<Entity4> createList(ResultSet rs) throws DaoException {
		Collection<Entity4> result = new ArrayList<Entity4>();
		Entity4 entity4 = null;
		while (rs.next()) {
			entity4 = new Entity4();
			entity4.setId(rs.getString("ID"));

			result.add(entity4);
		}
		return result;
	}

	public void createEntity4(Entity4 element) throws DaoException {
		LOG.debug("Creating Entity4");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(CREATE_QUERY);
			element.setId(UUID.randomUUID().toString());
			statement.setString(1, element.getId());
			// Start of user code create
			// End of user code

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur requete", e);
		} finally {
			try {
				if(statement!=null){statement.close();}
				if(cnx!=null){cnx.close();}
			} catch (SQLException e) {
				throw new DaoException("Erreur de fermeture JDBC", e);
			}
		}
	}
	
	public void updateEntity4(Entity4 element) throws DaoException {
		LOG.debug("Updating Entity4");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(UPDATE_QUERY);
			// Start of user code update
			// End of user code
			statement.setString(1,element.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur requete", e);
		} finally {
			try {
				if(statement!=null){statement.close();}
				if(cnx!=null){cnx.close();}
			} catch (SQLException e) {
				throw new DaoException("Erreur de fermeture JDBC", e);
			}
		}
	}
	
	public void deleteEntity4(Entity4 element) throws DaoException {
		LOG.debug("Deleting Entity4");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(DELETE_QUERY);
			statement.setString(1, element.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur requete", e);
		} finally {
			try {
				if(statement!=null){statement.close();}
				if(cnx!=null){cnx.close();}
			} catch (SQLException e) {
				throw new DaoException("Erreur de fermeture JDBC", e);
			}
		}
	}
	
	public Collection<Entity4> findAllEntity4s() throws DaoException {
		LOG.debug("Find all Entity4");
		Connection cnx = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.createStatement();
			rs = statement.executeQuery(FIND_ALL_QUERY);

			Collection<Entity4> result = createList(rs);
			return result;
		} catch (SQLException e) {
			throw new DaoException("Erreur requete", e);
		} finally {
			try {
				if(rs!=null){rs.close();}
				if(statement!=null){statement.close();}
				if(cnx!=null){cnx.close();}
			} catch (SQLException e) {
				throw new DaoException("Erreur de fermeture JDBC", e);
			}
		}
	}	
	
	public Entity4 findEntity4ById(String id) throws DaoException {
		LOG.debug("Find Entity4 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity4 result = new Entity4();
			result.setId(id);
			if (rs.next()) {
			}
			return result;
		} catch (SQLException e) {
			throw new DaoException("Erreur requete", e);
		} finally {
			try {
				if(rs!=null){rs.close();}
				if(statement!=null){statement.close();}
				if(cnx!=null){cnx.close();}
			} catch (SQLException e) {
				throw new DaoException("Erreur de fermeture JDBC", e);
			}
		}
	}
	


	//Start of user code
	//End of user code
}