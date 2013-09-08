package ac.soton.fmusim.components.ui.controls;

import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;

import ac.soton.fmusim.components.ui.providers.ColumnProvider;

public class TableViewerContainer {

	protected TableViewer tableViewer;
	private List<ColumnProvider> columnProviders;

	public TableViewerContainer(TableViewer viewer) {
		assert viewer != null;
		tableViewer = viewer;
	}

	/**
	 * Returns column providers if set.
	 * 
	 * @return the columnProviders
	 */
	public List<ColumnProvider> getColumnProviders() {
		return columnProviders;
	}

	/**
	 * Sets column providers and creates table columns.
	 * 
	 * @param columnProviders list of column providers
	 */
	public void setColumnProviders(List<ColumnProvider> columnProviders) {
		assert columnProviders != null;
		this.columnProviders = columnProviders;
		
		// first clear previous columns if exist
		for (TableColumn column : tableViewer.getTable().getColumns()) {
			column.dispose();
		}
		
		for (ColumnProvider provider : columnProviders) {
			TableViewerColumn column = createTableViewerColumn(tableViewer, provider.getTitle(), provider.getBound());
			column.setLabelProvider(provider.getLabelProvider());
		}
	}

	/**
	 * Creates a table viewer column.
	 * 
	 * @param viewer 
	 * @param title column title
	 * @param bound column width bound
	 * @return table viewer column
	 */
	private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound) {
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}

	/**
	 * Returns table viewer.
	 * 
	 * @return
	 */
	public TableViewer getViewer() {
		return tableViewer;
	}

	/**
	 * Sets table viewer input.
	 * 
	 * @param input current table content
	 */
	public void setInput(Object input) {
		tableViewer.setInput(input);
	}

	/**
	 * Returns table viewer input.
	 * 
	 * @return
	 */
	public Object getInput() {
		return tableViewer.getInput();
	}

}