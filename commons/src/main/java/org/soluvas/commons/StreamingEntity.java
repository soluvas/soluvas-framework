package org.soluvas.commons;

import java.io.OutputStream;

import javax.annotation.Nullable;

import com.google.common.base.Function;

/**
 * Used to pass a (probably big) file.
 * @author ceefour
 */
public class StreamingEntity implements Function<OutputStream, Void> {
	
	private final String fileName;
	private final Function<OutputStream, Void> output;
	
	/**
	 * @param fileName
	 * @param output
	 */
	public StreamingEntity(String fileName, Function<OutputStream, Void> output) {
		super();
		this.fileName = fileName;
		this.output = output;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Can be used only once.
	 * @see com.google.common.base.Function#apply(java.lang.Object)
	 */
	@Override @Nullable
	public Void apply(@Nullable OutputStream input) {
		return output.apply(input);
	}
	
}
