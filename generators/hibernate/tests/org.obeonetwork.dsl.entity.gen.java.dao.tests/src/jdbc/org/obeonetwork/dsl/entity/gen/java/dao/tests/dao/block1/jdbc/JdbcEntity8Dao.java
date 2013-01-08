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
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity7;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity8;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc.TestsConnectionUtils;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity8 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity8Dao implements IEntity8Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity8Dao.class);


	protected final static String TABLE_NAME = "ENTITY8";

	protected final static String REFERENCE6 = "FK_ENTITY7_REFERENCE6_ID";
	
	// Start of user code specifics queries
	protected static final String CREATE_QUERY = 
		"INSERT INTO " + TABLE_NAME + 
		" (ID, FK_ENTITY7_REFERENCE6_ID) VALUES (?, ?)";
		
	protected static final String UPDATE_QUERY = 
		"UPDATE " + TABLE_NAME + 
		" SET  FK_ENTITY7_REFERENCE6_ID = ?" +
		" WHERE ID = ?";
	
	protected static final String DELETE_QUERY = 
		"DELETE FROM " + TABLE_NAME + 
		" WHERE ID = ?";
		
	protected static final String FIND_ALL_QUERY = 
		"SELECT * FROM " + TABLE_NAME;
		
	protected static final String FIND_BY_ID = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE ID = ?";
		
	protected static final String FIND_BY_REFERENCE6 = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE FK_ENTITY7_REFERENCE6_ID = ?";
		
	
	
	// End of user code

	protected Collection createList(ResultSet rs) throws DaoException {
		Collection result = new ArrayList();
		Entity8 entity8 = null;
		while (rs.next()) {
			entity8 = new Entity8();
			entity8.setId(rs.getString("ID"));

			Entity7 reference6 = new Entity7();
			reference6.setId( rs.getString(REFERENCE6) );
			entity8.setReference6( reference6 );

			result.add(entity8);
		}
		return result;
	}

	public void createEntity8(Entity8 element) throws DaoException {
		LOG.debug("Creating Entity8");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(CREATE_QUERY);
			element.setId(UUID.randomUUID().toString());
			statement.setString(1, element.getId());
			// Start of user code create
			if (element.getReference6() != null) statement.setString(2, element.getReference6().getId());
			else statement.setString(2, null);
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
	
	public void updateEntity8(Entity8 element) throws DaoException {
		LOG.debug("Updating Entity8");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(UPDATE_QUERY);
			// Start of user code update
			if (element.getReference6() != null) statement.setString(1, element.getReference6().getId());
			else statement.setString(1, null);
			// End of user code
			statement.setString(2,element.getId());
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
	
	public void deleteEntity8(Entity8 element) throws DaoException {
		LOG.debug("Deleting Entity8");
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
	
	public Collection findAllEntity8s() throws DaoException {
		LOG.debug("Find all Entity8");
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
	
	public Entity8 findEntity8ById(String id) throws DaoException {
		LOG.debug("Find Entity8 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity8 result = new Entity8();
			result.setId(id);
			if (rs.next()) {
				Entity7 reference6 = new Entity7();
				reference6.setId(rs.getString(REFERENCE6));
				result.setReference6(reference6);
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
