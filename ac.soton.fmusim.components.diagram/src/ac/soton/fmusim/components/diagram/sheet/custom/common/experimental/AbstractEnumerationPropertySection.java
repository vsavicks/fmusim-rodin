/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.sheet.custom.common.experimental;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.util.StatusLineUtil;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.diagram.ui.properties.views.TextChangeHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * A generic class to edit a property via combo box.
 * 
 * @author vitaly
 */
//XXX: experimental section (not fully working yet), modified from the AbstractBasicTextPropertySection
public abstract class AbstractEnumerationPropertySection
	extends AbstractModelerPropertySection {

	// combo widget to display and set value of the property
	private CCombo comboWidget;

	// label widget for the property name
	private CLabel propertyNameLabelWidget;

	/**
	 * @return - name of the property to place in the label widget
	 */
	abstract protected String getPropertyNameLabel();

	/**
	 * Set property value for the given object
	 * 
	 * @param object - owner of the property
	 * @param value - new value
	 */
	abstract protected void setPropertyValue(EObject object, Object value);
	

	/**
	 * @return all enumeration values of this property
	 */
	abstract protected Object[] getEnumPropertyValues();

	/**
	 * @return - string representation of the property value
	 */
	//TODO
	abstract protected String getPropertyValueString();
	
	/**
	 * @return
	 */
	abstract protected String[] getEnumPropertyValueStrings();

	/**
	 * @return - title of the command which will be executed to set the property
	 */
	protected abstract String getPropertyChangeCommandName();

	/**
	 * A helper to listen for events that indicate that a text field has been
	 * changed.
	 */
	private TextChangeHelper listener_old = new TextChangeHelper() {
		boolean textModified = false;
		/**
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		public void handleEvent(Event event) {
			switch (event.type) {
				case SWT.Modify :
					textModified = !isNonUserChange();
					break;
				case SWT.KeyDown :
					if (event.character == SWT.CR) {
						textChanged((Control)event.widget);
					}
					break;
				case SWT.FocusOut :
					textChanged((Control)event.widget);
					break;
			}
		}
		
		public void textChanged(Control control) {
			if (textModified) {
				// clear error message
				IWorkbenchPart part = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().getActivePart();
				StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);

				setPropertyValue(control);
				textModified = false;
			}
		}		
	};
	
	/**
	 * Combo widget listener for selection events that indicate a combo field has been
	 * changed.
	 */
	private SelectionAdapter listener = new SelectionAdapter() {
		boolean selectionChanged = false;
		
		@Override
		public void widgetSelected(SelectionEvent event) {
			assert event.widget instanceof CCombo;
			CCombo combo = (CCombo) event.widget;
			int idx = combo.getSelectionIndex();
//			int index = combo.getSelectionIndex();
//			boolean equals = isEqual(index);
//			if (!equals) {
				comboChanged((Control) event.widget);
//			}
		}

		protected void comboChanged(Control control) {
			if (selectionChanged) {
				setPropertyValue(control);
				selectionChanged = false;
			}
		}
	};

	private Composite sectionComposite;

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		doCreateControls(parent, aTabbedPropertySheetPage);
	}
	
	/**
	 * Creates the GUI <code>Control</code> for this text property section
	 * @param parent parent <code>Composite</code>
	 * @param aTabbedPropertySheetPage <code>TabbedPropertySheetPage</code>
	 * @see org.eclipse.gmf.runtime.common.ui.properties.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.gmf.runtime.common.ui.properties.TabbedPropertySheetPage)
	 */
	public void doCreateControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		sectionComposite = getWidgetFactory().createFlatFormComposite(parent);
		comboWidget = createComboWidget(sectionComposite);
		propertyNameLabelWidget = createLabelWidget(sectionComposite);

		startComboWidgetEventListener();

	}

	/**
	 * Start listening to the combo widget events
	 */
	protected void startComboWidgetEventListener() {
		if (!isReadOnly()) {
			getComboWidget().addSelectionListener(getListener());
		}
	}

	/**
	 * Stop listening to combo widget events
	 */
	protected void stopComboWidgetEventListener() {
		if (!isReadOnly())
			getComboWidget().removeSelectionListener(getListener());
	}

	/**
	 * Instantiate a combo widget
	 * 
	 * @param parent - parent composite
	 * @return - a combo widget to display and edit the property
	 */
	protected CCombo createComboWidget(Composite parent) {
		CCombo combo = getWidgetFactory().createCCombo(parent);
		FormData data = new FormData();
		data.left = new FormAttachment(0, getStandardLabelWidth(parent,
			getPropertyNameStringsArray()));
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		combo.setLayoutData(data);
		if (isReadOnly())
			combo.setEditable(false);
		return combo;
	}

	/**
	 * returns as an array the property name
	 * @return - array of strings where each describes a property name one per
	 *         property. The strings will be used to calculate common indent
	 *         from the left
	 */
	protected String[] getPropertyNameStringsArray() {
		return new String[] {getPropertyNameLabel()};
	}

	/**
	 * Create a label for property name
	 * 
	 * @param parent - parent composite
	 * @return - label to show property name
	 */
	protected CLabel createLabelWidget(Composite parent) {
		CLabel label = getWidgetFactory().createCLabel(parent,
			getPropertyNameLabel());
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(getComboWidget(),
			-ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(getComboWidget(), 0, SWT.CENTER);
		label.setLayoutData(data);
		return label;
	}

	/**
	 * User selected a new value in the combo field - update the model
	 * 
	 * @param control <code>Control</code>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected synchronized void setPropertyValue(Control control) {

		final Object value = computeNewPropertyValue();
		ArrayList commands = new ArrayList();
		for (Iterator it = getEObjectList().iterator(); it.hasNext();) {
			final EObject next = (EObject) it.next();
			commands.add(createCommand(getPropertyChangeCommandName(), next,
				new Runnable() {

					public void run() {
						setPropertyValue(next, value);
					}

				}));
		}

		executeAsCompositeCommand(getPropertyChangeCommandName(), commands);
		refresh();

	}

	/**
	 * @return - a default implementation returns contents of the combo widget as
	 *         a new value for the property. Subclasses can override.
	 */
	//TODO: check if returned item is valid / index not out of bounds
	protected Object computeNewPropertyValue() {
		int i = getComboWidget().getSelectionIndex();
		if (i < 0) {
			return null;
		}
		return getEnumPropertyValues()[i];
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#dispose()
	 */
	public void dispose() {
		stopComboWidgetEventListener();
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	//TODO: what happens to listener when the combo text changes?
	public void refresh() {
//		getListener().startNonUserChange();
		try {
			executeAsReadAction(new Runnable() {

				public void run() {
					refreshUI();
				}
			});
		} finally {
//			getListener().finishNonUserChange();
		}
	}

	/**
	 * Refresh UI body - referesh will surround this with read action block
	 */
	protected void refreshUI() {
		getComboWidget().setItems(getEnumPropertyValueStrings());
		getComboWidget().setText(getPropertyValueString());
	}

	/**
	 * @return Returns the listener.
	 */
	protected SelectionAdapter getListener() {
		return listener;
	}

	/**
	 * @return Returns the comboWidget.
	 */
	protected CCombo getComboWidget() {
		return comboWidget;
	}

	/**
	 * @return Returns the propertyNameLabelWidget.
	 */
	public CLabel getPropertyNameLabelWidget() {
		return propertyNameLabelWidget;
	}

	/**
	 * @return Returns the sectionComposite.
	 */
	public Composite getSectionComposite() {
		return sectionComposite;
	}
}