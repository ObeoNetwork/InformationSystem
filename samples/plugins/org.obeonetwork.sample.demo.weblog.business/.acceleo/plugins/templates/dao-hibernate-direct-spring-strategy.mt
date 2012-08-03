<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0

import org.obeonetwork.dsl.entity.gen.java.common.common
import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
import org.obeonetwork.dsl.entity.gen.java.common.javaVersion
import org.obeonetwork.dsl.entity.gen.java.services.criterionServices
import org.obeonetwork.dsl.environment.gen.java.common.logger
import org.obeonetwork.dsl.entity.gen.java.hibernate.dao-hibernate-common
import org.obeonetwork.dsl.entity.gen.java.hibernate.dao-common
import org.obeonetwork.dsl.entity.gen.java.dao.api.dao-common
import org.obeonetwork.dsl.environment.gen.java.common.datatype
import org.obeonetwork.dsl.environment.gen.java.common.common

%>

<%script type="entity.Entity" name="fullFilePath"%>
<%pathToMainJava%>/<%hibernatePackage.toPath()%>/Hibernate<%name.toStandardNotation().toU1Case()%>Dao.java

<%script  type="entity.Entity" name="generateDao" file="<%fullFilePath%>"%>
<%generateDaoSpringStrategy%>

<%script  type="entity.Entity" name="generateDaoSpringStrategy"%>
package <%hibernatePackage%>;

// <%startUserCode%> for import
import java.util.Collection;

<%loggerImport%>
<%if (ownedFinders[criterions.filter("ExternalCriterion").nSize() == 0].nSize()>0){%>import org.hibernate.Criteria;
<%}%>
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.sharengo.orm.hibernate.AbstractHibernateDAO;

<%importDaoException%>
import <%entityQualifiedName%>;
import <%daoInterfaceQualifiedName%>;

// <%endUserCode%> for import

/**
 * Implementation of DAO interface <%daoInterfaceName%> based on the hibernate
 * persistence framework.
 * @see <%daoInterfaceQualifiedName%>
 */
public class Hibernate<%name.toStandardNotation().toU1Case()%>Dao extends AbstractHibernateDAO<%toJavaVersion(name.toStandardNotation().toU1Case())%> implements I<%name.toStandardNotation().toU1Case()%>Dao {

	/**
     * The logger of this class.
     */
	<%loggerDeclaration(getClassName())%>

	/**
	 * Create a new element
	 * @param <%name.firstLower()%> Element to create.<%throwCommentDaoException("If an HibernateException occurs.")%>
     * @see <%daoInterfaceQualifiedName%>.create<%name%>
     */
	public void create<%name.toStandardNotation()%>(final <%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().firstLower()%>)<%throwDaoException%> {
		LOG.debug("Create a new <%name.toStandardNotation()%> entity");
		<%tryDaoException%>
			getHibernateTemplate().save(<%name.toStandardNotation().firstLower()%>);
			getHibernateTemplate().flush();
		<%throwsDaoException%>
	}

	/**
	 * Update an existing element
	 * @param <%name.firstLower()%>
     *            Element to update. If the element has an id,it may use it. <%throwCommentDaoException("If an HibernateException occurs.")%>
     * @see <%daoInterfaceQualifiedName%>.update<%name%>
     */
	public void update<%name.toStandardNotation()%>(<%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().firstLower()%>)<%throwDaoException%> {
		LOG.debug("Update the entity <%name%> with id =" + <%name.toStandardNotation().firstLower()%>.getId());
		<%tryDaoException%>
			getHibernateTemplate().update(<%name.toStandardNotation().firstLower()%>);
			getHibernateTemplate().flush();
		<%throwsDaoException%>
	}

	/**
	 * Delete an element
	 * Only id can be used to find which element must be deleted.
	 * @param <%name.firstLower()%> Element which will be deleted. <%throwCommentDaoException("If an HibernateException occurs.")%>
     * @see <%daoInterfaceQualifiedName%>.delete<%name%>
   	 */
	public void delete<%name.toStandardNotation()%>(<%name.toStandardNotation().toU1Case()%> <%name.toStandardNotation().firstLower()%>)<%throwDaoException%> {
		LOG.debug("Delete the entity <%name%> with id =" + <%name.toStandardNotation().firstLower()%>.getId());
		<%tryDaoException%>
			getHibernateTemplate().delete(<%name.toStandardNotation().firstLower()%>);
			getHibernateTemplate().flush();
		<%throwsDaoException%>
	}

	/**
	 * Find all elements.
	 * @return A list with all elements, without any filter. <%throwCommentDaoException("If an HibernateException occurs.")%>
     * @see <%daoInterfaceQualifiedName%>.findAll<%name%>s
     */
	public Collection<%toJavaVersion(name.toStandardNotation().toU1Case())%> findAll<%name.toStandardNotation()%>s()<%throwDaoException%> {
		LOG.debug("Find all instance of <%name%> entity");
		<%tryDaoException%>
			Collection<%toJavaVersion(name.toStandardNotation().toU1Case())%> resultList = getHibernateTemplate().loadAll(<%name.toStandardNotation().toU1Case()%>.class);
			LOG.debug("Found " + resultList.size() + " instances of <%name%> entity");
			return resultList;
		<%throwsDaoException%>
	}

	/**
	 * Find one entity by its primary key.
     * @param id The PK of the entity
	 * @return The entity found. <%throwCommentDaoException("If an HibernateException occurs.")%>
     * @see <%daoInterfaceQualifiedName%>.find<%name%>ById
     */
	public <%name.toStandardNotation().toU1Case()%> find<%name.toStandardNotation()%>ById(String id)<%throwDaoException%> {
		LOG.debug("Find one instance of <%name%> entity by id : " + id);
		<%tryDaoException%>
			return (<%name.toStandardNotation().toU1Case()%>) getHibernateTemplate().load(<%name.toStandardNotation().toU1Case()%>.class, id);
		<%throwsDaoException%>
	}
	

<%-- Generate additional methods declaration --%>
<%for (ownedFinders){%>
	/**
	 * Find all entities by the attributes <%criterions.criterionName.sep(", ")%>
	<%for (criterions){%>
	 * @param <%criterionName%> 
	<%}%>
	 * @return A collection with all matching entities.
	 */
	public Collection<%toJavaVersion(entity.toJavaType)%> <%name%>(<%criterions.parameter.sep(", ")%>)<%throwDaoException%> {		
		LOG.debug("Call <%name%> on <%entity.name%> entity");		
		<%tryDaoException%>
			Collection<%toJavaVersion(entity.name)%> resultList;
			// <%startUserCode%> for <%name%> finder
			<%if (criterions.filter("ExternalCriterion").nSize() == 0){%>
			Criteria criteria = getSession().createCriteria(<%entity.name%>.class)<%for (criterions.filter("InternalCriterion")){%>

				.add(Restrictions.eq("<%target.name%>", <%name.firstLower()%>))<%}%>;

			resultList = criteria.list();
			<%}%>			
			// <%endUserCode%> for <%name%> finder
			LOG.debug("Find " + resultList.size() + " instances of <%name%> entity");
			return resultList;
		<%throwsDaoException%>
	}
	
<%}%>
	//<%startUserCode%>
	//<%endUserCode%>
}<%"\n"%>

<%script type="Criterion" name="parameter" post="trim()"%>
<%criterionType.toJavaType%> <%criterionName.firstLower()%>

<%script type="Entity" name="getClassName"%>
Hibernate<%name.toStandardNotation().toU1Case()%>Dao