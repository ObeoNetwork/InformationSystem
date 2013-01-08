package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity3;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity3Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

public class MemCacheEntity3Dao implements IEntity3Dao {
	
	protected static Map entity3sCache = new Hashtable();
	
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
	
	public Collection findAllEntity3s() throws DaoException {
		Collection allList = new ArrayList();
		allList.addAll(entity3sCache.values());
		return allList;
	}
	
	public Entity3 findEntity3ById(String id) throws DaoException {
		Entity3 result = (Entity3)entity3sCache.get(id);
		return result;
	}
	
}
