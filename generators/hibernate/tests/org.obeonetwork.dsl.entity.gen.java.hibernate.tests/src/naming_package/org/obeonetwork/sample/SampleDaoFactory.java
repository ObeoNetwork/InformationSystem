package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.badpractives.IBadPractivesDao;
import org.obeonetwork.sample.badpractives.package_.IPackage_Dao;


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
     * IBadPractivesDao DAO interface.
     * @return Returns an instance of a class that implements
     * IBadPractivesDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.badpractives.IBadPractivesDao getBadPractivesBadPractivesDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.IBadPractivesDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.IBadPractivesDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.IBadPractivesDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.IBadPractivesDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.IBadPractivesDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IPackage_Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IPackage_Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.sample.badpractives.package_.IPackage_Dao getBadPractivesPackage_Package_Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.badpractives.package_.IPackage_Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.badpractives.package_.IPackage_Dao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.badpractives.package_.IPackage_Dao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.badpractives.package_.IPackage_Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.badpractives.package_.IPackage_Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
