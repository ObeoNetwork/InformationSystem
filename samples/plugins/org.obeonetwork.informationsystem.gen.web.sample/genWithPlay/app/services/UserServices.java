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

public class UserServices {

	private static Finder<Long,User> find = new Finder(Long.class, User.class);

	public static User getById(Long id) { 
		return find.byId(id);
	}

	public static List<User> rows(int rowId, int nbElemByRow) {
		Logger.debug("UserServices rows : "+find.all().size());
		Page<User> users = find.where().findPagingList(nbElemByRow).getPage(rowId);
		return users.getList(); 
	}

	public static int count() { 
		int size = find.all().size();
		return size; 
	}

	public static List<User> all() { 
		return find.all(); 
	}

	public static List<Proxy> allProxies() { 
		List<Proxy> proxies = new ArrayList<Proxy>();
		List<User> users = find.all();
		for(User user: users) {
			proxies.add(user.toProxy());
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

	public static List<User> getByIds(List<Long> ids) { 

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

	/*public static List<User> search(String matcher) { 
		Logger.debug("UserServices search : "+matcher);
		return find.where("name LIKE "+matcher+"%").findList();
	}*/

	public static Long create(User user) {
		user.save();
		for(Choco choco : user.getChocos()) {
			choco.setUser(user);
			choco.save();
		}
		Logger.debug("User CREATE : " + user.getId());
		return user.getId();
	}

	public static Boolean delete(Long id) { 
		find.ref(id).delete();
		Logger.debug("User DELETE : " + id);
		return find.ref(id)==null;
	}

	public static Boolean update(final User user) { 

		User dbUser = Ebean.find(User.class, user.getId());
		for(Choco choco : dbUser.getChocos()) {
			choco.setUser(null);
			choco.save();
		}

		for(Choco choco : user.getChocos()) {
			choco.setUser(dbUser);
			choco.save();
		}

		dbUser.setId(user.getId());
		dbUser.setNickname(user.getNickname());
		dbUser.setShortNickname(user.getShortNickname());
		dbUser.setFirstName(user.getFirstName());
		dbUser.setLastName(user.getLastName());
		dbUser.setOffice(user.getOffice());
		dbUser.setEmail(user.getEmail());
		dbUser.setLevel(user.getLevel());
		dbUser.setXp(user.getXp());

		dbUser.save();
		Logger.debug("User UPDATE : " + user.id);
		return true;
	}
}
