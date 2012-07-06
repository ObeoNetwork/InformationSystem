package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block2.Entity2;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.api.IEntity2Dao;

// End of user code for import 

public class MemCacheEntity2Dao implements IEntity2Dao {
	
	protected static Map<String, Entity2> entity2sCache = new Hashtable<String, Entity2>();
	
	public void createEntity2(Entity2 entity) throws DaoException {
		entity2sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity2(Entity2 entity) throws DaoException {
		if (!entity2sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity2 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity2sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity2(Entity2 entity) throws DaoException {
		entity2sCache.remove(entity.getId());
	}
	
	public Collection<Entity2> findAllEntity2s() throws DaoException {
		Collection<Entity2> allList = new ArrayList<Entity2>();
		allList.addAll(entity2sCache.values());
		return allList;
	}
	
	public Entity2 findEntity2ById(String id) throws DaoException {
		Entity2 result = entity2sCache.get(id);
		return result;
	}
	
}