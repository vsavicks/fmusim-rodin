package ac.soton.fmusim.components.diagram.edit.policies;

import info.monitorenter.gui.chart.Chart2D;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;

import ac.soton.fmusim.components.DisplayComponent;
import ac.soton.fmusim.components.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.fmusim.components.exceptions.SimulationException;

public final class DisplayComponentOpenEditPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		final DisplayComponentEditPart part = (DisplayComponentEditPart) getHost();
		return new Command() {
			@Override
			public void execute() {
				final DisplayComponent component = (DisplayComponent) part
						.resolveSemanticElement();
				assert component != null;

				// get chart or create one if not yet instantiated
				final Chart2D chart;
				if (component.getChart() != null) {
					chart = component.getChart();
				} else {
					TransactionalEditingDomain editingDomain = part
							.getEditingDomain();
					editingDomain.getCommandStack().execute(
							new RecordingCommand(editingDomain) {
								@Override
								protected void doExecute() {
									try {
										component.instantiate();
									} catch (SimulationException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
					chart = component.getChart();
					// if initialisation failed, cancel the display
					if (chart == null)
						return;
				}

				// display the chart if not visible yet
				if (!chart.isVisible()) {
					JPanel container = new JPanel();
					container.setBorder(BorderFactory
							.createEmptyBorder(10, 10, 10, 10));
					container.setBackground(java.awt.Color.WHITE);
					container.setLayout(new java.awt.BorderLayout());
					container.add(chart, java.awt.BorderLayout.CENTER);

					final JFrame frame = new JFrame("Display");
					frame.getContentPane().add(container);
					frame.setSize(300, 300);
					frame.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							frame.dispose();
							chart.setVisible(false);
						}
					});
					chart.setVisible(true);
					frame.setVisible(true);
				}
			}

		};
	}
}