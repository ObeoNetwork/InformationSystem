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
public class Office extends Model implements IModel {
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "device_gen")
	@Id
	public Long id;

	@Required
	public String shortDescription;

	@Required
	public String description;



	public Office(Long id, String shortDescription, String description) {
		super();

		this.id = id;
		this.shortDescription = shortDescription;
		this.description = description;
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



	public static Finder<Long,Office> find = new Finder<Long,Office>(
    	Long.class, Office.class
  	);

	@Override
	public Proxy toProxy() {
		return new Proxy(id, shortDescription);
	}
	

}
