package counters;

/**
 * compteur
 */
public class Counter {
	/**
	 * Valeur du compteur
	 */
	private int value;

	/**
	 * Constructeur
	 * @param value
	 * 	valeur à définir
	 */
	public Counter(int value) {
		this.value = value;
	}

	/**
	 * Retourne la valeur du compteur
	 * @return la valeur du compteir
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Incrémente le compteur
	 */
	public void increment() {
		value++;
	}

	/**
	 * Décrémente le compteur
	 */
	public void decrement() {
		value--;
	}

	/**
	 * Définit la veleur du compteur
	 * @param value
	 * 	valeur à défiir
	 */
	public void setValue(int value) {
		this.value = value;
	}

}