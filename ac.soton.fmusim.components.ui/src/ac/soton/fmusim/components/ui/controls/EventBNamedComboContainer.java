/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.controls;

import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Combo;
import org.eventb.emf.core.EventBNamed;

/**
 * Selection combo container for EventBNamed elements.
 * A container solution alternative to subclassing a Combo,
 * which is not allowed by SWT.
 * 
 * @author vitaly
 *
 */
public class EventBNamedComboContainer {

	private Combo combo;

	/**Constructor.
	 * @param combo
	 */
	public EventBNamedComboContainer(Combo combo) {
		assert combo != null;
		this.combo = combo;
	}
	
	/**
	 * Returns wrapped combo.
	 * 
	 * @return
	 */
	public Combo getCombo() {
		return combo;
	}

	/**
	 * Sets combo input, expecting a list of EventBNamed elements.
	 * 
	 * @param elements
	 * @param selectedElement 
	 */
	public void setInput(EList<? extends EventBNamed> elements, EventBNamed selectedElement) {
		String[] items = new String[elements.size() + 1];
		int i = 0;
		items[i++] = ""; // empty item
		for (EventBNamed el : elements) {
			items[i++] = el.getName();
		}
		Arrays.sort(items);
		combo.setItems(items);
		combo.setData(elements);
		
		// set selection if provided
		if (selectedElement != null) {
			for (int j = 0; j < items.length; j++) {
				if (selectedElement.getName().equals(items[j])) {
					combo.select(j);
				}
			}
		}
	}
	
	/**
	 * Returns selected element.
	 * 
	 * @param combo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public EventBNamed getSelected() {
		// assertion checks for validity of data
		assert combo.getData() instanceof EList;
		if (((EList<?>) combo.getData()).size() > 0)
			assert ((EList<?>) combo.getData()).get(0) instanceof EventBNamed;
		
		if (combo.getSelectionIndex() < 0)
			return null;
		
		// find selected item by name
		String itemName = combo.getItem(combo.getSelectionIndex());
		EList<? extends EventBNamed> elements = (EList<? extends EventBNamed>) combo.getData();
		for (EventBNamed el : elements) {
			if (itemName.equals(el.getName())) {
				return el;
			}
		}
		return null;
	}

	public void addSelectionListener(SelectionAdapter selectionAdapter) {
		combo.addSelectionListener(selectionAdapter);
	}

}
