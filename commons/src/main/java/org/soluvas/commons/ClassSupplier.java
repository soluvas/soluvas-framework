package org.soluvas.commons;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 * Supplies a {@link Class}. For some weird reason, {@link Suppliers}.ofInstance doesn't work
 * for class argument with Blueprint XML. i.e. below won't work:
 * 
 * <pre>
 * {@code
 * <service auto-export="interfaces">
 * 	<service-properties>
 * 		<entry key="suppliedClass" value="java.lang.Class[? extends org.apache.wicket.Page]" />
 * 		<entry key="pageRole" value="home" />
 * 	</service-properties>
 * 	<bean class="com.google.common.base.Suppliers" factory-method="ofInstance">
 * 		<argument type="java.lang.Class" value="id.co.bippo.web.pub.HomePage" />
 * 	</bean>
 * </service>
 * }
 * </pre>
 * 
 * But this does work:
 * 
 * <pre>{@code
 * <service auto-export="interfaces">
 * 	<service-properties>
 * 		<entry key="suppliedClass" value="java.lang.Class[? extends org.apache.wicket.Page]" />
 * 		<entry key="pageRole" value="home" />
 * 	</service-properties>
 * 	<bean class="org.soluvas.commons.ClassSupplier">
 * 		<argument value="id.co.bippo.web.pub.HomePage" />
 * 	</bean>
 * </service>
 * }</pre>
 * 
 * @author ceefour
 */
public class ClassSupplier implements Supplier<Class<?>> {

	private Class<?> clazz;
	
	public ClassSupplier(Class<?> clazz) {
		super();
		this.clazz = clazz;
	}

	/* (non-Javadoc)
	 * @see com.google.common.base.Supplier#get()
	 */
	@Override
	public Class<?> get() {
		return clazz;
	}

}
