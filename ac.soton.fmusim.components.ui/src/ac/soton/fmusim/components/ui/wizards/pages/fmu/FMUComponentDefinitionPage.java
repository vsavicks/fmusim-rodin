package ac.soton.fmusim.components.ui.wizards.pages.fmu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.ptolemy.fmi.FMIScalarVariable;
import org.ptolemy.fmi.FMIScalarVariable.Causality;

import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.FMUInternalVariable;
import ac.soton.fmusim.components.VariableType;
import ac.soton.fmusim.components.ui.wizards.pages.experimental.ComponentModelSource;
import ac.soton.fmusim.components.util.FmiUtil;
import de.prob.cosimulation.FMU;


public class FMUComponentDefinitionPage extends WizardPage {
	
	private CheckboxTableViewer internalsViewer;
	private CheckboxTableViewer inputsViewer;
	private CheckboxTableViewer outputsViewer;
	private ComponentModelSource source;

	public FMUComponentDefinitionPage(String pageName, ComponentModelSource source) {
		super(pageName);
		this.source = source;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
//		setPageComplete(false);
		setControl(createFMUComponentDefinitionGroup(parent));
	}

	/**
	 * Creates FMU component definition control group.
	 * Consists of three labeled check-box table viewers
	 * for internal, input and output variables.
	 * 
	 * @param parent
	 * @return control
	 */
	private Control createFMUComponentDefinitionGroup(Composite parent) {
		// layout
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
		
		// labeled check-box tables
		internalsViewer = createLabeledTable(plate, "Internal:", createColumnProviders(), new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				// TODO Auto-generated method stub
				return ((FMIScalarVariable) element).causality == Causality.internal;
			}});
		
		inputsViewer = createLabeledTable(plate, "Input:", createColumnProviders(), new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				// TODO Auto-generated method stub
				return ((FMIScalarVariable) element).causality == Causality.input;
			}});
		
		outputsViewer = createLabeledTable(plate, "Output:", createColumnProviders(), new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				// TODO Auto-generated method stub
				return ((FMIScalarVariable) element).causality == Causality.output;
			}});
		
		return plate;
	}

	/**
	 * @return
	 */
	private List<ColumnProvider> createColumnProviders() {
		ArrayList<ColumnProvider> providers = new ArrayList<ColumnProvider>();
		providers.add(new ColumnProvider("Name", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMIScalarVariable) element).name;
			}}));
		providers.add(new ColumnProvider("Type", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				VariableType type = FmiUtil.getFmiType(((FMIScalarVariable) element), null);
				return type.toString();
			}}));
		providers.add(new ColumnProvider("Value", 100, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				FMUInternalVariable var = ComponentsFactory.eINSTANCE.createFMUInternalVariable();
				FmiUtil.getFmiType(((FMIScalarVariable) element), var);
				return var.getValue().toString();
			}}));
		providers.add(new ColumnProvider("Description", 300, new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return ((FMIScalarVariable) element).description;
			}}));
		return providers;
	}

	/**
	 * Creates a labeled check-box table with columns defined by the column providers and an optional viewer filter.
	 * 
	 * @param parent
	 * @param labelText
	 * @param columnProviders 
	 * @param filter
	 * @return table viewer
	 */
	private CheckboxTableViewer createLabeledTable(Composite parent, String labelText, List<ColumnProvider> columnProviders, ViewerFilter filter) {
		{
			// label
			Label label = new Label(parent, SWT.NONE);
			label.setText(labelText);
			{
				GridData data = new GridData();
				label.setLayoutData(data);
			}
			
			// table
			CheckboxTableViewer tableViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER);
			createColumns(tableViewer, columnProviders);
			tableViewer.getTable().setHeaderVisible(true);
			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			if (filter != null)
				tableViewer.addFilter(filter);
			
			{
				GridData data = new GridData();
				data.horizontalAlignment = GridData.FILL;
				data.grabExcessHorizontalSpace = true;
				data.verticalAlignment = GridData.FILL;
				data.grabExcessVerticalSpace = true;
				tableViewer.getTable().setLayoutData(data);
			}
			
			return tableViewer;
		}
	}

	/**
	 * Creates check-box table columns from the column providers.
	 * 
	 * @param tableViewer
	 * @param columnProviders
	 */
	private void createColumns(CheckboxTableViewer tableViewer, List<ColumnProvider> columnProviders) {
		// empty column for the check-box control
		TableViewerColumn zeroColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		zeroColumn.setLabelProvider(new ColumnLabelProvider());
		
		for (ColumnProvider provider : columnProviders) {
			TableViewerColumn column = createTableViewerColumn(tableViewer, provider.getTitle(), provider.getBound());
			column.setLabelProvider(provider.getLabelProvider());
		}
	}

	/**
	 * Creates a table viewer column.
	 * 
	 * @param tableViewer  table viewer
	 * @param title column title
	 * @param bound column width bound
	 * @return table viewer column
	 */
	private TableViewerColumn createTableViewerColumn(CheckboxTableViewer tableViewer, String title, int bound) {
		TableViewerColumn viewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible){
			FMU fmu = (FMU) source.getModel();
//			FMUContentProvider fmuCP = new FMUContentProvider();
//			fmuCP.setLists(model);
			
			if (fmu != null) {
				// domain model is loaded ok
				setPageComplete(validatePage());
			} else {
				// empty domain model
				setPageComplete(true);
			}
			internalsViewer.setInput(fmu.getModelDescription().modelVariables);
			inputsViewer.setInput(fmu.getModelDescription().modelVariables);
			outputsViewer.setInput(fmu.getModelDescription().modelVariables);		
			((Composite) getControl()).layout();
		}
		super.setVisible(visible);
	}

	/**
	 * @return
	 */
	private boolean validatePage() {
		// TODO Auto-generated method stub
		return true;
	}

//	//Retrieve checked boxes
//	public List<FMUVariable[]> getSelection() {
//		Object[] checked = internalsViewer.getCheckedElements();
//		Object[] checked2 = inputsViewer.getCheckedElements();
//		Object[] checked3 = outputsViewer.getCheckedElements();
//		int count = checked.length;
//		int count2 = checked2.length;
//		int count3 = checked3.length;
//		FMUVariable[] extracted = new FMUVariable[count];
//		System.arraycopy(checked, 0, extracted, 0, count);
//		FMUVariable[] extracted2 = new FMUVariable[count2];
//		System.arraycopy(checked2, 0, extracted2, 0, count2);
//		FMUVariable[] extracted3 = new FMUVariable[count3];
//		System.arraycopy(checked3, 0, extracted3, 0, count3);
//		List<FMUVariable[]> checkedLists = new ArrayList<FMUVariable[]>();
//		checkedLists.add(extracted);
//		checkedLists.add(extracted2);
//		checkedLists.add(extracted3);
//		return checkedLists;
//	}


/*
	protected List list;

	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
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
		Label label = new Label(plate, SWT.NONE);
		label.setText(getModelElementName());
		{
			GridData data = new GridData();
			label.setLayoutData(data);
		}
		list = new List(plate, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
		list.setEnabled(false);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			list.setLayoutData(data);
		}

		// logic

		list.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				selectedModelElement = modelElements.get(list.getSelectionIndex());
				fireModelElementChanged();
			}
		});
	}

	public void setResource(Resource resource) {
		selectedModelElement = null;
		modelElements.clear();
		list.removeAll();
		if (resource == null) {
			list.setEnabled(false);
		} else {
			list.setEnabled(true);
			modelElements = getModelElements(resource);
			for (EObject next : modelElements) {
				list.add(getModelElementLabel(next));
			}
			if (!modelElements.isEmpty()) {
				selectedModelElement = modelElements.get(0);
				list.select(0);
			}
		}
		fireModelElementChanged();
	}
*/

}

