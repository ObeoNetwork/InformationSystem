package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model implements IModel {
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "device_gen")
	@Id
	public Long id;

	@Required
	public String nickname;

	@Required
	public String shortNickname;

	@Required
	public String firstName;

	@Required
	public String lastName;

	@OneToMany(cascade=CascadeType.ALL)
	public List<Choco> chocos;

	@OneToOne (cascade=CascadeType.ALL)
	public Office office;

	@Required
	public String email;

	public Integer level;

	public Integer xp;



	public User(Long id, String nickname, String shortNickname, String firstName, String lastName, List<Choco> chocos, Office office, String email, Integer level, Integer xp) {
		super();

		this.id = id;
		this.nickname = nickname;
		this.shortNickname = shortNickname;
		this.firstName = firstName;
		this.lastName = lastName;
		this.chocos = chocos;
		this.office = office;
		this.email = email;
		this.level = level;
		this.xp = xp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getShortNickname() {
		return shortNickname;
	}

	public void setShortNickname(String shortNickname) {
		this.shortNickname = shortNickname;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Choco> getChocos() {
		return chocos;
	}

	public void setChocos(List<Choco> chocos) {
		this.chocos = chocos;
	}


	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}


	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}



	public static Finder<Long,User> find = new Finder<Long,User>(
    	Long.class, User.class
  	);

	@Override
	public Proxy toProxy() {
		return new Proxy(id, nickname);
	}
	

}
