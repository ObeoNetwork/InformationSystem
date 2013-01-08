package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.jdbc;

// Start of user code for import 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity3;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc.TestsConnectionUtils;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity3 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity3Dao implements IEntity3Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity3Dao.class);


	protected final static String TABLE_NAME = "ENTITY3";

	
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

	protected Collection createList(ResultSet rs) throws DaoException {
		Collection result = new ArrayList();
		Entity3 entity3 = null;
		while (rs.next()) {
			entity3 = new Entity3();
			entity3.setId(rs.getString("ID"));

			result.add(entity3);
		}
		return result;
	}

	public void createEntity3(Entity3 element) throws DaoException {
		LOG.debug("Creating Entity3");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
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
	
	public void updateEntity3(Entity3 element) throws DaoException {
		LOG.debug("Updating Entity3");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
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
	
	public void deleteEntity3(Entity3 element) throws DaoException {
		LOG.debug("Deleting Entity3");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
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
	
	public Collection findAllEntity3s() throws DaoException {
		LOG.debug("Find all Entity3");
		Connection cnx = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.createStatement();
			rs = statement.executeQuery(FIND_ALL_QUERY);

			Collection result = createList(rs);
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
	
	public Entity3 findEntity3ById(String id) throws DaoException {
		LOG.debug("Find Entity3 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity3 result = new Entity3();
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
