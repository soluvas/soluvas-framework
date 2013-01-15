/**
 */
package org.soluvas.image;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blitline Transformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Processes using Blitline. The source image must be publicly hosted, for example using S3.
 * 
 * The destination image is directly written into an S3 bucket. Make sure to set the Canonical ID, see http://blog.blitline.com/post/32296310740/canonical-id-s3-permissions
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.image.BlitlineTransformer#getApplicationId <em>Application Id</em>}</li>
 *   <li>{@link org.soluvas.image.BlitlineTransformer#getBucket <em>Bucket</em>}</li>
 *   <li>{@link org.soluvas.image.BlitlineTransformer#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.soluvas.image.BlitlineTransformer#getKeyTemplate <em>Key Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.image.ImagePackage#getBlitlineTransformer()
 * @model
 * @generated
 */
public interface BlitlineTransformer extends ImageTransformer {

	/*
	 * { "application_id": "1dI-CHEUwvAeTZtGh1HODCg",
	 * "src" : "http://www.google.com/logos/2011/yokoyama11-hp.jpg",
	 * "functions" : [ {"name": "blur", "params" : {"radius" : 0.0, "sigma" : 2.0}, "save" : { "image_identifier" : "MY_CLIENT_ID" }} ]}'	
	 */
		
	public static class JobS3Destination {
		public String bucket;
		public String key;
		public Map<String, String> headers;
		
		/**
		 * @param bucket
		 * @param key
		 * @param headers
		 */
		public JobS3Destination(String bucket, String key,
				Map<String, String> headers) {
			super();
			this.bucket = bucket;
			this.key = key;
			this.headers = headers;
		}

		/**
		 * @param bucket
		 * @param key
		 */
		public JobS3Destination(String bucket, String key) {
			super();
			this.bucket = bucket;
			this.key = key;
		}
		
	}
	public static class JobSave {
		@JsonProperty("image_identifier")
		public String imageIdentifier;
		@JsonProperty("s3_destination")
		public JobS3Destination s3Destination;
		public Integer quality;
		
		/**
		 * @param imageIdentifier
		 * @param s3Destination
		 * @param quality
		 */
		public JobSave(String imageIdentifier, JobS3Destination s3Destination,
				Integer quality) {
			super();
			this.imageIdentifier = imageIdentifier;
			this.s3Destination = s3Destination;
			this.quality = quality;
		}

		/**
		 * @param imageIdentifier
		 * @param s3Destination
		 */
		public JobSave(String imageIdentifier, JobS3Destination s3Destination) {
			super();
			this.imageIdentifier = imageIdentifier;
			this.s3Destination = s3Destination;
		}
		
	}
	
	public static class JobFunction {
		public String name;
		public Map<String, Object> params;
		public JobSave save;
		public JobFunction[] functions;
		
		/**
		 * @param name
		 * @param params
		 * @param save
		 * @param functions
		 */
		public JobFunction(String name, Map<String, Object> params, JobSave save,
				JobFunction[] functions) {
			super();
			this.name = name;
			this.params = params;
			this.save = save;
			this.functions = functions;
		}

		/**
		 * @param name
		 * @param params
		 * @param save
		 */
		public JobFunction(String name, Map<String, Object> params, JobSave save) {
			super();
			this.name = name;
			this.params = params;
			this.save = save;
		}
		
	}
	
	public static class Job {
		@JsonProperty("application_id")
		public String applicationId;
		public String src;
		public JobFunction[] functions;
		
		/**
		 * @param applicationId
		 * @param src
		 * @param functions
		 */
		public Job(String applicationId, String src, JobFunction[] functions) {
			super();
			this.applicationId = applicationId;
			this.src = src;
			this.functions = functions;
		}
		/**
		 * @param applicationId
		 * @param src
		 * @param functions
		 */
		public Job(String applicationId, String src, JobFunction function) {
			super();
			this.applicationId = applicationId;
			this.src = src;
			this.functions = new JobFunction[] { function };
		}
		
	}
		
	/**
	 * Returns the value of the '<em><b>Application Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application Id</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getBlitlineTransformer_ApplicationId()
	 * @model changeable="false"
	 * @generated
	 */
	String getApplicationId();

	/**
	 * Returns the value of the '<em><b>Bucket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bucket</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bucket</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getBlitlineTransformer_Bucket()
	 * @model changeable="false"
	 * @generated
	 */
	String getBucket();

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getBlitlineTransformer_Prefix()
	 * @model changeable="false"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Returns the value of the '<em><b>Key Template</b></em>' attribute.
	 * The default value is <code>"{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * key template in URI template format.
	 * 
	 * Variables are: namespace, styleCode, imageId, styleVariant, extension.
	 * 
	 * Default is: "{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}";
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Key Template</em>' attribute.
	 * @see org.soluvas.image.ImagePackage#getBlitlineTransformer_KeyTemplate()
	 * @model default="{+prefix}{namespace}/{styleCode}/{imageId}_{styleVariant}.{extension}" changeable="false"
	 * @generated
	 */
	String getKeyTemplate();
} // BlitlineTransformer
