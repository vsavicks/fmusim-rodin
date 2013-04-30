/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.fmu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ptolemy.fmi.FMIModelDescription;
import org.ptolemy.fmi.type.FMIBooleanType;
import org.ptolemy.fmi.type.FMIIntegerType;
import org.ptolemy.fmi.type.FMIRealType;
import org.ptolemy.fmi.type.FMIStringType;
import org.ptolemy.fmi.type.FMIType;
//import com.sun.jna.Function;

import de.prob.cosimulation.FMU;

public class FMUContentProvider {

	private List<FMUVariable> internalList;
	private List<FMUVariable> inputList;
	private List<FMUVariable> outputList;
	private FMIModelDescription modelDesc;

	//Retrieve FMU file's variables
	public void setLists(FMU fmuFile){
		internalList = new ArrayList<FMUVariable>();
		inputList = new ArrayList<FMUVariable>();
		outputList = new ArrayList<FMUVariable>();

//		try {
//			FMU fmuFile = new FMU(FMUPath);
			String causality = "";
			String description = "";
			String variability = "";
			FMIType type;
			String typestr = "";
			modelDesc = fmuFile.getModelDescription();
			for(int i=0;i<modelDesc.modelVariables.size();i++){
				if(modelDesc.modelVariables.get(i).causality != null ){
					causality = modelDesc.modelVariables.get(i).causality.toString();
				}
				if(modelDesc.modelVariables.get(i).description != null ){
					description = modelDesc.modelVariables.get(i).description.toString();
				}
				if(modelDesc.modelVariables.get(i).variability != null ){
					variability = modelDesc.modelVariables.get(i).variability.toString();
				}
				if(modelDesc.modelVariables.get(i).type != null ){
					type = modelDesc.modelVariables.get(i).type;
					if(type instanceof FMIRealType){typestr = "Real";}
					else if(type instanceof FMIIntegerType){typestr = "Integer";}
					else if(type instanceof FMIBooleanType){typestr = "Boolean";}
					else if(type instanceof FMIStringType){typestr = "String";}
				}				
				if ("input".equals(causality)) {
					inputList.add(new FMUVariable(modelDesc.modelVariables.get(i).name.toString(),
							typestr,
							variability,
							description));
				} else if ("output".equals(causality)) {
					outputList.add(new FMUVariable(modelDesc.modelVariables.get(i).name.toString(),
							typestr,
							variability,
							description));
				} else {
					internalList.add(new FMUVariable(modelDesc.modelVariables.get(i).name.toString(),
							typestr,
							variability,
							description));
				}
			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public List<FMUVariable> getInputs(){
		return this.inputList;
	}

	public List<FMUVariable> getOutputs(){
		return this.outputList;
	}

	public List<FMUVariable> getInternals(){
		return this.internalList;
	}
}
