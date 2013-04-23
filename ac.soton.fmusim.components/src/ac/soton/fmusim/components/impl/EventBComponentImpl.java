/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.EventBComponent;

import ac.soton.fmusim.components.util.ComponentsValidator;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.AbstractExtension;
import org.eventb.emf.core.Annotation;
import org.eventb.emf.core.Attribute;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.impl.StringToAttributeMapEntryImpl;
import org.eventb.emf.core.machine.Machine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BComponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#isGenerated <em>Generated</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#isLocalGenerated <em>Local Generated</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getExtensionId <em>Extension Id</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#isComposed <em>Composed</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getTimeVariableName <em>Time Variable Name</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.EventBComponentImpl#getMachine <em>Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventBComponentImpl extends ComponentImpl implements EventBComponent {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractExtension> extensions;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Attribute> attributes;

	/**
	 * The default value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected String reference = REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGenerated() <em>Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isLocalGenerated() <em>Local Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalGenerated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_GENERATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocalGenerated() <em>Local Generated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalGenerated()
	 * @generated
	 * @ordered
	 */
	protected boolean localGenerated = LOCAL_GENERATED_EDEFAULT;

	/**
	 * This is true if the Local Generated attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean localGeneratedESet;

	/**
	 * The default value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String EXTENSION_ID_EDEFAULT = ComponentsPackage.EVENTB_COMPONENT_EXTENSION_ID;

	/**
	 * The cached value of the '{@link #getExtensionId() <em>Extension Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionId()
	 * @generated
	 * @ordered
	 */
	protected String extensionId = EXTENSION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPOSED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComposed() <em>Composed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComposed()
	 * @generated
	 * @ordered
	 */
	protected boolean composed = COMPOSED_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeVariableName() <em>Time Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeVariableName() <em>Time Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeVariableName()
	 * @generated
	 * @ordered
	 */
	protected String timeVariableName = TIME_VARIABLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected Machine machine;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.EVENT_BCOMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentWithInverseEList<Annotation>(Annotation.class, this, ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS, CorePackage.ANNOTATION__EVENT_BOBJECT);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractExtension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList.Resolving<AbstractExtension>(AbstractExtension.class, this, ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EcoreEMap<String,Attribute>(CorePackage.Literals.STRING_TO_ATTRIBUTE_MAP_ENTRY, StringToAttributeMapEntryImpl.class, this, ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(String newReference) {
		String oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGenerated() {
		// TODO: implement this method to return the 'Generated' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerated(boolean newGenerated) {
		// TODO: implement this method to set the 'Generated' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLocalGenerated() {
		return localGenerated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalGenerated(boolean newLocalGenerated) {
		boolean oldLocalGenerated = localGenerated;
		localGenerated = newLocalGenerated;
		boolean oldLocalGeneratedESet = localGeneratedESet;
		localGeneratedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED, oldLocalGenerated, localGenerated, !oldLocalGeneratedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocalGenerated() {
		boolean oldLocalGenerated = localGenerated;
		boolean oldLocalGeneratedESet = localGeneratedESet;
		localGenerated = LOCAL_GENERATED_EDEFAULT;
		localGeneratedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED, oldLocalGenerated, LOCAL_GENERATED_EDEFAULT, oldLocalGeneratedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocalGenerated() {
		return localGeneratedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtensionId() {
		return extensionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionId(String newExtensionId) {
		String oldExtensionId = extensionId;
		extensionId = newExtensionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID, oldExtensionId, extensionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposed() {
		return composed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComposed(boolean newComposed) {
		boolean oldComposed = composed;
		composed = newComposed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__COMPOSED, oldComposed, composed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeVariableName() {
		return timeVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeVariableName(String newTimeVariableName) {
		String oldTimeVariableName = timeVariableName;
		timeVariableName = newTimeVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME, oldTimeVariableName, timeVariableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine getMachine() {
		if (machine != null && machine.eIsProxy()) {
			InternalEObject oldMachine = (InternalEObject)machine;
			machine = (Machine)eResolveProxy(oldMachine);
			if (machine != oldMachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComponentsPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
			}
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Machine basicGetMachine() {
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMachine(Machine newMachine) {
		Machine oldMachine = machine;
		machine = newMachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.EVENT_BCOMPONENT__MACHINE, oldMachine, machine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Event-B Component must have a valid reference to an existing machine.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasValidMachineReference(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		
		// get method to retrieve a machine with a proxy resolution
		Machine m = getMachine();
		
		// error if still null or proxy unresolved
		if (m == null || m.eIsProxy()) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ComponentsValidator.DIAGNOSTIC_SOURCE,
						 ComponentsValidator.EVENT_BCOMPONENT__HAS_VALID_MACHINE_REFERENCE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "hasValidMachineReference", EObjectValidator.getObjectLabel(this, context) }),
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
	public String getReferenceWithoutResolving() {
		if (this.eIsProxy()){
			return ((InternalEObject)this).eProxyURI().fragment();
		}else{
			return reference;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void doSetReference(String newReference) {
		if (this.eIsProxy()){
			((InternalEObject)this).eProxyURI().appendFragment(newReference);
		}else{
			reference = newReference;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBObject getContaining(EClass eClass) {
		EventBObject bObject = this;
		while (!eClass.isSuperTypeOf(bObject.eClass()))
			if (bObject.eContainer() instanceof EventBObject) bObject=(EventBObject)bObject.eContainer();
			else return null;
		return bObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getAllContained(EClass eClass, boolean resolve) {
		EList<EObject> typeObjects = new BasicEList<EObject>();
		typeObjects.add(null);	//include the null object
		for (TreeIterator<EObject>trit = EcoreUtil.getAllContents(this, resolve); trit.hasNext();){
			EObject o = trit.next();
			if (eClass.isSuperTypeOf(o.eClass())) typeObjects.add(o);
		}
		return typeObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI getURI() {
		if (eIsProxy()){
			return ((InternalEObject)this).eProxyURI();
		}else{
			return eResource().getURI();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation getAnnotation(String source) {
		for (Annotation annotation : getAnnotations()){
			if (source.equals(annotation.getSource())) return annotation;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAnnotations()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS:
				return getAnnotations();
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS:
				return getExtensions();
			case ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES:
				if (coreType) return getAttributes();
				else return getAttributes().map();
			case ComponentsPackage.EVENT_BCOMPONENT__REFERENCE:
				return getReference();
			case ComponentsPackage.EVENT_BCOMPONENT__GENERATED:
				return isGenerated();
			case ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED:
				return isLocalGenerated();
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID:
				return getExtensionId();
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return isComposed();
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				return getTimeVariableName();
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				if (resolve) return getMachine();
				return basicGetMachine();
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
			case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends AbstractExtension>)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES:
				((EStructuralFeature.Setting)getAttributes()).set(newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__REFERENCE:
				setReference((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__GENERATED:
				setGenerated((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED:
				setLocalGenerated((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID:
				setExtensionId((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed((Boolean)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				setTimeVariableName((String)newValue);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)newValue);
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
			case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS:
				getExtensions().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__GENERATED:
				setGenerated(GENERATED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED:
				unsetLocalGenerated();
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID:
				setExtensionId(EXTENSION_ID_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				setComposed(COMPOSED_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				setTimeVariableName(TIME_VARIABLE_NAME_EDEFAULT);
				return;
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				setMachine((Machine)null);
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
			case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ComponentsPackage.EVENT_BCOMPONENT__REFERENCE:
				return REFERENCE_EDEFAULT == null ? reference != null : !REFERENCE_EDEFAULT.equals(reference);
			case ComponentsPackage.EVENT_BCOMPONENT__GENERATED:
				return isGenerated() != GENERATED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED:
				return isSetLocalGenerated();
			case ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID:
				return EXTENSION_ID_EDEFAULT == null ? extensionId != null : !EXTENSION_ID_EDEFAULT.equals(extensionId);
			case ComponentsPackage.EVENT_BCOMPONENT__COMPOSED:
				return composed != COMPOSED_EDEFAULT;
			case ComponentsPackage.EVENT_BCOMPONENT__TIME_VARIABLE_NAME:
				return TIME_VARIABLE_NAME_EDEFAULT == null ? timeVariableName != null : !TIME_VARIABLE_NAME_EDEFAULT.equals(timeVariableName);
			case ComponentsPackage.EVENT_BCOMPONENT__MACHINE:
				return machine != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EObject.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EventBObject.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS: return CorePackage.EVENT_BOBJECT__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == EventBElement.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS: return CorePackage.EVENT_BELEMENT__EXTENSIONS;
				case ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES: return CorePackage.EVENT_BELEMENT__ATTRIBUTES;
				case ComponentsPackage.EVENT_BCOMPONENT__REFERENCE: return CorePackage.EVENT_BELEMENT__REFERENCE;
				case ComponentsPackage.EVENT_BCOMPONENT__GENERATED: return CorePackage.EVENT_BELEMENT__GENERATED;
				case ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED: return CorePackage.EVENT_BELEMENT__LOCAL_GENERATED;
				default: return -1;
			}
		}
		if (baseClass == AbstractExtension.class) {
			switch (derivedFeatureID) {
				case ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID: return CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EObject.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == EventBObject.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BOBJECT__ANNOTATIONS: return ComponentsPackage.EVENT_BCOMPONENT__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == EventBElement.class) {
			switch (baseFeatureID) {
				case CorePackage.EVENT_BELEMENT__EXTENSIONS: return ComponentsPackage.EVENT_BCOMPONENT__EXTENSIONS;
				case CorePackage.EVENT_BELEMENT__ATTRIBUTES: return ComponentsPackage.EVENT_BCOMPONENT__ATTRIBUTES;
				case CorePackage.EVENT_BELEMENT__REFERENCE: return ComponentsPackage.EVENT_BCOMPONENT__REFERENCE;
				case CorePackage.EVENT_BELEMENT__GENERATED: return ComponentsPackage.EVENT_BCOMPONENT__GENERATED;
				case CorePackage.EVENT_BELEMENT__LOCAL_GENERATED: return ComponentsPackage.EVENT_BCOMPONENT__LOCAL_GENERATED;
				default: return -1;
			}
		}
		if (baseClass == AbstractExtension.class) {
			switch (baseFeatureID) {
				case CorePackage.ABSTRACT_EXTENSION__EXTENSION_ID: return ComponentsPackage.EVENT_BCOMPONENT__EXTENSION_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (reference: ");
		result.append(reference);
		result.append(", localGenerated: ");
		if (localGeneratedESet) result.append(localGenerated); else result.append("<unset>");
		result.append(", extensionId: ");
		result.append(extensionId);
		result.append(", composed: ");
		result.append(composed);
		result.append(", timeVariableName: ");
		result.append(timeVariableName);
		result.append(')');
		return result.toString();
	}

} //EventBComponentImpl
