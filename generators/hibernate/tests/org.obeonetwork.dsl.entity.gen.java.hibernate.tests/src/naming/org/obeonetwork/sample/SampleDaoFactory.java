package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.IInterface_Dao;
import org.obeonetwork.sample.badpractives.IClass_Dao;
import org.obeonetwork.sample.badpractives.IBadNameDao;
import org.obeonetwork.sample.badpractives.IAnothernameDao;
import org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao;
import org.obeonetwork.sample.badpractives.IPublic_Dao;
import org.obeonetwork.sample.badpractives.IPrivate_Dao;
import org.obeonetwork.sample.badpractives.IProtected_Dao;
import org.obeonetwork.sample.badpractives.INull_Dao;
import org.obeonetwork.sample.badpractives.IMyEntityDao;
import org.obeonetwork.sample.badpractives.ITABLEDao;
import org.obeonetwork.sample.badpractives.package_.IReturn_Dao;

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
     * IInterface_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IInterface_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IInterface_Dao getInterface_Dao() throws DaoException {

		try {
			String className = bundle.getString(IInterface_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IInterface_Dao> daoClass = 
				Class.forName(className).asSubclass(IInterface_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IInterface_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IInterface_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass_Dao getClass_Dao() throws DaoException {

		try {
			String className = bundle.getString(IClass_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass_Dao> daoClass = 
				Class.forName(className).asSubclass(IClass_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IBadNameDao DAO interface.
     * @return Returns an instance of a class that implements
     * IBadNameDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IBadNameDao getBadNameDao() throws DaoException {

		try {
			String className = bundle.getString(IBadNameDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IBadNameDao> daoClass = 
				Class.forName(className).asSubclass(IBadNameDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IBadNameDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IBadNameDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAnothernameDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAnothernameDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAnothernameDao getAnothernameDao() throws DaoException {

		try {
			String className = bundle.getString(IAnothernameDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAnothernameDao> daoClass = 
				Class.forName(className).asSubclass(IAnothernameDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAnothernameDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAnothernameDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IEntityWithSpecialCharsDao DAO interface.
     * @return Returns an instance of a class that implements
     * IEntityWithSpecialCharsDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IEntityWithSpecialCharsDao getEntityWithSpecialCharsDao() throws DaoException {

		try {
			String className = bundle.getString(IEntityWithSpecialCharsDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IEntityWithSpecialCharsDao> daoClass = 
				Class.forName(className).asSubclass(IEntityWithSpecialCharsDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IEntityWithSpecialCharsDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IEntityWithSpecialCharsDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IPublic_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IPublic_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IPublic_Dao getPublic_Dao() throws DaoException {

		try {
			String className = bundle.getString(IPublic_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IPublic_Dao> daoClass = 
				Class.forName(className).asSubclass(IPublic_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IPublic_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IPublic_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IPrivate_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IPrivate_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IPrivate_Dao getPrivate_Dao() throws DaoException {

		try {
			String className = bundle.getString(IPrivate_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IPrivate_Dao> daoClass = 
				Class.forName(className).asSubclass(IPrivate_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IPrivate_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IPrivate_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IProtected_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IProtected_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IProtected_Dao getProtected_Dao() throws DaoException {

		try {
			String className = bundle.getString(IProtected_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IProtected_Dao> daoClass = 
				Class.forName(className).asSubclass(IProtected_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IProtected_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IProtected_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * INull_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * INull_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static INull_Dao getNull_Dao() throws DaoException {

		try {
			String className = bundle.getString(INull_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends INull_Dao> daoClass = 
				Class.forName(className).asSubclass(INull_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ INull_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ INull_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IMyEntityDao DAO interface.
     * @return Returns an instance of a class that implements
     * IMyEntityDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IMyEntityDao getMyEntityDao() throws DaoException {

		try {
			String className = bundle.getString(IMyEntityDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IMyEntityDao> daoClass = 
				Class.forName(className).asSubclass(IMyEntityDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IMyEntityDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IMyEntityDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * ITABLEDao DAO interface.
     * @return Returns an instance of a class that implements
     * ITABLEDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static ITABLEDao getTABLEDao() throws DaoException {

		try {
			String className = bundle.getString(ITABLEDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends ITABLEDao> daoClass = 
				Class.forName(className).asSubclass(ITABLEDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ ITABLEDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ ITABLEDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IReturn_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IReturn_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IReturn_Dao getReturn_Dao() throws DaoException {

		try {
			String className = bundle.getString(IReturn_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IReturn_Dao> daoClass = 
				Class.forName(className).asSubclass(IReturn_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IReturn_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IReturn_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}