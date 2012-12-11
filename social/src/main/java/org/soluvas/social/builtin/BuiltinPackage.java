/**
 */
package org.soluvas.social.builtin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.soluvas.social.SocialPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Can comment on a Target, or even another activity.
 * <!-- end-model-doc -->
 * @see org.soluvas.social.builtin.BuiltinFactory
 * @model kind="package"
 * @generated
 */
public interface BuiltinPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "builtin";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/social.builtin/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "builtin-social";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuiltinPackage eINSTANCE = org.soluvas.social.builtin.impl.BuiltinPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.PersonImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 0;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ID = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__NAME = SocialPackage.TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Photo Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PHOTO_ID = SocialPackage.TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Slug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__SLUG = SocialPackage.TARGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = SocialPackage.TARGET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = SocialPackage.TARGET_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__USERNAME = SocialPackage.TARGET_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__GENDER = SocialPackage.TARGET_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.ArticleImpl <em>Article</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.ArticleImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getArticle()
	 * @generated
	 */
	int ARTICLE = 1;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.BlogImpl <em>Blog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.BlogImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getBlog()
	 * @generated
	 */
	int BLOG = 2;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Blog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOG_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.BookImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 3;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.ExternalProfileImpl <em>External Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.ExternalProfileImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getExternalProfile()
	 * @generated
	 */
	int EXTERNAL_PROFILE = 4;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__FIRST_NAME = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__LAST_NAME = SocialPackage.TARGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__USERNAME = SocialPackage.TARGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gender</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__GENDER = SocialPackage.TARGET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Profile Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE__PROFILE_ID = SocialPackage.TARGET_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>External Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_PROFILE_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.MovieImpl <em>Movie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.MovieImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getMovie()
	 * @generated
	 */
	int MOVIE = 5;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Movie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOVIE_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.TvEpisodeImpl <em>Tv Episode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.TvEpisodeImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getTvEpisode()
	 * @generated
	 */
	int TV_EPISODE = 6;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Tv Episode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_EPISODE_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.TvShowImpl <em>Tv Show</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.TvShowImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getTvShow()
	 * @generated
	 */
	int TV_SHOW = 7;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Tv Show</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TV_SHOW_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.VideoImpl <em>Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.VideoImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getVideo()
	 * @generated
	 */
	int VIDEO = 8;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.WebsiteImpl <em>Website</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.WebsiteImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getWebsite()
	 * @generated
	 */
	int WEBSITE = 9;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Website</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEBSITE_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.social.builtin.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.social.builtin.impl.ActivityImpl
	 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 10;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NS_PREFIX = SocialPackage.TARGET__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__DESCRIPTION = SocialPackage.TARGET__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__TARGET_TYPE = SocialPackage.TARGET__TARGET_TYPE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__TITLE = SocialPackage.TARGET__TITLE;

	/**
	 * The feature id for the '<em><b>Images</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__IMAGES = SocialPackage.TARGET__IMAGES;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__URI = SocialPackage.TARGET__URI;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__TYPE_NAME = SocialPackage.TARGET__TYPE_NAME;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = SocialPackage.TARGET_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see org.soluvas.social.builtin.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Article</em>'.
	 * @see org.soluvas.social.builtin.Article
	 * @generated
	 */
	EClass getArticle();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Blog <em>Blog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Blog</em>'.
	 * @see org.soluvas.social.builtin.Blog
	 * @generated
	 */
	EClass getBlog();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see org.soluvas.social.builtin.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.ExternalProfile <em>External Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Profile</em>'.
	 * @see org.soluvas.social.builtin.ExternalProfile
	 * @generated
	 */
	EClass getExternalProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.social.builtin.ExternalProfile#getProfileId <em>Profile Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Id</em>'.
	 * @see org.soluvas.social.builtin.ExternalProfile#getProfileId()
	 * @see #getExternalProfile()
	 * @generated
	 */
	EAttribute getExternalProfile_ProfileId();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Movie <em>Movie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Movie</em>'.
	 * @see org.soluvas.social.builtin.Movie
	 * @generated
	 */
	EClass getMovie();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.TvEpisode <em>Tv Episode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tv Episode</em>'.
	 * @see org.soluvas.social.builtin.TvEpisode
	 * @generated
	 */
	EClass getTvEpisode();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.TvShow <em>Tv Show</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tv Show</em>'.
	 * @see org.soluvas.social.builtin.TvShow
	 * @generated
	 */
	EClass getTvShow();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Video <em>Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video</em>'.
	 * @see org.soluvas.social.builtin.Video
	 * @generated
	 */
	EClass getVideo();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Website <em>Website</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Website</em>'.
	 * @see org.soluvas.social.builtin.Website
	 * @generated
	 */
	EClass getWebsite();

	/**
	 * Returns the meta object for class '{@link org.soluvas.social.builtin.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see org.soluvas.social.builtin.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BuiltinFactory getBuiltinFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.PersonImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.ArticleImpl <em>Article</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.ArticleImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getArticle()
		 * @generated
		 */
		EClass ARTICLE = eINSTANCE.getArticle();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.BlogImpl <em>Blog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.BlogImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getBlog()
		 * @generated
		 */
		EClass BLOG = eINSTANCE.getBlog();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.BookImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.ExternalProfileImpl <em>External Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.ExternalProfileImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getExternalProfile()
		 * @generated
		 */
		EClass EXTERNAL_PROFILE = eINSTANCE.getExternalProfile();

		/**
		 * The meta object literal for the '<em><b>Profile Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_PROFILE__PROFILE_ID = eINSTANCE.getExternalProfile_ProfileId();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.MovieImpl <em>Movie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.MovieImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getMovie()
		 * @generated
		 */
		EClass MOVIE = eINSTANCE.getMovie();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.TvEpisodeImpl <em>Tv Episode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.TvEpisodeImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getTvEpisode()
		 * @generated
		 */
		EClass TV_EPISODE = eINSTANCE.getTvEpisode();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.TvShowImpl <em>Tv Show</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.TvShowImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getTvShow()
		 * @generated
		 */
		EClass TV_SHOW = eINSTANCE.getTvShow();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.VideoImpl <em>Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.VideoImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getVideo()
		 * @generated
		 */
		EClass VIDEO = eINSTANCE.getVideo();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.WebsiteImpl <em>Website</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.WebsiteImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getWebsite()
		 * @generated
		 */
		EClass WEBSITE = eINSTANCE.getWebsite();

		/**
		 * The meta object literal for the '{@link org.soluvas.social.builtin.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.social.builtin.impl.ActivityImpl
		 * @see org.soluvas.social.builtin.impl.BuiltinPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

	}

} //BuiltinPackage
