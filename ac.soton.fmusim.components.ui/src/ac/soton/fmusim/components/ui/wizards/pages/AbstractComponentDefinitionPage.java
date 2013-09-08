/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ac.soton.fmusim.components.ui.controls.EditableTableViewerContainer;
import ac.soton.fmusim.components.ui.controls.EventBNamedComboContainer;
import ac.soton.fmusim.components.ui.providers.ColumnProvider;

/**
 * Abstract component definition page.
 * Contains methods for creating labelled UI controls.
 * 
 * @author vitaly
 *
 */
public abstract class AbstractComponentDefinitionPage extends WizardPage {

	public AbstractComponentDefinitionPage(String pageName) {
		super(pageName);
	}

	public AbstractComponentDefinitionPage(String pageName, String title,
			ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	/**
	 * Creates labeled control group.
	 * 
	 * @param parent
	 * @param label
	 * @param tooltip
	 * @return
	 */
	protected Group createLabeledGroup(Composite parent, String label, String tooltip) {
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		group.setLayout(new GridLayout());
		group.setText(label);
		group.setToolTipText(tooltip);
		return group;
	}

	/**
	 * Creates a labeled plate for use with any type of control.
	 * 
	 * @param parent parent control
	 * @param name label name
	 * @return
	 */
	private Composite createLabeledPlate(Composite parent, String name) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		plate.setLayout(layout);
		
		Label label = new Label(plate, SWT.NONE);
		label.setText(name);
		label.setLayoutData(new GridData(100, SWT.DEFAULT));
		return plate;
	}

	/**
	 * Creates labeled text control.
	 * Label width is fixed to 100.
	 * 
	 * @param parent
	 * @param label
	 * @param tooltip 
	 * @return
	 */
	protected Text createLabeledText(Composite parent, String label, String tooltip) {
		Composite plate = createLabeledPlate(parent, label);
		Text text = new Text(plate, SWT.SINGLE | SWT.BORDER);
		text.setToolTipText(tooltip);
		text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		plate.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		return text;
	}

	/**
	 * Creates a labeled combo control.
	 * Label width is fixed to 100.
	 * 
	 * @param parent parent control
	 * @param name combo label
	 * @param tooltip tooltip text
	 * @return
	 */
	protected EventBNamedComboContainer createLabeledEventBNamedCombo(Composite parent, String name, String tooltip) {
		Composite plate = createLabeledPlate(parent, name);
		EventBNamedComboContainer comboWrap = new EventBNamedComboContainer(new Combo(plate, SWT.DROP_DOWN | SWT.READ_ONLY));
		comboWrap.getCombo().setToolTipText(tooltip);
		comboWrap.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		plate.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		return comboWrap;
	}
	
	/**
	 * Creates a labeled table with columns defined by the column providers and an optional viewer filter.
	 * 
	 * @param parent
	 * @param name
	 * @param tooltip
	 * @param columnProviders 
	 * @param filter
	 * @return table viewer
	 */
	public EditableTableViewerContainer createLabeledEditableTable(Composite parent, String name, String tooltip, List<ColumnProvider> columnProviders, ViewerFilter filter) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		plate.setLayout(layout);
		
		// label
		Label label = new Label(plate, SWT.NONE);
		label.setText(name);
		label.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		
		// table
		EditableTableViewerContainer tableWrap = new EditableTableViewerContainer(new TableViewer(plate, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION));
		tableWrap.getViewer().getTable().setToolTipText(tooltip);
		tableWrap.getViewer().getTable().setHeaderVisible(true);
		tableWrap.setColumns(columnProviders, 0);
		tableWrap.getViewer().setContentProvider(ArrayContentProvider.getInstance());
		if (filter != null)
			tableWrap.getViewer().addFilter(filter);
		tableWrap.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		
		plate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		return tableWrap;
	}
	

}