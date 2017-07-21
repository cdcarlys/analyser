package com.evaluation.content.analizer.sorting;

import com.evaluation.content.analizer.api.ISortStrategy;
import com.evaluation.content.analizer.core.Word;

/**
 * Strategy to sort Words by their length.
 * 
 * @author dmaldonado
 *
 */
public class SortStrategyByLength implements ISortStrategy<Word> {

	/**
	 * @see ISortStrategy#sort(java.lang. Object, java.lang.Object)
	 */
	public int sort(Word content1, Word content2) {

		if (content1.getValue().length() > content2.getValue().length()) {
			return AFTER;
		} else if (content1.getValue().length() < content2.getValue().length()) {
			return BEFORE;
		}

		return EQUAL;
	}

}
