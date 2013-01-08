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
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc.TestsConnectionUtils;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity7 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity7Dao implements IEntity7Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity7Dao.class);


	protected final static String TABLE_NAME = "ENTITY7";

	protected final static String REFERENCE5 = "FK_ENTITY8_REFERENCE5_ID";
	
	// Start of user code specifics queries
	protected static final String CREATE_QUERY = 
		"INSERT INTO " + TABLE_NAME + 
		" (ID, FK_ENTITY8_REFERENCE5_ID) VALUES (?, ?)";
		
	protected static final String UPDATE_QUERY = 
		"UPDATE " + TABLE_NAME + 
		" SET  FK_ENTITY8_REFERENCE5_ID = ?" +
		" WHERE ID = ?";
	
	protected static final String DELETE_QUERY = 
		"DELETE FROM " + TABLE_NAME + 
		" WHERE ID = ?";
		
	protected static final String FIND_ALL_QUERY = 
		"SELECT * FROM " + TABLE_NAME;
		
	protected static final String FIND_BY_ID = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE ID = ?";
		
	protected static final String FIND_BY_REFERENCE5 = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE FK_ENTITY8_REFERENCE5_ID = ?";
		
	
	
	// End of user code

	protected Collection createList(ResultSet rs) throws DaoException {
		Collection result = new ArrayList();
		Entity7 entity7 = null;
		while (rs.next()) {
			entity7 = new Entity7();
			entity7.setId(rs.getString("ID"));

			Entity8 reference5 = new Entity8();
			reference5.setId( rs.getString(REFERENCE5) );
			entity7.setReference5( reference5 );

			result.add(entity7);
		}
		return result;
	}

	public void createEntity7(Entity7 element) throws DaoException {
		LOG.debug("Creating Entity7");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(CREATE_QUERY);
			element.setId(UUID.randomUUID().toString());
			statement.setString(1, element.getId());
			// Start of user code create
			if (element.getReference5() != null) statement.setString(2, element.getReference5().getId());
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
	
	public void updateEntity7(Entity7 element) throws DaoException {
		LOG.debug("Updating Entity7");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(UPDATE_QUERY);
			// Start of user code update
			if (element.getReference5() != null) statement.setString(1, element.getReference5().getId());
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
	
	public void deleteEntity7(Entity7 element) throws DaoException {
		LOG.debug("Deleting Entity7");
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
	
	public Collection findAllEntity7s() throws DaoException {
		LOG.debug("Find all Entity7");
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
	
	public Entity7 findEntity7ById(String id) throws DaoException {
		LOG.debug("Find Entity7 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity7 result = new Entity7();
			result.setId(id);
			if (rs.next()) {
				Entity8 reference5 = new Entity8();
				reference5.setId(rs.getString(REFERENCE5));
				result.setReference5(reference5);
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
