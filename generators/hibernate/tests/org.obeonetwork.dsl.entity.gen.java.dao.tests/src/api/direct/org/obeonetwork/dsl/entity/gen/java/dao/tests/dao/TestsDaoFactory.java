package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity5Dao;


/**
 * Factory in charge of creating the appropriate instances of DAO objects by
 * using the properties in the dao.properties resource bundle.
 */
public class TestsDaoFactory {

    /**
     * Constant that represents the name of the bundle with the DAO mappings.
     */	
	private final static String FILE_DAO_MAPPING = "dao";
	
    /**
     * ResourceBundle that contains the mappings between interfaces and their
     * implementations.
     */
	private static ResourceBundle bundle = ResourceBundle.getBundle(FILE_DAO_MAPPING);

    /**
     * Protected constructor to prevent instantiation. See
     * <a href="http://checkstyle.sourceforge.net/config_design.html">this
     * CheckStyle site's page</a> for details (section DesignForExtension).
     */
    protected TestsDaoFactory() {
        // prevents subclass calls
        throw new UnsupportedOperationException();
    }


    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity1Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity1Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao getBlock1Entity1Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity4Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity4Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao getBlock1Entity4Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity6Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity6Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao getBlock1Entity6Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity7Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity7Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao getBlock1Entity7Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity8Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity8Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao getBlock1Entity8Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity2Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity2Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao getBlock1Block2Entity2Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity3Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity3Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao getBlock1Block2Entity3Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntity5Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntity5Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity5Dao getBlock1Block2Entity5Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity5Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity5Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity5Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity5Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
