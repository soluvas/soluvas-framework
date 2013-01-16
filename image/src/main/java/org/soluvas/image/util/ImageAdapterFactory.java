/**
 */
package org.soluvas.image.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.soluvas.commons.Identifiable;
import org.soluvas.commons.NameContainer;
import org.soluvas.commons.Nameable;
import org.soluvas.commons.SchemaVersionable;
import org.soluvas.commons.Timestamped;
import org.soluvas.image.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.image.ImagePackage
 * @generated
 */
public class ImageAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImagePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImageAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ImagePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageSwitch<Adapter> modelSwitch =
		new ImageSwitch<Adapter>() {
			@Override
			public Adapter caseImageConnector(ImageConnector object) {
				return createImageConnectorAdapter();
			}
			@Override
			public Adapter caseDavConnector(DavConnector object) {
				return createDavConnectorAdapter();
			}
			@Override
			public Adapter caseS3Connector(S3Connector object) {
				return createS3ConnectorAdapter();
			}
			@Override
			public Adapter caseImageTransformer(ImageTransformer object) {
				return createImageTransformerAdapter();
			}
			@Override
			public Adapter caseBlitlineTransformer(BlitlineTransformer object) {
				return createBlitlineTransformerAdapter();
			}
			@Override
			public Adapter caseThumbnailatorTransformer(ThumbnailatorTransformer object) {
				return createThumbnailatorTransformerAdapter();
			}
			@Override
			public Adapter caseUploadedImage(UploadedImage object) {
				return createUploadedImageAdapter();
			}
			@Override
			public Adapter caseImageManager(ImageManager object) {
				return createImageManagerAdapter();
			}
			@Override
			public Adapter caseImageTransform(ImageTransform object) {
				return createImageTransformAdapter();
			}
			@Override
			public Adapter caseResizeToFit(ResizeToFit object) {
				return createResizeToFitAdapter();
			}
			@Override
			public Adapter caseResizeToFill(ResizeToFill object) {
				return createResizeToFillAdapter();
			}
			@Override
			public Adapter caseDimensionLike(DimensionLike object) {
				return createDimensionLikeAdapter();
			}
			@Override
			public Adapter caseImageVariant(ImageVariant object) {
				return createImageVariantAdapter();
			}
			@Override
			public Adapter caseImage(Image object) {
				return createImageAdapter();
			}
			@Override
			public Adapter caseStyledImage(StyledImage object) {
				return createStyledImageAdapter();
			}
			@Override
			public Adapter caseImageCatalog(ImageCatalog object) {
				return createImageCatalogAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNameContainer(NameContainer object) {
				return createNameContainerAdapter();
			}
			@Override
			public Adapter caseSchemaVersionable(SchemaVersionable object) {
				return createSchemaVersionableAdapter();
			}
			@Override
			public Adapter caseTimestamped(Timestamped object) {
				return createTimestampedAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ImageConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ImageConnector
	 * @generated
	 */
	public Adapter createImageConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.S3Connector <em>S3 Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.S3Connector
	 * @generated
	 */
	public Adapter createS3ConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.BlitlineTransformer <em>Blitline Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.BlitlineTransformer
	 * @generated
	 */
	public Adapter createBlitlineTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.DavConnector <em>Dav Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.DavConnector
	 * @generated
	 */
	public Adapter createDavConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ImageTransformer <em>Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ImageTransformer
	 * @generated
	 */
	public Adapter createImageTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ThumbnailatorTransformer <em>Thumbnailator Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ThumbnailatorTransformer
	 * @generated
	 */
	public Adapter createThumbnailatorTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.UploadedImage <em>Uploaded Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.UploadedImage
	 * @generated
	 */
	public Adapter createUploadedImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ImageManager <em>Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ImageManager
	 * @generated
	 */
	public Adapter createImageManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ImageTransform <em>Transform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ImageTransform
	 * @generated
	 */
	public Adapter createImageTransformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ResizeToFit <em>Resize To Fit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ResizeToFit
	 * @generated
	 */
	public Adapter createResizeToFitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ResizeToFill <em>Resize To Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ResizeToFill
	 * @generated
	 */
	public Adapter createResizeToFillAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.DimensionLike <em>Dimension Like</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.DimensionLike
	 * @generated
	 */
	public Adapter createDimensionLikeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ImageVariant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ImageVariant
	 * @generated
	 */
	public Adapter createImageVariantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.Image
	 * @generated
	 */
	public Adapter createImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.StyledImage <em>Styled Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.StyledImage
	 * @generated
	 */
	public Adapter createStyledImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.image.ImageCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.image.ImageCatalog
	 * @generated
	 */
	public Adapter createImageCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.NameContainer <em>Name Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.NameContainer
	 * @generated
	 */
	public Adapter createNameContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.SchemaVersionable <em>Schema Versionable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.SchemaVersionable
	 * @generated
	 */
	public Adapter createSchemaVersionableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.soluvas.commons.Timestamped <em>Timestamped</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.soluvas.commons.Timestamped
	 * @generated
	 */
	public Adapter createTimestampedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ImageAdapterFactory
