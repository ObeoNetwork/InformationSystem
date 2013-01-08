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
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity2;
import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity3;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.fwk.dao.jdbc.TestsConnectionUtils;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

/**
 * This class provides the data access layer to the Entity2 entity class.
 * This is the JDBC implementation.
 */
public class JdbcEntity2Dao implements IEntity2Dao {
    /**
     * Commons Logging instance.
     */
	private final static Log LOG = LogFactory.getLog(JdbcEntity2Dao.class);


	protected final static String TABLE_NAME = "ENTITY2";

	protected final static String ATTRIBUTE8 = "ATTRIBUTE8";
	protected final static String REFERENCE1 = "FK_ENTITY3_REFERENCE1_ID";
	
	// Start of user code specifics queries
	protected static final String CREATE_QUERY = 
		"INSERT INTO " + TABLE_NAME + 
		" (ID, ATTRIBUTE8, FK_ENTITY3_REFERENCE1_ID) VALUES (?, ?, ?)";
		
	protected static final String UPDATE_QUERY = 
		"UPDATE " + TABLE_NAME + 
		" SET  ATTRIBUTE8 = ?, FK_ENTITY3_REFERENCE1_ID = ?" +
		" WHERE ID = ?";
	
	protected static final String DELETE_QUERY = 
		"DELETE FROM " + TABLE_NAME + 
		" WHERE ID = ?";
		
	protected static final String FIND_ALL_QUERY = 
		"SELECT * FROM " + TABLE_NAME;
		
	protected static final String FIND_BY_ID = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE ID = ?";
		
	protected static final String FIND_BY_ATTRIBUTE8 = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE ATTRIBUTE8 = ?";
		
	protected static final String FIND_BY_REFERENCE1 = 
		"SELECT * FROM " + TABLE_NAME +
		" WHERE FK_ENTITY3_REFERENCE1_ID = ?";
		
	
	
	// End of user code

	protected Collection createList(ResultSet rs) throws DaoException {
		Collection result = new ArrayList();
		Entity2 entity2 = null;
		while (rs.next()) {
			entity2 = new Entity2();
			entity2.setId(rs.getString("ID"));
			entity2.setAttribute8( rs.getString(ATTRIBUTE8) );

			Entity3 reference1 = new Entity3();
			reference1.setId( rs.getString(REFERENCE1) );
			entity2.setReference1( reference1 );

			result.add(entity2);
		}
		return result;
	}

	public void createEntity2(Entity2 element) throws DaoException {
		LOG.debug("Creating Entity2");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(CREATE_QUERY);
			element.setId(UUID.randomUUID().toString());
			statement.setString(1, element.getId());
			// Start of user code create
			statement.setString(2, element.getAttribute8());
			if (element.getReference1() != null) statement.setString(3, element.getReference1().getId());
			else statement.setString(3, null);
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
	
	public void updateEntity2(Entity2 element) throws DaoException {
		LOG.debug("Updating Entity2");
		Connection cnx = null;
		PreparedStatement statement = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(UPDATE_QUERY);
			// Start of user code update
			statement.setString(1, element.getAttribute8());
			if (element.getReference1() != null) statement.setString(2, element.getReference1().getId());
			else statement.setString(2, null);
			// End of user code
			statement.setString(3,element.getId());
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
	
	public void deleteEntity2(Entity2 element) throws DaoException {
		LOG.debug("Deleting Entity2");
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
	
	public Collection findAllEntity2s() throws DaoException {
		LOG.debug("Find all Entity2");
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
	
	public Entity2 findEntity2ById(String id) throws DaoException {
		LOG.debug("Find Entity2 by Id");
		Connection cnx = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			cnx = TestsConnectionUtils.getInstance().getConnection();
			statement = cnx.prepareStatement(FIND_BY_ID);
			statement.setString(1,id);			
			rs = statement.executeQuery();
			Entity2 result = new Entity2();
			result.setId(id);
			if (rs.next()) {
				result.setAttribute8( rs.getString(ATTRIBUTE8) );
				Entity3 reference1 = new Entity3();
				reference1.setId(rs.getString(REFERENCE1));
				result.setReference1(reference1);
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
