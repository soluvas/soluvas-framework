package org.soluvas.category;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CategoryInfo2;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.Translation;
import org.soluvas.commons.TranslationState;
import org.soluvas.commons.mongo.DateTimeConverter;
import org.soluvas.commons.mongo.UnitConverter;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.PropertyDefinition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.code.morphia.annotations.Converters;
import com.google.code.morphia.annotations.Id;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author rudi
 *
 */
@Converters({DateTimeConverter.class, UnitConverter.class})
public class Category2 implements Serializable, Identifiable {
	
	private static final long serialVersionUID = 1L;
	
	public static final long CURRENT_SCHEMA_VERSION = 2l;
	
	private static final Logger log = LoggerFactory.getLogger(Category2.class);
	
	public final static String NAME_ATTR = "name";
	public final static String DESCRIPTION_ATTR = "description";
	public final static String META_TITLE_ATTR = "metaTitle";
	public final static String META_KEYWORDS_ATTR = "metaKeywords";
	public final static String META_DESCRIPTION_ATTR = "metaDescription";
	public final static String TITLE_ATTR = "title";
	
	@Id private String id;
	private String nsPrefix;
	private String name;
	private Integer positioner;
	private String slug;
	private String imageId;
	private String slugPath;
	private String color;
	private Integer level;
	private String description;
	private DateTime creationTime;
	private DateTime modificationTime;
	private Map<String, Map<String, String>> translations;
	private CategoryStatus status;
	private String metaDescription;
	private String metaKeywords;
	private String metaTitle;
	private Long googleFormalId;
	private String primaryUri;
	private String parentId;
	private String language;
	private final Set<PropertyDefinition> propertyOverrides = new HashSet<>();
	private final Set<String> tags = new HashSet<>();
	private final Set<String> sameAsUris = new HashSet<>();
	private Map<String, String> images = new HashMap<>();
	private String title;
	
	/**
	 * @return the id
	 */
	@Override
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nsPrefix
	 */
	public String getNsPrefix() {
		return nsPrefix;
	}
	/**
	 * @param nsPrefix the nsPrefix to set
	 */
	public void setNsPrefix(String nsPrefix) {
		this.nsPrefix = nsPrefix;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the positioner
	 */
	public Integer getPositioner() {
		return positioner;
	}
	/**
	 * @param positioner the positioner to set
	 */
	public void setPositioner(Integer positioner) {
		this.positioner = positioner;
	}
	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	/**
	 * @return the imageId
	 */
	public String getImageId() {
		return imageId;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	/**
	 * @return the slugPath
	 */
	public String getSlugPath() {
		return slugPath;
	}
	/**
	 * @param slugPath the slugPath to set
	 */
	public void setSlugPath(String slugPath) {
		this.slugPath = slugPath;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the creationTime
	 */
	public DateTime getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}
	/**
	 * @return the modificationTime
	 */
	public DateTime getModificationTime() {
		return modificationTime;
	}
	/**
	 * @param modificationTime the modificationTime to set
	 */
	public void setModificationTime(DateTime modificationTime) {
		this.modificationTime = modificationTime;
	}
	/**
	 * @return the translations
	 */
	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}
	/**
	 * @param translations the translations to set
	 */
	public void setTranslations(Map<String, Map<String, String>> translations) {
		this.translations = translations;
	}
	/**
	 * @return the status
	 */
	public CategoryStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(CategoryStatus status) {
		this.status = status;
	}
	/**
	 * @return the metaDescription
	 */
	public String getMetaDescription() {
		return metaDescription;
	}
	/**
	 * @param metaDescription the metaDescription to set
	 */
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	/**
	 * @return the metaKeywords
	 */
	public String getMetaKeywords() {
		return metaKeywords;
	}
	/**
	 * @param metaKeywords the metaKeywords to set
	 */
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	/**
	 * @return the metaTitle
	 */
	public String getMetaTitle() {
		return metaTitle;
	}
	/**
	 * @param metaTitle the metaTitle to set
	 */
	public void setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
	}
	/**
	 * @return the googleFormalId
	 */
	public Long getGoogleFormalId() {
		return googleFormalId;
	}
	/**
	 * @param googleFormalId the googleFormalId to set
	 */
	public void setGoogleFormalId(Long googleFormalId) {
		this.googleFormalId = googleFormalId;
	}
	/**
	 * @return the primaryUri
	 */
	public String getPrimaryUri() {
		return primaryUri;
	}
	/**
	 * @param primaryUri the primaryUri to set
	 */
	public void setPrimaryUri(String primaryUri) {
		this.primaryUri = primaryUri;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public Map<String, String> getImages() {
		return images;
	}
	public void setImages(Map<String, String> images) {
		this.images = images;
	}
	
	@JsonIgnore
	public String getEffectiveName(String curLanguageTag) {
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getName();
		} else {
			final Map<String, Map<String, String>> translations = getTranslations();
			if (translations == null || translations.isEmpty()) {
				return getName();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getName();
				} else {
					final Map<String, String> translation = translations.get(curLanguageTag);
//					log.debug("Got translation by {}: {}", languageTag, translation.getMessages());
					if (!translation.containsKey(Category2.NAME_ATTR)) {
						log.debug("Got translation by {}, but not value by attribute {}",
								curLanguageTag, Category2.NAME_ATTR);
						return getName();
					} else {
						final String translatedValue = translation.get(Category.NAME_ATTR);
						log.debug("Got translation by {} with value by attribute {}: {}",
								curLanguageTag, Category2.NAME_ATTR, translatedValue);
						return translatedValue;
					}
				}
			}
		}
	}
	
	@JsonIgnore
	public void setEffectiveName() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@JsonIgnore
	public String getEffectiveDescription(String curLanguageTag) {
		if (curLanguageTag.equals(Optional.fromNullable(getLanguage()).or("id-ID"))) {
			return getDescription();
		} else {
			if (getTranslations().isEmpty()) {
				return getDescription();
			} else {
				if (!getTranslations().containsKey(curLanguageTag)) {
					return getDescription();
				} else {
					final Map<String, String> translation = getTranslations().get(curLanguageTag);
					if (!translation.containsKey(Category2.DESCRIPTION_ATTR)) {
						return getDescription();
					} else {
						return translation.get(Category2.DESCRIPTION_ATTR);
					}
				}
			}
		}
	}
	@JsonIgnore
	public void setEffectiveDescription() {
		throw new UnsupportedOperationException();
	}
	
	@JsonIgnore
	public String getEffectiveMetaTitle(String curLanguageTag) {
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getMetaTitle();
		} else {
			final Map<String, Map<String, String>> translations = getTranslations();
			if (translations == null || translations.isEmpty()) {
				return getMetaTitle();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getMetaTitle();
				} else {
					final Map<String, String> translation = translations.get(curLanguageTag);
//					log.debug("Got translation by {}: {}", languageTag, translation.getMessages());
					if (!translation.containsKey(Category2.META_TITLE_ATTR)) {
						log.debug("Got translation by {}, but not value by attribute {}",
								curLanguageTag, Category2.META_TITLE_ATTR);
						return getMetaTitle();
					} else {
						final String translatedValue = translation.get(Category2.META_TITLE_ATTR);
						log.debug("Got translation by {} with value by attribute {}: {}",
								curLanguageTag, Category2.META_TITLE_ATTR, translatedValue);
						return translatedValue;
					}
				}
			}
		}
	}
	
	@JsonIgnore
	public void setEffectiveMetaTitle() {
		throw new UnsupportedOperationException();
	}
	
	@JsonIgnore
	public String getEffectiveMetaKeywords(String curLanguageTag) {
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getMetaKeywords();
		} else {
			final Map<String, Map<String, String>> translations = getTranslations();
			if (translations == null || translations.isEmpty()) {
				return getMetaKeywords();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getMetaKeywords();
				} else {
					final Map<String, String> translation = translations.get(curLanguageTag);
//					log.debug("Got translation by {}: {}", languageTag, translation.getMessages());
					if (!translation.containsKey(Category2.META_KEYWORDS_ATTR)) {
						log.debug("Got translation by {}, but not value by attribute {}",
								curLanguageTag, Category2.META_KEYWORDS_ATTR);
						return getMetaKeywords();
					} else {
						final String translatedValue = translation.get(Category2.META_KEYWORDS_ATTR);
						log.debug("Got translation by {} with value by attribute {}: {}",
								curLanguageTag, Category2.META_KEYWORDS_ATTR, translatedValue);
						return translatedValue;
					}
				}
			}
		}
	}
	
	@JsonIgnore
	public void setEffectiveMetaKeywords() {
		throw new UnsupportedOperationException();
	}
	
	@JsonIgnore
	public String getEffectiveMetaDescription(String curLanguageTag) {
		if (Optional.fromNullable(getLanguage()).or("id-ID").equals(curLanguageTag)) {
			return getMetaDescription();
		} else {
			final Map<String, Map<String, String>> translations = getTranslations();
			if (translations == null || translations.isEmpty()) {
				return getMetaDescription();
			} else {
				if (!translations.containsKey(curLanguageTag)) {
					return getMetaDescription();
				} else {
					final Map<String, String> translation = translations.get(curLanguageTag);
//					log.debug("Got translation by {}: {}", languageTag, translation.getMessages());
					if (!translation.containsKey(Category2.META_DESCRIPTION_ATTR)) {
						log.debug("Got translation by {}, but not value by attribute {}",
								curLanguageTag, Category2.META_DESCRIPTION_ATTR);
						return getMetaDescription();
					} else {
						final String translatedValue = translation.get(Category2.META_DESCRIPTION_ATTR);
						log.debug("Got translation by {} with value by attribute {}: {}",
								curLanguageTag, Category2.META_DESCRIPTION_ATTR, translatedValue);
						return translatedValue;
					}
				}
			}
		}
	}
	
	@JsonIgnore
	public void setEffectiveMetaDescription() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public CategoryInfo2 toInfo(String curLanguageTag) {
		return new ToCategoryInfo(curLanguageTag).apply(this);
	}
	
	public CategoryInfo toInfoXmi(String curLanguageTag) {
		return new ToCategoryInfoXmi(curLanguageTag).apply(this);
	}
	
	public CategoryInfo toInfoXmi() {
		return new ToCategoryInfoXmi(getLanguage()).apply(this);
	}

	/**
	 * @return the propertyOverrides
	 */
	public Set<PropertyDefinition> getPropertyOverrides() {
		return propertyOverrides;
	}
	/**
	 * @return the tags
	 */
	public Set<String> getTags() {
		return tags;
	}
	/**
	 * @return the sameAsUris
	 */
	public Set<String> getSameAsUris() {
		return sameAsUris;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category2 [id=" + id + ", nsPrefix=" + nsPrefix + ", name="
				+ name + ", positioner=" + positioner + ", slug=" + slug
				+ ", imageId=" + imageId + ", slugPath=" + slugPath
				+ ", color=" + color + ", level=" + level + ", description=" + description
				+ ", creationTime=" + creationTime + ", modificationTime="
				+ modificationTime + ", translations=" + translations
				+ ", status=" + status + ", metaDescription=" + metaDescription
				+ ", metaKeywords=" + metaKeywords + ", metaTitle=" + metaTitle
				+ ", googleFormalId=" + googleFormalId + ", primaryUri="
				+ primaryUri + ", parentId=" + parentId + ", language="
				+ language + ", propertyOverrides=" + propertyOverrides
				+ ", tags=" + tags + ", sameAsUris=" + sameAsUris + "]";
	}

	public class ToCategoryInfo implements Function<Category2, CategoryInfo2> {
		
		private final String curLanguageTag;

		public ToCategoryInfo() {
			super();
			this.curLanguageTag = "id-ID";//as default, may be come from appManifest
		}
		
		public ToCategoryInfo(final String curLanguageTag) {
			super();
			this.curLanguageTag = curLanguageTag;
		}
		
		@Override @Nullable
		public CategoryInfo2 apply(@Nullable Category2 cat) {
			final CategoryInfo2 catInfo = new CategoryInfo2();
			catInfo.setColor(cat.getColor());
			catInfo.setGoogleFormalId(cat.getGoogleFormalId());
			catInfo.setId(cat.getId());
			catInfo.setImageId(cat.getImageId());
			catInfo.setLevel(cat.getLevel());
			catInfo.setName(cat.getEffectiveName(curLanguageTag));
			catInfo.setNsPrefix(cat.getNsPrefix());
			if (cat.getParentId() != null) {
				catInfo.setParentId(cat.getParentId());
			}
			catInfo.setPositioner(cat.getPositioner());
			catInfo.setPrimaryUri(cat.getPrimaryUri());
			catInfo.setSlug(cat.getSlug());
			catInfo.setSlugPath(cat.getSlugPath());
			
			return catInfo;
		}
	}
	
	public class ToCategoryInfoXmi implements Function<Category2, CategoryInfo> {
		
		private final String curLanguageTag;

		public ToCategoryInfoXmi() {
			super();
			this.curLanguageTag = "id-ID";//as default, may be come from appManifest
		}
		
		public ToCategoryInfoXmi(final String curLanguageTag) {
			super();
			this.curLanguageTag = curLanguageTag;
		}
		
		@Override @Nullable
		public CategoryInfo apply(@Nullable Category2 cat) {
			final CategoryInfo catInfo = CommonsFactory.eINSTANCE.createCategoryInfo();
			catInfo.setColor(cat.getColor());
			catInfo.setGoogleFormalId(cat.getGoogleFormalId());
			catInfo.setId(cat.getId());
			catInfo.setImageId(cat.getImageId());
			catInfo.setLevel(cat.getLevel());
			catInfo.setName(cat.getEffectiveName(curLanguageTag));
			catInfo.setNsPrefix(cat.getNsPrefix());
			if (cat.getParentId() != null) {
//				catInfo.setParent(value);
			}
			catInfo.setPositioner(cat.getPositioner());
			catInfo.setPrimaryUri(cat.getPrimaryUri());
			catInfo.setSlug(cat.getSlug());
			catInfo.setSlugPath(cat.getSlugPath());
			catInfo.setTranslationState(TranslationState.ORIGINAL);
			catInfo.setOriginalLanguage(cat.getLanguage());
			catInfo.setLanguage(cat.getLanguage());
			if (cat.getTranslations() != null && !cat.getTranslations().isEmpty()) {
				for (final Entry<String, Map<String, String>> entry : cat.getTranslations().entrySet()) {
					final String key = entry.getKey();
					final Translation translation = CommonsFactory.eINSTANCE.createTranslation();
					translation.setLanguage(key);
					for (final Entry<String, String> entryTrans : entry.getValue().entrySet()) {
						translation.getMessages().put(entryTrans.getKey(), entryTrans.getValue());
					}
					catInfo.getTranslations().put(key, translation);
				}
			}
			
			return catInfo;
		}
	}

	public void resolve(EntityLookup<Category2, String> categoryLookup) {
		if (getSlug() == null) {
			setSlug(SlugUtils.generateSegment(getName()));
		}
		setSlugPath(Joiner.on('/').join(getSlugSegments(this, categoryLookup)));
		setLevel(getLevel(this, categoryLookup));
	}
	
	protected List<String> getSlugSegments(Category2 category,
			EntityLookup<Category2, String> categoryLookup) {
		final Category2 parent = categoryLookup.findOne(category.getParentId());
		return category.getParentId() != null
				? ImmutableList.copyOf(Iterables.concat(getSlugSegments(parent, categoryLookup), ImmutableList.of(category.getSlug())))
				: ImmutableList.<String>of(category.getSlug());
	}
	
	protected int getLevel(Category2 category, EntityLookup<Category2, String> categoryLookup) {
		final Category2 parent = categoryLookup.findOne(category.getParentId());
		return category.getParentId() != null
				? getLevel(parent, categoryLookup) + 1
				: 1;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonIgnore
	public String getEffectiveTitle(String curLanguageTag) {
		if (curLanguageTag.equals(Optional.fromNullable(getLanguage()).or("id-ID"))) {
			return getTitle();
		} else {
			if (getTranslations().isEmpty()) {
				return getTitle();
			} else {
				if (!getTranslations().containsKey(curLanguageTag)) {
					return getTitle();
				} else {
					final Map<String, String> translation = getTranslations().get(curLanguageTag);
					if (!translation.containsKey(Category2.TITLE_ATTR)) {
						return getTitle();
					} else {
						return translation.get(Category2.TITLE_ATTR);
					}
				}
			}
		}
	}
	@JsonIgnore
	public void setEffectiveTitle() {
		throw new UnsupportedOperationException();
	}
	
}
