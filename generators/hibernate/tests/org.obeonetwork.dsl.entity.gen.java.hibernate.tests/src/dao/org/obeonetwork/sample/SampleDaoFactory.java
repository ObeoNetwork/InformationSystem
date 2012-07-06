package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.kindofdao.IExempleDirectDao;
import org.obeonetwork.sample.customize.IPersonDao;
import org.obeonetwork.sample.customize.IAddressDao;
import org.obeonetwork.sample.operation.IOperationsDao;
import org.obeonetwork.sample.operation.IFindersDao;

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
     * IExempleDirectDao DAO interface.
     * @return Returns an instance of a class that implements
     * IExempleDirectDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IExempleDirectDao getExempleDirectDao() throws DaoException {

		try {
			String className = bundle.getString(IExempleDirectDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IExempleDirectDao> daoClass = 
				Class.forName(className).asSubclass(IExempleDirectDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IExempleDirectDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IExempleDirectDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IPersonDao DAO interface.
     * @return Returns an instance of a class that implements
     * IPersonDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IPersonDao getPersonDao() throws DaoException {

		try {
			String className = bundle.getString(IPersonDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IPersonDao> daoClass = 
				Class.forName(className).asSubclass(IPersonDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IPersonDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IPersonDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAddressDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAddressDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAddressDao getAddressDao() throws DaoException {

		try {
			String className = bundle.getString(IAddressDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAddressDao> daoClass = 
				Class.forName(className).asSubclass(IAddressDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAddressDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAddressDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IOperationsDao DAO interface.
     * @return Returns an instance of a class that implements
     * IOperationsDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IOperationsDao getOperationsDao() throws DaoException {

		try {
			String className = bundle.getString(IOperationsDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IOperationsDao> daoClass = 
				Class.forName(className).asSubclass(IOperationsDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IOperationsDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IOperationsDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IFindersDao DAO interface.
     * @return Returns an instance of a class that implements
     * IFindersDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IFindersDao getFindersDao() throws DaoException {

		try {
			String className = bundle.getString(IFindersDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IFindersDao> daoClass = 
				Class.forName(className).asSubclass(IFindersDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IFindersDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IFindersDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}