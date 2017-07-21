package com.evaluation.content.analizer.api;

/**
 * Definition of all method for a container of a specific content
 * 
 * @author dmaldonado
 *
 */
public interface IContent<A extends IWord> {

	/**
	 * @param toAdd
	 *            the value to be added.
	 */
	boolean add(final A toAdd);

	/**
	 * @return the number of elements present in the content.
	 */
	int size();

	/**
	 * This method is responsible for ensuring memory allocation to store new
	 * values.
	 */
	void ensureCapacity(int minCapacity);

	/**
	 * Responsible for parsing the content given in parameter.
	 * 
	 * @param content
	 *            the content
	 */
	void parseContent(Object content);

	/**
	 * @return true is the container is empty else false.
	 */
	boolean isEmpty();

	/**
	 *
	 * @return the data present in the container.
	 */
	Object[] getDataContent();
}
