package com.peniel.bus.vo;
public class PropertyBatch {
	private String property_id;
	private String property_name_text;

	/**
	 * @return the property_id
	 */
	public String getProperty_id() {
		return property_id;
	}

	/**
	 * @param property_id
	 *            the property_id to set
	 */
	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}

	/**
	 * @return the property_name_text
	 */
	public String getProperty_name_text() {
		return property_name_text;
	}

	/**
	 * @param property_name_text
	 *            the property_name_text to set
	 */
	public void setProperty_name_text(String property_name_text) {
		this.property_name_text = property_name_text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((property_id == null) ? 0 : property_id.hashCode());
		result = prime
				* result
				+ ((property_name_text == null) ? 0 : property_name_text
						.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyBatch other = (PropertyBatch) obj;
		if (property_id == null) {
			if (other.property_id != null)
				return false;
		} else if (!property_id.equals(other.property_id))
			return false;
		if (property_name_text == null) {
			if (other.property_name_text != null)
				return false;
		} else if (!property_name_text.equals(other.property_name_text))
			return false;
		return true;
	}

}
