package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.jdbc;

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
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block2.Entity5;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block1.Entity6;

import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.api.IEntity5Dao;

// End of user code for import 

/**
 * This class provides the data access layer to the Entity5 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity5Dao implements IEntity5Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity5Dao.class);;


	protected final static String TABLE_NAME = "ENTITY5";

	protected final static String REFERENCE2 = "FK_ENTITY6_REFERENCE2_ID";
	
	// Start of user code specifics queries
	protected static final String CREATE_QUERY = 
		"INSERT INTO " + TABLE_NAME + 
		" (ID, FK_ENTITY6_REFERENCE2_ID) VALUES (?, ?)";
		
	protected static final String UPDATE_QUERY = 
		"UPDATE " + TABLE_NAME + 
		" SET  FK_ENTITY6_REFERENCE2_ID = ?" +
		" WHERE ID = ?";
	
	protected static final String DELETE_QUERY = 
		"DELETE FROM " + TABLE_NAME + 
		" WHERE ID = ?";
		
	protected static final String FIND_ALL_QUERY = 
		"SELECT * FROM " + TABLE_NAME;
		
	protected static final String FIND_BY_ID = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE ID = ?";
		
	protected static final String FIND_BY_REFERENCE2 = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE FK_ENTITY6_REFERENCE2_ID = ?";
		
	
	
	// End of user code

	protected Collection<Entity5> createList(ResultSet rs) throws DaoException {
		Collection<Entity5> result = new ArrayList<Entity5>();
		Entity5 entity5 = null;
		while (rs.next()) {
			entity5 = new Entity5();
			entity5.setId(rs.getString("ID"));

			Entity6 reference2 = new Entity6();
			reference2.setId( rs.getString(REFERENCE2) );
			entity5.setReference2( reference2 );

			result.add(entity5);
		}
		return result;
	}

	public void createEntity5(Entity5 element) throws DaoException {
		LOG.debug("Creating Entity5");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(CREATE_QUERY);
			element.setId(UUID.randomUUID().toString());
			statement.setString(1, element.getId());
			// Start of user code create
			if (element.getReference2() != null) statement.setString(2, element.getReference2().getId());
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
	
	public void updateEntity5(Entity5 element) throws DaoException {
		LOG.debug("Updating Entity5");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(UPDATE_QUERY);
			// Start of user code update
			if (element.getReference2() != null) statement.setString(1, element.getReference2().getId());
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
	
	public void deleteEntity5(Entity5 element) throws DaoException {
		LOG.debug("Deleting Entity5");
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
	
	public Collection<Entity5> findAllEntity5s() throws DaoException {
		LOG.debug("Find all Entity5");
		Connection cnx = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.createStatement();
			rs = statement.executeQuery(FIND_ALL_QUERY);

			Collection<Entity5> result = createList(rs);
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
	
	public Entity5 findEntity5ById(String id) throws DaoException {
		LOG.debug("Find Entity5 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = Dsl.entity.gen.java.dao.testsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity5 result = new Entity5();
			result.setId(id);
			if (rs.next()) {
				Entity6 reference2 = new Entity6();
				reference2.setId(rs.getString(REFERENCE2));
				result.setReference2(reference2);
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