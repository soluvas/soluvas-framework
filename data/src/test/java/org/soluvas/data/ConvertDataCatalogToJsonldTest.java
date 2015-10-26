package org.soluvas.data;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.json.JsonUtils;
import org.soluvas.json.LowerEnumSerializer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class ConvertDataCatalogToJsonldTest {

	private static final Logger log = LoggerFactory
			.getLogger(ConvertDataCatalogToJsonldTest.class);
	
	static {
		LowerEnumSerializer.LOWER = false;
	}
	
	public void convert(File xmiFile, Map<String, Term2> map) throws IOException {
		final DataCatalog dataCatalog = new OnDemandXmiLoader<DataCatalog>(DataPackage.eINSTANCE, xmiFile).get();
		final EList<Term> termList = dataCatalog.getTerms();
		for (final Term xmiTerm : termList) {
			final Term2 term2 = new Term2();
			term2.copyFromXmi(xmiTerm);
			if (xmiTerm.getKindName().equals("Size")) {
				term2.setEnumerationId(TermKindRepositoryImpl.APPAREL_SIZE);
			}
			
			map.put(term2.getId(), term2);
		}
	}
	
	@Test
	public void convertAll() throws IOException {
		DataFactory.eINSTANCE.createAttribute();
		CommonsFactory.eINSTANCE.createAttributeSet();
		
		final String parentDir = System.getProperty("user.home") + "/git/soluvas-framework/data/src/main/resources/org/soluvas/data";
		final Resource[] resources = new PathMatchingResourcePatternResolver()
			.getResources("file:" + parentDir + "/*.DataCatalog.xmi");
		final TreeMap<String, Term2> map = new TreeMap<>();
		for (final Resource res : resources) {
			convert(res.getFile(), map);
		}
		
		final Term2Catalog dataCatalog = new Term2Catalog();
		dataCatalog.getData().addAll(map.values());
		final File jsonFile = new File(parentDir, "soluvas.TermDataCatalog.jsonld");
		log.info("Writing {}", jsonFile);
		FileUtils.write(jsonFile, JsonUtils.asJson(dataCatalog));
	}

}
