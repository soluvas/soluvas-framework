package org.soluvas.data;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.soluvas.commons.Identifiable;

import com.google.code.morphia.annotations.Id;
import com.google.common.collect.ImmutableSet;

/**
 * @author rudi
 *
 */
public class Term2 implements Serializable, Identifiable {
	
	private static final long serialVersionUID = 1L;
	
	public static final long CURRENT_SCHEMA_VERSION = 2l;
	
	public static String NAME_ATTR = "name";
	
	@Id private String id;
	private String name;
	private String nsPrefix;
	private String imageId;
	private Integer positioner;
	private String color;
	private String language;
	private final Map<String, Map<String, String>> translations = new HashMap<>();
	private String kindNsPrefix;
	private String kindName;
	private String primaryUri;
	private Set<String> sameAsUris;
	
	public Term2() {
		super();
	}
	
	public Term2(Term xmiTerm) {
		this.setColor(xmiTerm.getColor());
		this.setId(xmiTerm.getNsPrefix() + "_" + xmiTerm.getName());
		this.setImageId(xmiTerm.getImageId());
		this.setKindName(xmiTerm.getKindName());
		this.setKindNsPrefix(xmiTerm.getKindNsPrefix());
		this.setLanguage(xmiTerm.getLanguage());
		this.setName(xmiTerm.getDisplayName());
		this.setNsPrefix(xmiTerm.getNsPrefix());
		this.setPositioner(xmiTerm.getPositioner());
		this.setPrimaryUri(xmiTerm.getPrimaryUri());
		this.setSameAsUris(ImmutableSet.copyOf(xmiTerm.getSameAsUris()));
	}

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

	/**
	 * @return the kindNsPrefix
	 */
	public String getKindNsPrefix() {
		return kindNsPrefix;
	}

	/**
	 * @param kindNsPrefix the kindNsPrefix to set
	 */
	public void setKindNsPrefix(String kindNsPrefix) {
		this.kindNsPrefix = kindNsPrefix;
	}

	/**
	 * @return the kindName
	 */
	public String getKindName() {
		return kindName;
	}

	/**
	 * @param kindName the kindName to set
	 */
	public void setKindName(String kindName) {
		this.kindName = kindName;
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
	 * @return the sameAsUris
	 */
	public Set<String> getSameAsUris() {
		return sameAsUris;
	}

	/**
	 * @param sameAsUris the sameAsUris to set
	 */
	public void setSameAsUris(Set<String> sameAsUris) {
		this.sameAsUris = sameAsUris;
	}

	/**
	 * @return the translations
	 */
	public Map<String, Map<String, String>> getTranslations() {
		return translations;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Term2 [id=" + id + ", name=" + name + ", nsPrefix=" + nsPrefix
				+ ", imageId=" + imageId + ", positioner=" + positioner
				+ ", color=" + color + ", language=" + language
				+ ", translations=" + translations + ", kindNsPrefix="
				+ kindNsPrefix + ", kindName=" + kindName + ", primaryUri="
				+ primaryUri + ", sameAsUris=" + sameAsUris + "]";
	}
	
	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}

}
