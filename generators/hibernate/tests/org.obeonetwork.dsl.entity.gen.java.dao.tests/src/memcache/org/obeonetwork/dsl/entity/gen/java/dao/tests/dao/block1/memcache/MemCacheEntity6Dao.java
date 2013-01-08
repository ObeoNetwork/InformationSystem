package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity6;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity6Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

public class MemCacheEntity6Dao implements IEntity6Dao {
	
	protected static Map entity6sCache = new Hashtable();
	
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
	
	public Collection findAllEntity6s() throws DaoException {
		Collection allList = new ArrayList();
		allList.addAll(entity6sCache.values());
		return allList;
	}
	
	public Entity6 findEntity6ById(String id) throws DaoException {
		Entity6 result = (Entity6)entity6sCache.get(id);
		return result;
	}
	
}
