package airline;

public class FrachtFlugzeug extends Flugzeug{
	private double maxZuladung;
	
	FrachtFlugzeug(double maxGewicht, double reiseGeschw, double flugStunden, double verbrauch, double tankKapazitaet,double kerosinVorrat, double maxZuladung){
		super(maxGewicht, reiseGeschw, flugStunden, verbrauch, tankKapazitaet,kerosinVorrat);
		setMaxZuladung(maxZuladung);
	}

	public double getMaxZuladung() {
		return maxZuladung;
	}

	public void setMaxZuladung(double maxZuladung) {
		if(maxZuladung <= (maxGewicht-tankKapazitaet))
			this.maxZuladung = maxZuladung;
		else
			System.out.println("Das Flugzeug packt die Maximale Zuladung nicht!!!");
	}
	
	public String toString() {
		String string = super.toString()+ ", Max.Zuladung: " + getMaxZuladung();
		return string;
	}
	
	

}
