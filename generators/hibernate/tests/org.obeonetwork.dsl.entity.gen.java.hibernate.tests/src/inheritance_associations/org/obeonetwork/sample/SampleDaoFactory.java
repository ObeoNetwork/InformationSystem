package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.IClass0101Dao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101Dao;
import org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101BIDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011Dao;
import org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011BIDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11Dao;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101SubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011SubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11SubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao;
import org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao;
import org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao;

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

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101ENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101ENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass0101ENDSubDao getClass0101ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101ENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101BIENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101BIENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass0101BIENDSubDao getClass0101BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101BIENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101EndSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101EndSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass101EndSubDao getClass101EndSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101EndSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101EndSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass101EndSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101EndSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101EndSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101BIENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101BIENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass101BIENDSubDao getClass101BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass101BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101BIENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011ENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011ENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass011ENDSubDao getClass011ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass011ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011ENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011BiENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011BiENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass011BiENDSubDao getClass011BiENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011BiENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011BiENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass011BiENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011BiENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011BiENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11ENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11ENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass11ENDSubDao getClass11ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass11ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11ENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11BIENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11BIENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass11BIENDSubDao getClass11BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass11BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11BIENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass01ManyENDSubDao getClass01ManyENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyBIENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyBIENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass01ManyBIENDSubDao getClass01ManyBIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyBIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyBIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyBIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyBIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyBIENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01ENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01ENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassMany01ENDSubDao getClassMany01ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01ENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01BIENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01BIENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassMany01BIENDSubDao getClassMany01BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01BIENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyEndSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyEndSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassManyManyEndSubDao getClassManyManyEndSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyEndSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyEndSubDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyEndSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyEndSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyEndSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyBIENDSubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyBIENDSubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassManyManyBIENDSubDao getClassManyManyBIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyBIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyBIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyBIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyBIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyBIENDSubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101SubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101SubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass0101SubDao getClass0101SubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101SubDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101SubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass0101BISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass0101BISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass0101BISubDao getClass0101BISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass0101BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass0101BISubDao> daoClass = 
				Class.forName(className).asSubclass(IClass0101BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass0101BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass0101BISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101SubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101SubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass101SubDao getClass101SubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101SubDao> daoClass = 
				Class.forName(className).asSubclass(IClass101SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101SubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass101BISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass101BISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass101BISubDao getClass101BISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass101BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass101BISubDao> daoClass = 
				Class.forName(className).asSubclass(IClass101BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass101BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass101BISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011SubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011SubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass011SubDao getClass011SubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011SubDao> daoClass = 
				Class.forName(className).asSubclass(IClass011SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011SubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass011BISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass011BISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass011BISubDao getClass011BISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass011BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass011BISubDao> daoClass = 
				Class.forName(className).asSubclass(IClass011BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass011BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass011BISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11SubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11SubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass11SubDao getClass11SubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11SubDao> daoClass = 
				Class.forName(className).asSubclass(IClass11SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11SubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass11BISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass11BISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass11BISubDao getClass11BISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass11BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass11BISubDao> daoClass = 
				Class.forName(className).asSubclass(IClass11BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass11BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass11BISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManySubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManySubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass01ManySubDao getClass01ManySubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManySubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManySubDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManySubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManySubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManySubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClass01ManyBISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClass01ManyBISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClass01ManyBISubDao getClass01ManyBISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClass01ManyBISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClass01ManyBISubDao> daoClass = 
				Class.forName(className).asSubclass(IClass01ManyBISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClass01ManyBISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClass01ManyBISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01SubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01SubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassMany01SubDao getClassMany01SubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01SubDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01SubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassMany01BISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassMany01BISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassMany01BISubDao getClassMany01BISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassMany01BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassMany01BISubDao> daoClass = 
				Class.forName(className).asSubclass(IClassMany01BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassMany01BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassMany01BISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManySubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManySubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassManyManySubDao getClassManyManySubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManySubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManySubDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManySubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManySubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManySubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IClassManyManyBISubDao DAO interface.
     * @return Returns an instance of a class that implements
     * IClassManyManyBISubDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IClassManyManyBISubDao getClassManyManyBISubDao() throws DaoException {

		try {
			String className = bundle.getString(IClassManyManyBISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IClassManyManyBISubDao> daoClass = 
				Class.forName(className).asSubclass(IClassManyManyBISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IClassManyManyBISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IClassManyManyBISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}