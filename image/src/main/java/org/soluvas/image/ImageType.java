package org.soluvas.image;


/**
 * Inspired by Neo4j RelationshipType.
 * 
 * <p>
 * It's very important to note that a image type is uniquely identified
 * by its name, not by any particular instance that implements this interface.
 * This means that the proper way to check if two image types are equal
 * is by invoking <code>equals()</code> on their {@link #name names}, NOT by
 * using Java's identity operator (<code>==</code>) or <code>equals()</code> on
 * the image type instances. A consequence of this is that you can NOT
 * use image types in hashed collections such as
 * {@link java.util.HashMap HashMap} and {@link java.util.HashSet HashSet}.
 * <p>
 * However, you usually want to check whether a specific image
 * <i>instance</i> is of a certain type. That is best achieved with the
 * {@link image#isType image.isType} method, such as: <code><pre>
 * if ( rel.isType( MyimageTypes.CONTAINED_IN ) )
 * {
 *     ...
 * }
 * </pre></code>
 * 
 * @author rudi
 */
public interface ImageType {
    /**
     * Returns the name of the image type. The name uniquely identifies a
     * image type, i.e. two different imageType instances with
     * different object identifiers (and possibly even different classes) are
     * semantically equivalent if they have {@link String#equals(Object) equal}
     * names.
     * 
     * @return the name of the image type
     */
    public String name();
}
