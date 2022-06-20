package airline;

public class Flugzeug {
	double maxGewicht, reiseGeschw, flugStunden, verbrauch, tankKapazitaet, kerosinVorrat;

	Flugzeug(double maxGewicht, double reiseGeschw, double flugStunden, double verbrauch, double tankKapazitaet,double kerosinVorrat) {
		setMaxGewicht(maxGewicht);
		setReiseGeschw(reiseGeschw);
		setFlugStunden(flugStunden);
		setVerbrauch(verbrauch);
		setTankKapazitaet(tankKapazitaet);
		setKerosinVorrat(kerosinVorrat);
	}

	public double getMaxGewicht() {
		return maxGewicht;
	}

	public void setMaxGewicht(double maxGewicht) {
		this.maxGewicht = maxGewicht;
	}

	public double getReiseGeschw() {
		return reiseGeschw;
	}

	public void setReiseGeschw(double reiseGeschw) {
		this.reiseGeschw = reiseGeschw;
	}

	public double getFlugStunden() {
		return flugStunden;
	}

	public void setFlugStunden(double flugStunden) {
		this.flugStunden = flugStunden;
	}

	public double getVerbrauch() {
		return verbrauch;
	}

	public void setVerbrauch(double verbrauch) {
		this.verbrauch = verbrauch;
	}

	public double getTankKapazitaet() {
		return tankKapazitaet;
	}

	public void setTankKapazitaet(double tankKapazitaet) {
		this.tankKapazitaet = tankKapazitaet;
	}

	public double getKerosinVorrat() {
		return kerosinVorrat;
	}

	public void setKerosinVorrat(double kerosinVorrat) {
		if(getTankKapazitaet()<kerosinVorrat) 
			System.out.println("Der Tank darf nicht überfüllt werden");
			else
				this.kerosinVorrat = kerosinVorrat;
	}

	public void info() {
		System.out.println("Flugstunden:\t" + getFlugStunden() + ", " + "Tankinhalt:\t" + getKerosinVorrat());
	}

	public String toString() {
		String string;
		string = "Max. Gewicht: " + getMaxGewicht() + ", " + "Reise Geschwindigkeit: " + getReiseGeschw() + ", "
				+ "Flugstunden: " + getFlugStunden() + ", " + "Verbrauch: " + getVerbrauch() + ", " + "Tank Kapazität: "
				+ getTankKapazitaet() + ", " + "Kerosin Vorrat" + getKerosinVorrat();
		return string;
	}

	public double reichweite() {
		double reichweite;
		reichweite = (getKerosinVorrat() / getVerbrauch()) * getReiseGeschw();
		return reichweite;
	}
	
	public boolean fliegen(double km) {
		if(km > reichweite())
			return false;
		else {
			double h = km/getReiseGeschw();
			setFlugStunden((getFlugStunden()+ h));
			setKerosinVorrat((getKerosinVorrat()- getVerbrauch()*h));
			return true;
		}
	}
	
	public void tanken(double liter) {
		setKerosinVorrat(liter + getKerosinVorrat());
	}

}
