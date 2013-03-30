package org.soluvas.jaxrs;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.soluvas.json.JsonUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/**
 * This {@link ContextResolver} needs to be manually configured (via DI).
 * You CANNOT expose this as service and expect it to work (something
 * with CXF wanting to do reflection, I guess).
 * 
 * <p>Correct example:
 * 
 * <pre>{@literal
 * <bean id="productRsSys" class="id.co.bippo.product.rs.hand.ProductResourceSys">
 * 	<argument ref="productRawRepo" />
 * 	<argument ref="productRawFactory" />
 * 	<argument ref="inventoryManager" />
 * 	<argument ref="priceCalc" />
 * 	<argument ref="mixinMgr" />
 * 	<argument ref="termMgr" />
 * 	<argument ref="productImageRepo" />
 * </bean>
 * <bean id="productRsShop" class="id.co.bippo.product.rs.hand.ProductResourceShop">
 * 	<argument ref="productRawRepo" />
 * 	<argument ref="productRawFactory" />
 * 	<argument ref="inventoryManager" />
 * 	<argument ref="priceCalc" />
 * 	<argument ref="mixinMgr" />
 * 	<argument ref="termMgr" />
 * </bean>
 * <bean id="productRsMall" class="id.co.bippo.product.rs.hand.ProductResourceMall">
 * 	<argument ref="productRawRepo" />
 * 	<argument ref="productRawFactory" />
 * 	<argument ref="inventoryManager" />
 * 	<argument ref="priceCalc" />
 * 	<argument ref="mixinMgr" />
 * 	<argument ref="termMgr" />
 * </bean>
 * <bean id="productRsPub" class="id.co.bippo.product.rs.hand.ProductResourcePub">
 * 	<argument ref="productRepo" />
 * 	<argument ref="inventoryManager" />
 * </bean>
 * <reference id="jacksonMapperFactory" interface="org.soluvas.json.JacksonMapperFactory" />
 * <bean id="jacksonContextResolver" class="org.soluvas.jaxrs.Jackson2ContextResolver">
 * 	<argument ref="jacksonMapperFactory"/>
 * </bean>
 * <jaxrs:server id="rsServerSys" address="/api/product_sys">
 * 	<jaxrs:providers>
 * 		<bean class="com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider" />
 * 		<ref component-id="jacksonContextResolver"/>
 * 	</jaxrs:providers>
 * 	<jaxrs:serviceBeans>
 * 		<ref component-id="productRsSys" />
 * 	</jaxrs:serviceBeans>
 * </jaxrs:server>	
 * <jaxrs:server id="rsServerShop" address="/api/product_shop">
 * 	<jaxrs:providers>
 * 		<bean class="com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider" />
 * 		<ref component-id="jacksonContextResolver"/>
 * 	</jaxrs:providers>
 * 	<jaxrs:serviceBeans>
 * 		<ref component-id="productRsShop" />
 * 	</jaxrs:serviceBeans>
 * </jaxrs:server>	
 * <jaxrs:server id="rsServerMall" address="/api/product_mall">
 * 	<jaxrs:providers>
 * 		<bean class="com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider" />
 * 		<ref component-id="jacksonContextResolver"/>
 * 	</jaxrs:providers>
 * 	<jaxrs:serviceBeans>
 * 		<ref component-id="productRsMall" />
 * 	</jaxrs:serviceBeans>
 * </jaxrs:server>	
 * <jaxrs:server id="rsServerPub" address="/api/product_pub">
 * 	<jaxrs:providers>
 * 		<bean class="com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider" />
 * 		<ref component-id="jacksonContextResolver"/>
 * 	</jaxrs:providers>
 * 	<jaxrs:serviceBeans>
 * 		<ref component-id="productRsPub" />
 * 	</jaxrs:serviceBeans>
 * </jaxrs:server>	
 * }</pre>
 * 
 * @author ceefour
 */
@Provider @Produces(MediaType.APPLICATION_JSON)
public class Jackson2ContextResolver implements ContextResolver<ObjectMapper> {

	private final Supplier<ObjectMapper> objectMapperSupplier;

	/**
	 * For Spring-Jersey or Java EE usage.
	 */
	public Jackson2ContextResolver() {
		this(Suppliers.ofInstance(JsonUtils.mapper));
	}
	
	/**
	 * For OSGi usage.
	 * @param objectMapperSupplier
	 */
	public Jackson2ContextResolver(Supplier<ObjectMapper> objectMapperSupplier) {
		super();
		this.objectMapperSupplier = objectMapperSupplier;
	}
	
	@Override
	public ObjectMapper getContext(Class<?> type) {
		return objectMapperSupplier.get();
	}
}
