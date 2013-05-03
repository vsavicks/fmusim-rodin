/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUInternalVariable;
import ac.soton.fmusim.components.util.ComponentsValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getFmu <em>Fmu</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FMUComponentImpl extends ComponentImpl implements FMUComponent {
	/**
	 * The default value of the '{@link #getFmu() <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmu()
	 * @generated
	 * @ordered
	 */
	protected static final Object FMU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFmu() <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmu()
	 * @generated
	 * @ordered
	 */
	protected Object fmu = FMU_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<FMUInternalVariable> variables;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FMUComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.FMU_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getFmu() {
		return fmu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmu(Object newFmu) {
		Object oldFmu = fmu;
		fmu = newFmu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.FMU_COMPONENT__FMU, oldFmu, fmu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMUInternalVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList.Resolving<FMUInternalVariable>(FMUInternalVariable.class, this, ComponentsPackage.FMU_COMPONENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.FMU_COMPONENT__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * FMU Component path must be a valid .fmu path.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasValidFmuPath(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		
		String p = getPath();
		if (p == null || new File(p).exists() == false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ComponentsValidator.DIAGNOSTIC_SOURCE,
						 ComponentsValidator.FMU_COMPONENT__HAS_VALID_FMU_PATH,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "hasValidFmuPath", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentsPackage.FMU_COMPONENT__FMU:
				return getFmu();
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				return getVariables();
			case ComponentsPackage.FMU_COMPONENT__PATH:
				return getPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentsPackage.FMU_COMPONENT__FMU:
				setFmu(newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends FMUInternalVariable>)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__PATH:
				setPath((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentsPackage.FMU_COMPONENT__FMU:
				setFmu(FMU_EDEFAULT);
				return;
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				getVariables().clear();
				return;
			case ComponentsPackage.FMU_COMPONENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentsPackage.FMU_COMPONENT__FMU:
				return FMU_EDEFAULT == null ? fmu != null : !FMU_EDEFAULT.equals(fmu);
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ComponentsPackage.FMU_COMPONENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fmu: ");
		result.append(fmu);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //FMUComponentImpl
