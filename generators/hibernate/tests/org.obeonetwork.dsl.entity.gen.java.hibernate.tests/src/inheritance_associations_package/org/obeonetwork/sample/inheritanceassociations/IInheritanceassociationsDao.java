package org.obeonetwork.sample.inheritanceassociations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritanceassociations.Class0101;
import org.obeonetwork.sample.inheritanceassociations.Class0101END;
import org.obeonetwork.sample.inheritanceassociations.Class0101BI;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class101;
import org.obeonetwork.sample.inheritanceassociations.Class101END;
import org.obeonetwork.sample.inheritanceassociations.Class101BI;
import org.obeonetwork.sample.inheritanceassociations.Class101BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class011;
import org.obeonetwork.sample.inheritanceassociations.Class011END;
import org.obeonetwork.sample.inheritanceassociations.Class011BI;
import org.obeonetwork.sample.inheritanceassociations.Class011BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class11;
import org.obeonetwork.sample.inheritanceassociations.Class11END;
import org.obeonetwork.sample.inheritanceassociations.Class11BI;
import org.obeonetwork.sample.inheritanceassociations.Class11BIEND;
import org.obeonetwork.sample.inheritanceassociations.Class01Many;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyEND;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBI;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01END;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BI;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIEND;
import org.obeonetwork.sample.inheritanceassociations.ClassManyMany;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEnd;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBI;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIEND;
import org.obeonetwork.sample.inheritanceassociations.Class0101ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class0101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class101EndSub;
import org.obeonetwork.sample.inheritanceassociations.Class101BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class011ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class011BiENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11ENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class11BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01ENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BIENDSub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyEndSub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBIENDSub;
import org.obeonetwork.sample.inheritanceassociations.Class0101Sub;
import org.obeonetwork.sample.inheritanceassociations.Class0101BISub;
import org.obeonetwork.sample.inheritanceassociations.Class101Sub;
import org.obeonetwork.sample.inheritanceassociations.Class101BISub;
import org.obeonetwork.sample.inheritanceassociations.Class011Sub;
import org.obeonetwork.sample.inheritanceassociations.Class011BISub;
import org.obeonetwork.sample.inheritanceassociations.Class11Sub;
import org.obeonetwork.sample.inheritanceassociations.Class11BISub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManySub;
import org.obeonetwork.sample.inheritanceassociations.Class01ManyBISub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01Sub;
import org.obeonetwork.sample.inheritanceassociations.ClassMany01BISub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManySub;
import org.obeonetwork.sample.inheritanceassociations.ClassManyManyBISub;

// End of user code for import

/**
 * This class provides the data access layer to the inheritance_associations entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IInheritanceassociationsDao {

	/**
	 * Create a new element.
	 * @param class_01_01 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101(Class0101 class0101) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101(Class0101 class0101) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101(Class0101 class0101) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101> findAllClass0101s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101 findClass0101ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101END(Class0101END class0101END) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101END(Class0101END class0101END) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101END(Class0101END class0101END) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101END> findAllClass0101ENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101END findClass0101ENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101BI(Class0101BI class0101BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101BI(Class0101BI class0101BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101BI(Class0101BI class0101BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101BI> findAllClass0101BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101BI findClass0101BIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101BIEND(Class0101BIEND class0101BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101BIEND> findAllClass0101BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101BIEND findClass0101BIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101(Class101 class101) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101(Class101 class101) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101(Class101 class101) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101> findAllClass101s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101 findClass101ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101END(Class101END class101END) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101END(Class101END class101END) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101END(Class101END class101END) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101END> findAllClass101ENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101END findClass101ENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101BI(Class101BI class101BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101BI(Class101BI class101BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101BI(Class101BI class101BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101BI> findAllClass101BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101BI findClass101BIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101BIEND(Class101BIEND class101BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101BIEND(Class101BIEND class101BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101BIEND(Class101BIEND class101BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101BIEND> findAllClass101BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101BIEND findClass101BIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011(Class011 class011) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011(Class011 class011) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011(Class011 class011) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011> findAllClass011s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011 findClass011ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011END(Class011END class011END) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011END(Class011END class011END) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011END(Class011END class011END) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011END> findAllClass011ENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011END findClass011ENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011BI(Class011BI class011BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011BI(Class011BI class011BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011BI(Class011BI class011BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011BI> findAllClass011BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011BI findClass011BIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011BIEND(Class011BIEND class011BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011BIEND(Class011BIEND class011BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011BIEND(Class011BIEND class011BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011BIEND> findAllClass011BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011BIEND findClass011BIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11(Class11 class11) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11(Class11 class11) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11(Class11 class11) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11> findAllClass11s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11 findClass11ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11END(Class11END class11END) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11END(Class11END class11END) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11END(Class11END class11END) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11END> findAllClass11ENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11END findClass11ENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11BI(Class11BI class11BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11BI(Class11BI class11BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11BI(Class11BI class11BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11BI> findAllClass11BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11BI findClass11BIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11BIEND(Class11BIEND class11BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11BIEND(Class11BIEND class11BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11BIEND(Class11BIEND class11BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11BIEND> findAllClass11BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11BIEND findClass11BIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01Many(Class01Many class01Many) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01Many(Class01Many class01Many) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01Many(Class01Many class01Many) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01Many> findAllClass01Manys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01Many findClass01ManyById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManyEND(Class01ManyEND class01ManyEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManyEND> findAllClass01ManyENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManyEND findClass01ManyENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManyBI(Class01ManyBI class01ManyBI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManyBI> findAllClass01ManyBIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManyBI findClass01ManyBIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManyBIEND(Class01ManyBIEND class01ManyBIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManyBIEND> findAllClass01ManyBIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManyBIEND findClass01ManyBIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01(ClassMany01 classMany01) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01(ClassMany01 classMany01) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01(ClassMany01 classMany01) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01> findAllClassMany01s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01 findClassMany01ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01END(ClassMany01END classMany01END) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01END(ClassMany01END classMany01END) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01END(ClassMany01END classMany01END) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01END> findAllClassMany01ENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01END findClassMany01ENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01BI(ClassMany01BI classMany01BI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01BI(ClassMany01BI classMany01BI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01BI(ClassMany01BI classMany01BI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01BI> findAllClassMany01BIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01BI findClassMany01BIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01BIEND(ClassMany01BIEND classMany01BIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01BIEND> findAllClassMany01BIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01BIEND findClassMany01BIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyMany(ClassManyMany classManyMany) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyMany(ClassManyMany classManyMany) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyMany(ClassManyMany classManyMany) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyMany> findAllClassManyManys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyMany findClassManyManyById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_End Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_End Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_End Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManyEnd(ClassManyManyEnd classManyManyEnd) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManyEnd> findAllClassManyManyEnds() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManyEnd findClassManyManyEndById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_BI Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_BI Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManyBI(ClassManyManyBI classManyManyBI) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManyBI> findAllClassManyManyBIs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManyBI findClassManyManyBIById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_BI_END Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_BI_END Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI_END Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManyBIEND(ClassManyManyBIEND classManyManyBIEND) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManyBIEND> findAllClassManyManyBIENDs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManyBIEND findClassManyManyBIENDById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101ENDSub(Class0101ENDSub class0101ENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101ENDSub> findAllClass0101ENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101ENDSub findClass0101ENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_BI_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_BI_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101BIENDSub(Class0101BIENDSub class0101BIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101BIENDSub> findAllClass0101BIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101BIENDSub findClass0101BIENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_End_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101EndSub(Class101EndSub class101EndSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_End_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101EndSub(Class101EndSub class101EndSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_End_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101EndSub(Class101EndSub class101EndSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101EndSub> findAllClass101EndSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101EndSub findClass101EndSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_BI_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_BI_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_BI_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101BIENDSub(Class101BIENDSub class101BIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101BIENDSub> findAllClass101BIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101BIENDSub findClass101BIENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011ENDSub(Class011ENDSub class011ENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011ENDSub> findAllClass011ENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011ENDSub findClass011ENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_Bi_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_Bi_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_Bi_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011BiENDSub(Class011BiENDSub class011BiENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011BiENDSub> findAllClass011BiENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011BiENDSub findClass011BiENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11ENDSub(Class11ENDSub class11ENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11ENDSub> findAllClass11ENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11ENDSub findClass11ENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_BI_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_BI_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11BIENDSub(Class11BIENDSub class11BIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11BIENDSub> findAllClass11BIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11BIENDSub findClass11BIENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManyENDSub(Class01ManyENDSub class01ManyENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManyENDSub> findAllClass01ManyENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManyENDSub findClass01ManyENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_BI_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_BI_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManyBIENDSub(Class01ManyBIENDSub class01ManyBIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManyBIENDSub> findAllClass01ManyBIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManyBIENDSub findClass01ManyBIENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01ENDSub(ClassMany01ENDSub classMany01ENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01ENDSub> findAllClassMany01ENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01ENDSub findClassMany01ENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_BI_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_BI_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01BIENDSub(ClassMany01BIENDSub classMany01BIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01BIENDSub> findAllClassMany01BIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01BIENDSub findClassMany01BIENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_End_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_End_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_End_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManyEndSub(ClassManyManyEndSub classManyManyEndSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManyEndSub> findAllClassManyManyEndSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManyEndSub findClassManyManyEndSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_BI_END_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_BI_END_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI_END_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManyBIENDSub(ClassManyManyBIENDSub classManyManyBIENDSub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManyBIENDSub> findAllClassManyManyBIENDSubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManyBIENDSub findClassManyManyBIENDSubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101Sub(Class0101Sub class0101Sub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101Sub(Class0101Sub class0101Sub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101Sub(Class0101Sub class0101Sub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101Sub> findAllClass0101Subs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101Sub findClass0101SubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_01_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass0101BISub(Class0101BISub class0101BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_01_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass0101BISub(Class0101BISub class0101BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_01_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass0101BISub(Class0101BISub class0101BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class0101BISub> findAllClass0101BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class0101BISub findClass0101BISubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101Sub(Class101Sub class101Sub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101Sub(Class101Sub class101Sub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101Sub(Class101Sub class101Sub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101Sub> findAllClass101Subs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101Sub findClass101SubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_01_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass101BISub(Class101BISub class101BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_01_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass101BISub(Class101BISub class101BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_01_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass101BISub(Class101BISub class101BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class101BISub> findAllClass101BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class101BISub findClass101BISubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011Sub(Class011Sub class011Sub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011Sub(Class011Sub class011Sub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011Sub(Class011Sub class011Sub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011Sub> findAllClass011Subs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011Sub findClass011SubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_1_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass011BISub(Class011BISub class011BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_1_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass011BISub(Class011BISub class011BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_1_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass011BISub(Class011BISub class011BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class011BISub> findAllClass011BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class011BISub findClass011BISubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11Sub(Class11Sub class11Sub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11Sub(Class11Sub class11Sub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11Sub(Class11Sub class11Sub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11Sub> findAllClass11Subs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11Sub findClass11SubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_1_1_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass11BISub(Class11BISub class11BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_1_1_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass11BISub(Class11BISub class11BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_1_1_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass11BISub(Class11BISub class11BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class11BISub> findAllClass11BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class11BISub findClass11BISubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManySub(Class01ManySub class01ManySub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManySub(Class01ManySub class01ManySub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManySub(Class01ManySub class01ManySub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManySub> findAllClass01ManySubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManySub findClass01ManySubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_01_Many_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_01_Many_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_01_Many_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClass01ManyBISub(Class01ManyBISub class01ManyBISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Class01ManyBISub> findAllClass01ManyBISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Class01ManyBISub findClass01ManyBISubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01Sub(ClassMany01Sub classMany01Sub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01Sub> findAllClassMany01Subs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01Sub findClassMany01SubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_01_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_01_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_01_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassMany01BISub(ClassMany01BISub classMany01BISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassMany01BISub> findAllClassMany01BISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassMany01BISub findClassMany01BISubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManySub(ClassManyManySub classManyManySub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManySub(ClassManyManySub classManyManySub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManySub(ClassManyManySub classManyManySub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManySub> findAllClassManyManySubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManySub findClassManyManySubById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param class_Many_Many_BI_Sub Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException;

	/**
	 * Update an existing element.
	 * @param class_Many_Many_BI_Sub Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param class_Many_Many_BI_Sub Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassManyManyBISub(ClassManyManyBISub classManyManyBISub) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassManyManyBISub> findAllClassManyManyBISubs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassManyManyBISub findClassManyManyBISubById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}