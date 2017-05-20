package counters;

/**
 * Compteur cyclique
 */
public class CyclicCounter extends BoundedCounter {

	/**
	 * Constructeur
	 * @param value
	 * 	la valeur du compteur
	 * @param max
	 * 	la valeur maximale
	 * @param min
	 * 	la valeur minimale
	 */
	public CyclicCounter(int value, int max, int min) {
		super(value, max, min);
	}

	/* (non-Javadoc)
	 * @see counters.BoundedCounter#decrement()
	 */
	@Override
	public void decrement() {
		if (getValue() > getMin()) {
			super.decrement();
		} else {
			setValue(getMax());
		}
	}

	/* (non-Javadoc)
	 * @see counters.BoundedCounter#increment()
	 */
	@Override
	public void increment() {
		if (getValue() < getMax()) {
			super.increment();
		} else {
			setValue(getMin());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Clock.transform(getValue());
	}



}