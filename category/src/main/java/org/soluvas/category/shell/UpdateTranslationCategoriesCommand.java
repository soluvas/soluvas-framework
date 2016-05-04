package org.soluvas.category.shell;

import java.util.Map;

import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.soluvas.category.Category2;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.util.BatchFinder;
import org.soluvas.data.util.BatchProcessor;
import org.soluvas.data.util.RepositoryUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

/**
 * @author rudi
 *
 */
@Service @Scope("prototype")
@Command(scope="cat", name="updatetranslation", description="Update translation for categories")
public class UpdateTranslationCategoriesCommand extends ExtCommandSupport {
	
	@Option(name="--force", aliases="-f", description="Force for migrating..")
	private transient boolean f = false;

	@Override
	protected Object doExecute() throws Exception {
		if (!f) {
			System.err.println("Do nothing..");
			return null;
		}
		final PropertyDefinitionRepository propDefRepo = getBean(PropertyDefinitionRepository.class);
		final Map<String, PropertyDefinition> propMap = propDefRepo.findAllBaseAsMap();
		final MongoCategoryRepository catRepo = getBean(MongoCategoryRepository.class);
		final AppManifest appManifest = getBean(AppManifest.class);
		
		RepositoryUtils.runBatch("Update translations categories", new Sort("_id"),
				new BatchFinder<Category2>() {
					@Override
					public Page<Category2> find(Pageable pageable) throws Exception {
						return catRepo.findAll(pageable);
					}
				}, new BatchProcessor<Category2>() {

					@Override
					public void process(Category2 input, long elementIndex,
							long elementOffset, long numberOfElements,
							long totalElements, long pageNumber,
							long totalPages, ProgressMonitor monitor)
							throws Exception {
						
						if (Strings.isNullOrEmpty(input.getLanguage())) {
							input.setLanguage(appManifest.getDefaultLanguageTag());
						}
						for (final PropertyDefinition propDef : input.getPropertyOverrides()) {
							final PropertyDefinition oriPropDef = propMap.get(propDef.getId());
							propDef.setLanguage(oriPropDef.getLanguage());
							propDef.getTranslations().putAll(oriPropDef.getTranslations());
						}
						
						catRepo.modify(input.getId(), input);
					}
					
				});
		
		return null;
	}

}
