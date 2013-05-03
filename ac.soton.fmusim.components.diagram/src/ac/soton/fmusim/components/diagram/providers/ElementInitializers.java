/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.providers;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBPort;
import ac.soton.fmusim.components.FMUPort;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.diagram.expressions.ComponentsAbstractExpression;
import ac.soton.fmusim.components.diagram.expressions.ComponentsOCLFactory;
import ac.soton.fmusim.components.diagram.part.ComponentsDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public void init_FMUPort_3001(FMUPort instance) {
		try {
			Object value_0 = ComponentsOCLFactory.getExpression(1,
					ComponentsPackage.eINSTANCE.getFMUPort(), null).evaluate(
					instance);

			value_0 = ComponentsAbstractExpression.performCast(value_0,
					ComponentsPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_FMUPort_3002(FMUPort instance) {
		try {
			Object value_0 = ComponentsOCLFactory.getExpression(3,
					ComponentsPackage.eINSTANCE.getFMUPort(), null).evaluate(
					instance);

			value_0 = ComponentsAbstractExpression.performCast(value_0,
					ComponentsPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EventBPort_3003(EventBPort instance) {
		try {
			Object value_0 = ComponentsOCLFactory.getExpression(5,
					ComponentsPackage.eINSTANCE.getEventBPort(), null)
					.evaluate(instance);

			value_0 = ComponentsAbstractExpression.performCast(value_0,
					ComponentsPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public void init_EventBPort_3004(EventBPort instance) {
		try {
			Object value_0 = ComponentsOCLFactory.getExpression(7,
					ComponentsPackage.eINSTANCE.getEventBPort(), null)
					.evaluate(instance);

			value_0 = ComponentsAbstractExpression.performCast(value_0,
					ComponentsPackage.eINSTANCE.getVariableCausality());
			instance.setCausality((VariableCausality) value_0);
		} catch (RuntimeException e) {
			ComponentsDiagramEditorPlugin.getInstance().logError(
					"Element initialization failed", e); //$NON-NLS-1$						
		}
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = ComponentsDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			ComponentsDiagramEditorPlugin.getInstance().setElementInitializers(
					cached = new ElementInitializers());
		}
		return cached;
	}
}
