/**
 */
package org.soluvas.data;

import com.google.common.base.CaseFormat;

/**
 * @deprecated Daftar enumeration langsung dibaca dari file JSONLD aja. Khusus beberapa enumeration yang umum dipakai
 * 		seperti Color dan ApparelSize, dibikinkan constant. ~Hendy
 */
@Deprecated
public enum TermKind {
	/**
	 * The '<em><b>Color</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLOR_VALUE
	 * @generated
	 * @ordered
	 */
	COLOR("Color", true),

	/**
	 * The '<em><b>Apparel size</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPAREL_SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	APPAREL_SIZE("Apparel size", false),

	/**
	 * The '<em><b>Shoe size</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOE_SIZE_VALUE
	 * @generated
	 * @ordered
	 */
	SHOE_SIZE("Shoe size", false);
	
	private String displayName;
	
	/**
	 * Bisa nambah sendiri, untuk sekarang COLOR saja
	 */
	private Boolean expandable;
	
	private TermKind(String displayName, Boolean expandable) {
		this.displayName = displayName;
		this.expandable = expandable;
	}
	
	public Boolean getExpandable() {
		return expandable;
	}

	public String getId() {
		return name();
	}
	
	public String getEnumerationId() {
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name());
	}
	
	public String getName() {
		return displayName;
	}
	
	// TODO: nanti ada translation juga, tapi ya di object yang di JSONLD ~Hendy 
	
} //TermKind
