package objects;

/**
 * Statut d'un objet
 */
public class Status {
	/**
	 *  Booléen on
	 */
	boolean on;
	/**
	 *  Booléen detected
	 */
	boolean detected;
	/**
	 *  booléen problème
	 */
	boolean problem;
	/**
	 *  valeur de la quantité
	 */
	int quantity;

	/**
	 * Constructeur
	 */
	public Status() {
	}

	/**
	 * Changer de statut
	 * @param var
	 * 	variable à changer
	 * <p>
	 * booléen de nom var prend pour valeur son inverse
	 * </p>
	 */
	public void switchStatus(String var) {
		switch (var) {
		case "on":
			on = !on;
			break;
		case "detected":
			detected = !detected;
			break;
		case "problem":
			problem = !problem;
			break;
		default:
			break;
		}
	}

	/**
	 * Décrémente la quantité
	 */
	public void decrease() {
		if (quantity > 0)
			quantity--;
		else
			System.out.println("ERROR");
	}

	/**
	 * Inccrémente la quantité
	 */
	public void increase() {
		quantity++;
	}

	/**
	 * Définit la quantité
	 * @param var
	 * 	valeur à définir comme quantité
	 * <p>
	 * Quantité prend var pour valeur
	 * </p>
	 */
	public void setQuantity(int var) {
		quantity = var;
	}

	/**
	 * Set On
	 * @param var
	 * 	valeur souhiatée de on
	 * <p>
	 * On prend pour valeur var
	 * </p>
	 */
	public void setOn(boolean var) {
		on = var;
	}

	/**
	 * Set Detected
	 * @param var
	 * 	valeur souhaitée de detected
	 * <p>
	 * Detected prend pour valeur var
	 * </p>
	 */
	public void setDetected(boolean var) {
		detected = var;
	}

	/**
	 * Set Problem
	 * @param var
	 * 	valeur souhaitée de var
	 * <p>
	 * Problem prend pour valeur var
	 * </p>
	 */
	public void setProblem(boolean var) {
		problem = var;
	}

	/**
	 * Retourne la valeur de On
	 * @return la valeur de on
	 */
	public boolean getOn() {
		return on;
	}

	/**
	 * retourne la valeur de Detected 
	 * @return la valeur de detected
	 */
	public boolean getDetected() {
		return detected;
	}

	/**
	 * Retourne la valeur de Problem
	 * @return la valeur de problem
	 */
	public boolean getProblem() {
		return problem;
	}

	/**
	 * Retoune la quantité
	 * @return la valeur de quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Initialise le statut
	 * <p>
	 * Définit on, detected et problem à false, définit la qunatité à 0
	 * </p>
	 */
	public void ini() {
		setQuantity(0);
		setOn(false);
		setDetected(false);
		setProblem(false);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "on: " + String.valueOf(on) + " | detected : " + String.valueOf(detected) + " | pb : "
				+ String.valueOf(problem) + " | quantity : " + quantity;
	}
}