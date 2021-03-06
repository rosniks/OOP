package apfel;

import werkzeuge.Entsaftbar;
import werkzeuge.Vergleichbar;

public class Apfel implements Entsaftbar, Vergleichbar {
	private String name; // bekannte Apfelsorten sind: Braeburn, Jonagold, Gala, ...
	private String farbe; // nur gruen oder rot m?glich
	private double groesse; // Umfang in Zentimetern

	public Apfel(String name, String farbe, double groesse) {
		setName(name);
		setFarbe(farbe);
		setGroesse(groesse);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		if (farbe.equals("rot") || farbe.equals("gruen"))
			this.farbe = farbe;
		else
			System.out.println("Aepfel k?nnen nicht " + farbe + " sein.");
	}

	public double getGroesse() {
		return groesse;
	}

	public void setGroesse(double groesse) {
		this.groesse = Math.abs(groesse);
	}

	public void wachsen() {
		setGroesse(2 * getGroesse());
	}

	public void reifen() {
		setFarbe("rot");
	}

	public String toString() {
		return ("Name:" + getName() + ", Farbe:" + getFarbe() + ", Groesse:" + getGroesse());
	}

	public boolean grobVergleichen(Object o) {
		return (o instanceof Apfel);
	}

	public boolean genauVergleichen(Object o) {
		if (grobVergleichen(o)) {
			Apfel a = (Apfel) o;
			return ((getName() == a.getName()) && (getFarbe() == a.getFarbe()) && (getGroesse() == a.getGroesse()));
		} else
			return false;
	}

	public double entsaften() {
		return (ERTRAGBIRNE * (4 / 3) * 8 * Math.pow((Math.PI), 4) / Math.pow(groesse, 3));
	}

}
