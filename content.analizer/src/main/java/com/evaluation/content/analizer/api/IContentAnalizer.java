package com.evaluation.content.analizer.api;

import com.evaluation.content.analizer.core.Word;

/**
 * In this interface are described all method to be implemented by a content
 * Analyzer.
 * 
 * @author dmaldonado
 *
 */
public interface IContentAnalizer<C extends IContent<Word>> {

	/**
	 * Analyse the content given in parameter
	 * 
	 * @param content
	 *            the content to analyse.
	 * @return an instance of {@link IAnalyseResult}
	 * @throws Exception
	 */
	IAnalyseResult analizeContent(C content) throws Exception;

}
