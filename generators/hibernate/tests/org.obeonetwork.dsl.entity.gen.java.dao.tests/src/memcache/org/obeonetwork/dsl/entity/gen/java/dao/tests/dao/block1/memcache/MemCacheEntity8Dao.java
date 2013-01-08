package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity8;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity8Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

public class MemCacheEntity8Dao implements IEntity8Dao {
	
	protected static Map entity8sCache = new Hashtable();
	
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
	
	public Collection findAllEntity8s() throws DaoException {
		Collection allList = new ArrayList();
		allList.addAll(entity8sCache.values());
		return allList;
	}
	
	public Entity8 findEntity8ById(String id) throws DaoException {
		Entity8 result = (Entity8)entity8sCache.get(id);
		return result;
	}
	
}
