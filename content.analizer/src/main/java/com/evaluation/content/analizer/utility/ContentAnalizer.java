package com.evaluation.content.analizer.utility;

import com.evaluation.content.analizer.api.IAnalyseResult;
import com.evaluation.content.analizer.api.IContent;
import com.evaluation.content.analizer.api.IContentAnalizer;
import com.evaluation.content.analizer.api.ISortable;
import com.evaluation.content.analizer.core.AnalyseResult;
import com.evaluation.content.analizer.core.Word;

/**
 * This analyser of text will sort it with two criteria: <br/>
 * 
 * <ul>
 * <li>Length of the word</li>
 * <li>Code Ascii</li>
 * </ul>
 * 
 * @author dmaldonado
 *
 */
@SuppressWarnings("rawtypes")
public class ContentAnalizer implements IContentAnalizer {

	/**
	 * The sorter to be used to analyse the text
	 */
	private ISortable<Word> wordSorter;

	/**
	 * 
	 * @param wordSorter
	 */
	public ContentAnalizer(ISortable<Word> wordSorter) {

		if (null == wordSorter) {
			throw new IllegalArgumentException("To analize a text we need a sorter of text");
		}

		this.wordSorter = wordSorter;
	}

	/**
	 * responsible to apply the sorting and count the number of time every word
	 * is repeated.
	 */
	public IAnalyseResult analizeContent(IContent content) throws Exception {

		AnalyseResult result = new AnalyseResult();

		wordSorter.setSortableContent(content);
		Word[] sortedWords = wordSorter.sort();

		for (Word word : sortedWords) {
			result.add(word);
		}

		return result;
	}

}
