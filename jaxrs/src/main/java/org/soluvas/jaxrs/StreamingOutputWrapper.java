package org.soluvas.jaxrs;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

import com.google.common.base.Function;

/**
 * @author ceefour
 *
 */
public class StreamingOutputWrapper implements StreamingOutput {
	
	private final Function<OutputStream, Void> func;
	
	/**
	 * @param func
	 */
	public StreamingOutputWrapper(Function<OutputStream, Void> func) {
		super();
		this.func = func;
	}

	@Override
	public void write(OutputStream output) throws IOException,
			WebApplicationException {
		func.apply(output);
	}

}
