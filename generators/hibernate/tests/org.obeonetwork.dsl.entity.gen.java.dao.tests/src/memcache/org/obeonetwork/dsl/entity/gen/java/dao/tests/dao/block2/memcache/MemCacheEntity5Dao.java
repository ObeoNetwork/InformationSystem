package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block2.Entity5;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.api.IEntity5Dao;

// End of user code for import 

public class MemCacheEntity5Dao implements IEntity5Dao {
	
	protected static Map<String, Entity5> entity5sCache = new Hashtable<String, Entity5>();
	
	public void createEntity5(Entity5 entity) throws DaoException {
		entity5sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity5(Entity5 entity) throws DaoException {
		if (!entity5sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity5 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity5sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity5(Entity5 entity) throws DaoException {
		entity5sCache.remove(entity.getId());
	}
	
	public Collection<Entity5> findAllEntity5s() throws DaoException {
		Collection<Entity5> allList = new ArrayList<Entity5>();
		allList.addAll(entity5sCache.values());
		return allList;
	}
	
	public Entity5 findEntity5ById(String id) throws DaoException {
		Entity5 result = entity5sCache.get(id);
		return result;
	}
	
}