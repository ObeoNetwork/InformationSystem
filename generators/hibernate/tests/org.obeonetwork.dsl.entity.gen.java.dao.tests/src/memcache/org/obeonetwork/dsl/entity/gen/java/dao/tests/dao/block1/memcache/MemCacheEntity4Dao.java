package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity4;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity4Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code for import 

public class MemCacheEntity4Dao implements IEntity4Dao {
	
	protected static Map<String, Entity4> entity4sCache = new Hashtable<String, Entity4>();
	
	public void createEntity4(Entity4 entity) throws DaoException {
		entity4sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity4(Entity4 entity) throws DaoException {
		if (!entity4sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity4 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity4sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity4(Entity4 entity) throws DaoException {
		entity4sCache.remove(entity.getId());
	}
	
	public Collection<Entity4> findAllEntity4s() throws DaoException {
		Collection<Entity4> allList = new ArrayList<Entity4>();
		allList.addAll(entity4sCache.values());
		return allList;
	}
	
	public Entity4 findEntity4ById(String id) throws DaoException {
		Entity4 result = entity4sCache.get(id);
		return result;
	}
	
}