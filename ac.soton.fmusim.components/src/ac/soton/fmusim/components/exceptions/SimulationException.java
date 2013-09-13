/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.exceptions;

/**
 * Exception indicating that the simulation has encountered a problem.
 * Handling this exception should involve stopping the simulation process.
 * 
 * @author vitaly
 *
 */
@SuppressWarnings("serial")
public class SimulationException extends Exception {

	/**
	 * 
	 */
	public SimulationException() {
	}

	/**
	 * @param arg0
	 */
	public SimulationException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public SimulationException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public SimulationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
