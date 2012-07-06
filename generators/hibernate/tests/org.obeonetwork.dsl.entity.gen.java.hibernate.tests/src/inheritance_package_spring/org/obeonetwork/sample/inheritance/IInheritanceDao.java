package org.obeonetwork.sample.inheritance;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.inheritance.Basic;
import org.obeonetwork.sample.inheritance.BasicWithoutAttr;
import org.obeonetwork.sample.inheritance.Root;
import org.obeonetwork.sample.inheritance.ClassA1;
import org.obeonetwork.sample.inheritance.ClassA2;
import org.obeonetwork.sample.inheritance.ClassA3;
import org.obeonetwork.sample.inheritance.Main;
import org.obeonetwork.sample.inheritance.Sub1;
import org.obeonetwork.sample.inheritance.Sub2;

// End of user code for import

/**
 * This class provides the data access layer to the inheritance entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IInheritanceDao {

	/**
	 * Create a new element.
	 * @param basic Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createBasic(Basic basic) throws DaoException;

	/**
	 * Update an existing element.
	 * @param basic Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateBasic(Basic basic) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param basic Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteBasic(Basic basic) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Basic> findAllBasics() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Basic findBasicById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param basicWithoutAttr Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException;

	/**
	 * Update an existing element.
	 * @param basicWithoutAttr Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param basicWithoutAttr Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<BasicWithoutAttr> findAllBasicWithoutAttrs() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public BasicWithoutAttr findBasicWithoutAttrById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param root Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createRoot(Root root) throws DaoException;

	/**
	 * Update an existing element.
	 * @param root Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateRoot(Root root) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param root Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteRoot(Root root) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Root> findAllRoots() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Root findRootById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param classA1 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassA1(ClassA1 classA1) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classA1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassA1(ClassA1 classA1) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classA1 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassA1(ClassA1 classA1) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassA1> findAllClassA1s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassA1 findClassA1ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param classA2 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassA2(ClassA2 classA2) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classA2 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassA2(ClassA2 classA2) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classA2 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassA2(ClassA2 classA2) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassA2> findAllClassA2s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassA2 findClassA2ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param classA3 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createClassA3(ClassA3 classA3) throws DaoException;

	/**
	 * Update an existing element.
	 * @param classA3 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateClassA3(ClassA3 classA3) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param classA3 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteClassA3(ClassA3 classA3) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<ClassA3> findAllClassA3s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public ClassA3 findClassA3ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param main Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createMain(Main main) throws DaoException;

	/**
	 * Update an existing element.
	 * @param main Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateMain(Main main) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param main Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteMain(Main main) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Main> findAllMains() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Main findMainById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param sub1 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createSub1(Sub1 sub1) throws DaoException;

	/**
	 * Update an existing element.
	 * @param sub1 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateSub1(Sub1 sub1) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param sub1 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteSub1(Sub1 sub1) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Sub1> findAllSub1s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Sub1 findSub1ById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param sub2 Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createSub2(Sub2 sub2) throws DaoException;

	/**
	 * Update an existing element.
	 * @param sub2 Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateSub2(Sub2 sub2) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param sub2 Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteSub2(Sub2 sub2) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Sub2> findAllSub2s() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Sub2 findSub2ById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}