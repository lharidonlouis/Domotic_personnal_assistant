package counters;

/**
 * Horloge
 */
public class Clock implements Runnable {
	/**
	 * Compteur cyclique de la semaine
	 */
	private CyclicCounter week = new CyclicCounter(1, 4, 1);
	/**
	 * compteur cyclique du jour
	 */
	private CyclicCounter day = new CyclicCounter(1, 7, 1);
	/**
	 * compteur cycliqeu de l'heure
	 */
	private CyclicCounter hour = new CyclicCounter(0, 23, 0);
	/**
	 * compteur cycliqeu des minutes
	 */
	private CyclicCounter minute = new CyclicCounter(0, 59, 0);
	/**
	 * valeur de la vitesse de l'horloge
	 */
	private static final int CHRONO_SPEED = 500;

	/**
	 * SerialVersionID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Fonction d'incrémenation 10 par 10 de l'horloge
	 */
	public void increment() {
		for (int i = 0; i < 10; i++) {
			minute.increment();
			if (minute.getValue() == 0) {
				hour.increment();
				if (hour.getValue() == 0) {
					day.increment();
					if (day.getValue() == 1) {
						week.increment();
					}
				}
			}
		}
	}

	/**
	 * Fonction de décrémentation 10 par 10 de l'horloge
	 */
	public void decrement() {
		for (int i = 0; i < 10; i++) {
			minute.decrement();
			if (minute.getValue() == 59) {
				hour.decrement();
				if (hour.getValue() == 23) {
					day.decrement();
					if (day.getValue() == 7) {
						week.decrement();
					}
				}
			}
		}
	}

	/**
	 * Retourne la semaine
	 * @return le compteur cyclique semaine
	 */
	public CyclicCounter getWeek() {
		return week;
	}

	/**
	 * Retourne le jour
	 * @return le compteur cyclique jour
	 */
	public CyclicCounter getDay() {
		return day;
	}

	/**
	 * Retourne l'heure
	 * @return le compteur cyclique heure
	 */
	public CyclicCounter getHour() {
		return hour;
	}

	/**
	 * Retourne la minute
	 * @return le compteur cyclique minute
	 */
	public CyclicCounter getMinute() {
		return minute;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return week.toString() + " : " + day.toString() + " : " + hour.toString() + " : " + minute.toString();
	}

	
	/**
	 * Initialisation de l'horloge
	 */
	public void init() {
		week.setValue(1);
		day.setValue(1);
		hour.setValue(0);
		minute.setValue(0);
	}

	/**
	 * Définition de l'horloge
	 * @param m
	 * 	minute à définir
	 * @param h
	 * 	heure à définir
	 * @param d
	 * 	jour à définir
	 * @param w
	 * 	semaine à définir
	 */
	public void set(int m, int h, int d, int w) {
		week.setValue(w);
		day.setValue(d);
		hour.setValue(h);
		minute.setValue(m);
	}

	/**
	 * Vérification de la plage horraire
	 * @param delta
	 * 	différence max à vérifier
	 * @param base
	 * 	Horloge à comparer
	 * @return vrai si l'horloge à moins de delta*10 minutes de différence avec l'horloge base, faux sinons
	 */
	public boolean inrange(int delta, Clock base) {
		if ((getMinute().getValue() == (base.getMinute().getValue()))
				&& (getHour().getValue() == (base.getHour().getValue()))) {
			return true;
		}
		for (int i = 0; i < (delta / 10); i++) {
			base.increment();
			if ((getMinute().getValue() == (base.getMinute().getValue()))
					&& (getHour().getValue() == (base.getHour().getValue()))) {
				return true;
			}
		}
		for (int i = 0; i < ((2 * delta) / 10); i++) {
			base.decrement();
			if ((getMinute().getValue() == (base.getMinute().getValue()))
					&& (getHour().getValue() == (base.getHour().getValue()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determination de la différence
	 * @param delta 
	 * 	différence max
	 * @param base
	 * 	Horloge à comparer
	 * @return la valeur de la différence entre l'Horloge et l'Horloge base
	 */
	public int inrangeOf(int delta, Clock base) {
		int count = 0;
		if ((getMinute().getValue() == (base.getMinute().getValue()))
				&& (getHour().getValue() == (base.getHour().getValue()))) {
			return count;
		}

		for (int i = 0; i < (delta / 10); i++) {
			base.increment();
			count++;
			if ((getMinute().getValue() == (base.getMinute().getValue()))
					&& (getHour().getValue() == (base.getHour().getValue()))) {
				return count;
			}
		}
		for (int i = 0; i < ((2 * delta) / 10); i++) {
			base.decrement();
			count--;
			if ((getMinute().getValue() == (base.getMinute().getValue()))
					&& (getHour().getValue() == (base.getHour().getValue()))) {
				return count;
			}
		}
		return count;
	}

	
	/**
	 * Transformation pour affichage
	 * @param value
	 * 	valeur
	 * @return la valeur en string
	 */
	public static String transform(int value) {
		String result = "";
		if (value < 10) {
			result = "0" + value;
		} else {
			result = String.valueOf(value);
		}
		return result;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		boolean run = true;
		while (run) {
			increment();
			// System.out.println(toString());
		}
	}

}