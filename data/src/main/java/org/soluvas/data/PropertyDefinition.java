package org.soluvas.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 
 * @author rudi
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="@type", defaultImpl=PropertyDefinition.class)
@JsonSubTypes(@JsonSubTypes.Type(name="PropertyDefinition", value=PropertyDefinition.class))
public class PropertyDefinition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final static String NAME_ATTR = "name";
	public final static String DESCRIPTION_ATTR = "description";
	
	private String id;
	private String description;
	private Integer positioner;
	private String name;
	private Boolean enabled;
	private Long minValues;
	private Long maxValues;
	private String dataTypeName;
	private PropertyKind defaultKind;
	private String defaultEnum;
	private String defaultQuantity;
	private Unit<?> defaultUnit;
	private Boolean usableAsOption;
	private Boolean visibleInSimple;
	private Boolean searchableInQuick;
	private String imageId;
	private Integer fieldWidth;
	private String primaryUri;
	private Locale language;
	private final Set<String> sameAsUris = new HashSet<>();
	private final Map<String, Map<String, String>> translations = new HashMap<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPositioner() {
		return positioner;
	}
	public void setPositioner(Integer positioner) {
		this.positioner = positioner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getMinValues() {
		return minValues;
	}
	public void setMinValues(Long minValues) {
		this.minValues = minValues;
	}
	public Long getMaxValues() {
		return maxValues;
	}
	public void setMaxValues(Long maxValues) {
		this.maxValues = maxValues;
	}
	public String getDataTypeName() {
		return dataTypeName;
	}
	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}
	public PropertyKind getDefaultKind() {
		return defaultKind;
	}
	public void setDefaultKind(PropertyKind defaultKind) {
		this.defaultKind = defaultKind;
	}
	public String getDefaultEnum() {
		return defaultEnum;
	}
	public void setDefaultEnum(String defaultEnum) {
		this.defaultEnum = defaultEnum;
	}
	
	public String getDefaultQuantity() {
		return defaultQuantity;
	}
	public void setDefaultQuantity(String defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}
	
	@Nullable
	@JsonIgnore
	public Class<? extends Quantity> getDefaultQuantityClass() {
		if (getDefaultQuantity() != null) {
			final String className = "javax.measure.quantity." + getDefaultQuantity();
			try {
				return (Class<? extends Quantity>) 
					PropertyDefinition.class.getClassLoader().loadClass(className);
			} catch (ClassNotFoundException e) {
				throw new DataException("Cannot load quantity class " + className, e);
			}
		} else {
			return null;
		}
	}
	
	public Unit<?> getDefaultUnit() {
		return defaultUnit;
	}
	public void setDefaultUnit(Unit<?> defaultUnit) {
		this.defaultUnit = defaultUnit;
	}
	
	/**
	 * In root, tenant, {@link org.soluvas.category.FormalCategory}, and {@link org.soluvas.category.Category} layers,
	 * this determines whether when creating a new Product, this property will be suggested as Option Type.
	 * Inside product, this marks the property as option, which means its value is mandatory.
	 * @return
	 */
	public Boolean getUsableAsOption() {
		return usableAsOption;
	}
	public void setUsableAsOption(Boolean usableAsOption) {
		this.usableAsOption = usableAsOption;
	}
	
	public Boolean getVisibleInSimple() {
		return visibleInSimple;
	}
	public void setVisibleInSimple(Boolean visibleInSimple) {
		this.visibleInSimple = visibleInSimple;
	}
	public Boolean getSearchableInQuick() {
		return searchableInQuick;
	}
	public void setSearchableInQuick(Boolean searchableInQuick) {
		this.searchableInQuick = searchableInQuick;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public Integer getFieldWidth() {
		return fieldWidth;
	}
	public void setFieldWidth(Integer fieldWidth) {
		this.fieldWidth = fieldWidth;
	}
	public String getPrimaryUri() {
		return primaryUri;
	}
	public void setPrimaryUri(String primaryUri) {
		this.primaryUri = primaryUri;
	}
	public Set<String> getSameAsUris() {
		return sameAsUris;
	}
	
	/**
	 * Key: {languageTag}, e.g. {@code en-US}, {@code id-ID}. 
	 */
	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}
	
	/**
	 * Current language. When first loaded, this will be the original language.
	 * After translation, this will be the translated language.
	 * @return
	 */
	public Locale getLanguage() {
		return language;
	}
	public void setLanguage(Locale language) {
		this.language = language;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PropertyDefinition [id=" + id + ", description=" + description
				+ ", positioner=" + positioner + ", name=" + name
				+ ", enabled=" + enabled + ", minValues=" + minValues
				+ ", maxValues=" + maxValues + ", dataTypeName=" + dataTypeName
				+ ", defaultKind=" + defaultKind + ", defaultEnum="
				+ defaultEnum + ", defaultQuantity=" + defaultQuantity
				+ ", defaultUnit=" + defaultUnit + ", usableAsOption="
				+ usableAsOption + ", visibleInSimple=" + visibleInSimple
				+ ", searchableInQuick=" + searchableInQuick + ", imageId="
				+ imageId + ", fieldWidth=" + fieldWidth + ", primaryUri="
				+ primaryUri + ", language=" + language + ", sameAsUris="
				+ sameAsUris + ", translations=" + translations + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PropertyDefinition other = (PropertyDefinition) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
