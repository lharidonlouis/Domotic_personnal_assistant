package objects;

/**
 * Position d'un objet
 */
public class Position {
	/**
	 * Valeur X de la position
	 */
	private int posX;
	/**
	 *  Valeur Y de la position
	 */
	private int posY;

	/**
	 * Constructeur de la position
	 * @param posX
	 * 	la position x
	 * @param posY
	 * 	la position y
	 */
	public Position(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * Retourne la position X
	 * @return la position x
	 */
	public int getposX() {
		return posX;
	}

	/**
	 * Retourne la position Y
	 * @return la position Y souhaitée
	 */
	public int getposY() {
		return posY;
	}

	/**
	 * Définit la position X
	 * @param posX
	 * 	la position x souhaitée
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Définit la position Y
	 * @param posY
	 * 	la position y
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "x: " + posX + " y: " + posY;
	}
}
