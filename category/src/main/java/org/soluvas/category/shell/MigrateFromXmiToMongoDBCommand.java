package org.soluvas.category.shell;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author rudi
 *
 */
@Service @Lazy
@Command(scope="cat", name="migrate", description="Migrate categories from xmi file to mongoDB.")
public class MigrateFromXmiToMongoDBCommand extends ExtCommandSupport {

	@Override
	protected Object doExecute() throws Exception {
		final CategoryRepository xmiRepo = getBean(CategoryRepository.class);
		
		
		return null;
	}

}
