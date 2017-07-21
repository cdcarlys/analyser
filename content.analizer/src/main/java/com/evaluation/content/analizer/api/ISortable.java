package com.evaluation.content.analizer.api;

/**
 * Expose the main method to sort instance that inherits of {@link IWord}
 * 
 * Created by dmaldonado on 21/07/2017.
 */
public interface ISortable<C extends IWord> {

	/**
	 * Sort the elements of the type {@link IWord}
	 * 
	 * @return an array of element sorted
	 * @throws Exception
	 */
	C[] sort() throws Exception;

	/**
	 * Set the content to be sorted
	 * 
	 * @param textToAnalyze
	 */
	void setSortableContent(IContent<?> textToAnalyze);
}
