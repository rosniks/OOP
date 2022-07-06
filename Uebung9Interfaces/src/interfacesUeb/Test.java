package interfacesUeb;

import apfel.Apfel;
import birne.Birne;
import werkzeuge.Entsaftbar;

public class Test {

	public static void main(String[] args) {
		 Apfel a1 = new Apfel("Delicious", "gruen", 4);
		 Apfel a2 = new Apfel("Braeburn", "gruen", 3); 
		 Apfel a3 = new Apfel("Braeburn", "gruen", 3); 
		 System.out.println(a1.genauVergleichen(a2));
		 System.out.println(a2.genauVergleichen(a3));
		 Entsaftbar e = a1;
		 System.out.println(e.entsaften());
		 a1.reifen();
		 System.out.println(e.entsaften());
		 Birne b = new Birne("Williams", "gruen", 7);
		 e=b;
		 System.out.println(e.entsaften());
		 b.wachsen();
		 System.out.println(b);
		 System.out.println(b.genauVergleichen(a3));
	}

}
