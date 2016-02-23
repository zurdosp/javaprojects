package br.com.ppc.dao;

import java.util.List;
/**
 *
 * @author Christian Oscar Tejada Pacheco
 *
 * @param <DomainObject>
 * @param <KeyType>
 */
public interface AbstractDAO <DomainObject, KeyType> {

	public KeyType create(final DomainObject entity) ;

	public void update(final DomainObject entity);

	public void remove(final DomainObject entity);

	public DomainObject find(final KeyType key);

	public List<DomainObject> list();

}


