package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block2.Entity3;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.api.IEntity3Dao;

// End of user code for import 

public class MemCacheEntity3Dao implements IEntity3Dao {
	
	protected static Map<String, Entity3> entity3sCache = new Hashtable<String, Entity3>();
	
	public void createEntity3(Entity3 entity) throws DaoException {
		entity3sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity3(Entity3 entity) throws DaoException {
		if (!entity3sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity3 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity3sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity3(Entity3 entity) throws DaoException {
		entity3sCache.remove(entity.getId());
	}
	
	public Collection<Entity3> findAllEntity3s() throws DaoException {
		Collection<Entity3> allList = new ArrayList<Entity3>();
		allList.addAll(entity3sCache.values());
		return allList;
	}
	
	public Entity3 findEntity3ById(String id) throws DaoException {
		Entity3 result = entity3sCache.get(id);
		return result;
	}
	
}