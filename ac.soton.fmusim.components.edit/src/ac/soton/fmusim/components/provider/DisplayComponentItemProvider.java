/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
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

import ac.soton.fmusim.components.ComponentsFactory;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.DisplayComponent;

/**
 * This is the item provider adapter for a {@link ac.soton.fmusim.components.DisplayComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DisplayComponentItemProvider
	extends NamedElementItemProvider
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
	public DisplayComponentItemProvider(AdapterFactory adapterFactory) {
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

			addStepPeriodPropertyDescriptor(object);
			addChartPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				 getString("_UI_Component_stepPeriod_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Component_stepPeriod_feature", "_UI_Component_type"),
				 ComponentsPackage.Literals.COMPONENT__STEP_PERIOD,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Chart feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addChartPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_DisplayComponent_chart_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_DisplayComponent_chart_feature", "_UI_DisplayComponent_type"),
				 ComponentsPackage.Literals.DISPLAY_COMPONENT__CHART,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
	 * This returns DisplayComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DisplayComponent"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DisplayComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_DisplayComponent_type") :
			getString("_UI_DisplayComponent_type") + " " + label;
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

		switch (notification.getFeatureID(DisplayComponent.class)) {
			case ComponentsPackage.DISPLAY_COMPONENT__STEP_PERIOD:
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
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

		newChildDescriptors.add
			(createChildParameter
				(ComponentsPackage.Literals.COMPONENT__VARIABLES,
				 ComponentsFactory.eINSTANCE.createFMUParameter()));
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
