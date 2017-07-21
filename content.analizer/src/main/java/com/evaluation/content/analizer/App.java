package com.evaluation.content.analizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.evaluation.content.analizer.api.IAnalyseResult;
import com.evaluation.content.analizer.core.TextContainer;
import com.evaluation.content.analizer.sorting.SortStrategyByAscci;
import com.evaluation.content.analizer.sorting.SortStrategyByLength;
import com.evaluation.content.analizer.sorting.WordComparator;
import com.evaluation.content.analizer.sorting.WordQuickSort;
import com.evaluation.content.analizer.utility.ContentAnalizer;

/**
 * This class is to run the evaluation. Have a good Test...
 *
 */
public class App {
	
	public static void main(String[] args) throws Exception {
		
		@SuppressWarnings("unchecked")
		WordComparator comparator = new WordComparator(new SortStrategyByLength(), new SortStrategyByAscci() );

        WordQuickSort wordSort = new WordQuickSort(comparator);

        TextContainer text = new TextContainer();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter something [for example:The quick brown fox jumped over the lazy brown dog’s back]:");
        String input = br.readLine();
        
        text.parseContent(input);
        
        ContentAnalizer analiser = new ContentAnalizer(wordSort);
        
        IAnalyseResult analizeContent = analiser.analizeContent(text);
        System.out.println("The result is :");
        analizeContent.printReport();
	}
}
