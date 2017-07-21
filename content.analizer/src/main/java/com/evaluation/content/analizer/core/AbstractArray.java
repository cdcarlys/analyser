package com.evaluation.content.analizer.core;

import java.util.Arrays;

/**
 * Centralize all method involving class simulating collections
 * 
 * @author dmaldonado
 *
 */
public abstract class AbstractArray<C> {

	protected static final int DEFAULT_CAPACITY = 10;
	
	protected static final String ILLEGAL_CAPACITY = "Illegal capacity";

	/**
	 * This attribute corresponds with the number of results of the analyse
	 */
	protected int size;

	private Object[] dataContent;

	/**
	 * @see com.evaluation.content.analizer.api.IContent#getDataContent()
	 */
	public Object[] getDataContent() {
		return this.dataContent;
	}

	/**
	 * @see com.evaluation.content.analizer.api.IContent#size()
	 */
	public int size() {

		return this.size;
	}

	/**
	 * @see com.evaluation.content.analizer.api.IContent#isEmpty()
	 */
	public boolean isEmpty() {

		return this.size() == 0;
	}

	/**
	 * @see com.evaluation.content.analizer.api.IContent#add(Object)
	 */
	public abstract boolean add(C toAdd);

	/**
	 * Increase the capacity of this container if necessary.
	 */
	public void ensureCapacity(int minCapacity) {

		int oldCapacity = dataContent.length;

		if (minCapacity > oldCapacity) {

			int newCapacity = (oldCapacity * 3) / 2 + 1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}

			dataContent = Arrays.copyOf(dataContent, newCapacity);
		}
	}

	/**
	 * @param dataContent
	 *            the dataContent to set
	 */
	protected void setDataContent(Object[] dataContent) {
		this.dataContent = dataContent;
	}

}
