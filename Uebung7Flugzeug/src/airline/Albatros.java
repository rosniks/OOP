package airline;

public class Albatros {

	public static void main (String[] args) {
		FrachtFlugzeug albatros = new FrachtFlugzeug(68000, 800, 500, 2000, 20000, 16000, 200000);
		albatros.fliegen(3000);
		albatros.tanken(5000);
		albatros.info();
		System.out.println(albatros);
	}
}
