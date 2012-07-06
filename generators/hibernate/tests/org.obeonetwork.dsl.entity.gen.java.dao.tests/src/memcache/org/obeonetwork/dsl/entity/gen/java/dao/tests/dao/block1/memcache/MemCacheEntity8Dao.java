package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.business.block1.Entity8;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao;

// End of user code for import 

public class MemCacheEntity8Dao implements IEntity8Dao {
	
	protected static Map<String, Entity8> entity8sCache = new Hashtable<String, Entity8>();
	
	public void createEntity8(Entity8 entity) throws DaoException {
		entity8sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity8(Entity8 entity) throws DaoException {
		if (!entity8sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity8 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity8sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity8(Entity8 entity) throws DaoException {
		entity8sCache.remove(entity.getId());
	}
	
	public Collection<Entity8> findAllEntity8s() throws DaoException {
		Collection<Entity8> allList = new ArrayList<Entity8>();
		allList.addAll(entity8sCache.values());
		return allList;
	}
	
	public Entity8 findEntity8ById(String id) throws DaoException {
		Entity8 result = entity8sCache.get(id);
		return result;
	}
	
}