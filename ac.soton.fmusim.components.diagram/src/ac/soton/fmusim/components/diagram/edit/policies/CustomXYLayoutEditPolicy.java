package ac.soton.fmusim.components.diagram.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

public class CustomXYLayoutEditPolicy extends XYLayoutEditPolicy {
	@Override
	protected Rectangle getCurrentConstraintFor(GraphicalEditPart child) {
		IFigure fig = child.getFigure();
		Object constraint = fig.getParent().getLayoutManager().getConstraint(fig);
		// HACK to avoid an exception:
		// java.lang.ClassCastException: org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator cannot be cast to org.eclipse.draw2d.geometry.Rectangle
		if (constraint instanceof BorderItemLocator)
			return fig.getBounds();
		return (Rectangle) constraint;
	}
}