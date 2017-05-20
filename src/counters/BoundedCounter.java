package counters;

/**
 * Compteur délimité
 *
 */
public class BoundedCounter extends Counter {
	/**
	 * Valeur maximale
	 */
	private int max;
	/**
	 * Valeur minimale
	 */
	private int min;

	/**
	 * Constructeur
	 * @param value
	 * 	valeur du compteur
	 * @param max
	 * 	la valeur maximale
	 * @param min
	 * 	la valeur minnimale
	 */
	public BoundedCounter(int value, int max, int min) {
		super(value);
		this.max = max;
		this.min = min;
	}

	/* (non-Javadoc)
	 * @see counters.Counter#decrement()
	 */
	@Override
	public void decrement() {
		if (getValue() > min) {
			super.decrement();
		}
	}

	/* (non-Javadoc)
	 * @see counters.Counter#increment()
	 */
	@Override
	public void increment() {
		if (getValue() < max) {
			super.increment();
		}
	}

	/**
	 * Retourne la valeur max
	 * @return la valeur maximale
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Retourne la valeur min
	 * @return la valeur minimale
	 */
	public int getMin() {
		return min;
	}

}