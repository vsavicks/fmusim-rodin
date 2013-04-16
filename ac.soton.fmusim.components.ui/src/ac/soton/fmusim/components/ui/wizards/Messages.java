/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards;

import org.eclipse.osgi.util.NLS;

/**
 * @author vitaly
 *
 */
public class Messages {
	
	private static final String BUNDLE_NAME = "ac.soton.fmusim.components.ui.wizards.messages"; //$NON-NLS-1$

	private Messages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	// model selection page
	public static String ModelSelectionPageModelURI;
	public static String ModelSelectionPageBrowseFS;
	public static String ModelSelectionPageBrowseWS;
	public static String ModelSelectionPageFindInWS;
	public static String ModelSelectionPageSelectModel;
	public static String ModelSelectionPageSelectModelDesc;
	public static String ModelSelectionPageLoad;
	public static String ModelSelectionPageBadURI;
	public static String ModelSelectionPageModelNA;
	public static String ModelSelectionPageErrorLoadingModel;
	
	// component import wizard
	public static String ComponentImportWizardDomainModelSelectionPageTitle;
	public static String ComponentImportWizardModelSelectionPageDesc;

}
