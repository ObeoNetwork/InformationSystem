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
public class Choco extends Model implements IModel {
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "device_gen")
	@Id
	public Long id;

	@Required
	public String shortDescription;

	@Required
	public String description;

	@ManyToOne
	public User user;



	public Choco(Long id, String shortDescription, String description, User user) {
		super();

		this.id = id;
		this.shortDescription = shortDescription;
		this.description = description;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public static Finder<Long,Choco> find = new Finder<Long,Choco>(
    	Long.class, Choco.class
  	);

	@Override
	public Proxy toProxy() {
		return new Proxy(id, shortDescription);
	}
	

}
