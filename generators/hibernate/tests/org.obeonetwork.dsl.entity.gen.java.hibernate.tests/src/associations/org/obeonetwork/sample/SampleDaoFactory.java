package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.IClass0101Dao;
import org.obeonetwork.sample.associations.IClass0101ENDDao;
import org.obeonetwork.sample.associations.IClass0101BIDao;
import org.obeonetwork.sample.associations.IClass0101BIENDDao;
import org.obeonetwork.sample.associations.IClass101Dao;
import org.obeonetwork.sample.associations.IClass101ENDDao;
import org.obeonetwork.sample.associations.IClass101BIDao;
import org.obeonetwork.sample.associations.IClass101BIENDDao;
import org.obeonetwork.sample.associations.IClass011Dao;
import org.obeonetwork.sample.associations.IClass011ENDDao;
import org.obeonetwork.sample.associations.IClass011BIDao;
import org.obeonetwork.sample.associations.IClass011BIENDDao;
import org.obeonetwork.sample.associations.IClass11Dao;
import org.obeonetwork.sample.associations.IClass11ENDDao;
import org.obeonetwork.sample.associations.IClass11BIDao;
import org.obeonetwork.sample.associations.IClass11BIENDDao;
import org.obeonetwork.sample.associations.IClass01ManyDao;
import org.obeonetwork.sample.associations.IClass01ManyENDDao;
import org.obeonetwork.sample.associations.IClass01ManyBIDao;
import org.obeonetwork.sample.associations.IClass01ManyBIENDDao;
import org.obeonetwork.sample.associations.IClassMany01Dao;
import org.obeonetwork.sample.associations.IClassMany01ENDDao;
import org.obeonetwork.sample.associations.IClassMany01BIDao;
import org.obeonetwork.sample.associations.IClassMany01BIENDDao;
import org.obeonetwork.sample.associations.IClassManyManyDao;
import org.obeonetwork.sample.associations.IClassManyManyEndDao;
import org.obeonetwork.sample.associations.IClassManyManyBIDao;
import org.obeonetwork.sample.associations.IClassManyManyBIENDDao;


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
     * IClass0101Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass0101Dao getAssociationsClass0101Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass0101Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass0101Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass0101Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass0101Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass0101Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101ENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101ENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass0101ENDDao getAssociationsClass0101ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass0101ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass0101ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass0101ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass0101ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass0101ENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101BIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101BIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass0101BIDao getAssociationsClass0101BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass0101BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass0101BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass0101BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass0101BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass0101BIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101BIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101BIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass0101BIENDDao getAssociationsClass0101BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass0101BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass0101BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass0101BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass0101BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass0101BIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass101Dao getAssociationsClass101Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass101Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass101Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass101Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass101Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass101Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101ENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101ENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass101ENDDao getAssociationsClass101ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass101ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass101ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass101ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass101ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass101ENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101BIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101BIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass101BIDao getAssociationsClass101BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass101BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass101BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass101BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass101BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass101BIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101BIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101BIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass101BIENDDao getAssociationsClass101BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass101BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass101BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass101BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass101BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass101BIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass011Dao getAssociationsClass011Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass011Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass011Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass011Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass011Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass011Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011ENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011ENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass011ENDDao getAssociationsClass011ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass011ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass011ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass011ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass011ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass011ENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011BIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011BIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass011BIDao getAssociationsClass011BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass011BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass011BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass011BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass011BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass011BIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011BIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011BIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass011BIENDDao getAssociationsClass011BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass011BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass011BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass011BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass011BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass011BIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass11Dao getAssociationsClass11Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass11Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass11Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass11Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass11Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass11Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11ENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11ENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass11ENDDao getAssociationsClass11ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass11ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass11ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass11ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass11ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass11ENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11BIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11BIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass11BIDao getAssociationsClass11BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass11BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass11BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass11BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass11BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass11BIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11BIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11BIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass11BIENDDao getAssociationsClass11BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass11BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass11BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass11BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass11BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass11BIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass01ManyDao getAssociationsClass01ManyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass01ManyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass01ManyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass01ManyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass01ManyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass01ManyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass01ManyENDDao getAssociationsClass01ManyENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass01ManyENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass01ManyENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass01ManyENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass01ManyENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass01ManyENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyBIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyBIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass01ManyBIDao getAssociationsClass01ManyBIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass01ManyBIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass01ManyBIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass01ManyBIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass01ManyBIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass01ManyBIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyBIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyBIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClass01ManyBIENDDao getAssociationsClass01ManyBIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClass01ManyBIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClass01ManyBIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClass01ManyBIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClass01ManyBIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClass01ManyBIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassMany01Dao getAssociationsClassMany01Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassMany01Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassMany01Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassMany01Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassMany01Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassMany01Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01ENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01ENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassMany01ENDDao getAssociationsClassMany01ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassMany01ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassMany01ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassMany01ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassMany01ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassMany01ENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01BIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01BIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassMany01BIDao getAssociationsClassMany01BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassMany01BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassMany01BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassMany01BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassMany01BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassMany01BIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01BIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01BIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassMany01BIENDDao getAssociationsClassMany01BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassMany01BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassMany01BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassMany01BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassMany01BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassMany01BIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassManyManyDao getAssociationsClassManyManyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassManyManyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassManyManyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassManyManyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassManyManyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassManyManyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyEndDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyEndDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassManyManyEndDao getAssociationsClassManyManyEndDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassManyManyEndDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassManyManyEndDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassManyManyEndDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassManyManyEndDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassManyManyEndDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyBIDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyBIDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassManyManyBIDao getAssociationsClassManyManyBIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassManyManyBIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassManyManyBIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassManyManyBIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassManyManyBIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassManyManyBIDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyBIENDDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyBIENDDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.associations.IClassManyManyBIENDDao getAssociationsClassManyManyBIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.associations.IClassManyManyBIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.associations.IClassManyManyBIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.associations.IClassManyManyBIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.associations.IClassManyManyBIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.associations.IClassManyManyBIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
