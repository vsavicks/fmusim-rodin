/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.fmu;

public class FMUVariable {

	private String VarName;
	private String VarDesc;
	private String VarType;
	private String VarVariability;

	public FMUVariable(){
	}

	public FMUVariable(String name){
		this.VarName = name;
	}

	public FMUVariable(String name, String type, String variability, String desc){
		this.VarName = name;
		this.VarDesc = desc;
		this.VarType = type;
		this.VarVariability = variability;
	}

	public String getName(){
		return this.VarName;
	}

	public String getType(){
		return this.VarType;
	}

	public String getVariability(){
		return this.VarVariability;
	}

	public String getDesc(){
		return this.VarDesc;
	}

	public void setName(String name){
		this.VarName = name;
	}

	public void setType(String type){
		this.VarType = type;
	}

	public void setDescription(String description){
		this.VarDesc = description;
	}

	public void setVariability(String variability){
		this.VarVariability = variability;
	}

}
