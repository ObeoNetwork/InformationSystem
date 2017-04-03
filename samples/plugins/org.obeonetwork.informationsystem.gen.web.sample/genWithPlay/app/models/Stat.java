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

public class Stat {
	public Long res;
	public String desc;
	
	public Stat(Long res, String desc) {
		super();
		this.res = res;
		this.desc = desc;
	}
	
	public Long getRes() {
		return res;
	}
	public void setRes(Long res) {
		this.res = res;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
