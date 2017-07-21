package com.evaluation.content.analizer.sorting;

import com.evaluation.content.analizer.api.ISortStrategy;
import com.evaluation.content.analizer.core.Word;

/**
 * Strategy to sort Words by their ascii codes.
 * 
 * @author dmaldonado
 *
 */
public class SortStrategyByAscci implements ISortStrategy<Word> {

	/**
	 * @see ISortStrategy#sort(java.lang. Object, java.lang.Object)
	 */
	public int sort(Word content1, Word content2) {

		return content1.getValue().compareTo(content2.getValue());
	}

}
