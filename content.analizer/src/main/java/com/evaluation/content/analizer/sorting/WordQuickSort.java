package com.evaluation.content.analizer.sorting;

import java.util.Arrays;

import com.evaluation.content.analizer.api.IComparable;
import com.evaluation.content.analizer.api.IContent;
import com.evaluation.content.analizer.api.ISortable;
import com.evaluation.content.analizer.core.Word;

/**
 * This class implements the quick sort algorithm in order to sort the content found in the {@link IContent<IWord>.}
 *
 * Created by dmaldonado on 21/07/2017.
 */
public class WordQuickSort implements ISortable<Word> {

    /**
     * Container of words
     */
    private Word[] words;

    /**
     * Length of the container of words.
     */
    private int length;

    /**
     * The comparator of content
     */
    private IComparable<Word> comparator;

    /**
     * @param wordContainer contains all word to be sorted
     */
    public WordQuickSort(IComparable<Word> comparator) {

        if (null == comparator) {
            throw new IllegalArgumentException("A comparator of Word is necessary to sort words");
        }

        this.comparator = comparator;
    }

    /**
     * Responsible to call the method to sort the content.
     */
    public Word[] sort() throws Exception {

        if (null == this.words) {
            throw new Exception("Impossible to sort a null content");
        }

        return quickSort(0, this.length -1);
    }

    /**
     * Sort the words with the quick sort algorithm.
     *
     * @param lowerIndex lower index of the array to sort the array
     * @param higherIndex higher index of the array to sort the array
     */
    private Word[] quickSort(final int lowerIndex, final int higherIndex){

        int i = lowerIndex;
        int j = higherIndex;

        // calculate pivot word

        Word pivot = this.words[lowerIndex+(higherIndex-lowerIndex)/2];

        // Divide into two arrays
        while (i <= j) {

            while (comparator.compare(this.words[i], pivot) < 0) {
                i++;
            }
            while (comparator.compare(this.words[j], pivot)  > 0) {
                j--;
            }
            if (i <= j) {
                exchangeWords(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }

        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);

        if (i < higherIndex)
            quickSort(i, higherIndex);

        return this.words;
    }

    /**
     * Exchange the position of two words in the container
     *
     * @param i first index to do the exchange
     * @param j second index to dot the exchange
     */
    private void exchangeWords(int i, int j) {
        Word temp = this.words[i];
        this.words[i] = this.words[j];
        this.words[j] = temp;
    }

    /**
     * @param text the container of word to set the words to sort
     */
	public void setSortableContent(@SuppressWarnings("rawtypes") IContent textToAnalyze) {
		
		if (textToAnalyze == null || textToAnalyze.getDataContent() == null || textToAnalyze.size() == 0) {
            throw new IllegalArgumentException("A word container with values must be passed in arguments");
        }

        this.words =  Arrays.copyOf(textToAnalyze.getDataContent(), textToAnalyze.size(), Word[].class);
        this.length = this.words.length;
		
	}
}
