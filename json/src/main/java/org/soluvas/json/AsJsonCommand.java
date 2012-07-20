package org.soluvas.json;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

/**
 * @author ceefour
 */
@Command(scope="as", name="json", description="Format any object as JSON.")
public class AsJsonCommand extends OsgiCommandSupport {
	
//	private transient Logger log = LoggerFactory.getLogger(AsJsonCommand.class);
	
	@Argument(name="OBJECT", required=true, description="Object to format as JSON, e.g. (process:find hello).")
	private Object input;
	
	public AsJsonCommand() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		return JsonUtils.asJson(input);
	}

}
