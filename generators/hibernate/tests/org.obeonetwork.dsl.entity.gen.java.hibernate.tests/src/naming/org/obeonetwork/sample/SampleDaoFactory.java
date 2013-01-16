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
	public static org.obeonetwork.sample.badpractives.IInterface_Dao getBadPractivesInterface_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IInterface_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IInterface_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IInterface_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IInterface_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IInterface_Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IClass_Dao getBadPractivesClass_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IClass_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IClass_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IClass_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IClass_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IClass_Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IBadNameDao getBadPractivesBadNameDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IBadNameDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IBadNameDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IBadNameDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IBadNameDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IBadNameDao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IAnothernameDao getBadPractivesAnothernameDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IAnothernameDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IAnothernameDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IAnothernameDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IAnothernameDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IAnothernameDao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao getBadPractivesEntityWithSpecialCharsDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IEntityWithSpecialCharsDao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IPublic_Dao getBadPractivesPublic_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IPublic_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IPublic_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IPublic_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IPublic_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IPublic_Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IPrivate_Dao getBadPractivesPrivate_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IPrivate_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IPrivate_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IPrivate_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IPrivate_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IPrivate_Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IProtected_Dao getBadPractivesProtected_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IProtected_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IProtected_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IProtected_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IProtected_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IProtected_Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.INull_Dao getBadPractivesNull_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.INull_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.INull_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.INull_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.INull_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.INull_Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.IMyEntityDao getBadPractivesMyEntityDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IMyEntityDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IMyEntityDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IMyEntityDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IMyEntityDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IMyEntityDao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.ITABLEDao getBadPractivesTABLEDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.ITABLEDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.ITABLEDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.ITABLEDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.ITABLEDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.ITABLEDao.class.getName(), e);
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
	public static org.obeonetwork.sample.badpractives.package_.IReturn_Dao getBadPractivesPackage_Return_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.package_.IReturn_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.package_.IReturn_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.package_.IReturn_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.package_.IReturn_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.package_.IReturn_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
