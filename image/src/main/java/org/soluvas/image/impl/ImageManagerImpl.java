/**
 */
package org.soluvas.image.impl;

import java.io.File;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Gender;
import org.soluvas.image.FileExport;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImagePackage;
import org.soluvas.image.store.ImageRepository;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ImageManagerImpl extends EObjectImpl implements ImageManager {
	
	private static final Logger log = LoggerFactory
			.getLogger(ImageManagerImpl.class);
	private String maleDefaultPhotoId;
	private String femaleDefaultPhotoId;
	private String unknownDefaultPhotoId;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImagePackage.Literals.IMAGE_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String getDefaultPhotoId(Gender gender) {
		log.debug("Current User Gender {}", gender);
		switch (gender) {
		case MALE:
			return maleDefaultPhotoId;
		case FEMALE:
			return femaleDefaultPhotoId;
		default:
			return unknownDefaultPhotoId;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public long export(ImageRepository imageRepo, boolean metadata, FileExport files, File destFolder) {
		
	}

} //ImageManagerImpl
