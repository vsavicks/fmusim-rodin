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
//import org.eclipse.gmf.internal.bridge.wizards.pages.simple.Messages;
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

/**
 * @author vitaly
 *
 */
public class EventBPortDefinitionPage extends WizardPage {

	/**
	 * @param pageName
	 */
	protected EventBPortDefinitionPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}

//	private final StructureBuilder structureBuilder;
//
//	private final DomainModelSource domainModelSource;
//
//	private DomainModelSourceImpl currentModelSource;
//
//	private TreeViewer viewer;
//
//	private Button deselectAllButton;
//
//	private Button recognizeButton;
//
//	public PortDefinitionPage(String pageId, StructureBuilder structureBuilder, DomainModelSource domainModelSource) {
//		super(pageId);
//		this.structureBuilder = structureBuilder;
//		this.domainModelSource = domainModelSource;
//	}
//	
//	@Override
//	public void createControl(Composite parent) {
//		setPageComplete(false);
//		setControl(createDomainModelGroup(parent));
//	}
//
//	protected GridData createFillBothGridData(int span) {
//		GridData data = new GridData();
//		data.verticalAlignment = GridData.FILL;
//		data.grabExcessVerticalSpace = true;
//		data.horizontalAlignment = GridData.FILL;
//		data.grabExcessHorizontalSpace = true;
//		data.horizontalSpan = span;
//		return data;
//	}
//
//	protected GridData createFillHorzGridData(int span) {
//		GridData data = new GridData();
//		data.horizontalAlignment = GridData.FILL;
//		data.grabExcessHorizontalSpace = true;
//		data.horizontalSpan = span;
//		return data;
//	}
//
//	private Composite createDomainModelGroup(Composite parent) {
//		Composite plate = new Composite(parent, SWT.NONE);
//		GridLayout layout = new GridLayout(2, false);
//		layout.verticalSpacing = 12;
//		plate.setLayout(layout);
//		Label domainModelElementsLabel = new Label(plate, SWT.NONE);
//		domainModelElementsLabel.setText(Messages.DefinitionPageElementsToProcess);
//		domainModelElementsLabel.setLayoutData(createFillHorzGridData(2));
//		Composite viewerPlate = createViewerGroup(plate);
//		viewerPlate.setLayoutData(createFillBothGridData(2));
//		plate.setLayoutData(createFillBothGridData(1));
//		return plate;
//	}
//
//	private Composite createViewerGroup(Composite parent) {
//		Composite plate = new Composite(parent, SWT.NONE);
//		GridLayout layout = new GridLayout(2, false);
//		layout.verticalSpacing = 12;
//		plate.setLayout(layout);
//		viewer = createViewer(plate);
//		viewer.getControl().setLayoutData(createFillBothGridData(1));
//		Composite buttonsPlate = createDomainModelButtons(plate);
//		buttonsPlate.setLayoutData(new GridData(GridData.FILL_VERTICAL));
//		return plate;
//	}
//
//	private Composite createDomainModelButtons(Composite parent) {
//		Composite plate = new Composite(parent, SWT.NONE);
//		GridLayout layout = new GridLayout(1, false);
//		layout.verticalSpacing = 12;
//		plate.setLayout(layout);
//		deselectAllButton = new Button(plate, SWT.PUSH);
//		deselectAllButton.setLayoutData(createFillHorzGridData(1));
//		deselectAllButton.setText(Messages.DefinitionPageDeselectAll);
//		deselectAllButton.addSelectionListener(new SelectionListener() {
//
//			public void widgetDefaultSelected(SelectionEvent e) {
//			}
//
//			public void widgetSelected(SelectionEvent e) {
//				deselectChildren(getModel());
//				viewer.refresh(true);
//			}
//
//			private void deselectChildren(ResolvedItem item) {
//				for (ResolvedItem child : item.getChildren()) {
//					child.setResolution(null);
//					deselectChildren(child);
//				}
//			}
//		});
//		recognizeButton = new Button(plate, SWT.PUSH);
//		recognizeButton.setLayoutData(createFillHorzGridData(1));
//		recognizeButton.setText(Messages.DefinitionPageDefaults);
//		recognizeButton.addSelectionListener(new SelectionListener() {
//
//			public void widgetDefaultSelected(SelectionEvent e) {
//			}
//
//			public void widgetSelected(SelectionEvent e) {
//				final EPackage contents = currentModelSource.getContents();
//				viewer.setInput(contents == null ? null : structureBuilder.process(currentModelSource));
//				viewer.expandAll();
//				if (contents != null) {
//					setPageComplete(validatePage());
//				} else {
//					setPageComplete(true);
//				}
//			}
//		});
//		return plate;
//	}
//
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
//		elementColumn.setText(Messages.DefinitionPageElement);
//		elementColumn.setResizable(true);
//		layout.addColumnData(new ColumnWeightData(1, 32, true));
//
//		addResolutionColumn(tree, Resolution.NODE, Plugin.NODE_ICON);
//		addResolutionColumn(tree, Resolution.LINK, Plugin.LINK_ICON);
//		if (structureBuilder.isWithLabels()) {
//			addResolutionColumn(tree, Resolution.LABEL, Plugin.LABEL_ICON);
//		}
//
//		return viewer = DomainModelViewerFactory.createViewer(tree, structureBuilder.isWithLabels());
//	}
//
//	protected TreeColumn addResolutionColumn(Tree tree, Resolution resolution, String iconId) {
//		TreeColumn column = new TreeColumn(tree, SWT.CENTER);
//		// column.setText(resolution.getName());
//		column.setImage(Plugin.getDefault().getImageRegistry().get(iconId));
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
//
//	protected DomainModelSourceImpl createDomainModelSource(EPackage contents, EClass diagramElement) {
//		return new DomainModelSourceImpl(contents, diagramElement);
//	}
//
//	public ResolvedItem getModel() {
//		return (ResolvedItem) viewer.getInput();
//	}
}
