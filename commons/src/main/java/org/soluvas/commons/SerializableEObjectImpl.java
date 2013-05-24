package org.soluvas.commons;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

import com.google.common.collect.ImmutableMap;

/**
 * Serializes the {@link EObject} using {@link BinaryResourceImpl}.
 * You probably also want to make constructors public in your GenModel.
 * 
 * @author ceefour
 */
public class SerializableEObjectImpl extends EObjectImpl {

	private Object writeReplace() throws IOException {
		return new SerializationProxy(this);
	}

	public static class SerializationProxy implements Serializable {
		// private static final Logger log = LoggerFactory
		// .getLogger(ProductVariantImpl.SerializationProxy.class);
		private byte[] buf;

		public SerializationProxy(EObject obj) throws IOException {
			super();
			// final XMIResourceImpl res = new XMIResourceImpl();
			final BinaryResourceImpl res = new BinaryResourceImpl();
			res.getContents().add(obj);
			try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				res.save(out, ImmutableMap.of());
				buf = out.toByteArray();
			}
			// log.debug("Serialized {} to {} bytes", obj.eClass().getName(),
			// buf.length);
		}

		private Object readResolve() throws IOException {
			// final XMIResourceImpl res = new XMIResourceImpl();
			final BinaryResourceImpl res = new BinaryResourceImpl();
			res.load(new ByteArrayInputStream(buf), ImmutableMap.of());
			return res.getContents().get(0);
		}
	}

}
