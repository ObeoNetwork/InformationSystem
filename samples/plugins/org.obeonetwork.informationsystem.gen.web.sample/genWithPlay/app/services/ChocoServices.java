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

public class ChocoServices {

	private static Finder<Long,Choco> find = new Finder(Long.class, Choco.class);

	public static Choco getById(Long id) { 
		return find.byId(id);
	}

	public static List<Choco> rows(int rowId, int nbElemByRow) {
		Logger.debug("ChocoServices rows : "+find.all().size());
		Page<Choco> chocos = find.where().findPagingList(nbElemByRow).getPage(rowId);
		return chocos.getList(); 
	}

	public static int count() { 
		int size = find.all().size();
		return size; 
	}

	public static List<Choco> all() { 
		return find.all(); 
	}

	public static List<Proxy> allProxies() { 
		List<Proxy> proxies = new ArrayList<Proxy>();
		List<Choco> chocos = find.all();
		for(Choco choco: chocos) {
			proxies.add(choco.toProxy());
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

	public static List<Choco> getByIds(List<Long> ids) { 

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

	/*public static List<Choco> search(String matcher) { 
		Logger.debug("ChocoServices search : "+matcher);
		return find.where("name LIKE "+matcher+"%").findList();
	}*/

	public static Long create(Choco choco) {
		choco.save();
		Logger.debug("Choco CREATE : " + choco.getId());
		return choco.getId();
	}

	public static Boolean delete(Long id) { 
		find.ref(id).delete();
		Logger.debug("Choco DELETE : " + id);
		return find.ref(id)==null;
	}

	public static Boolean update(final Choco choco) { 

		Choco dbChoco = Ebean.find(Choco.class, choco.getId());

		dbChoco.setId(choco.getId());
		dbChoco.setShortDescription(choco.getShortDescription());
		dbChoco.setDescription(choco.getDescription());
		dbChoco.setUser(choco.getUser());

		dbChoco.save();
		Logger.debug("Choco UPDATE : " + choco.id);
		return true;
	}
}
