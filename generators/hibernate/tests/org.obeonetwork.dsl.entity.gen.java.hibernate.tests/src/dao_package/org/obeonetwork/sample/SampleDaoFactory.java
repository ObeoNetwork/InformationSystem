package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.kindofdao.IKindOfDaoDao;
import org.obeonetwork.sample.customize.ICustomizeDao;
import org.obeonetwork.sample.operation.IOperationDao;


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
     * IKindOfDaoDao DAO interface.
     * @return Returns an instance of a class that implements
     * IKindOfDaoDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.kindofdao.IKindOfDaoDao getKindOfDaoKindOfDaoDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.kindofdao.IKindOfDaoDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.kindofdao.IKindOfDaoDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.kindofdao.IKindOfDaoDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.kindofdao.IKindOfDaoDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.kindofdao.IKindOfDaoDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * ICustomizeDao DAO interface.
     * @return Returns an instance of a class that implements
     * ICustomizeDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.customize.ICustomizeDao getCustomizeCustomizeDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.customize.ICustomizeDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.customize.ICustomizeDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.customize.ICustomizeDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.customize.ICustomizeDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.customize.ICustomizeDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IOperationDao DAO interface.
     * @return Returns an instance of a class that implements
     * IOperationDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.operation.IOperationDao getOperationOperationDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.operation.IOperationDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.operation.IOperationDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.operation.IOperationDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.operation.IOperationDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.operation.IOperationDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
