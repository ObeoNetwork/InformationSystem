<%
metamodel http://www.obeonetwork.org/dsl/entity/2.0.0

import org.obeonetwork.dsl.environment.gen.java.common.common
import org.obeonetwork.dsl.entity.gen.java.common.common
import org.obeonetwork.dsl.entity.gen.java.hibernate.dao-hibernate-common
import org.obeonetwork.dsl.entity.gen.java.spring.hibernateMappingsContext
import org.obeonetwork.dsl.environment.gen.java.common.services.StringServices
%>

<%script type="EObject" name="ORMApplicationContextRelativePath"%>
/conf/spring/orm/applicationContext.xml

<%script type="entity.Root" name="fullFilePath"%>
<%if (getProperty("linkage.strategy")=="spring"){%>
<%pathToMainResources%><%ORMApplicationContextRelativePath%>
<%}%>

<%script type="entity.Root" name="applicationContext" file="<%fullFilePath%>"%>
<%generate%>

<%script type="entity.Root" name="generate"%>
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:jee="http://www.springframework.org/schema/jee"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
           http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd
           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.0.xsd
           http://www.springframework.org/schema/jee http://www.springframework.org/schema/jee/spring-jee-2.0.xsd">
	
	<!--<%startUserCode%> for start of document -->	 

	<!-- <%endUserCode%> for start of document -->
	
	<!-- Hibernate Transaction Manager -->
	<bean id="transactionManager"
 		class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory">
			<ref bean="sessionFactory" />
		</property>
	</bean>
	
	<tx:advice id="txAdviceDAO" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="get*" propagation="SUPPORTS" read-only="true" />
			<tx:method name="*" isolation="DEFAULT" propagation="REQUIRED" read-only="false"/>
		</tx:attributes>
	</tx:advice>
	<aop:config>
		<aop:advisor pointcut="execution(* **.*Dao.*(..))" advice-ref="txAdviceDAO" />
	</aop:config>
	
	<!-- Hibernate SessionFactory -->
	<import resource="classpath:<%hibernateMappingsContextRelativeFilePath%>"/>
	<bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="mappingResources" ref="<%hibernateMappingResourcesBeanID%>"/>
		<!-- <%startUserCode%> for hibernate properties -->
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.dialect">org.hibernate.dialect.H2Dialect</prop>
				<prop key="hibernate.show_sql">true</prop>
				<prop key="hibernate.generate_statistics">true</prop>
 				<prop key="hibernate.hbm2ddl.auto">create</prop> 
 				<prop key="hibernate.jdbc.batch_size">1</prop>
			</props>
		</property>
		<!-- <%endUserCode%> for hibernate properties -->
	</bean> 
	<%generateDAOBeans%>
</beans>

<%script type="entity.Root" name="allDAOs"%>
<%eAllContents("Block")[entities.nSize() > 0]%>

<%script type="Root" name="generateDAOBeans"%>
<%for (eAllContents("Block")[entities.nSize() > 0]){%>
<%generateDAOBean%>
<%}%>

<%script type="EObject" name="DAOScope"%>
<%self().filter("Block")%>

<%script type="Block" name="DAOBeanID"%>
<%name.toClassStandardNotation().toU1Case()%>DAO

<%script type="EObject" name="generateDAOBean" post="indentTab()"%>
<%for (DAOScope){%>

<!-- <%name.toClassStandardNotation()%> -->
<bean id="<%DAOBeanID%>" 
	class="<%hibernatePackage%>.<%daoHibernateImpl%>">
	<property name="sessionFactory">
		<ref bean="sessionFactory" />
	</property>
</bean>

<!-- <%startUserCode%> for <%name%> specific configuration -->
<!-- <%endUserCode%>  for <%name%> specific configuration -->
<!-- end <%name.toClassStandardNotation()%> -->
<%}%>