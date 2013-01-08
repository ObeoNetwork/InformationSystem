package org.obeonetwork.sample.associations;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.associations.Class0101;
import org.obeonetwork.sample.associations.Class0101END;
import org.obeonetwork.sample.associations.Class0101BI;
import org.obeonetwork.sample.associations.Class0101BIEND;
import org.obeonetwork.sample.associations.Class101;
import org.obeonetwork.sample.associations.Class101END;
import org.obeonetwork.sample.associations.Class101BI;
import org.obeonetwork.sample.associations.Class101BIEND;
import org.obeonetwork.sample.associations.Class011;
import org.obeonetwork.sample.associations.Class011END;
import org.obeonetwork.sample.associations.Class011BI;
import org.obeonetwork.sample.associations.Class011BIEND;
import org.obeonetwork.sample.associations.Class11;
import org.obeonetwork.sample.associations.Class11END;
import org.obeonetwork.sample.associations.Class11BI;
import org.obeonetwork.sample.associations.Class11BIEND;
import org.obeonetwork.sample.associations.Class01Many;
import org.obeonetwork.sample.associations.Class01ManyEND;
import org.obeonetwork.sample.associations.Class01ManyBI;
import org.obeonetwork.sample.associations.Class01ManyBIEND;
import org.obeonetwork.sample.associations.ClassMany01;
import org.obeonetwork.sample.associations.ClassMany01END;
import org.obeonetwork.sample.associations.ClassMany01BI;
import org.obeonetwork.sample.associations.ClassMany01BIEND;
import org.obeonetwork.sample.associations.ClassManyMany;
import org.obeonetwork.sample.associations.ClassManyManyEnd;
import org.obeonetwork.sample.associations.ClassManyManyBI;
import org.obeonetwork.sample.associations.ClassManyManyBIEND;

// End of user code

/**
 * This class provides the data access layer to the associations entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IAssociationsDao {

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

	//Start of user code for technicals dao access api
	//End of user code
}
