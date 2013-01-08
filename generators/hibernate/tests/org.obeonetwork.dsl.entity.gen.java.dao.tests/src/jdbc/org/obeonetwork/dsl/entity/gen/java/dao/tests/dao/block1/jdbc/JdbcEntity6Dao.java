package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.jdbc;

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
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity6;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc.TestsConnectionUtils;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity6 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity6Dao implements IEntity6Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity6Dao.class);


	protected final static String TABLE_NAME = "ENTITY6";

	protected final static String REFERENCE4 = "FK_ENTITY4_REFERENCE4_ID";
	
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
		Entity6 entity6 = null;
		while (rs.next()) {
			entity6 = new Entity6();
			entity6.setId(rs.getString("ID"));

			result.add(entity6);
		}
		return result;
	}

	public void createEntity6(Entity6 element) throws DaoException {
		LOG.debug("Creating Entity6");
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
	
	public void updateEntity6(Entity6 element) throws DaoException {
		LOG.debug("Updating Entity6");
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
	
	public void deleteEntity6(Entity6 element) throws DaoException {
		LOG.debug("Deleting Entity6");
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
	
	public Collection findAllEntity6s() throws DaoException {
		LOG.debug("Find all Entity6");
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
	
	public Entity6 findEntity6ById(String id) throws DaoException {
		LOG.debug("Find Entity6 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity6 result = new Entity6();
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
