package org.soluvas.data;

import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public interface PropertyDefinitionRepository {

	/**
	 * Find all {@link PropertyDefinition}, with overrides applied from specific {@code tenantId}.
	 * @param tenantId
	 * @return
	 */
	ImmutableList<PropertyDefinition> findAllByTenantId(String tenantId);

	PropertyDefinition findOneByTenantId(String tenantId, String id)
			throws EntityLookupException;

	/**
	 * Find recommended {@link PropertyDefinition}s by specific category(s).
	 * @param tenantId
	 * @param categoryIds Multiple, because a product can have multiple categories.
	 * @return
	 */
	ImmutableList<PropertyDefinition> findRecommendedByTenantIdAndCategories(
			String tenantId, Set<String> categoryIds);

	ImmutableMap<String, PropertyDefinition> getTenantOverrides(String tenantId);

	ImmutableMap<String, PropertyDefinition> getCategoryOverrides(
			String tenantId, String categoryId);

	void setTenantOverrides(String tenantId,
			ImmutableMap<String, PropertyDefinition> overrides);

	void setCategoryOverrides(String tenantId, String categoryId,
			ImmutableMap<String, PropertyDefinition> overrides);

}