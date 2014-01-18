/**
 * Copyright (c) 2013 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package ac.soton.fmusim.components.impl;

import info.monitorenter.gui.chart.Chart2D;
import info.monitorenter.gui.chart.IAxisScalePolicy;
import info.monitorenter.gui.chart.ITrace2D;
import info.monitorenter.gui.chart.ZoomableChart;
import info.monitorenter.gui.chart.axis.AxisLinear;
import info.monitorenter.gui.chart.labelformatters.LabelFormatterNumber;
import info.monitorenter.gui.chart.traces.Trace2DLtd;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ac.soton.fmusim.components.AbstractVariable;
import ac.soton.fmusim.components.ComponentsPackage;
import ac.soton.fmusim.components.Connector;
import ac.soton.fmusim.components.DisplayComponent;
import ac.soton.fmusim.components.DisplayPort;
import ac.soton.fmusim.components.Port;
import ac.soton.fmusim.components.VariableCausality;
import ac.soton.fmusim.components.VariableType;
import ac.soton.fmusim.components.exceptions.SimulationException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Display Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.fmusim.components.impl.DisplayComponentImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.DisplayComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.DisplayComponentImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.DisplayComponentImpl#getStepPeriod <em>Step Period</em>}</li>
 *   <li>{@link ac.soton.fmusim.components.impl.DisplayComponentImpl#getChart <em>Chart</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisplayComponentImpl extends NamedElementImpl implements DisplayComponent {
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
	protected static final double STEP_PERIOD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStepPeriod() <em>Step Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepPeriod()
	 * @generated
	 * @ordered
	 */
	protected double stepPeriod = STEP_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getChart() <em>Chart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChart()
	 * @generated
	 * @ordered
	 */
	protected static final Chart2D CHART_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChart() <em>Chart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChart()
	 * @generated
	 * @ordered
	 */
	protected Chart2D chart = CHART_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisplayComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.DISPLAY_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.DISPLAY_COMPONENT__INPUTS);
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
			outputs = new EObjectContainmentEList.Resolving<Port>(Port.class, this, ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS);
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
			variables = new EObjectContainmentEList.Resolving<AbstractVariable>(AbstractVariable.class, this, ComponentsPackage.DISPLAY_COMPONENT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStepPeriod() {
		return stepPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepPeriod(double newStepPeriod) {
		double oldStepPeriod = stepPeriod;
		stepPeriod = newStepPeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.DISPLAY_COMPONENT__STEP_PERIOD, oldStepPeriod, stepPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chart2D getChart() {
		return chart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChart(Chart2D newChart) {
		Chart2D oldChart = chart;
		chart = newChart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentsPackage.DISPLAY_COMPONENT__CHART, oldChart, chart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void initialise(double tStart, double tStop) {
		Chart2D chart = getChart();
		assert chart != null;
		int counter = 1;
		
		// remove previous traces
		chart.removeAllTraces();

		// add traces for all connected ports
		for (Port p : getInputs()) {
			assert p instanceof DisplayPort;
			DisplayPort port = (DisplayPort) p;
			
			// get trace colour
			Color color;
			assert port.getColour() != null;
			switch (port.getColour()) {
			case BLUE: color = Color.BLUE; break;
			case RED: color = Color.RED; break;
			case GREEN: color = Color.GREEN; break;
			case ORANGE: color = Color.ORANGE; break;
			case YELLOW: color = Color.YELLOW; break;
			case PINK: color = Color.PINK; break;
			case CYAN: color = Color.CYAN; break;
			default: color = Color.BLUE;
			}
			
			// get plotted signal name either from the port
			// or from a connected output
			String signalName = port.getName();
			if (signalName == null) {
				if (port.getConnector() != null) {
					for (Port pt : port.getConnector().getPorts()) {
						if (pt.getCausality() == VariableCausality.OUTPUT)
							signalName = pt.getName();
					}
				}
			}
			if (signalName == null)
				signalName = "<signal"+(counter++) +">";
			
			// create trace and add to port/chart
		    ITrace2D trace = new Trace2DLtd(300); 
		    trace.setName(signalName);
		    trace.setColor(color);
		    port.setTrace(trace);
		    getChart().addTrace(trace);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void readInputs() throws SimulationException {
		for (Port port : getInputs()) {
			Connector connector = port.getConnector();
			
			// skip port if not connected
			if (connector == null) {
				continue;
			}
			
			// update port value
			Object value = connector.getValue();
			assert value != null;
			port.setValue(value);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void writeOutputs() {
		//XXX: nothing to do here (no outputs in display component)
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void doStep(double time, double step) {
		for (Port p : getInputs()) {
			assert p instanceof DisplayPort;
			DisplayPort port = (DisplayPort) p;
			
			// if port connected, plot the value
			if (port.getConnector() != null) {
				Object value = port.getValue();
				double traceValue = 0;
				if (port.getType() == VariableType.REAL) {
					traceValue = ((Double) value).doubleValue();
				} else if (port.getType() == VariableType.INTEGER) {
					traceValue = ((Integer) value).intValue();
				} else if (port.getType() == VariableType.BOOLEAN) {
					traceValue = ((Boolean) value).booleanValue() ? 1 : 0;
				}
				
				assert port.getTrace() != null;
				port.getTrace().addPoint(time, traceValue);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void terminate() {
		//XXX: do nothing
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void instantiate() throws SimulationException {
		if (getChart() == null) {
			@SuppressWarnings("serial")
			Chart2D chart = new ZoomableChart() {
				long lastClickTime;
				@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getWhen() - lastClickTime < 500)
					this.zoomAll();
				lastClickTime = e.getWhen();
			}};
			
			// remove original axes
		    chart.removeAxisXBottom(chart.getAxisX());
		    chart.removeAxisYLeft(chart.getAxisY());
		    
		    // empty label formatter
		    @SuppressWarnings("serial")
			LabelFormatterNumber lf = new LabelFormatterNumber(NumberFormat.getIntegerInstance()) {
		    	@Override
		    	public String format(double value) {
		    		return "0";
		    	}
		    };
		    
		    // set new axes
		    chart.addAxisXBottom(new AxisLinear<IAxisScalePolicy>(new LabelFormatterNumber(NumberFormat.getIntegerInstance())));
		    chart.setAxisYLeft(new AxisLinear<IAxisScalePolicy>(new LabelFormatterNumber(NumberFormat.getIntegerInstance())), 0);
		    chart.setAxisYRight(new AxisLinear<IAxisScalePolicy>(lf), 0);
		    chart.setAxisXTop(new AxisLinear<IAxisScalePolicy>(lf), 0);
		    
		    chart.getAxisX().setPaintGrid(true);
		    chart.getAxisY().setPaintGrid(true);
		    chart.getAxisX().getAxisTitle().setTitle("");
		    chart.getAxisY().getAxisTitle().setTitle("");
		    chart.setGridColor(new Color(224,224,224));
		    chart.setVisible(false);
			setChart(chart);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
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
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				return getInputs();
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				return getOutputs();
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				return getVariables();
			case ComponentsPackage.DISPLAY_COMPONENT__STEP_PERIOD:
				return getStepPeriod();
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				return getChart();
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
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends Port>)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends AbstractVariable>)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__STEP_PERIOD:
				setStepPeriod((Double)newValue);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				setChart((Chart2D)newValue);
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
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				getInputs().clear();
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				getOutputs().clear();
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				getVariables().clear();
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__STEP_PERIOD:
				setStepPeriod(STEP_PERIOD_EDEFAULT);
				return;
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				setChart(CHART_EDEFAULT);
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
			case ComponentsPackage.DISPLAY_COMPONENT__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case ComponentsPackage.DISPLAY_COMPONENT__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case ComponentsPackage.DISPLAY_COMPONENT__VARIABLES:
				return variables != null && !variables.isEmpty();
			case ComponentsPackage.DISPLAY_COMPONENT__STEP_PERIOD:
				return stepPeriod != STEP_PERIOD_EDEFAULT;
			case ComponentsPackage.DISPLAY_COMPONENT__CHART:
				return CHART_EDEFAULT == null ? chart != null : !CHART_EDEFAULT.equals(chart);
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
		result.append(", chart: ");
		result.append(chart);
		result.append(')');
		return result.toString();
	}

} //DisplayComponentImpl
