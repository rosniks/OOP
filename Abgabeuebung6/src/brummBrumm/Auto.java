package brummBrumm;

public class Auto {
	private int kmStand;
	private double verbrauch, tankVolumen, kraftstoffVorrat;
	
	Auto(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat){
		setKmStand(kmStand);
		setVerbrauch(verbrauch);
		setTankVolumen(tankVolumen);
		setKraftstoffVorrat(kraftstoffVorrat);
	}

	public int getKmStand() {
		return kmStand;
	}

	public void setKmStand(int kmStand) {
		this.kmStand = kmStand;
	}

	public double getVerbrauch() {
		return verbrauch;
	}

	public void setVerbrauch(double verbrauch) {
		this.verbrauch = verbrauch;
	}

	public double getTankVolumen() {
		return tankVolumen;
	}

	public void setTankVolumen(double tankVolumen) {
		this.tankVolumen = tankVolumen;
	}

	public double getKraftstoffVorrat() {
		return kraftstoffVorrat;
	}

	public void setKraftstoffVorrat(double kraftstoffVorrat) {
		this.kraftstoffVorrat = kraftstoffVorrat;
	}
	
	public void info() {
		System.out.println("Kilometerstand:\t"+ getKmStand());
		System.out.println("Tankinhalt:\t"+ getKraftstoffVorrat());
	}

}
