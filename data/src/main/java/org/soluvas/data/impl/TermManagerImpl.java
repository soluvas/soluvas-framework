/**
 */
package org.soluvas.data.impl;

import java.util.List;

import javax.annotation.Nullable;

import org.soluvas.data.DataCatalog;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Term Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.soluvas.data.impl.TermManagerImpl#getDataCatalog <em>Data Catalog</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TermManagerImpl implements TermManager {
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
	protected TermManagerImpl() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @param dataCatalog
	 */
	public TermManagerImpl(DataCatalog dataCatalog) {
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
	 */
	@Override
	public List<Term> findTerms(final String kindNsPrefix, final String kindName) {
		final List<Term> terms = ImmutableList.copyOf(Iterables.filter(dataCatalog.getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				return Objects.equal(input.getKindNsPrefix(), kindNsPrefix) && Objects.equal(input.getKindName(), kindName);
			}
		}));
		return terms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public Multimap<String, Term> getTermsByAttributeTypes() {
		final Multimap<String, Term> multimap = Multimaps.index(dataCatalog.getTerms(), new Function<Term, String>() {
			@Override @Nullable
			public String apply(@Nullable Term input) {
				return Strings.nullToEmpty(input.getKindNsPrefix()) + "_" + Strings.nullToEmpty(input.getKindName());
			}
		});
		return multimap;
	}

	@Override
	public Term findTerm(final String qName) {
		return Iterables.tryFind(dataCatalog.getTerms(), new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				return Objects.equal(qName, input.getQName());
			}
		}).orNull();
	}

} //TermManagerImpl
