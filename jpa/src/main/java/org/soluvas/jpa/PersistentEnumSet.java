package org.soluvas.jpa;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Nullable;
import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import com.google.common.base.Preconditions;

/**
 * {@code Set<Enum>} backend by {@link TreeSet} and translates to 
 * <a href="http://www.postgresql.org/docs/9.3/static/datatype-enum.html">PostgreSQL {@code enum}</a>{@code []} custom data type.
 * Adapted from {@link PersistentStringList} and {@link PersistentEnum}.
 * 
 * <p>Parameters:
 * 
 * <ul>
 * 	<li>enumClass: Fully qualified Java {@link Enum} class name, e.g. {@link org.soluvas.commons.AccountStatus}.</li>
 * 	<li>enumName: <a href="http://www.postgresql.org/docs/9.3/static/datatype-enum.html">PostgreSQL {@code enum}</a> data type name, e.g. {@link account_status}.</li>
 * @author anton
 */
public class PersistentEnumSet /*extends AbstractReflectionUserType<Set<Enum<?>>>*/ implements UserType, ParameterizedType {
	
//	private static final long serialVersionUID = 1L;

	@Nullable
	private Class<Enum<?>> enumClass;
	@Nullable
	private String enumName;

	@Override
	public void setParameterValues(Properties parameters) {
		final String mappedClassStr = Preconditions.checkNotNull(
				parameters.getProperty("enumClass"), "'enumClass' UserType parameter is required");
		try {
			enumClass = (Class<Enum<?>>) PersistentEnumSet.class.forName(mappedClassStr);
		} catch (ClassNotFoundException e) {
			throw new PersistenceException("Cannot load enumClass: " + mappedClassStr, e);
		}
		enumName = Preconditions.checkNotNull(
				parameters.getProperty("enumName"), "'enumName' UserType parameter is required");
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.ARRAY };
	}

	@Override
	public Class returnedClass() {
		return TreeSet.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
	    if (x == y) {
	        return true;
	    } else if (x == null || y == null) {
	        return false;
	    } else {
	        return x.equals(y);
	    }
    }

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
	    final Array theArray = rs.getArray(names[0]);
	    if (rs.wasNull()) {
	    	return null;
	    }
    	final Set<Enum<?>> enums = new TreeSet<>();
    	Object origArray = theArray.getArray();
    	// Notice how Object is mapped to PGobject. This makes this implementation Postgres specific
    	if (origArray instanceof PGobject[]) {
    		for (PGobject identifier : (PGobject[]) origArray) {
    			enums.add(Enum.valueOf((Class) enumClass, identifier.getValue()));
    		}
    	} else if (origArray instanceof String[]) {
    		for (String identifier : (String[]) origArray) {
    			enums.add(Enum.valueOf((Class) enumClass, identifier));
    		}
    	} else {
    		throw new IllegalArgumentException("PersistentEnum type expects PGobject[], got " + origArray.getClass().getName() + " for value '" + origArray + "'");
    	}
    	return enums;
    }

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
	    if (value == null) {
	    	// To support NULL insertion, use type 1111 instead of VARCHAR
	        st.setNull(index, Types.ARRAY);
	    } else {
            // createArrayOf() uses type name instead of java.sql.Types, see discussion at https://github.com/pgjdbc/pgjdbc/issues/189
	    	final Set<Enum<?>> castObject = (Set<Enum<?>>) value;
	    	final Array array = session.connection().createArrayOf(
	    			enumName, castObject.toArray(new Enum[] {}));
	        st.setArray(index, array);
	    }
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (value != null)
			return new TreeSet<>((Collection<String>) value);
		else 
			return null;
	}

	@Override
	public boolean isMutable() {
		// support EMF-style collections. but I'm not really sure if this is worthed? ~Hendy
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return deepCopy(original);
	}

}
