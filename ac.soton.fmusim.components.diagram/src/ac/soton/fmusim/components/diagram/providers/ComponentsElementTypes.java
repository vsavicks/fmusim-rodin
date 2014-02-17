/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.diagram.edit.parts.ComponentDiagramEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.ConnectorEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.DisplayComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.DisplayPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBInputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBOutputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.EventBVariableEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUComponentEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUInputPortEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUPortOutputEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.FMUVariableEditPart;
import ac.soton.fmusim.components.diagram.edit.parts.PortConnectorEditPart;
import ac.soton.fmusim.components.diagram.part.ComponentsDiagramEditorPlugin;

/**
 * @generated
 */
public class ComponentsElementTypes {

	/**
	 * @generated
	 */
	private ComponentsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType ComponentDiagram_1000 = getElementType("ac.soton.fmusim.components.diagram.ComponentDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUComponent_2001 = getElementType("ac.soton.fmusim.components.diagram.FMUComponent_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBComponent_2002 = getElementType("ac.soton.fmusim.components.diagram.EventBComponent_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Connector_2003 = getElementType("ac.soton.fmusim.components.diagram.Connector_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType DisplayComponent_2006 = getElementType("ac.soton.fmusim.components.diagram.DisplayComponent_2006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType FMUPort_3001 = getElementType("ac.soton.fmusim.components.diagram.FMUPort_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUPort_3002 = getElementType("ac.soton.fmusim.components.diagram.FMUPort_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FMUVariable_3009 = getElementType("ac.soton.fmusim.components.diagram.FMUVariable_3009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType EventBPort_3003 = getElementType("ac.soton.fmusim.components.diagram.EventBPort_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBPort_3004 = getElementType("ac.soton.fmusim.components.diagram.EventBPort_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType EventBVariable_3010 = getElementType("ac.soton.fmusim.components.diagram.EventBVariable_3010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType DisplayPort_3013 = getElementType("ac.soton.fmusim.components.diagram.DisplayPort_3013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType PortConnector_4001 = getElementType("ac.soton.fmusim.components.diagram.PortConnector_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return ComponentsDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(ComponentDiagram_1000,
					ComponentsPackage.eINSTANCE.getComponentDiagram());

			elements.put(FMUComponent_2001,
					ComponentsPackage.eINSTANCE.getFMUComponent());

			elements.put(EventBComponent_2002,
					ComponentsPackage.eINSTANCE.getEventBComponent());

			elements.put(Connector_2003,
					ComponentsPackage.eINSTANCE.getConnector());

			elements.put(DisplayComponent_2006,
					ComponentsPackage.eINSTANCE.getDisplayComponent());

			elements.put(FMUPort_3001, ComponentsPackage.eINSTANCE.getFMUPort());

			elements.put(FMUPort_3002, ComponentsPackage.eINSTANCE.getFMUPort());

			elements.put(FMUVariable_3009,
					ComponentsPackage.eINSTANCE.getFMUVariable());

			elements.put(EventBPort_3003,
					ComponentsPackage.eINSTANCE.getEventBPort());

			elements.put(EventBPort_3004,
					ComponentsPackage.eINSTANCE.getEventBPort());

			elements.put(EventBVariable_3010,
					ComponentsPackage.eINSTANCE.getEventBVariable());

			elements.put(DisplayPort_3013,
					ComponentsPackage.eINSTANCE.getDisplayPort());

			elements.put(PortConnector_4001,
					ComponentsPackage.eINSTANCE.getPort_Connector());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(ComponentDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(FMUComponent_2001);
			KNOWN_ELEMENT_TYPES.add(EventBComponent_2002);
			KNOWN_ELEMENT_TYPES.add(Connector_2003);
			KNOWN_ELEMENT_TYPES.add(DisplayComponent_2006);
			KNOWN_ELEMENT_TYPES.add(FMUPort_3001);
			KNOWN_ELEMENT_TYPES.add(FMUPort_3002);
			KNOWN_ELEMENT_TYPES.add(FMUVariable_3009);
			KNOWN_ELEMENT_TYPES.add(EventBPort_3003);
			KNOWN_ELEMENT_TYPES.add(EventBPort_3004);
			KNOWN_ELEMENT_TYPES.add(EventBVariable_3010);
			KNOWN_ELEMENT_TYPES.add(DisplayPort_3013);
			KNOWN_ELEMENT_TYPES.add(PortConnector_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ComponentDiagramEditPart.VISUAL_ID:
			return ComponentDiagram_1000;
		case FMUComponentEditPart.VISUAL_ID:
			return FMUComponent_2001;
		case EventBComponentEditPart.VISUAL_ID:
			return EventBComponent_2002;
		case ConnectorEditPart.VISUAL_ID:
			return Connector_2003;
		case DisplayComponentEditPart.VISUAL_ID:
			return DisplayComponent_2006;
		case FMUInputPortEditPart.VISUAL_ID:
			return FMUPort_3001;
		case FMUPortOutputEditPart.VISUAL_ID:
			return FMUPort_3002;
		case FMUVariableEditPart.VISUAL_ID:
			return FMUVariable_3009;
		case EventBInputPortEditPart.VISUAL_ID:
			return EventBPort_3003;
		case EventBOutputPortEditPart.VISUAL_ID:
			return EventBPort_3004;
		case EventBVariableEditPart.VISUAL_ID:
			return EventBVariable_3010;
		case DisplayPortEditPart.VISUAL_ID:
			return DisplayPort_3013;
		case PortConnectorEditPart.VISUAL_ID:
			return PortConnector_4001;
		}
		return null;
	}

}
