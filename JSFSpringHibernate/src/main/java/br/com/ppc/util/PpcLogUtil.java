package br.com.ppc.util;

import java.util.Collection;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author Christian Oscar Tejada Pacheco
 *
 */
public class PpcLogUtil {

	public static Collection collect(final Collection collection, final String propertyName) {
		return CollectionUtils.collect(collection, new BeanToPropertyValueTransformer(propertyName));
	}

}
