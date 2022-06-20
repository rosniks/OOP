package bankkonto;

public abstract class Konto {
	private long kontonr; // Kontonummer
	private long blz; // Bankleitzahl
	private String institut; // Name des Kreditinstituts
	private String inhaber; // Name des Kontoinhabers
	private String waehrung; // entweder "USD" oder "EUR"
	private double saldo; // aktueller Kontostand
	private static double gebuehr = 0.20; // Buchungspostengebuehr

	public final double UMRECHNUNGSFAKTOR_EUR_USD = 1.4283;

	Konto(long kontonr, long blz, String institut, String inhaber, String waehrung, double saldo) {
		setKontonr(kontonr);
		setBlz(blz);
		setInstitut(institut);
		setInhaber(inhaber);
		setWaehrung(waehrung);
		setSaldo(saldo);
	}

	public long getKontonr() {
		return kontonr;
	}

	public void setKontonr(long kontonr) {
		this.kontonr = kontonr;
	}

	public long getBlz() {
		return blz;
	}

	public void setBlz(long blz) {
		this.blz = blz;
	}

	public String getInstitut() {
		return institut;
	}

	public void setInstitut(String institut) {
		this.institut = institut;
	}

	public String getInhaber() {
		return inhaber;
	}

	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(String waehrung) {
		if (waehrung == ("EUR") || waehrung == "USD")
			this.waehrung = waehrung;
		else
			System.out.println("Falsches Währungsformat");
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getGebuehr() {
		return gebuehr;
	}

	public static void setGebuehr(double gebuehr) {
		Konto.gebuehr = gebuehr;
	}

	public abstract double verfuegbar();

	public void buchen(double bewegung) {
		setSaldo(getSaldo() + bewegung);
	}

	public void dollarUmstellung() {
		if (getWaehrung() == "USD")
			System.out.println("Ihr Konto ist bereits auf USD gestellt");
		else {
			setSaldo(getSaldo() * UMRECHNUNGSFAKTOR_EUR_USD);
			setWaehrung("USD");
		}
	}

	public double currentGebuehr() {
		if (getWaehrung() == "EUR")
			return (getGebuehr());
		else if (getWaehrung() == "USD")
			return (getGebuehr() * UMRECHNUNGSFAKTOR_EUR_USD);
		else {
			System.out.println("Fehler beim Währungsformat");
			return getGebuehr();
		}
	}

	public void euroUmstellung() {
		if (getWaehrung() == "EUR")
			System.out.println("Ihr Konto ist bereits auf EUR gestellt");
		else {
			setSaldo(getSaldo() / UMRECHNUNGSFAKTOR_EUR_USD);
			setWaehrung("EUR");
		}
	}

	public void druckeKontoBlatt() {
		System.out.println("Kontonummer: " + getKontonr());
		System.out.println("Bankleitzahl: " + getBlz());
		System.out.println("Kreditinstitut: " + getInstitut());
		System.out.println("Kontoinhaber: " + getInhaber());
		System.out.println("Waehrung: " + getWaehrung());
		System.out.println("aktueller Kontostand: " + getSaldo());
	}
}
