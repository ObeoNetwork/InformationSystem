package org.obeonetwork.sample.inheritance;

// Start of user code for import
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import org.obeonetwork.fwk.dao.exception.DaoException;
import org.obeonetwork.fwk.dao.hibernate.HibernateUtil;
import org.obeonetwork.sample.inheritance.Basic;
import org.obeonetwork.sample.inheritance.BasicWithoutAttr;
import org.obeonetwork.sample.inheritance.Root;
import org.obeonetwork.sample.inheritance.ClassA1;
import org.obeonetwork.sample.inheritance.ClassA2;
import org.obeonetwork.sample.inheritance.ClassA3;
import org.obeonetwork.sample.inheritance.Main;
import org.obeonetwork.sample.inheritance.Sub1;
import org.obeonetwork.sample.inheritance.Sub2;
import org.obeonetwork.sample.inheritance.IInheritanceDao;

// End of user code

/**
 * Implementation of DAO interface IInheritanceDao based on the hibernate
 * persistence framework.
 * @see org.obeonetwork.sample.inheritance.IInheritanceDao
 */
public class HibernateInheritanceDao implements IInheritanceDao {

	/**
     * The logger of this class.
     */
	private final static Log LOG = LogFactory.getLog(HibernateInheritanceDao.class);

	/**
	 * Create a new element
	 * @param basic Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.createBasic
     */
	public void createBasic(Basic basic) throws DaoException {
		LOG.debug("Create a new Basic entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(basic);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param basic
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.updateBasic
     */
	public void updateBasic(Basic basic) throws DaoException {
		LOG.debug("Update the entity Basic with id =" + basic.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(basic);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param basic Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.deleteBasic
   	 */
	public void deleteBasic(Basic basic) throws DaoException {
		LOG.debug("Delete the entity Basic with id =" + basic.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(basic);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.findAllBasics
     */
	public Collection<Basic> findAllBasics() throws DaoException {
		LOG.debug("Find all instance of Basic entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Basic.class);
			Collection<Basic> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Basic entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicDao.findBasicById
     */
	public Basic findBasicById(String id) throws DaoException {
		LOG.debug("Find one instance of Basic entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Basic.class)
				.add(Restrictions.eq("id", id));
			Basic result = (Basic)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param basicWithoutAttr Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.createBasicWithoutAttr
     */
	public void createBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException {
		LOG.debug("Create a new BasicWithoutAttr entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(basicWithoutAttr);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param basicWithoutAttr
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.updateBasicWithoutAttr
     */
	public void updateBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException {
		LOG.debug("Update the entity BasicWithoutAttr with id =" + basicWithoutAttr.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(basicWithoutAttr);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param basicWithoutAttr Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.deleteBasicWithoutAttr
   	 */
	public void deleteBasicWithoutAttr(BasicWithoutAttr basicWithoutAttr) throws DaoException {
		LOG.debug("Delete the entity BasicWithoutAttr with id =" + basicWithoutAttr.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(basicWithoutAttr);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.findAllBasicWithoutAttrs
     */
	public Collection<BasicWithoutAttr> findAllBasicWithoutAttrs() throws DaoException {
		LOG.debug("Find all instance of BasicWithoutAttr entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BasicWithoutAttr.class);
			Collection<BasicWithoutAttr> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of BasicWithoutAttr entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IBasicWithoutAttrDao.findBasicWithoutAttrById
     */
	public BasicWithoutAttr findBasicWithoutAttrById(String id) throws DaoException {
		LOG.debug("Find one instance of BasicWithoutAttr entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(BasicWithoutAttr.class)
				.add(Restrictions.eq("id", id));
			BasicWithoutAttr result = (BasicWithoutAttr)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param root Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IRootDao.createRoot
     */
	public void createRoot(Root root) throws DaoException {
		LOG.debug("Create a new Root entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(root);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param root
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IRootDao.updateRoot
     */
	public void updateRoot(Root root) throws DaoException {
		LOG.debug("Update the entity Root with id =" + root.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(root);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param root Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IRootDao.deleteRoot
   	 */
	public void deleteRoot(Root root) throws DaoException {
		LOG.debug("Delete the entity Root with id =" + root.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(root);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IRootDao.findAllRoots
     */
	public Collection<Root> findAllRoots() throws DaoException {
		LOG.debug("Find all instance of Root entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Root.class);
			Collection<Root> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Root entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IRootDao.findRootById
     */
	public Root findRootById(String id) throws DaoException {
		LOG.debug("Find one instance of Root entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Root.class)
				.add(Restrictions.eq("id", id));
			Root result = (Root)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classA1 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.createClassA1
     */
	public void createClassA1(ClassA1 classA1) throws DaoException {
		LOG.debug("Create a new ClassA1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classA1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classA1
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.updateClassA1
     */
	public void updateClassA1(ClassA1 classA1) throws DaoException {
		LOG.debug("Update the entity ClassA1 with id =" + classA1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classA1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classA1 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.deleteClassA1
   	 */
	public void deleteClassA1(ClassA1 classA1) throws DaoException {
		LOG.debug("Delete the entity ClassA1 with id =" + classA1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classA1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.findAllClassA1s
     */
	public Collection<ClassA1> findAllClassA1s() throws DaoException {
		LOG.debug("Find all instance of ClassA1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA1.class);
			Collection<ClassA1> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassA1 entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA1Dao.findClassA1ById
     */
	public ClassA1 findClassA1ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassA1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA1.class)
				.add(Restrictions.eq("id", id));
			ClassA1 result = (ClassA1)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classA2 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.createClassA2
     */
	public void createClassA2(ClassA2 classA2) throws DaoException {
		LOG.debug("Create a new ClassA2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classA2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classA2
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.updateClassA2
     */
	public void updateClassA2(ClassA2 classA2) throws DaoException {
		LOG.debug("Update the entity ClassA2 with id =" + classA2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classA2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classA2 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.deleteClassA2
   	 */
	public void deleteClassA2(ClassA2 classA2) throws DaoException {
		LOG.debug("Delete the entity ClassA2 with id =" + classA2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classA2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.findAllClassA2s
     */
	public Collection<ClassA2> findAllClassA2s() throws DaoException {
		LOG.debug("Find all instance of ClassA2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA2.class);
			Collection<ClassA2> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassA2 entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA2Dao.findClassA2ById
     */
	public ClassA2 findClassA2ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassA2 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA2.class)
				.add(Restrictions.eq("id", id));
			ClassA2 result = (ClassA2)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param classA3 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.createClassA3
     */
	public void createClassA3(ClassA3 classA3) throws DaoException {
		LOG.debug("Create a new ClassA3 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(classA3);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param classA3
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.updateClassA3
     */
	public void updateClassA3(ClassA3 classA3) throws DaoException {
		LOG.debug("Update the entity ClassA3 with id =" + classA3.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(classA3);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param classA3 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.deleteClassA3
   	 */
	public void deleteClassA3(ClassA3 classA3) throws DaoException {
		LOG.debug("Delete the entity ClassA3 with id =" + classA3.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(classA3);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.findAllClassA3s
     */
	public Collection<ClassA3> findAllClassA3s() throws DaoException {
		LOG.debug("Find all instance of ClassA3 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA3.class);
			Collection<ClassA3> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of ClassA3 entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IClassA3Dao.findClassA3ById
     */
	public ClassA3 findClassA3ById(String id) throws DaoException {
		LOG.debug("Find one instance of ClassA3 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(ClassA3.class)
				.add(Restrictions.eq("id", id));
			ClassA3 result = (ClassA3)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param main Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.createMain
     */
	public void createMain(Main main) throws DaoException {
		LOG.debug("Create a new Main entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(main);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param main
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.updateMain
     */
	public void updateMain(Main main) throws DaoException {
		LOG.debug("Update the entity Main with id =" + main.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(main);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param main Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.deleteMain
   	 */
	public void deleteMain(Main main) throws DaoException {
		LOG.debug("Delete the entity Main with id =" + main.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(main);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.findAllMains
     */
	public Collection<Main> findAllMains() throws DaoException {
		LOG.debug("Find all instance of Main entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Main.class);
			Collection<Main> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Main entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.IMainDao.findMainById
     */
	public Main findMainById(String id) throws DaoException {
		LOG.debug("Find one instance of Main entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Main.class)
				.add(Restrictions.eq("id", id));
			Main result = (Main)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param sub1 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.createSub1
     */
	public void createSub1(Sub1 sub1) throws DaoException {
		LOG.debug("Create a new Sub1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(sub1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param sub1
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.updateSub1
     */
	public void updateSub1(Sub1 sub1) throws DaoException {
		LOG.debug("Update the entity Sub1 with id =" + sub1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(sub1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param sub1 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.deleteSub1
   	 */
	public void deleteSub1(Sub1 sub1) throws DaoException {
		LOG.debug("Delete the entity Sub1 with id =" + sub1.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(sub1);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.findAllSub1s
     */
	public Collection<Sub1> findAllSub1s() throws DaoException {
		LOG.debug("Find all instance of Sub1 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub1.class);
			Collection<Sub1> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Sub1 entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub1Dao.findSub1ById
     */
	public Sub1 findSub1ById(String id) throws DaoException {
		LOG.debug("Find one instance of Sub1 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub1.class)
				.add(Restrictions.eq("id", id));
			Sub1 result = (Sub1)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	/**
	 * Create a new element
	 * @param sub2 Element to create.
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.createSub2
     */
	public void createSub2(Sub2 sub2) throws DaoException {
		LOG.debug("Create a new Sub2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			session.save(sub2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Update an existing element
	 * @param sub2
     *            Element to update. If the element has an id,it may use it. 
     	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.updateSub2
     */
	public void updateSub2(Sub2 sub2) throws DaoException {
		LOG.debug("Update the entity Sub2 with id =" + sub2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.update(sub2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param sub2 Element which will be deleted. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.deleteSub2
   	 */
	public void deleteSub2(Sub2 sub2) throws DaoException {
		LOG.debug("Delete the entity Sub2 with id =" + sub2.getId());
		try {
			Session session = HibernateUtil.currentSession();
			session.delete(sub2);
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.findAllSub2s
     */
	public Collection<Sub2> findAllSub2s() throws DaoException {
		LOG.debug("Find all instance of Sub2 entity");
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub2.class);
			Collection<Sub2> resultList = criteria.list();
			
			LOG.debug("Found " + resultList.size() + " instances of Sub2 entity");
			return resultList;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. 
	 	 * @throws DaoException If an HibernateException occurs.
     * @see org.obeonetwork.sample.inheritance.ISub2Dao.findSub2ById
     */
	public Sub2 findSub2ById(String id) throws DaoException {
		LOG.debug("Find one instance of Sub2 entity by id : " + id);
		try {
			Session session = HibernateUtil.currentSession();
			Criteria criteria = session.createCriteria(Sub2.class)
				.add(Restrictions.eq("id", id));
			Sub2 result = (Sub2)criteria.uniqueResult();
			
			return result;
		} catch (HibernateException e) {
			throw new DaoException(e);
		}
	}
	

	//Start of user code
	//End of user code
}

