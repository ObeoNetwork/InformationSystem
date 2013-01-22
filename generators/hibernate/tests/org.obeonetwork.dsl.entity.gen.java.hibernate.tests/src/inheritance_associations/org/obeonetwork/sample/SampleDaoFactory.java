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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101Dao getInheritanceassociationsClass0101Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao getInheritanceassociationsClass0101ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101ENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao getInheritanceassociationsClass0101BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao getInheritanceassociationsClass0101BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101Dao getInheritanceassociationsClass101Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao getInheritanceassociationsClass101ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101ENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101BIDao getInheritanceassociationsClass101BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao getInheritanceassociationsClass101BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011Dao getInheritanceassociationsClass011Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao getInheritanceassociationsClass011ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011ENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011BIDao getInheritanceassociationsClass011BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao getInheritanceassociationsClass011BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11Dao getInheritanceassociationsClass11Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao getInheritanceassociationsClass11ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11ENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11BIDao getInheritanceassociationsClass11BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao getInheritanceassociationsClass11BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao getInheritanceassociationsClass01ManyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao getInheritanceassociationsClass01ManyENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao getInheritanceassociationsClass01ManyBIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao getInheritanceassociationsClass01ManyBIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao getInheritanceassociationsClassMany01Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01Dao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao getInheritanceassociationsClassMany01ENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao getInheritanceassociationsClassMany01BIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao getInheritanceassociationsClassMany01BIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao getInheritanceassociationsClassManyManyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao getInheritanceassociationsClassManyManyEndDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao getInheritanceassociationsClassManyManyBIDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao getInheritanceassociationsClassManyManyBIENDDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao getInheritanceassociationsClass0101ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101ENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao getInheritanceassociationsClass0101BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BIENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao getInheritanceassociationsClass101EndSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101EndSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao getInheritanceassociationsClass101BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BIENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao getInheritanceassociationsClass011ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011ENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao getInheritanceassociationsClass011BiENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BiENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao getInheritanceassociationsClass11ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11ENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao getInheritanceassociationsClass11BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BIENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao getInheritanceassociationsClass01ManyENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao getInheritanceassociationsClass01ManyBIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBIENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao getInheritanceassociationsClassMany01ENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01ENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao getInheritanceassociationsClassMany01BIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BIENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao getInheritanceassociationsClassManyManyEndSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyEndSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao getInheritanceassociationsClassManyManyBIENDSubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBIENDSubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao getInheritanceassociationsClass0101SubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101SubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao getInheritanceassociationsClass0101BISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass0101BISubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101SubDao getInheritanceassociationsClass101SubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101SubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101SubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao getInheritanceassociationsClass101BISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass101BISubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011SubDao getInheritanceassociationsClass011SubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011SubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011SubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao getInheritanceassociationsClass011BISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass011BISubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11SubDao getInheritanceassociationsClass11SubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11SubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11SubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao getInheritanceassociationsClass11BISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass11BISubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao getInheritanceassociationsClass01ManySubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManySubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao getInheritanceassociationsClass01ManyBISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClass01ManyBISubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao getInheritanceassociationsClassMany01SubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01SubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao getInheritanceassociationsClassMany01BISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassMany01BISubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao getInheritanceassociationsClassManyManySubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManySubDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao getInheritanceassociationsClassManyManyBISubDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritanceassociations.IClassManyManyBISubDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
