/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.fmusim.components.impl;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
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

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.FMUComponent;
import ac.soton.fmusim.components.FMUParameter;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.exceptions.ModelException;
import ac.soton.fmusim.components.exceptions.SimulationException;
import ac.soton.fmusim.components.util.ComponentsValidator;
import de.prob.cosimulation.FMU;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FMU Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getFmu <em>Fmu</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getPath <em>Path</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.FMUComponentImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FMUComponentImpl extends NamedElementImpl implements FMUComponent {
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.##########");

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputs;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractVariable> variables;

	/**
	 * The default value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected static final long STEP_PERIOD_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected long stepPeriod = STEP_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getFmu() <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmu()
	 * @generated
	 * @ordered
	 */
	protected static final FMU FMU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFmu() <em>Fmu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFmu()
	 * @generated
	 * @ordered
	 */
	protected FMU fmu = FMU_EDEFAULT;

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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<FMUParameter> parameters;

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
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.FMU_COMPONENT__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.FMU_COMPONENT__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractVariable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList.Resolving<AbstractVariable>(AbstractVariable.class, this, ComponentsPackage.FMU_COMPONENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStepPeriod() {
		return stepPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepPeriod(long newStepPeriod) {
		long oldStepPeriod = stepPeriod;
		stepPeriod = newStepPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.FMU_COMPONENT__STEP_PERIOD, oldStepPeriod, stepPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FMU getFmu() {
		return fmu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFmu(FMU newFmu) {
		FMU oldFmu = fmu;
		fmu = newFmu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.FMU_COMPONENT__FMU, oldFmu, fmu));
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FMUParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList.Resolving<FMUParameter>(FMUParameter.class, this, ComponentsPackage.FMU_COMPONENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * FMU Component path must be a valid .fmu path.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasValidFmuPath(DiagnosticChain diagnostics, Map<Object, Object> context) {
		//XXX skip if path is null (treated by non-null validation constraint)
		String p = getPath();
		if (p != null && new File(p).exists() == false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ComponentsValidator.DIAGNOSTIC_SOURCE,
						 ComponentsValidator.FMU_COMPONENT__HAS_VALID_FMU_PATH,
						//TODO: use external string resource and a default approach, i.e. EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {...
						 MessageFormat.format("Component ''{0}'' must have a valid FMU path", new Object[] { this.getName() }),	
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void instantiate() throws SimulationException {
		// reuse FMU if possible
		if (fmu != null) {
			fmu.reset();
		} else {
			try {
				setFmu(new FMU(getPath()));
			} catch (IOException e) {
				throw new SimulationException("Failed to load FMU: "+ getPath() + '\n' + e.getMessage());
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialise(long tStart, long tStop) {
		FMU fmu = getFmu();
		assert fmu != null;
		
		// initialise parameters that have non-default values
		for (FMUParameter par : getParameters()) {
			if (!par.getStartValue().equals(par.getDefaultValue()))
				setValueFMU(fmu, par, par.getStartValue());
		}
		
		// initialise FMU
		fmu.initialize(tStart/1000f, tStop/1000f);
		
		// update variables
		for (AbstractVariable v : getVariables())
			v.setValue(getValueFMU(fmu, v));
		for (Port p : getInputs())
			p.setValue(getValueFMU(fmu, p));
		for (Port p : getOutputs())
			p.setValue(getValueFMU(fmu, p));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void readInputs() {
		FMU fmu = getFmu();
		assert fmu != null;
		
		for (Port port : getInputs()) {
			Connector connector = port.getIn();
			
			// skip port if not connected
			if (connector == null) {
				continue;
			}
			
			// set value to port's FMU variable
			Object value = connector.getValue();
			setValueFMU(fmu, port, value);
			
			// update port value
			port.setValue(value);
		}
	}

	/**
	 * Sets value to FMU variable.
	 * 
	 * @param fmu
	 * @param port
	 * @param value
	 * @return
	 */
	private void setValueFMU(FMU fmu, AbstractVariable variable, Object value) {
		String name = variable.getName();
		switch (variable.getType()) {
		case BOOLEAN:
			fmu.set(name, (Boolean) value);
			break;
		case INTEGER:
			fmu.set(name, (Integer) value);
			break;
		case REAL:
			fmu.set(name, (Double) value);
			break;
		case STRING:
			fmu.set(name, (String) value);
			break;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void writeOutputs() {
		FMU fmu = getFmu();
		assert fmu != null;
		
		for (Port port : getOutputs()) {
			Object value = getValueFMU(fmu, port);
			
			// send value to connector if connected
			for (Connector c : port.getOut()) {
				c.setValue(value);
			}
			
			// update port value
			port.setValue(value);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void doStep(long time, long step) {
		FMU fmu = getFmu();
		assert fmu != null;
		
//		//XXX: time fix
//		double rem = Math.IEEEremainder(time, 0.00000001);
//		if (rem > 0) {
//			time = Double.parseDouble(DECIMAL_FORMAT.format(time));
//		}
		
		// simulation step
		fmu.doStep(time/1000f, step);
		
		// update variables
		for (AbstractVariable v : getVariables())
			v.setValue(getValueFMU(fmu, v));
	}

	/**
	 * Returns FMU variable's value.
	 * 
	 * @param fmu
	 * @param variable
	 * @return
	 */
	private Object getValueFMU(FMU fmu, AbstractVariable variable) {
		String name = variable.getName();
		Object value = null;
		switch (variable.getType()) {
		case BOOLEAN:
			value  = fmu.getBoolean(name) == false; //XXX: hack to fix the bug with JFMI (returns negated value of actual boolean value)
			break;
		case INTEGER:
			value = fmu.getInt(name);
			break;
		case REAL:
			value = fmu.getDouble(name);
			break;
		case STRING:
			value = fmu.getString(name);
			break;
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void terminate() {
		//FIXME: termination causes JVM to fail (invalid memory access)
//		FMU fmu = getFmu();
//		assert fmu != null;
//		
//		fmu.terminate();
//		setFmu(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.FMU_COMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.FMU_COMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.FMU_COMPONENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case ComponentsPackage.FMU_COMPONENT__INPUTS:
				return getInputs();
			case ComponentsPackage.FMU_COMPONENT__OUTPUTS:
				return getOutputs();
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				return getVariables();
			case ComponentsPackage.FMU_COMPONENT__STEP_PERIOD:
				return getStepPeriod();
			case ComponentsPackage.FMU_COMPONENT__FMU:
				return getFmu();
			case ComponentsPackage.FMU_COMPONENT__PATH:
				return getPath();
			case ComponentsPackage.FMU_COMPONENT__PARAMETERS:
				return getParameters();
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
			case ComponentsPackage.FMU_COMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__STEP_PERIOD:
				setStepPeriod((Long)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__FMU:
				setFmu((FMU)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__PATH:
				setPath((String)newValue);
				return;
			case ComponentsPackage.FMU_COMPONENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends FMUParameter>)newValue);
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
			case ComponentsPackage.FMU_COMPONENT__INPUTS:
				getInputs().clear();
				return;
			case ComponentsPackage.FMU_COMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				getVariables().clear();
				return;
			case ComponentsPackage.FMU_COMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
				return;
			case ComponentsPackage.FMU_COMPONENT__FMU:
				setFmu(FMU_EDEFAULT);
				return;
			case ComponentsPackage.FMU_COMPONENT__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case ComponentsPackage.FMU_COMPONENT__PARAMETERS:
				getParameters().clear();
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
			case ComponentsPackage.FMU_COMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ComponentsPackage.FMU_COMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ComponentsPackage.FMU_COMPONENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ComponentsPackage.FMU_COMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
			case ComponentsPackage.FMU_COMPONENT__FMU:
				return FMU_EDEFAULT == null ? fmu != null : !FMU_EDEFAULT.equals(fmu);
			case ComponentsPackage.FMU_COMPONENT__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case ComponentsPackage.FMU_COMPONENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
		result.append(" (stepPeriod: ");
		result.append(stepPeriod);
		result.append(", fmu: ");
		result.append(fmu);
		result.append(", path: ");
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //FMUComponentImpl
