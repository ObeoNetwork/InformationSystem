/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.TxRunnable;

import models.*;
import play.Logger;
import play.db.ebean.Model.Finder;

public class OfficeServices {

	private static Finder<Long,Office> find = new Finder(Long.class, Office.class);

	public static Office getById(Long id) { 
		return find.byId(id);
	}

	public static List<Office> rows(int rowId, int nbElemByRow) {
		Logger.debug("OfficeServices rows : "+find.all().size());
		Page<Office> offices = find.where().findPagingList(nbElemByRow).getPage(rowId);
		return offices.getList(); 
	}

	public static int count() { 
		int size = find.all().size();
		return size; 
	}

	public static List<Office> all() { 
		return find.all(); 
	}

	public static List<Proxy> allProxies() { 
		List<Proxy> proxies = new ArrayList<Proxy>();
		List<Office> offices = find.all();
		for(Office office: offices) {
			proxies.add(office.toProxy());
		}
		return proxies; 
	}

	public static List<Stat> stats() {
		List<Stat> stats = new ArrayList<Stat>();

		stats.add(new Stat(14L,"January"));
		stats.add(new Stat(11L,"February"));
		stats.add(new Stat(30L,"March"));
		stats.add(new Stat(20L,"April"));
		stats.add(new Stat(24L,"May"));
		stats.add(new Stat(12L,"June"));
		stats.add(new Stat(2L,"July"));
		stats.add(new Stat(4L,"August"));
		stats.add(new Stat(50L,"September"));
		stats.add(new Stat(20L,"October"));
		stats.add(new Stat(7L,"November"));
		stats.add(new Stat(10L,"December"));

		return stats;
	}

	public static List<Office> getByIds(List<Long> ids) { 

		StringBuffer strIds = new StringBuffer();
		Iterator<Long> IterIds = ids.iterator();

		strIds.append("(");
		while(IterIds.hasNext()) {
			Long id = IterIds.next();
			strIds.append(id);
			if(IterIds.hasNext())
				strIds.append(",");
		}
		strIds.append(")");
		return find.where("id IN "+strIds).findList(); 
	}

	/*public static List<Office> search(String matcher) { 
		Logger.debug("OfficeServices search : "+matcher);
		return find.where("name LIKE "+matcher+"%").findList();
	}*/

	public static Long create(Office office) {
		office.save();
		Logger.debug("Office CREATE : " + office.getId());
		return office.getId();
	}

	public static Boolean delete(Long id) { 
		find.ref(id).delete();
		Logger.debug("Office DELETE : " + id);
		return find.ref(id)==null;
	}

	public static Boolean update(final Office office) { 

		Office dbOffice = Ebean.find(Office.class, office.getId());

		dbOffice.setId(office.getId());
		dbOffice.setShortDescription(office.getShortDescription());
		dbOffice.setDescription(office.getDescription());

		dbOffice.save();
		Logger.debug("Office UPDATE : " + office.id);
		return true;
	}
}
