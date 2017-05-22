package org.soluvas.data.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OptionTypeCatalog implements Serializable {
	protected static final String TERM_KEY_EDEFAULT = null;

	protected String termKey = TERM_KEY_EDEFAULT;

	protected OptionType optionType;

	protected OptionTypeCatalog child;

	public OptionTypeCatalog() {
		super();
	}

	public String getTermKey() {
		return termKey;
	}

	public void setTermKey(String newTermKey) {
		termKey = newTermKey;
	}

	public OptionType getOptionType() {
		return optionType;
	}

	public OptionType basicGetOptionType() {
		return optionType;
	}

	public void setOptionType(OptionType newOptionType) {
		optionType = newOptionType;
	}

	public OptionTypeCatalog getChild() {
		return child;
	}

	public OptionTypeCatalog basicGetChild() {
		return child;
	}

	public void setChild(OptionTypeCatalog newChild) {
		child = newChild;
	}

	@Override
	public String toString() {

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (termKey: ");
		result.append(termKey);
		result.append(')');
		return result.toString();
	}

} //OptionTypeCatalog
