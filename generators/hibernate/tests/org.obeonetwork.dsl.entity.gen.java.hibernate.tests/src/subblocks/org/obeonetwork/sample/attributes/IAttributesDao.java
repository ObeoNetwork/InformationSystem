package org.obeonetwork.sample.attributes;

// Start of user code for import 
import java.util.Collection;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.sample.attributes.Cardinality;
import org.obeonetwork.sample.attributes.PrimitiveType;

// End of user code for import

/**
 * This class provides the data access layer to the attributes entity class.<br/>
 * This is the interface which represent the contract of the DAO access.
 */
public interface IAttributesDao {

	/**
	 * Create a new element.
	 * @param cardinality Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createCardinality(Cardinality cardinality) throws DaoException;

	/**
	 * Update an existing element.
	 * @param cardinality Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updateCardinality(Cardinality cardinality) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param cardinality Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deleteCardinality(Cardinality cardinality) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<Cardinality> findAllCardinalitys() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Cardinality findCardinalityById(String id) throws DaoException;

	/**
	 * Create a new element.
	 * @param primitiveType Element to create.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void createPrimitiveType(PrimitiveType primitiveType) throws DaoException;

	/**
	 * Update an existing element.
	 * @param primitiveType Element to update. 
     *            If the element has an id, it may use it.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void updatePrimitiveType(PrimitiveType primitiveType) throws DaoException;

	/**
	 * Delete an element.
     * Only id can be used to find which element must be deleted.
	 * @param primitiveType Element which will be delete. 
	 * @throws DaoException If a DAO problem occurs.
	 */
	public void deletePrimitiveType(PrimitiveType primitiveType) throws DaoException;

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public Collection<PrimitiveType> findAllPrimitiveTypes() throws DaoException;

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity.
	 * @return The entity found.
	 * @throws DaoException If a DAO problem occurs.
	 */
	public PrimitiveType findPrimitiveTypeById(String id) throws DaoException;

	//Start of user code for technicals dao access api
	//End of user code for technical dao access api
}