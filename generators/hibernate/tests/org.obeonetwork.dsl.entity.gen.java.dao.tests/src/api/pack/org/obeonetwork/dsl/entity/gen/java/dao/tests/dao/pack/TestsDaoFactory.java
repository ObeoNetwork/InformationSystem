package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.pack.exception.DaoException;


/**
 * Factory in charge of creating the appropriate instances of DAO objects by
 * using the properties in the dao.properties resource bundle.
 */
public class TestsDaoFactory {

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
    protected TestsDaoFactory() {
        // prevents subclass calls
        throw new UnsupportedOperationException();
    }


    /**
     * Factory method which provides the appropriate implementation for the
     * IBlock1Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IBlock1Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.api.IBlock1Dao getBlock1Block1Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.api.IBlock1Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.api.IBlock1Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.api.IBlock1Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.api.IBlock1Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IBlock2Dao DAO interface.
     * @return Returns an instance of a class that implements
     * IBlock2Dao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.block2.api.IBlock2Dao getBlock1Block2Block2Dao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.block2.api.IBlock2Dao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class daoClass = 
				Class.forName(className);
			return (org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.block2.api.IBlock2Dao)daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.block2.api.IBlock2Dao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.pack.block1.block2.api.IBlock2Dao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
