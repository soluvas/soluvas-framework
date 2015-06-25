package org.soluvas.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

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
public class PropertyDefinition {

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
	private Class<? extends Quantity> defaultQuantity;
	private Unit<?> defaultUnit;
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
	public Class<? extends Quantity> getDefaultQuantity() {
		return defaultQuantity;
	}
	public void setDefaultQuantity(Class<? extends Quantity> defaultQuantity) {
		this.defaultQuantity = defaultQuantity;
	}
	public Unit<?> getDefaultUnit() {
		return defaultUnit;
	}
	public void setDefaultUnit(Unit<?> defaultUnit) {
		this.defaultUnit = defaultUnit;
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
	
}
