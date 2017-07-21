package com.evaluation.content.analizer.sorting;

import com.evaluation.content.analizer.api.IComparable;
import com.evaluation.content.analizer.api.ISortStrategy;
import com.evaluation.content.analizer.core.Word;

/**
 * Created by dmaldonado on 21/07/2017.
 */
public final class WordComparator implements IComparable<Word> {

	/**
	 * the sorting strategies used by the comparator
	 */
	private ISortStrategy<Word>[] sortingStrategies;

	/**
	 * Constructor where the strategies of sorting are set to this.
	 */
	public WordComparator(ISortStrategy<Word>... sortingStrategies) {

		if (null == sortingStrategies || sortingStrategies.length == 0) {
			throw new IllegalArgumentException("It is necessary almost one strategy");
		}

		this.sortingStrategies = sortingStrategies;
	}

	/**
	 * compare the word with the strategies set for this comparator.
	 */
	public int compare(Word word1, Word word2) {

		for (ISortStrategy<Word> strategy : this.sortingStrategies) {
			int compareResult = strategy.sort(word1, word2);
			if (compareResult != 0) {
				return compareResult;
			}
		}

		return 0;
	}
}
