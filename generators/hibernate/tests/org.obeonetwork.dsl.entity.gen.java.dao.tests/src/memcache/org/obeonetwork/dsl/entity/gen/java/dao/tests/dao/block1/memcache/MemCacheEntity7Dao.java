package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity7;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity7Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

public class MemCacheEntity7Dao implements IEntity7Dao {
	
	protected static Map entity7sCache = new Hashtable();
	
	public void createEntity7(Entity7 entity) throws DaoException {
		entity7sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity7(Entity7 entity) throws DaoException {
		if (!entity7sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity7 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity7sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity7(Entity7 entity) throws DaoException {
		entity7sCache.remove(entity.getId());
	}
	
	public Collection findAllEntity7s() throws DaoException {
		Collection allList = new ArrayList();
		allList.addAll(entity7sCache.values());
		return allList;
	}
	
	public Entity7 findEntity7ById(String id) throws DaoException {
		Entity7 result = (Entity7)entity7sCache.get(id);
		return result;
	}
	
}
