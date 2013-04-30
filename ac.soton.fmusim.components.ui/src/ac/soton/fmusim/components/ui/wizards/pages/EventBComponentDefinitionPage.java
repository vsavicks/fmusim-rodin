/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import ac.soton.fmusim.components.ui.wizards.pages.experimental.ComponentModelSource;

/**
 * @author vitaly
 *
 */
public class EventBComponentDefinitionPage extends WizardPage {

	private ComponentModelSource source;

	/**
	 * @param pageName
	 */
	public EventBComponentDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}

	@Override
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NULL);
		
		{
			GridLayout layout = new GridLayout();
			plate.setLayout(layout);
			
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			plate.setLayoutData(data);
		}
		setControl(plate);
	}

}
