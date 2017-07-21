package com.evaluation.content.analizer.core;

/**
 * Created by dmaldonado on 21/07/2017.
 */
public class ResultPair {

	/**
	 * first element of the pair
	 */
	private Integer firstElement;

	/**
	 * second element of the pair
	 */
	private String secondElement;

	/**
	 * @param firstElement
	 * @param secondElement
	 */
	public ResultPair(Integer firstElement, String secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	/**
	 * @return the first element
	 */
	public Integer getFirstElement() {
		return firstElement;
	}

	/**
	 *
	 * @param firstElement
	 *            the first element to set
	 */
	public void setFirstElement(Integer firstElement) {
		this.firstElement = firstElement;
	}

	/**
	 * @return the second element
	 */
	public String getSecondElement() {
		return secondElement;
	}

	/**
	 * @param secondElement
	 *            the second element to set
	 */
	public void setSecondElement(String secondElement) {
		this.secondElement = secondElement;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%d %s", firstElement, secondElement);
	}

}
