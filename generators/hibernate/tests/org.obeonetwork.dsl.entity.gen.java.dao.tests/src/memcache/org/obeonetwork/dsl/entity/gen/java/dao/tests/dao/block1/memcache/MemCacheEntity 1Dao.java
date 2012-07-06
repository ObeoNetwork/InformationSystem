package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block1.Entity 1;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity 1Dao;

// End of user code for import 

public class MemCacheEntity 1Dao implements IEntity 1Dao {
	
	protected static Map<String, Entity 1> entity 1sCache = new Hashtable<String, Entity 1>();
	
	public void createEntity 1(Entity 1 entity) throws DaoException {
		entity 1sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity 1(Entity 1 entity) throws DaoException {
		if (!entity 1sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity 1 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity 1sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity 1(Entity 1 entity) throws DaoException {
		entity 1sCache.remove(entity.getId());
	}
	
	public Collection<Entity 1> findAllEntity 1s() throws DaoException {
		Collection<Entity 1> allList = new ArrayList<Entity 1>();
		allList.addAll(entity 1sCache.values());
		return allList;
	}
	
	public Entity 1 findEntity 1ById(String id) throws DaoException {
		Entity 1 result = entity 1sCache.get(id);
		return result;
	}
	
}