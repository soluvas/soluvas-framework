/**
 */
package org.soluvas.data.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.QNameFunction;
import org.soluvas.data.DataCatalog;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinManager;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mixin Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.MixinManagerImpl#getDataCatalog <em>Data Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MixinManagerImpl implements MixinManager {
	
	private static final Logger log = LoggerFactory
			.getLogger(MixinManagerImpl.class);
	
	/**
	 * The cached value of the '{@link #getDataCatalog() <em>Data Catalog</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataCatalog()
	 * @generated
	 * @ordered
	 */
	protected DataCatalog dataCatalog;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected MixinManagerImpl() {
		throw new UnsupportedOperationException();
	}
	
	public MixinManagerImpl(DataCatalog dataCatalog) {
		super();
		this.dataCatalog = dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataCatalog getDataCatalog() {
		return dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataCatalog basicGetDataCatalog() {
		return dataCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Mixin findMixin(String qName) {
		final String patternStr = "([^_]+)_(.+)";
		final Matcher nsPrefixMatcher = Pattern.compile(patternStr).matcher(qName);
		Preconditions.checkState(nsPrefixMatcher.matches(),
				"Cannot match QName %s against nsPrefix pattern %s",
				qName, patternStr);
		final String nsPrefix = nsPrefixMatcher.group(1);
		final String mixinName = nsPrefixMatcher.group(2);
		
		try {
			return Iterables.find(dataCatalog.getMixins(), new Predicate<Mixin>() {
				@Override
				public boolean apply(@Nullable Mixin input) {
					return Objects.equal(nsPrefix, input.getNsPrefix()) && Objects.equal(mixinName, input.getName());
				}
			});
		} catch (NoSuchElementException e) {
			final List<String> mixinNames = ImmutableList.copyOf(Iterables.transform(dataCatalog.getMixins(), new QNameFunction()));
			log.warn(String.format("Cannot find mixin %s_%s. %d available mixins are: %s",
					nsPrefix, mixinName, mixinNames.size(), mixinNames));
			return null;
		}
	}

} //MixinManagerImpl
