/**
 */
package com.soluvas.story.builtin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import com.soluvas.story.StoryPackage;

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
 * @see com.soluvas.story.builtin.BuiltinFactory
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
	String eNS_URI = "http://www.soluvas.com/schema/story.builtin/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "builtin-story";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BuiltinPackage eINSTANCE = com.soluvas.story.builtin.impl.BuiltinPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.FollowImpl <em>Follow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.FollowImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getFollow()
	 * @generated
	 */
	int FOLLOW = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The number of structural features of the '<em>Follow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLLOW_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.LikeImpl <em>Like</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.LikeImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getLike()
	 * @generated
	 */
	int LIKE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The number of structural features of the '<em>Like</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIKE_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.ListenImpl <em>Listen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.ListenImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getListen()
	 * @generated
	 */
	int LISTEN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The number of structural features of the '<em>Listen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LISTEN_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.ReadImpl <em>Read</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.ReadImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getRead()
	 * @generated
	 */
	int READ = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__START_TIME = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ__END_TIME = StoryPackage.ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Read</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int READ_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.WatchImpl <em>Watch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.WatchImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getWatch()
	 * @generated
	 */
	int WATCH = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__START_TIME = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH__END_TIME = StoryPackage.ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Watch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATCH_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.CommentImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__MESSAGE = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.TimeTrackable <em>Time Trackable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.TimeTrackable
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getTimeTrackable()
	 * @generated
	 */
	int TIME_TRACKABLE = 6;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRACKABLE__START_TIME = 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRACKABLE__END_TIME = 1;

	/**
	 * The number of structural features of the '<em>Time Trackable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_TRACKABLE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link com.soluvas.story.builtin.impl.ShareImpl <em>Share</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.soluvas.story.builtin.impl.ShareImpl
	 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getShare()
	 * @generated
	 */
	int SHARE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__NAME = StoryPackage.ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Tenses</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__TENSES = StoryPackage.ACTION__TENSES;

	/**
	 * The feature id for the '<em><b>Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__PAST_TENSE = StoryPackage.ACTION__PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Past Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__PLURAL_PAST_TENSE = StoryPackage.ACTION__PLURAL_PAST_TENSE;

	/**
	 * The feature id for the '<em><b>Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__PRESENT_TENSE = StoryPackage.ACTION__PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Plural Present Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__PLURAL_PRESENT_TENSE = StoryPackage.ACTION__PLURAL_PRESENT_TENSE;

	/**
	 * The feature id for the '<em><b>Imperative Tense</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__IMPERATIVE_TENSE = StoryPackage.ACTION__IMPERATIVE_TENSE;

	/**
	 * The feature id for the '<em><b>Ns Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__NS_PREFIX = StoryPackage.ACTION__NS_PREFIX;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__ACTION_TYPE = StoryPackage.ACTION__ACTION_TYPE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE__MESSAGE = StoryPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Share</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARE_FEATURE_COUNT = StoryPackage.ACTION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Follow <em>Follow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Follow</em>'.
	 * @see com.soluvas.story.builtin.Follow
	 * @generated
	 */
	EClass getFollow();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Like <em>Like</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Like</em>'.
	 * @see com.soluvas.story.builtin.Like
	 * @generated
	 */
	EClass getLike();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Listen <em>Listen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Listen</em>'.
	 * @see com.soluvas.story.builtin.Listen
	 * @generated
	 */
	EClass getListen();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Read <em>Read</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Read</em>'.
	 * @see com.soluvas.story.builtin.Read
	 * @generated
	 */
	EClass getRead();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Watch <em>Watch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Watch</em>'.
	 * @see com.soluvas.story.builtin.Watch
	 * @generated
	 */
	EClass getWatch();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see com.soluvas.story.builtin.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.TimeTrackable <em>Time Trackable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Trackable</em>'.
	 * @see com.soluvas.story.builtin.TimeTrackable
	 * @generated
	 */
	EClass getTimeTrackable();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.builtin.TimeTrackable#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see com.soluvas.story.builtin.TimeTrackable#getStartTime()
	 * @see #getTimeTrackable()
	 * @generated
	 */
	EAttribute getTimeTrackable_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link com.soluvas.story.builtin.TimeTrackable#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see com.soluvas.story.builtin.TimeTrackable#getEndTime()
	 * @see #getTimeTrackable()
	 * @generated
	 */
	EAttribute getTimeTrackable_EndTime();

	/**
	 * Returns the meta object for class '{@link com.soluvas.story.builtin.Share <em>Share</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Share</em>'.
	 * @see com.soluvas.story.builtin.Share
	 * @generated
	 */
	EClass getShare();

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
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.FollowImpl <em>Follow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.FollowImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getFollow()
		 * @generated
		 */
		EClass FOLLOW = eINSTANCE.getFollow();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.LikeImpl <em>Like</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.LikeImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getLike()
		 * @generated
		 */
		EClass LIKE = eINSTANCE.getLike();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.ListenImpl <em>Listen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.ListenImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getListen()
		 * @generated
		 */
		EClass LISTEN = eINSTANCE.getListen();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.ReadImpl <em>Read</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.ReadImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getRead()
		 * @generated
		 */
		EClass READ = eINSTANCE.getRead();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.WatchImpl <em>Watch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.WatchImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getWatch()
		 * @generated
		 */
		EClass WATCH = eINSTANCE.getWatch();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.CommentImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.TimeTrackable <em>Time Trackable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.TimeTrackable
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getTimeTrackable()
		 * @generated
		 */
		EClass TIME_TRACKABLE = eINSTANCE.getTimeTrackable();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_TRACKABLE__START_TIME = eINSTANCE.getTimeTrackable_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIME_TRACKABLE__END_TIME = eINSTANCE.getTimeTrackable_EndTime();

		/**
		 * The meta object literal for the '{@link com.soluvas.story.builtin.impl.ShareImpl <em>Share</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.soluvas.story.builtin.impl.ShareImpl
		 * @see com.soluvas.story.builtin.impl.BuiltinPackageImpl#getShare()
		 * @generated
		 */
		EClass SHARE = eINSTANCE.getShare();

	}

} //BuiltinPackage
