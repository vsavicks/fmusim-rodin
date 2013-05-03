/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.diagram.edit.parts.ConnectorValueEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPortNameType2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBPortNameTypeEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentNameEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUInternalVariableEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortNameType2EditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortNameTypeEditPart;
import ac.soton.fmusim.components.diagram.parsers.ConnectorLabelExpressionLabelParser;
import ac.soton.fmusim.components.diagram.parsers.FMUInternalVariableExpressionLabelParser;
import ac.soton.fmusim.components.diagram.parsers.MessageFormatParser;
import ac.soton.fmusim.components.diagram.part.ComponentsVisualIDRegistry;

/**
 * @generated
 */
public class ComponentsParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser fMUComponentName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getFMUComponentName_5001Parser() {
		if (fMUComponentName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ComponentsPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			fMUComponentName_5001Parser = parser;
		}
		return fMUComponentName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser eventBComponentName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getEventBComponentName_5002Parser() {
		if (eventBComponentName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { ComponentsPackage.eINSTANCE
					.getNamedElement_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			eventBComponentName_5002Parser = parser;
		}
		return eventBComponentName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser getConnectorLabel_5003Parser() {
		return new ConnectorLabelExpressionLabelParser();
	}

	/**
	 * @generated
	 */
	private IParser fMUPortNameType_5004Parser;

	/**
	 * @generated
	 */
	private IParser getFMUPortNameType_5004Parser() {
		if (fMUPortNameType_5004Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ComponentsPackage.eINSTANCE.getNamedElement_Name(),
					ComponentsPackage.eINSTANCE.getAbstractVariable_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0} : {1}"); //$NON-NLS-1$
			fMUPortNameType_5004Parser = parser;
		}
		return fMUPortNameType_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser fMUPortNameType_5005Parser;

	/**
	 * @generated
	 */
	private IParser getFMUPortNameType_5005Parser() {
		if (fMUPortNameType_5005Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ComponentsPackage.eINSTANCE.getNamedElement_Name(),
					ComponentsPackage.eINSTANCE.getAbstractVariable_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0} : {1}"); //$NON-NLS-1$
			fMUPortNameType_5005Parser = parser;
		}
		return fMUPortNameType_5005Parser;
	}

	/**
	 * @generated
	 */
	private FMUInternalVariableExpressionLabelParser fMUInternalVariable_3006Parser;

	/**
	 * @generated
	 */
	private IParser getFMUInternalVariable_3006Parser() {
		if (fMUInternalVariable_3006Parser == null) {
			fMUInternalVariable_3006Parser = new FMUInternalVariableExpressionLabelParser();
		}
		return fMUInternalVariable_3006Parser;
	}

	/**
	 * @generated
	 */
	private IParser eventBPortNameType_5006Parser;

	/**
	 * @generated
	 */
	private IParser getEventBPortNameType_5006Parser() {
		if (eventBPortNameType_5006Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ComponentsPackage.eINSTANCE.getNamedElement_Name(),
					ComponentsPackage.eINSTANCE.getAbstractVariable_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0} : {1}"); //$NON-NLS-1$
			eventBPortNameType_5006Parser = parser;
		}
		return eventBPortNameType_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser eventBPortNameType_5007Parser;

	/**
	 * @generated
	 */
	private IParser getEventBPortNameType_5007Parser() {
		if (eventBPortNameType_5007Parser == null) {
			EAttribute[] features = new EAttribute[] {
					ComponentsPackage.eINSTANCE.getNamedElement_Name(),
					ComponentsPackage.eINSTANCE.getAbstractVariable_Type() };
			MessageFormatParser parser = new MessageFormatParser(features);
			parser.setViewPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditorPattern("{0} : {1}"); //$NON-NLS-1$
			parser.setEditPattern("{0} : {1}"); //$NON-NLS-1$
			eventBPortNameType_5007Parser = parser;
		}
		return eventBPortNameType_5007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case FMUComponentNameEditPart.VISUAL_ID:
			return getFMUComponentName_5001Parser();
		case EventBComponentNameEditPart.VISUAL_ID:
			return getEventBComponentName_5002Parser();
		case ConnectorValueEditPart.VISUAL_ID:
			return getConnectorLabel_5003Parser();
		case FMUPortNameTypeEditPart.VISUAL_ID:
			return getFMUPortNameType_5004Parser();
		case FMUPortNameType2EditPart.VISUAL_ID:
			return getFMUPortNameType_5005Parser();
		case FMUInternalVariableEditPart.VISUAL_ID:
			return getFMUInternalVariable_3006Parser();
		case EventBPortNameTypeEditPart.VISUAL_ID:
			return getEventBPortNameType_5006Parser();
		case EventBPortNameType2EditPart.VISUAL_ID:
			return getEventBPortNameType_5007Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(ComponentsVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ComponentsVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ComponentsElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
