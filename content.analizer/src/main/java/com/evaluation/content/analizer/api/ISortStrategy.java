package com.evaluation.content.analizer.api;

/**
 * Exposition the method of sorting for contents.
 * 
 * @author dmaldonado
 *
 */
public interface ISortStrategy<C extends IWord> {
	
	final int BEFORE = -1;
	
	final int EQUAL = 0;
	
	final int AFTER = 1;

	/**
	 * Sorts the content according to an order to be specified.
	 * 
	 * @param content1
	 *            first content
	 * @param content2
	 *            second content
	 * @return 1 if content1 greater than content2, 2 if content1 lower than
	 *         content2, 0 in another case
	 */
	int sort(C content1, C content2);

}
