package com.evaluation.content.analizer.core;

import com.evaluation.content.analizer.api.IWord;

import java.io.Serializable;

/**
 * This class represent a Word of the text.
 * 
 * @author dmaldonado
 *
 */
public class Word implements IWord, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The word value.
	 */
	private String value;

	/**
	 * @param value
	 */
	public Word(String value) {
		super();

		if (null == value) {
			throw new IllegalArgumentException("Please instanciate this class with a value different to null");
		}
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
