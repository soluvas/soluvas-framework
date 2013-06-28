package com.soluvas.story.util;

import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.soluvas.story.Action;
import com.soluvas.story.StoryException;
import com.soluvas.story.schema.ActionType;
import com.soluvas.story.schema.StorySchemaCatalog;

/**
 * @author rully
 *
 */
public class StoryUtils {

	/**
	 * Helper method to create an {@link Action}.
	 * @param nsPrefix
	 * @param name
	 * @return
	 * @deprecated Use {@link StorySchemaCatalog#createAction(Class)}.
	 */
	@Deprecated
	public static <T extends Action> T createAction(@Nonnull final Class<T> targetClass) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(StoryUtils.class).getBundleContext();
		final ServiceReference<StorySchemaCatalog> storySchemaCatalogRef = Preconditions.checkNotNull(bundleContext.getServiceReference(StorySchemaCatalog.class),
				"Cannot get %s service reference", StorySchemaCatalog.class.getName());
		final StorySchemaCatalog storySchemaCatalog = Preconditions.checkNotNull(
				bundleContext.getService(storySchemaCatalogRef),
				"Cannot get %s service", StorySchemaCatalog.class.getName());
		try {
			final ActionType actionType = Iterables.find(storySchemaCatalog.getActionTypes(),
					new Predicate<ActionType>() {
				@Override
				public boolean apply(@Nullable final ActionType input) {
					return targetClass.equals( input.getJavaClass() );
				}
			});
			return (T) actionType.create();
		} catch (final NoSuchElementException e) {
			final Function<ActionType, String> targetTypeQName = new Function<ActionType, String>() {
				@Override @Nullable
				public String apply(@Nullable ActionType input) {
					return input.getJavaClass().getName();
				}
			};
			final List<String> supportedActionTypeQNames = Lists.transform(storySchemaCatalog.getActionTypes(), targetTypeQName);
			throw new StoryException(String.format("Cannot find action type %s, %s supported types are: %s",
					targetClass.getName(), supportedActionTypeQNames.size(), supportedActionTypeQNames), e);
		} finally {
			bundleContext.ungetService(storySchemaCatalogRef);
		}
	}

}
