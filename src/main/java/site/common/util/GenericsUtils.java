package site.common.util;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Provides a helper that locates the declarated generics type of a class.
 * 
 * @author Ben Alex
 * @version $Id: GenericsUtils.java,v 1.2 2005/11/17 00:55:50 benalex Exp $
 */
public class GenericsUtils {
	/**
	 * Locates the first generic declaration on a class.
	 * 
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or <code>null</code> if cannot
	 *         be determined
	 */
	public static Class getGenericClass(Class clazz) {
		return getGenericClass(clazz, 0);
	}

	public static Class getGenericClass(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();

		if (genType instanceof ParameterizedType) {
			Type[] params = ((ParameterizedType) genType)
					.getActualTypeArguments();

			if ((params != null) && (params.length >= (index - 1))) {
				return (Class) params[index];
			}
		} else if (!clazz.getSuperclass().equals(Object.class)) {
			return getGenericClass(clazz.getSuperclass(), 0);
		} else {
			throw new RuntimeException("Couldn't get the generic info!");
		}
		return null;
	}
}
