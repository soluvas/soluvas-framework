package org.soluvas.jpa;

import com.google.common.base.Preconditions;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import javax.annotation.Nullable;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.sql.*;
import java.util.*;

/**
 * {@code List<Enum>} backend by {@link java.util.ArrayList} and translates to
 * either <a href="http://www.postgresql.org/docs/9.3/static/datatype-enum.html">PostgreSQL {@code enum}</a>{@code []} custom data type
 * or {@code varchar} data type.
 * Adapted from {@link PersistentStringList} and {@link PersistentEnum}.
 * 
 * <p>Parameters:
 * 
 * <ul>
 * 	<li>enumClass: Fully qualified Java {@link Enum} class name, e.g. {@link org.soluvas.commons.AccountStatus}.</li>
 * 	<li>enumName: <a href="http://www.postgresql.org/docs/9.3/static/datatype-enum.html">PostgreSQL {@code enum}</a> data type name, e.g. {@link account_status}
 * 		or {@code varchar}.</li>
 * @author anton
 */
public class PersistentEnumList /*extends AbstractReflectionUserType<Set<Enum<?>>>*/ implements UserType, ParameterizedType {
	
//	private static final long serialVersionUID = 1L;

	@Nullable
	private Class<Enum<?>> enumClass;
	@Nullable
	private String enumName;

	@Override
	public void setParameterValues(Properties parameters) {
		Preconditions.checkNotNull(parameters, "UserType parameters 'enumClass' and 'enumName' are required");
		final String mappedClassStr = Preconditions.checkNotNull(
				parameters.getProperty("enumClass"), "'enumClass' UserType parameter is required");
		try {
			enumClass = (Class<Enum<?>>) PersistentEnumList.class.forName(mappedClassStr);
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
		return ArrayList.class;
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
    	final List<Enum<?>> enums = new ArrayList<>();
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
	    	final Collection<Enum<?>> castObject = (Collection<Enum<?>>) value;
	    	final Array array = session.connection().createArrayOf(
	    			enumName, castObject.toArray(new Enum[] {}));
	        st.setArray(index, array);
	    }
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (value != null)
			return new ArrayList<>((Collection<String>) value);
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
