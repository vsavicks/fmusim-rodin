/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.ui.wizards.pages.experimental;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.gmf.internal.bridge.ui.Plugin;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSource;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelSourceImpl;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.DomainModelViewerFactory;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ResolvedItem;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.StructureBuilder;
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.ResolvedItem.Resolution;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

import ac.soton.fmusim.components.ui.wizards.Messages;

/**
 * Modified from org.eclipse.gmf.internal.bridge.wizards.pages.simple.DefinitionPage.
 * 
 * @author vitaly
 *
 */
public class FMUPortDefinitionPage extends WizardPage {

//	private final StructureBuilder structureBuilder;

	private final ComponentModelSource domainModelSource;

	private DomainModelSourceImpl currentModelSource;

	private TreeViewer viewer;

	private Button deselectAllButton;

	private Button recognizeButton;

	public FMUPortDefinitionPage(String pageId, StructureBuilder structureBuilder, ComponentModelSource domainModelSource) {
		super(pageId);
//		this.structureBuilder = structureBuilder;
		this.domainModelSource = domainModelSource;
	}
	
	@Override
	public void createControl(Composite parent) {
		setPageComplete(false);
		setControl(createModelGroup(parent));
	}

	protected GridData createFillBothGridData(int span) {
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.grabExcessVerticalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = span;
		return data;
	}

	protected GridData createFillHorzGridData(int span) {
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.horizontalSpan = span;
		return data;
	}

	private Composite createModelGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		Label domainModelElementsLabel = new Label(plate, SWT.NONE);
		domainModelElementsLabel.setText(Messages.FMUDefinitionPageElementsToProcess);
		domainModelElementsLabel.setLayoutData(createFillHorzGridData(2));
		Composite viewerPlate = createViewerGroup(plate);
		viewerPlate.setLayoutData(createFillBothGridData(2));
		plate.setLayoutData(createFillBothGridData(1));
		return plate;
	}

	private Composite createViewerGroup(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
//		viewer = createViewer(plate);
		viewer.getControl().setLayoutData(createFillBothGridData(1));
		Composite buttonsPlate = createModelButtons(plate);
		buttonsPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
		return plate;
	}

	private Composite createModelButtons(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 12;
		plate.setLayout(layout);
		deselectAllButton = new Button(plate, SWT.PUSH);
		deselectAllButton.setLayoutData(createFillHorzGridData(1));
		deselectAllButton.setText(Messages.FMUDefinitionPageDeselectAll);
		deselectAllButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				deselectChildren(getModel());
				viewer.refresh(true);
			}

			private void deselectChildren(ResolvedItem item) {
				for (ResolvedItem child : item.getChildren()) {
					child.setResolution(null);
					deselectChildren(child);
				}
			}
		});

		return plate;
	}

//	protected TreeViewer createViewer(Composite parent) {
//		final Tree tree = new Tree(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
//		TableLayout layout = new TableLayout() {
//
//			private boolean firstTime = true;
//
//			public void layout(Composite c, boolean flush) {
//				super.layout(c, flush);
//				if (!firstTime) {
//					return;
//				}
//				int cawidth = c.getClientArea().width;
//
//				// XXX: Layout is being called with an invalid value the first time
//				// it is being called on Linux. This method resets the
//				// Layout to null so we make sure we run it only when
//				// the value is OK.
//				if (cawidth <= 1) {
//					return;
//				}
//
//				TreeColumn elementColumn = ((Tree) c).getColumn(0);
//				int vsbWidth = tree.getVerticalBar().getSize().x + 9; // 9 is magic since vsbw is not enough
//				int width = elementColumn.getWidth() - vsbWidth;
//				if (width < 0) {
//					width = 0;
//				}
//				elementColumn.setWidth(width);
//				firstTime = false;
//			}
//		};
//		tree.setLayout(layout);
//		tree.setHeaderVisible(true);
//		// tree.setLinesVisible(true);
//
//		TreeColumn elementColumn = new TreeColumn(tree, SWT.LEFT);
//		elementColumn.setText(Messages.FMUDefinitionPageElement);
//		elementColumn.setResizable(true);
//		layout.addColumnData(new ColumnWeightData(1, 32, true));
//
//		addResolutionColumn(tree, Resolution.INPUT, ComponentsUIPlugin.INPUT_ICON);
//		addResolutionColumn(tree, Resolution.OUTPUT, ComponentsUIPlugin.OUTPUT_ICON);
//		addResolutionColumn(tree, Resolution.INTERNAL, ComponentsUIPlugin.INTERNAL_ICON);
//
//		return viewer = FMUModelViewerFactory.createFMUViewer(tree, structureBuilder.isWithLabels());
//	}
//
//	protected TreeColumn addResolutionColumn(Tree tree, Resolution resolution, String iconId) {
//		TreeColumn column = new TreeColumn(tree, SWT.CENTER);
//		// column.setText(resolution.getName());
//		column.setImage(ComponentsUIPlugin.getDefault().getImageRegistry().get(iconId));
//		column.setResizable(false);
//		((TableLayout) tree.getLayout()).addColumnData(new ColumnPixelData(18, false, true));
//		return column;
//	}
//
//	protected boolean validatePage() {
//		return true;
//	}
//
//	public void setVisible(boolean visible) {
//		super.setVisible(visible);
//		if (!visible) {
//			return;
//		}
//		final EPackage contents = domainModelSource.getContents();
//		if (currentModelSource != null && currentModelSource.like(domainModelSource)) {
//			return; // domain model source is the same; do not reset viewer
//		}
//		currentModelSource = createDomainModelSource(contents, domainModelSource.getDiagramElement());
//		assert currentModelSource != null;
//		viewer.setInput(contents == null ? null : structureBuilder.process(currentModelSource));
//		viewer.expandAll();
//		viewer.getControl().pack();
//		if (contents != null) {
//			// domain model is loaded ok
//			setPageComplete(validatePage());
//		} else {
//			// empty domain model
//			setPageComplete(true);
//		}
//		((Composite) getControl()).layout(true, true);
//	}

	protected DomainModelSourceImpl createDomainModelSource(EPackage contents, EClass diagramElement) {
		return new DomainModelSourceImpl(contents, diagramElement);
	}

	public ResolvedItem getModel() {
		return (ResolvedItem) viewer.getInput();
	}
}
