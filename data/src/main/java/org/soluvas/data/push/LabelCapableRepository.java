package org.soluvas.data.push;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.soluvas.data.EntityLookup;

import com.google.common.base.Function;

/**
 * Synchronous interface for label capabilities.
 * @author ceefour
 */
public interface LabelCapableRepository<ID, T> {
	
	/**
	 * Convenience method for listing all labels. This calls the label repository's findAll.
	 * 
	 * TBD: Should this be even here? I think an entity repository must not be coupled to a label repository.
	 * A label repository don't even need to exist. 
	 * @return
	 */
	List<Label> findAllLabels();
	
	/**
	 * Get label IDs for a set of entities.
	 * @return
	 */
	Map<ID, Set<String>> getLabelIdsFor(Set<ID> ids);
	
	/**
	 * Get labels for a set of entities. The lookup function is used to
	 * transform label IDs into {@link Label} objects.
	 * @see EntityLookup
	 * @see CachingEntityLookup
	 * @return
	 */
	Map<ID, Set<Label>> getLabelsFor(Set<ID> ids, Function<String, Label> labelLookup);
	
	/**
	 * Labels a set of entities with {@link Label}s. For the Label, only the ID is required.
	 * @param ids
	 * @param labels
	 */
	void label(Set<ID> ids, Set<Label> labels);
	
	/**
	 * Convenience method for {@link #label(Set, Set)}. For the Label, only the ID is required.
	 * @param id
	 * @param label
	 */
	void label(ID id, Label label);
	
	/**
	 * Unlabels a set of entities from {@link Label}s. For the Label, only the ID is required.
	 * @param ids
	 * @param labels
	 */
	void unlabel(Set<ID> ids, Set<Label> labels);
	
	/**
	 * Convenience method for {@link #unlabel(Set, Set)}. For the Label, only the ID is required.
	 * @param id
	 * @param label
	 */
	void unlabel(ID id, Label label);

	/**
	 * Unlabels a set of entities from all labels.
	 * @param ids
	 * @param labels
	 */
	void unlabelAll(Set<ID> ids);
	
	/**
	 * Convenience method for {@link #unlabelAll(Set)}.
	 * @param id
	 * @param label
	 */
	void unlabelAll(ID id);

}
