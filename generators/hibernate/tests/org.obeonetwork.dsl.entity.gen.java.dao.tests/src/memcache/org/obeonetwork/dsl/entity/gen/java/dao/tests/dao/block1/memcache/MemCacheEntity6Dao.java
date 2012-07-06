package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block1.Entity6;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao;

// End of user code for import 

public class MemCacheEntity6Dao implements IEntity6Dao {
	
	protected static Map<String, Entity6> entity6sCache = new Hashtable<String, Entity6>();
	
	public void createEntity6(Entity6 entity) throws DaoException {
		entity6sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity6(Entity6 entity) throws DaoException {
		if (!entity6sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity6 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity6sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity6(Entity6 entity) throws DaoException {
		entity6sCache.remove(entity.getId());
	}
	
	public Collection<Entity6> findAllEntity6s() throws DaoException {
		Collection<Entity6> allList = new ArrayList<Entity6>();
		allList.addAll(entity6sCache.values());
		return allList;
	}
	
	public Entity6 findEntity6ById(String id) throws DaoException {
		Entity6 result = entity6sCache.get(id);
		return result;
	}
	
}