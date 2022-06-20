package bankkonto;

public class TestGiroKonto {

	public static void main(String[] args) {
		GiroKonto gustav = new GiroKonto(167565, 5662, "Sparkasse", "Gustav", "EUR", 50, 10000);
		gustav.druckeKontoBlatt();
		System.out.println();
		gustav.dollarUmstellung();
		gustav.druckeKontoBlatt();
	}

}
