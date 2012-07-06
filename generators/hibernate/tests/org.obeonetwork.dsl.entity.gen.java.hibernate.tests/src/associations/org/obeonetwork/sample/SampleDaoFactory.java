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
	public static IClass0101Dao getClass0101Dao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101Dao> daoClass = 
				Class.forName(className).asSubclass(IClass0101Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101Dao.class.getName(), e);
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
	public static IClass0101ENDDao getClass0101ENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101ENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101ENDDao.class.getName(), e);
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
	public static IClass0101BIDao getClass0101BIDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101BIDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101BIDao.class.getName(), e);
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
	public static IClass0101BIENDDao getClass0101BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101BIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101BIENDDao.class.getName(), e);
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
	public static IClass101Dao getClass101Dao() throws DaoException {

		try {
			String className = bundle.getString(IClass101Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101Dao> daoClass = 
				Class.forName(className).asSubclass(IClass101Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101Dao.class.getName(), e);
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
	public static IClass101ENDDao getClass101ENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101ENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass101ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101ENDDao.class.getName(), e);
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
	public static IClass101BIDao getClass101BIDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101BIDao> daoClass = 
				Class.forName(className).asSubclass(IClass101BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101BIDao.class.getName(), e);
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
	public static IClass101BIENDDao getClass101BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101BIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass101BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101BIENDDao.class.getName(), e);
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
	public static IClass011Dao getClass011Dao() throws DaoException {

		try {
			String className = bundle.getString(IClass011Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011Dao> daoClass = 
				Class.forName(className).asSubclass(IClass011Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011Dao.class.getName(), e);
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
	public static IClass011ENDDao getClass011ENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011ENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass011ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011ENDDao.class.getName(), e);
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
	public static IClass011BIDao getClass011BIDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011BIDao> daoClass = 
				Class.forName(className).asSubclass(IClass011BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011BIDao.class.getName(), e);
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
	public static IClass011BIENDDao getClass011BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011BIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass011BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011BIENDDao.class.getName(), e);
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
	public static IClass11Dao getClass11Dao() throws DaoException {

		try {
			String className = bundle.getString(IClass11Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11Dao> daoClass = 
				Class.forName(className).asSubclass(IClass11Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11Dao.class.getName(), e);
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
	public static IClass11ENDDao getClass11ENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11ENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass11ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11ENDDao.class.getName(), e);
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
	public static IClass11BIDao getClass11BIDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11BIDao> daoClass = 
				Class.forName(className).asSubclass(IClass11BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11BIDao.class.getName(), e);
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
	public static IClass11BIENDDao getClass11BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11BIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass11BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11BIENDDao.class.getName(), e);
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
	public static IClass01ManyDao getClass01ManyDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyDao.class.getName(), e);
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
	public static IClass01ManyENDDao getClass01ManyENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyENDDao.class.getName(), e);
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
	public static IClass01ManyBIDao getClass01ManyBIDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyBIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyBIDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyBIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyBIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyBIDao.class.getName(), e);
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
	public static IClass01ManyBIENDDao getClass01ManyBIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyBIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyBIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyBIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyBIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyBIENDDao.class.getName(), e);
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
	public static IClassMany01Dao getClassMany01Dao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01Dao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01Dao.class.getName(), e);
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
	public static IClassMany01ENDDao getClassMany01ENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01ENDDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01ENDDao.class.getName(), e);
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
	public static IClassMany01BIDao getClassMany01BIDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01BIDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01BIDao.class.getName(), e);
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
	public static IClassMany01BIENDDao getClassMany01BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01BIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01BIENDDao.class.getName(), e);
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
	public static IClassManyManyDao getClassManyManyDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyDao.class.getName(), e);
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
	public static IClassManyManyEndDao getClassManyManyEndDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyEndDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyEndDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyEndDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyEndDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyEndDao.class.getName(), e);
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
	public static IClassManyManyBIDao getClassManyManyBIDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyBIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyBIDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyBIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyBIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyBIDao.class.getName(), e);
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
	public static IClassManyManyBIENDDao getClassManyManyBIENDDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyBIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyBIENDDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyBIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyBIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyBIENDDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}