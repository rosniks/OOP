package aufgabe1;

public class Caesar {
	private final int ABSTAND;
	
	Caesar(int a){
		if((a>=-26) && (a<=26))
		ABSTAND = a;
		else ABSTAND= a%26;
	}
	
	public char codiere(char c) {
		return (char)((c+ABSTAND)<26 ? (c+ABSTAND) : (c+ABSTAND)%26);
	}
	
	public static void main(String[] args) {
		Caesar tmp = new Caesar(1);
		String sup = "Hallozz";
		for(int i=0; i<sup.length(); i++) {
			char l =tmp.codiere(sup.charAt(i));
			System.out.print(l);
		}
	}
	
	
}
