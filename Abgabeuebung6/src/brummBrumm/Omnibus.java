package brummBrumm;

public class Omnibus extends Auto{
	private int anzahlSitze;
	
	Omnibus(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat, int anzahlSitze){
		super(kmStand, verbrauch, tankVolumen, kraftstoffVorrat);
		setAnzahlSitze(anzahlSitze);
	}

	public int getAnzahlSitze() {
		return anzahlSitze;
	}

	public void setAnzahlSitze(int anzahlSitze) {
		this.anzahlSitze = Math.abs(anzahlSitze);
	}
	
	public String toString() {
		return super.toString()+ ", AnzahlSitze: " + anzahlSitze;
	}
	
	
}
