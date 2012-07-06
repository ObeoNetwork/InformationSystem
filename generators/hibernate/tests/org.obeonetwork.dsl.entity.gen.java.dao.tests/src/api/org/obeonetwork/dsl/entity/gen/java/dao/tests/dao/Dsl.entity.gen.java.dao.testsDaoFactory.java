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
public class Dsl.entity.gen.java.dao.testsDaoFactory {

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
    protected Dsl.entity.gen.java.dao.testsDaoFactory() {
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
	public static IEntity1Dao getEntity1Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity1Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity1Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity1Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity1Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity1Dao.class.getName(), e);
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
	public static IEntity4Dao getEntity4Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity4Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity4Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity4Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity4Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity4Dao.class.getName(), e);
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
	public static IEntity6Dao getEntity6Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity6Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity6Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity6Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity6Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity6Dao.class.getName(), e);
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
	public static IEntity7Dao getEntity7Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity7Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity7Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity7Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity7Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity7Dao.class.getName(), e);
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
	public static IEntity8Dao getEntity8Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity8Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity8Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity8Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity8Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity8Dao.class.getName(), e);
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
	public static IEntity2Dao getEntity2Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity2Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity2Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity2Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity2Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity2Dao.class.getName(), e);
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
	public static IEntity3Dao getEntity3Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity3Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity3Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity3Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity3Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity3Dao.class.getName(), e);
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
	public static IEntity5Dao getEntity5Dao() throws DaoException {

		try {
			String className = bundle.getString(IEntity5Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntity5Dao> daoClass = 
				Class.forName(className).asSubclass(IEntity5Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntity5Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntity5Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}