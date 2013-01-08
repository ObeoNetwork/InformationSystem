package org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block2.memcache;

// Start of user code for import 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.obeonetwork.dsl.entity.gen.java.common.tests.block1.block2.Entity2;
import org.obeonetwork.dsl.entity.gen.java.dao.tests.dao.block1.block2.api.IEntity2Dao;
import org.obeonetwork.fwk.dao.exception.DaoException;

// End of user code

public class MemCacheEntity2Dao implements IEntity2Dao {
	
	protected static Map entity2sCache = new Hashtable();
	
	public void createEntity2(Entity2 entity) throws DaoException {
		entity2sCache.put(entity.getId(), entity);
	}
	
	public void updateEntity2(Entity2 entity) throws DaoException {
		if (!entity2sCache.containsKey(entity.getId())) {
			throw new DaoException("Entity2 (id : " + entity.getId() + ") to update doesn't exist.");
		}
		entity2sCache.put(entity.getId(), entity);
	}
	
	public void deleteEntity2(Entity2 entity) throws DaoException {
		entity2sCache.remove(entity.getId());
	}
	
	public Collection findAllEntity2s() throws DaoException {
		Collection allList = new ArrayList();
		allList.addAll(entity2sCache.values());
		return allList;
	}
	
	public Entity2 findEntity2ById(String id) throws DaoException {
		Entity2 result = (Entity2)entity2sCache.get(id);
		return result;
	}
	
}
