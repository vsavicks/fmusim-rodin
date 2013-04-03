/**
 */
package ac.soton.fmusim.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Fmi Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see ac.soton.fmusim.components.ComponentsPackage#getFmiTypes()
 * @model
 * @generated
 */
public enum FmiTypes implements Enumerator {
	/**
	 * The '<em><b>Fmi Real</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FMI_REAL_VALUE
	 * @generated
	 * @ordered
	 */
	FMI_REAL(2, "fmiReal", "fmiReal"),

	/**
	 * The '<em><b>Fmi Integer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FMI_INTEGER_VALUE
	 * @generated
	 * @ordered
	 */
	FMI_INTEGER(3, "fmiInteger", "fmiInteger"),

	/**
	 * The '<em><b>Fmi Boolean</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FMI_BOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	FMI_BOOLEAN(4, "fmiBoolean", "fmiBoolean"),

	/**
	 * The '<em><b>Fmi String</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FMI_STRING_VALUE
	 * @generated
	 * @ordered
	 */
	FMI_STRING(5, "fmiString", "fmiString");

	/**
	 * The '<em><b>Fmi Real</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fmi Real</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FMI_REAL
	 * @model name="fmiReal"
	 * @generated
	 * @ordered
	 */
	public static final int FMI_REAL_VALUE = 2;

	/**
	 * The '<em><b>Fmi Integer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fmi Integer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FMI_INTEGER
	 * @model name="fmiInteger"
	 * @generated
	 * @ordered
	 */
	public static final int FMI_INTEGER_VALUE = 3;

	/**
	 * The '<em><b>Fmi Boolean</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fmi Boolean</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FMI_BOOLEAN
	 * @model name="fmiBoolean"
	 * @generated
	 * @ordered
	 */
	public static final int FMI_BOOLEAN_VALUE = 4;

	/**
	 * The '<em><b>Fmi String</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fmi String</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FMI_STRING
	 * @model name="fmiString"
	 * @generated
	 * @ordered
	 */
	public static final int FMI_STRING_VALUE = 5;

	/**
	 * An array of all the '<em><b>Fmi Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FmiTypes[] VALUES_ARRAY =
		new FmiTypes[] {
			FMI_REAL,
			FMI_INTEGER,
			FMI_BOOLEAN,
			FMI_STRING,
		};

	/**
	 * A public read-only list of all the '<em><b>Fmi Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FmiTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fmi Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FmiTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FmiTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fmi Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FmiTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FmiTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fmi Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FmiTypes get(int value) {
		switch (value) {
			case FMI_REAL_VALUE: return FMI_REAL;
			case FMI_INTEGER_VALUE: return FMI_INTEGER;
			case FMI_BOOLEAN_VALUE: return FMI_BOOLEAN;
			case FMI_STRING_VALUE: return FMI_STRING;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private FmiTypes(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //FmiTypes
