package com.evaluation.content.analizer.core;

import java.util.StringTokenizer;

import com.evaluation.content.analizer.api.IContent;
import com.evaluation.content.analizer.api.IWord;

/**
 * This class is an implementation of {@link IContent}. This is a container of
 * Word.
 * 
 * @author dmaldonado
 *
 */
public class TextContainer extends AbstractArray<IWord> implements IContent<IWord> {

	private static final String SEPARATORS = " \t\n\r\f,.:;?![]'";

	/**
	 * Default constructor
	 */
	public TextContainer() {
		super();

		this.setDataContent(new Object[DEFAULT_CAPACITY]);
	}

	/**
	 * This constructor indicates the capacity of the empty which will created.
	 */
	public TextContainer(int capacity) {
		super();

		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal capacity");
		}

		this.setDataContent(new Object[capacity]);
	}

	/**
	 * @see com.evaluation.content.analizer.api.IContent#parseContent(Object)
	 */
	public void parseContent(Object content) {

		if (null != content && content instanceof String && !((String) content).isEmpty()) {

			StringTokenizer tokenizer = new StringTokenizer((String) content, SEPARATORS);
			while (tokenizer.hasMoreTokens()) {
				this.add(new Word(tokenizer.nextToken()));
			}
		} else if (!(content instanceof String)) {

			throw new IllegalArgumentException("The content to be parsed must be of the type String");
		}
	}
	
	/**
	 * @see com.evaluation.content.analizer.api.IContent#add(Object)
	 */
	public boolean add(IWord toAdd) {

		ensureCapacity(this.size() + 1);
		this.getDataContent()[this.size++] = toAdd;
		return true;
	}

}
