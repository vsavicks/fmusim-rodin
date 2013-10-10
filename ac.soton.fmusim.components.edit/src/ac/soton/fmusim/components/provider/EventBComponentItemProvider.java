/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.provider.AbstractExtensionItemProvider;

import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBComponent;

/**
 * This is the item provider adapter for a {@link ac.soton.fmusim.components.EventBComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EventBComponentItemProvider
	extends AbstractExtensionItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBComponentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addComposedPropertyDescriptor(object);
			addMachinePropertyDescriptor(object);
			addReadInputEventsPropertyDescriptor(object);
			addTimeVariablePropertyDescriptor(object);
			addWaitEventsPropertyDescriptor(object);
			addTracePropertyDescriptor(object);
			addStepPeriodPropertyDescriptor(object);
			addRealPrecisionPropertyDescriptor(object);
			addStepTimePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NamedElement_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
				 ComponentsPackage.Literals.NAMED_ELEMENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Composed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addComposedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_composed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_composed_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__COMPOSED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Machine feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMachinePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_machine_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_machine_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__MACHINE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Read Input Events feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReadInputEventsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_readInputEvents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_readInputEvents_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__READ_INPUT_EVENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Variable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeVariablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_timeVariable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_timeVariable_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__TIME_VARIABLE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Wait Events feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWaitEventsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_waitEvents_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_waitEvents_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__WAIT_EVENTS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Trace feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTracePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_trace_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_trace_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__TRACE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Step Period feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStepPeriodPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_stepPeriod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_stepPeriod_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__STEP_PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Real Precision feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealPrecisionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_realPrecision_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_realPrecision_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__REAL_PRECISION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Step Time feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStepTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_EventBComponent_stepTime_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_EventBComponent_stepTime_feature", "_UI_EventBComponent_type"),
				 ComponentsPackage.Literals.EVENT_BCOMPONENT__STEP_TIME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ComponentsPackage.Literals.COMPONENT__INPUTS);
			childrenFeatures.add(ComponentsPackage.Literals.COMPONENT__OUTPUTS);
			childrenFeatures.add(ComponentsPackage.Literals.COMPONENT__VARIABLES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns EventBComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/EventBComponent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((EventBComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_EventBComponent_type") :
			getString("_UI_EventBComponent_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(EventBComponent.class)) {
			case ComponentsPackage.EVENT_BCOMPONENT__NAME:
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_PERIOD:
			case ComponentsPackage.EVENT_BCOMPONENT__REAL_PRECISION:
			case ComponentsPackage.EVENT_BCOMPONENT__STEP_TIME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__INPUTS:
			case ComponentsPackage.EVENT_BCOMPONENT__OUTPUTS:
			case ComponentsPackage.EVENT_BCOMPONENT__VARIABLES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(CorePackage.Literals.EVENT_BELEMENT__EXTENSIONS,
				 ComponentsFactory.eINSTANCE.createEventBComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__INPUTS,
				 ComponentsFactory.eINSTANCE.createFMUPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__INPUTS,
				 ComponentsFactory.eINSTANCE.createEventBPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__INPUTS,
				 ComponentsFactory.eINSTANCE.createDisplayPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__OUTPUTS,
				 ComponentsFactory.eINSTANCE.createFMUPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__OUTPUTS,
				 ComponentsFactory.eINSTANCE.createEventBPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__OUTPUTS,
				 ComponentsFactory.eINSTANCE.createDisplayPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__VARIABLES,
				 ComponentsFactory.eINSTANCE.createFMUPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__VARIABLES,
				 ComponentsFactory.eINSTANCE.createEventBPort()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__VARIABLES,
				 ComponentsFactory.eINSTANCE.createFMUVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__VARIABLES,
				 ComponentsFactory.eINSTANCE.createEventBVariable()));

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__VARIABLES,
				 ComponentsFactory.eINSTANCE.createDisplayPort()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ComponentsPackage.Literals.COMPONENT__INPUTS ||
			childFeature == ComponentsPackage.Literals.COMPONENT__OUTPUTS ||
			childFeature == ComponentsPackage.Literals.COMPONENT__VARIABLES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
