package org.obeonetwork.sample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

public class HibernateFilter extends OpenSessionInViewFilter {

	@Override
	protected void closeSession(Session session, SessionFactory sessionFactory) {
		session.flush();
		SessionFactoryUtils.closeSession(session);
	}


}
