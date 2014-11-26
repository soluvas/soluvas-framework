package org.soluvas.jpa;

import java.io.Serializable;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * <a href="http://stackoverflow.com/a/21984484">From Stackoverflow</a>.
 * Being <a href="https://github.com/JadiraOrg/jadira/issues/21">proposed to Jadira</a>
 * 
 * @author atang
 */
public class PersistentStringList implements UserType {

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.ARRAY };
	}

	@Override
	public Class returnedClass() {
		return List.class;
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
	    return Arrays.asList( (String[]) theArray.getArray() );
    }

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
	    if (value == null) {
	        st.setNull(index, Types.ARRAY);
	    } else {
	    	List<String> castObject = (List<String>) value;
	        Array array = session.connection().createArrayOf("varchar", castObject.toArray(new String[] {}));
	        st.setArray(index, array);
	    }		
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		if (value != null)
			return new ArrayList<>((List<String>) value);
		else 
			return null;
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return deepCopy(original);
	}

}
