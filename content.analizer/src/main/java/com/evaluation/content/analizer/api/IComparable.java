package com.evaluation.content.analizer.api;

/**
 * Functional interface to define a comparable method
 *
 * Created by dmaldonado on 21/07/2017.
 */
public interface IComparable<C extends IWord> {

	/**
	 * @param toCompare1
	 *            the first element to compare
	 * @param toCompare2
	 *            the second element to compare
	 * @return negative value if first element if lower tha second one, positive
	 *         value if first element is greater than the second one, if equals
	 *         the result is 0
	 */
	int compare(C toCompare1, C toCompare2);
}
