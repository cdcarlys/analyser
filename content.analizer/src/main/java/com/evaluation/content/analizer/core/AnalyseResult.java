package com.evaluation.content.analizer.core;

import java.util.Optional;

import com.evaluation.content.analizer.api.IAnalyseResult;
import com.evaluation.content.analizer.api.IWord;

/**
 * This class represent the result of the analyse of the text.
 *
 * @author dmaldonado
 *
 */
public class AnalyseResult extends AbstractArray<IWord> implements IAnalyseResult {

	/**
	 * Default constructor
	 */
	public AnalyseResult() {
		super();

		this.setDataContent(new Object[DEFAULT_CAPACITY]);
	}

	/**
	 * This constructor indicates the capacity of the empty which will created.
	 */
	public AnalyseResult(int capacity) {

		if (capacity < 0) {
			throw new IllegalArgumentException(ILLEGAL_CAPACITY);
		}

		this.setDataContent(new Object[capacity]);
	}

	/**
	 * @see com.evaluation.content.analizer.api.IReport#printReport()
	 */
	public void printReport() {

		for (Object object : getDataContent()) {

			if (null != object) {
				System.out.println((ResultPair) object);
			}
		}
	}

	/**
	 * @param value
	 *            the value to be used to get the result.
	 * @return the result associated to the value.
	 */
	private ResultPair getResult(final String value) {

		for (Object pair : this.getDataContent()) {

			if (null != pair) {
				ResultPair currentPair = (ResultPair) pair;

				if (currentPair.getSecondElement().equals(value)) {
					return currentPair;
				}
			}
		}

		return null;
	}

	@Override
	public boolean add(IWord toAdd) {

		if (null != toAdd) {

			Optional<ResultPair> optionalResult = Optional.ofNullable(getResult(toAdd.getValue()));
			ResultPair result = null;

			if (!optionalResult.isPresent()) {

				result = new ResultPair(Integer.valueOf(1), toAdd.getValue());
				ensureCapacity(this.size() + 1);
				this.getDataContent()[this.size++] = result;
				
			} else {

				result = optionalResult.get();
				result.setFirstElement(Integer.valueOf(result.getFirstElement().intValue() + 1));
			}


			return true;
		}

		return false;
	}

}
