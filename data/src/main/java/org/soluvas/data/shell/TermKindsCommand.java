package org.soluvas.data.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;
import java.util.Map.Entry;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.NameFunction;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Multimap;

/**
 * Display number of {@link Term}s for all recognized {@link Kind}s.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="term", name="kinds", description="Display Terms grouped by recognized Kinds.")
public class TermKindsCommand extends ExtCommandSupport {

	@Override
	protected Object doExecute() throws Exception {
		final TermManager termMgr = getBean(TermManager.class);
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%3s|%-40s|@",
				"№", "Kind", "∑", "Terms"));
		final Multimap<String, Term> terms = termMgr.getTermsByAttributeTypes();
		int i = 0;
		for (final Entry<String, Collection<Term>> entry : terms.asMap().entrySet()) {
			final Collection<String> termNames = Collections2.transform(entry.getValue(), new NameFunction());
			System.out.println(ansi().render("@|bold,black %3d||@@|bold %-20s|@@|bold,black ||@%3d@|bold,black ||@%-40s",
					++i, entry.getKey(), entry.getValue().size(), Joiner.on(' ').join(termNames) ));
		}
		return null;
	}

}
