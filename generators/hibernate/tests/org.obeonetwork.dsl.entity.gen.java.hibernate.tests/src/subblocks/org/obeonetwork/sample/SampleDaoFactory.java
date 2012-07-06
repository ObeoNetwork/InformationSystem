package org.obeonetwork.sample;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao;
import org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao;
import org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao;
import org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao;
import org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao;
import org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao;
import org.obeonetwork.sample.attributes.IAttributesDao;

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
     * IOnetomanycompDao DAO interface.
     * @return Returns an instance of a class that implements
     * IOnetomanycompDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IOnetomanycompDao getOnetomanycompDao() throws DaoException {

		try {
			String className = bundle.getString(IOnetomanycompDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IOnetomanycompDao> daoClass = 
				Class.forName(className).asSubclass(IOnetomanycompDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IOnetomanycompDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IOnetomanycompDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IOnetoonecompDao DAO interface.
     * @return Returns an instance of a class that implements
     * IOnetoonecompDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IOnetoonecompDao getOnetoonecompDao() throws DaoException {

		try {
			String className = bundle.getString(IOnetoonecompDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IOnetoonecompDao> daoClass = 
				Class.forName(className).asSubclass(IOnetoonecompDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IOnetoonecompDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IOnetoonecompDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssounidionetomanyDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssounidionetomanyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssounidionetomanyDao getAssounidionetomanyDao() throws DaoException {

		try {
			String className = bundle.getString(IAssounidionetomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssounidionetomanyDao> daoClass = 
				Class.forName(className).asSubclass(IAssounidionetomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssounidionetomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssounidionetomanyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssounidionetooneDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssounidionetooneDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssounidionetooneDao getAssounidionetooneDao() throws DaoException {

		try {
			String className = bundle.getString(IAssounidionetooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssounidionetooneDao> daoClass = 
				Class.forName(className).asSubclass(IAssounidionetooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssounidionetooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssounidionetooneDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssounidimanytooneDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssounidimanytooneDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssounidimanytooneDao getAssounidimanytooneDao() throws DaoException {

		try {
			String className = bundle.getString(IAssounidimanytooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssounidimanytooneDao> daoClass = 
				Class.forName(className).asSubclass(IAssounidimanytooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssounidimanytooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssounidimanytooneDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssounidimanytomanyDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssounidimanytomanyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssounidimanytomanyDao getAssounidimanytomanyDao() throws DaoException {

		try {
			String className = bundle.getString(IAssounidimanytomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssounidimanytomanyDao> daoClass = 
				Class.forName(className).asSubclass(IAssounidimanytomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssounidimanytomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssounidimanytomanyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssobidionetomanyDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssobidionetomanyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssobidionetomanyDao getAssobidionetomanyDao() throws DaoException {

		try {
			String className = bundle.getString(IAssobidionetomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssobidionetomanyDao> daoClass = 
				Class.forName(className).asSubclass(IAssobidionetomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssobidionetomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssobidionetomanyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssobidimanytomanyDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssobidimanytomanyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssobidimanytomanyDao getAssobidimanytomanyDao() throws DaoException {

		try {
			String className = bundle.getString(IAssobidimanytomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssobidimanytomanyDao> daoClass = 
				Class.forName(className).asSubclass(IAssobidimanytomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssobidimanytomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssobidimanytomanyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssobidionetooneDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssobidionetooneDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssobidionetooneDao getAssobidionetooneDao() throws DaoException {

		try {
			String className = bundle.getString(IAssobidionetooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssobidionetooneDao> daoClass = 
				Class.forName(className).asSubclass(IAssobidionetooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssobidionetooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssobidionetooneDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAssobidimanytooneDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAssobidimanytooneDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAssobidimanytooneDao getAssobidimanytooneDao() throws DaoException {

		try {
			String className = bundle.getString(IAssobidimanytooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAssobidimanytooneDao> daoClass = 
				Class.forName(className).asSubclass(IAssobidimanytooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAssobidimanytooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAssobidimanytooneDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * ITableperhierarchyDao DAO interface.
     * @return Returns an instance of a class that implements
     * ITableperhierarchyDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static ITableperhierarchyDao getTableperhierarchyDao() throws DaoException {

		try {
			String className = bundle.getString(ITableperhierarchyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends ITableperhierarchyDao> daoClass = 
				Class.forName(className).asSubclass(ITableperhierarchyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ ITableperhierarchyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ ITableperhierarchyDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * ITablepersubclassDao DAO interface.
     * @return Returns an instance of a class that implements
     * ITablepersubclassDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static ITablepersubclassDao getTablepersubclassDao() throws DaoException {

		try {
			String className = bundle.getString(ITablepersubclassDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends ITablepersubclassDao> daoClass = 
				Class.forName(className).asSubclass(ITablepersubclassDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ ITablepersubclassDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ ITablepersubclassDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}

    /**
     * Factory method which provides the appropriate implementation for the
     * IAttributesDao DAO interface.
     * @return Returns an instance of a class that implements
     * IAttributesDao as specified in the mapping bundle.
     * @throws DaoException If the declared implementation cannot be found or
     * cannot be instantiated.
     */
	public static IAttributesDao getAttributesDao() throws DaoException {

		try {
			String className = bundle.getString(IAttributesDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends IAttributesDao> daoClass = 
				Class.forName(className).asSubclass(IAttributesDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ IAttributesDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ IAttributesDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}