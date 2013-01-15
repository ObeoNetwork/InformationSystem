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
	public static org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao getCollectionsCompositionOnetomanycompOnetomanycompDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.composition.onetomanycomp.IOnetomanycompDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao getCollectionsCompositionOnetoonecompOnetoonecompDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.composition.onetoonecomp.IOnetoonecompDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao getCollectionsAssociationsUnidirectionalAssounidionetomanyAssounidionetomanyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidionetomany.IAssounidionetomanyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao getCollectionsAssociationsUnidirectionalAssounidionetooneAssounidionetooneDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidionetoone.IAssounidionetooneDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao getCollectionsAssociationsUnidirectionalAssounidimanytooneAssounidimanytooneDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytoone.IAssounidimanytooneDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao getCollectionsAssociationsUnidirectionalAssounidimanytomanyAssounidimanytomanyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.unidirectional.assounidimanytomany.IAssounidimanytomanyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao getCollectionsAssociationsBidirectionalAssobidionetomanyAssobidionetomanyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidionetomany.IAssobidionetomanyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao getCollectionsAssociationsBidirectionalAssobidimanytomanyAssobidimanytomanyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytomany.IAssobidimanytomanyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao getCollectionsAssociationsBidirectionalAssobidionetooneAssobidionetooneDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidionetoone.IAssobidionetooneDao.class.getName(), e);
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
	public static org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao getCollectionsAssociationsBidirectionalAssobidimanytooneAssobidimanytooneDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.collections.associations.bidirectional.assobidimanytoone.IAssobidimanytooneDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao getInheritenceTableperhierarchyTableperhierarchyDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritence.tableperhierarchy.ITableperhierarchyDao.class.getName(), e);
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
	public static org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao getInheritenceTablepersubclassTablepersubclassDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.inheritence.tablepersubclass.ITablepersubclassDao.class.getName(), e);
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
	public static org.obeonetwork.sample.attributes.IAttributesDao getAttributesAttributesDao() throws DaoException {

		try {
			String className = bundle.getString(org.obeonetwork.sample.attributes.IAttributesDao.class.getName());

			// Cast and instanciate with JDK 1.5 control
			Class<? extends org.obeonetwork.sample.attributes.IAttributesDao> daoClass = 
				Class.forName(className).asSubclass(org.obeonetwork.sample.attributes.IAttributesDao.class);
			return daoClass.newInstance();

		} catch (MissingResourceException e) {
			throw new DaoException("Key " 
				+ org.obeonetwork.sample.attributes.IAttributesDao.class.getName()
				+ " not found in " + FILE_DAO_MAPPING + ".properties", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("DAO implementation not found for "
				+ org.obeonetwork.sample.attributes.IAttributesDao.class.getName(), e);
		} catch (InstantiationException e) {
			throw new DaoException(e);
		} catch (IllegalAccessException e) {
			throw new DaoException(e);
		}
		
	}
}
