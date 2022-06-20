package bankkonto;

public class GiroKonto extends Konto{
	private double kreditrahmen;
	
	GiroKonto(long kontonr, long blz, String institut, String inhaber, String waehrung, double saldo, double kreditrahmen){
		super(kontonr, blz, institut, inhaber, waehrung, saldo);
		setKreditrahmen(kreditrahmen);
	}

	public double getKreditrahmen() {
		return kreditrahmen;
	}

	public void setKreditrahmen(double kreditrahmen) {
		this.kreditrahmen = kreditrahmen;
	}
	
	public double verfuegbar() {
		return (getSaldo()+ getKreditrahmen());
	}
	
	public void buchen(double bewegung) {
		setSaldo(getSaldo()+ bewegung - currentGebuehr());
	}
	
	public void dollarUmstellung() {
		if(getWaehrung() == "USD") 
			System.out.println("Ihr Konto ist bereits auf USD gestellt");
		else
		{
			setSaldo(getSaldo()*UMRECHNUNGSFAKTOR_EUR_USD);
			setWaehrung("USD");
			setKreditrahmen(getKreditrahmen()*UMRECHNUNGSFAKTOR_EUR_USD);
		}
	}
	
	public void euroUmstellung() {
		if(getWaehrung() == "EUR")
			System.out.println("Ihr Konto ist bereits auf EUR gestellt");
		else {
			setSaldo(getSaldo()/UMRECHNUNGSFAKTOR_EUR_USD);
			setWaehrung("EUR");
			setKreditrahmen(getKreditrahmen()/UMRECHNUNGSFAKTOR_EUR_USD);
		}
	}
	
	public void druckeKontoBlatt() {
		super.druckeKontoBlatt();
		System.out.println("Kreditrahmen: "+getKreditrahmen());
	}
}
