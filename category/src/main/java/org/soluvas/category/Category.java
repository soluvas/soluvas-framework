/**
 */
package org.soluvas.category;

import java.util.List;

import javax.annotation.Nullable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.soluvas.commons.BundleAware;
import org.soluvas.commons.CategoryInfo;
import org.soluvas.commons.CategoryLike;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Describable;
import org.soluvas.commons.Informer;
import org.soluvas.commons.NsPrefixable;
import org.soluvas.commons.Parentable;
import org.soluvas.commons.ResourceAware;
import org.soluvas.commons.Timestamped;
import org.soluvas.data.EntityLookup;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.category.Category#getStatus <em>Status</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getMetaDescription <em>Meta Description</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getMetaKeywords <em>Meta Keywords</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getMetaTitle <em>Meta Title</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getAvailableSortBy <em>Available Sort By</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getDefaultSortBy <em>Default Sort By</em>}</li>
 *   <li>{@link org.soluvas.category.Category#isAnchor <em>Anchor</em>}</li>
 *   <li>{@link org.soluvas.category.Category#isIncludeInMenu <em>Include In Menu</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getCatalogName <em>Catalog Name</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getDefaultMixin <em>Default Mixin</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getUName <em>UName</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getParentUName <em>Parent UName</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getPrimaryUri <em>Primary Uri</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getSameAsUris <em>Same As Uris</em>}</li>
 *   <li>{@link org.soluvas.category.Category#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.category.CategoryPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends CategoryLike, NsPrefixable, Parentable<Category>, ResourceAware, BundleAware, CategoryContainer, Describable, Informer<CategoryInfo>, Timestamped {
	
	public class ToCategoryInfo implements Function<Category, CategoryInfo> {
		
		private Iterable<Category> getParents(Category child) {
			if (child.getParent() != null) {
				return Iterables.concat(getParents(child.getParent()), ImmutableList.of(child.getParent()));
			} else {
				return ImmutableList.of();
			}
		}
		
		@Override @Nullable
		public CategoryInfo apply(@Nullable Category cat) {
			final CategoryInfo catInfo = CommonsFactory.eINSTANCE.createCategoryInfo();
			catInfo.setCategoryCount(cat.getCategoryCount());
			catInfo.setColor(cat.getColor());
			catInfo.setNsPrefix(cat.getNsPrefix());
			catInfo.setId(cat.getId());
			catInfo.setImageId(cat.getImageId());
			catInfo.setLevel(cat.getLevel());
			catInfo.setName(cat.getName());
			catInfo.setPositioner(cat.getPositioner());
			catInfo.setSlug(cat.getSlug());
			catInfo.setSlugPath(cat.getSlugPath());
			catInfo.setPrimaryUri(cat.getPrimaryUri());
			
			if (cat.getParent() != null) {
				catInfo.setParent(cat.getParent().toInfo());
			}
			final List<Category> parentCats = ImmutableList.copyOf(getParents(cat));
			final List<CategoryInfo> parentInfos = ImmutableList.copyOf(Iterables.transform(parentCats, this));
			catInfo.getParents().addAll(parentInfos);
			
			return catInfo;
		}
	}
	
	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The default value is <code>"active"</code>.
	 * The literals are from the enumeration {@link org.soluvas.category.CategoryStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.category.CategoryStatus
	 * @see #setStatus(CategoryStatus)
	 * @see org.soluvas.category.CategoryPackage#getCategory_Status()
	 * @model default="active"
	 * @generated
	 */
	CategoryStatus getStatus();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see org.soluvas.category.CategoryStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(CategoryStatus value);

	/**
	 * Returns the value of the '<em><b>Meta Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Description</em>' attribute.
	 * @see #setMetaDescription(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_MetaDescription()
	 * @model
	 * @generated
	 */
	String getMetaDescription();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getMetaDescription <em>Meta Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Description</em>' attribute.
	 * @see #getMetaDescription()
	 * @generated
	 */
	void setMetaDescription(String value);

	/**
	 * Returns the value of the '<em><b>Meta Keywords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Keywords</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Keywords</em>' attribute.
	 * @see #setMetaKeywords(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_MetaKeywords()
	 * @model
	 * @generated
	 */
	String getMetaKeywords();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getMetaKeywords <em>Meta Keywords</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Keywords</em>' attribute.
	 * @see #getMetaKeywords()
	 * @generated
	 */
	void setMetaKeywords(String value);

	/**
	 * Returns the value of the '<em><b>Meta Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Title</em>' attribute.
	 * @see #setMetaTitle(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_MetaTitle()
	 * @model
	 * @generated
	 */
	String getMetaTitle();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getMetaTitle <em>Meta Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Title</em>' attribute.
	 * @see #getMetaTitle()
	 * @generated
	 */
	void setMetaTitle(String value);

	/**
	 * Returns the value of the '<em><b>Available Sort By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Available Sort By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Sort By</em>' attribute.
	 * @see #setAvailableSortBy(List)
	 * @see org.soluvas.category.CategoryPackage#getCategory_AvailableSortBy()
	 * @model dataType="org.soluvas.commons.List<org.eclipse.emf.ecore.EString>" many="false"
	 * @generated
	 */
	List<String> getAvailableSortBy();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getAvailableSortBy <em>Available Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Sort By</em>' attribute.
	 * @see #getAvailableSortBy()
	 * @generated
	 */
	void setAvailableSortBy(List<String> value);

	/**
	 * Returns the value of the '<em><b>Default Sort By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Sort By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Sort By</em>' attribute.
	 * @see #setDefaultSortBy(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_DefaultSortBy()
	 * @model
	 * @generated
	 */
	String getDefaultSortBy();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getDefaultSortBy <em>Default Sort By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Sort By</em>' attribute.
	 * @see #getDefaultSortBy()
	 * @generated
	 */
	void setDefaultSortBy(String value);

	/**
	 * Returns the value of the '<em><b>Anchor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anchor</em>' attribute.
	 * @see #setAnchor(boolean)
	 * @see org.soluvas.category.CategoryPackage#getCategory_Anchor()
	 * @model
	 * @generated
	 */
	boolean isAnchor();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#isAnchor <em>Anchor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Anchor</em>' attribute.
	 * @see #isAnchor()
	 * @generated
	 */
	void setAnchor(boolean value);

	/**
	 * Returns the value of the '<em><b>Include In Menu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include In Menu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include In Menu</em>' attribute.
	 * @see #setIncludeInMenu(boolean)
	 * @see org.soluvas.category.CategoryPackage#getCategory_IncludeInMenu()
	 * @model
	 * @generated
	 */
	boolean isIncludeInMenu();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#isIncludeInMenu <em>Include In Menu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include In Menu</em>' attribute.
	 * @see #isIncludeInMenu()
	 * @generated
	 */
	void setIncludeInMenu(boolean value);

	/**
	 * Returns the value of the '<em><b>Catalog Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the category catalog.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Catalog Name</em>' attribute.
	 * @see #setCatalogName(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_CatalogName()
	 * @model
	 * @generated
	 */
	String getCatalogName();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getCatalogName <em>Catalog Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catalog Name</em>' attribute.
	 * @see #getCatalogName()
	 * @generated
	 */
	void setCatalogName(String value);

	/**
	 * Returns the value of the '<em><b>Default Mixin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Mixin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Default {@link org.soluvas.data.Mixin} UName, including nsPrefix, e.g. "base_Apparel".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Mixin</em>' attribute.
	 * @see #setDefaultMixin(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_DefaultMixin()
	 * @model
	 * @generated
	 */
	String getDefaultMixin();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getDefaultMixin <em>Default Mixin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Mixin</em>' attribute.
	 * @see #getDefaultMixin()
	 * @generated
	 */
	void setDefaultMixin(String value);

	/**
	 * Returns the value of the '<em><b>UName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * nsPrefix + "_" + id.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>UName</em>' attribute.
	 * @see org.soluvas.category.CategoryPackage#getCategory_UName()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getUName();

	/**
	 * Returns the value of the '<em><b>Parent UName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parent Category UName ("{nsPrefix}_{ID}"), useful during serialization/deserialization to get a real reference to the parent (which may/may not be found).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent UName</em>' attribute.
	 * @see #setParentUName(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_ParentUName()
	 * @model
	 * @generated
	 */
	String getParentUName();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getParentUName <em>Parent UName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent UName</em>' attribute.
	 * @see #getParentUName()
	 * @generated
	 */
	void setParentUName(String value);

	/**
	 * Returns the value of the '<em><b>Primary Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Primary Linked Data URI, this will be used as <code>@id</code> in JSON-LD.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary Uri</em>' attribute.
	 * @see #setPrimaryUri(String)
	 * @see org.soluvas.category.CategoryPackage#getCategory_PrimaryUri()
	 * @model
	 * @generated
	 */
	String getPrimaryUri();

	/**
	 * Sets the value of the '{@link org.soluvas.category.Category#getPrimaryUri <em>Primary Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Uri</em>' attribute.
	 * @see #getPrimaryUri()
	 * @generated
	 */
	void setPrimaryUri(String value);

	/**
	 * Returns the value of the '<em><b>Same As Uris</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Additional <a href="http://schema.org/sameAs">sameAs</a> Linked Data URIs.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Same As Uris</em>' attribute list.
	 * @see org.soluvas.category.CategoryPackage#getCategory_SameAsUris()
	 * @model
	 * @generated
	 */
	@JsonDeserialize(as=BasicEList.class)
	EList<String> getSameAsUris();

	/**
	 * Returns the value of the '<em><b>Tags</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Freeform hashtags, however do not put special characters like space, comma, and semicolon.
	 * Dash, underscore, and dot are usually okay.
	 * Can be used for both inbound and outbound.
	 * Inbound: putting a product uploaded from Instagram or Twitter to specified category based on Instagram/Twitter hashtags.
	 * Outbound: publishing a product or category to Instagram/Twitter/Facebook, while hashtagging based on category's tags.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tags</em>' attribute list.
	 * @see org.soluvas.category.CategoryPackage#getCategory_Tags()
	 * @model
	 * @generated
	 */
	EList<String> getTags();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Provide default values for id, slug, slugPath, etc.
	 * 
	 * If categoryLookup is provided, it will lookup the parentUName and set the parent reference.
	 * This is optional and unnecessary during loading from XMI, but is required during EmfModel deserialization.
	 * <!-- end-model-doc -->
	 * @model categoryLookupDataType="org.soluvas.category.EntityLookup<org.soluvas.category.Category, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	void resolve(EntityLookup<Category, String> categoryLookup);

} // Category
