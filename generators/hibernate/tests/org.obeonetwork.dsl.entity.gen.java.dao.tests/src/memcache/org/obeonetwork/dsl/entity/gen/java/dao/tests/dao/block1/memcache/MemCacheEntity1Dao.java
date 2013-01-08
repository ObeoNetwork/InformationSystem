package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.memcache;

// Start of user code for import
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.Entity1;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.api.IEntity1Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

public class MemCacheEntity1Dao implements IEntity1Dao {
	
	protected static Map entity1sCache = new Hashtable();
	
	public void createEntity1(Entity1 entity) throws DaoException {
		entity1sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity1(Entity1 entity) throws DaoException {
		if (!entity1sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity1 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity1sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity1(Entity1 entity) throws DaoException {
		entity1sCache.remove(entity.getId());
	}
	
	public Collection findAllEntity1s() throws DaoException {
		Collection allList = new ArrayList();
		allList.addAll(entity1sCache.values());
		return allList;
	}
	
	public Entity1 findEntity1ById(String id) throws DaoException {
		Entity1 result = (Entity1)entity1sCache.get(id);
		return result;
	}
	
}
