package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.IBasicDao;
import org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao;
import org.obeonetwork.sample.inheritance.IRootDao;
import org.obeonetwork.sample.inheritance.IClassA1Dao;
import org.obeonetwork.sample.inheritance.IClassA2Dao;
import org.obeonetwork.sample.inheritance.IClassA3Dao;
import org.obeonetwork.sample.inheritance.IMainDao;
import org.obeonetwork.sample.inheritance.ISub1Dao;
import org.obeonetwork.sample.inheritance.ISub2Dao;

/**
 * Factory in charge of creating the appropriate instances of DAO objects by
 * using the properties in the dao.properties resource bundle.
 */
public class SampleDaoFactory {

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
    protected SampleDaoFactory() {
        // prevents subclass calls
        throw new UnsupportedOperationException();
    }


    /**
     * Factory method which provides the appropriate implementation for the
     * IBasicDao DAO interface.
     * @return Returns an instance of a class that implements
     * IBasicDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IBasicDao getBasicDao() throws DaoException {

		try {
			String className = bundle.getString(IBasicDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IBasicDao> daoClass = 
				Class.forName(className).asSubclass(IBasicDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IBasicDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IBasicDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IBasicWithoutAttrDao DAO interface.
     * @return Returns an instance of a class that implements
     * IBasicWithoutAttrDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IBasicWithoutAttrDao getBasicWithoutAttrDao() throws DaoException {

		try {
			String className = bundle.getString(IBasicWithoutAttrDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IBasicWithoutAttrDao> daoClass = 
				Class.forName(className).asSubclass(IBasicWithoutAttrDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IBasicWithoutAttrDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IBasicWithoutAttrDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IRootDao DAO interface.
     * @return Returns an instance of a class that implements
     * IRootDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IRootDao getRootDao() throws DaoException {

		try {
			String className = bundle.getString(IRootDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IRootDao> daoClass = 
				Class.forName(className).asSubclass(IRootDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IRootDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IRootDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassA1Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassA1Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassA1Dao getClassA1Dao() throws DaoException {

		try {
			String className = bundle.getString(IClassA1Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassA1Dao> daoClass = 
				Class.forName(className).asSubclass(IClassA1Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassA1Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassA1Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassA2Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassA2Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassA2Dao getClassA2Dao() throws DaoException {

		try {
			String className = bundle.getString(IClassA2Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassA2Dao> daoClass = 
				Class.forName(className).asSubclass(IClassA2Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassA2Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassA2Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassA3Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassA3Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassA3Dao getClassA3Dao() throws DaoException {

		try {
			String className = bundle.getString(IClassA3Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassA3Dao> daoClass = 
				Class.forName(className).asSubclass(IClassA3Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassA3Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassA3Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IMainDao DAO interface.
     * @return Returns an instance of a class that implements
     * IMainDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IMainDao getMainDao() throws DaoException {

		try {
			String className = bundle.getString(IMainDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IMainDao> daoClass = 
				Class.forName(className).asSubclass(IMainDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IMainDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IMainDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * ISub1Dao DAO interface.
     * @return Returns an instance of a class that implements
     * ISub1Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static ISub1Dao getSub1Dao() throws DaoException {

		try {
			String className = bundle.getString(ISub1Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends ISub1Dao> daoClass = 
				Class.forName(className).asSubclass(ISub1Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ ISub1Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ ISub1Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * ISub2Dao DAO interface.
     * @return Returns an instance of a class that implements
     * ISub2Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static ISub2Dao getSub2Dao() throws DaoException {

		try {
			String className = bundle.getString(ISub2Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends ISub2Dao> daoClass = 
				Class.forName(className).asSubclass(ISub2Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ ISub2Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ ISub2Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}