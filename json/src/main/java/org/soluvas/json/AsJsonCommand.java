package org.soluvas.json;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Format any object as JSON.
 * @author ceefour
 */
@Command(scope="as", name="json", description="Format any object as JSON.")
public class AsJsonCommand extends OsgiCommandSupport {
	
//	private transient Logger log = LoggerFactory.getLogger(AsJsonCommand.class);
	
	private ObjectMapper mapper;
	
	@Argument(name="OBJECT", required=true, description="Object to format as JSON, e.g. (process:find hello).")
	private Object input;
	
	public AsJsonCommand(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		return mapper.writeValueAsString(input);
	}

}
