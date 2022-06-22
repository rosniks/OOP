package brummBrumm;

public class Auto {
	private int kmStand;
	private double verbrauch; // Verbrauch auf 100 Kilometern
	private double tankVolumen;
	private double kraftstoffVorrat;

	Auto(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat) {
		setKmStand(kmStand);
		setVerbrauch(verbrauch);
		setTankVolumen(tankVolumen);
		setKraftstoffVorrat(kraftstoffVorrat);
	}

	public int getKmStand() {
		return kmStand;
	}

	public void setKmStand(int kmStand) {
		this.kmStand = Math.abs(kmStand);
	}

	public double getVerbrauch() {
		return verbrauch;
	}

	public void setVerbrauch(double verbrauch) {
		this.verbrauch = Math.abs(verbrauch);
	}

	public double getTankVolumen() {
		return tankVolumen;
	}

	public void setTankVolumen(double tankVolumen) {
		this.tankVolumen = Math.abs(tankVolumen);
	}

	public double getKraftstoffVorrat() {
		return kraftstoffVorrat;
	}

	public void setKraftstoffVorrat(double kraftstoffVorrat) {
		if (getKraftstoffVorrat() > getTankVolumen())
			System.out.println("So viel passt nicht in den Tank!!!");
		else
			this.kraftstoffVorrat = kraftstoffVorrat;
	}

	public void info() {
		System.out.println("Kilometerstand:\t" + getKmStand());
		System.out.println("Tankinhalt:\t" + getKraftstoffVorrat());
	}

	public String toString() {
		return "KmStand: " + kmStand + ", Verbrauch: " + verbrauch + ", Vol.Tank: " + tankVolumen + ", Tankinhalt: "
				+ kraftstoffVorrat;
	}

	public void fahren(int km) {
		if (km > (getKraftstoffVorrat() / getVerbrauch()) * 100)
			System.out.println("Zu wenig Tank für die Strecke!");
		else {
			setKmStand(getKmStand() + km);
			setKraftstoffVorrat(getKraftstoffVorrat() - getVerbrauch() * (km / 100));
		}
	}

	public void tanken(double liter) {
		if (liter > getTankVolumen() - getKraftstoffVorrat())
			System.out.println("Es wird nicht getankt, das würde den Tank zum überlauf bringen!!!");
		else {
			setKraftstoffVorrat(liter + getKraftstoffVorrat());
		}
	}

	public static void main(String[] args) {
		Auto goggoMobil = new Auto(0, 5.0, 50, 30);
		goggoMobil.fahren(300);
		goggoMobil.tanken(45);
		goggoMobil.info();
	}
}
