/**
 */
package org.soluvas.social.builtin.impl;

import javax.annotation.Nonnull;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.soluvas.social.builtin.*;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo;
import org.soluvas.social.builtin.Activity;
import org.soluvas.social.builtin.Article;
import org.soluvas.social.builtin.Blog;
import org.soluvas.social.builtin.Book;
import org.soluvas.social.builtin.BuiltinFactory;
import org.soluvas.social.builtin.BuiltinPackage;
import org.soluvas.social.builtin.ExternalProfile;
import org.soluvas.social.builtin.Movie;
import org.soluvas.social.builtin.Person;
import org.soluvas.social.builtin.TvEpisode;
import org.soluvas.social.builtin.TvShow;
import org.soluvas.social.builtin.Video;
import org.soluvas.social.builtin.Website;
import org.soluvas.social.schema.SocialSchemaCatalog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BuiltinFactoryImpl extends EFactoryImpl implements BuiltinFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BuiltinFactory init() {
		try {
			BuiltinFactory theBuiltinFactory = (BuiltinFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/social.builtin/1.0"); 
			if (theBuiltinFactory != null) {
				return theBuiltinFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BuiltinFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BuiltinPackage.PERSON: return createPerson();
			case BuiltinPackage.ARTICLE: return createArticle();
			case BuiltinPackage.BLOG: return createBlog();
			case BuiltinPackage.BOOK: return createBook();
			case BuiltinPackage.EXTERNAL_PROFILE: return createExternalProfile();
			case BuiltinPackage.MOVIE: return createMovie();
			case BuiltinPackage.TV_EPISODE: return createTvEpisode();
			case BuiltinPackage.TV_SHOW: return createTvShow();
			case BuiltinPackage.VIDEO: return createVideo();
			case BuiltinPackage.WEBSITE: return createWebsite();
			case BuiltinPackage.ACTIVITY: return createActivity();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Article createArticle() {
		ArticleImpl article = new ArticleImpl();
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Blog createBlog() {
		BlogImpl blog = new BlogImpl();
		return blog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Book createBook() {
		BookImpl book = new BookImpl();
		return book;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalProfile createExternalProfile() {
		ExternalProfileImpl externalProfile = new ExternalProfileImpl();
		return externalProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Movie createMovie() {
		MovieImpl movie = new MovieImpl();
		return movie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TvEpisode createTvEpisode() {
		TvEpisodeImpl tvEpisode = new TvEpisodeImpl();
		return tvEpisode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TvShow createTvShow() {
		TvShowImpl tvShow = new TvShowImpl();
		return tvShow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Video createVideo() {
		VideoImpl video = new VideoImpl();
		return video;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Website createWebsite() {
		WebsiteImpl website = new WebsiteImpl();
		return website;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BuiltinPackage getBuiltinPackage() {
		return (BuiltinPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BuiltinPackage getPackage() {
		return BuiltinPackage.eINSTANCE;
	}

	@Override
	public Person createPerson(SocialSchemaCatalog socialSchemaCatalog, @Nonnull final PersonInfo personInfo) {
		return new Person.FromInfo(socialSchemaCatalog).apply(personInfo);
	}

	@Override
	public Person createPerson(SocialSchemaCatalog socialSchemaCatalog, @Nonnull final String id, @Nonnull final String slug,
			@Nonnull final String name, @Nonnull final String photoId, @Nonnull final Gender gender) {
		final PersonInfo personInfo = CommonsFactory.eINSTANCE.createPersonInfo(
				id, slug, name, photoId, gender);
		return createPerson(socialSchemaCatalog, personInfo);
	}

} //BuiltinFactoryImpl
