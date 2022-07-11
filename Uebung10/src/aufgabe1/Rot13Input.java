package aufgabe1;
// Alle Methoden, die auf einem "String" arbeiten, geben einen

// neuen String zurueck, nicht etwa eine veraenderte Kopie des alten.
// Wenn Sie einen "String" direkt bearbeiten wollen, muessen Sie ein
// "StringBuffer"-Objekt verwenden.

// Das folgende Programm liest Textzeilen vom Benutzer ein und legt
// jeweils ein StringBuffer-Objekt an, das die aktuelle Zeile enthält.
// Das Programm codiert dann jedes Zeichen dieser Zeile mit dem rot13-Code,
// der einfach jeden Buchstaben 13 Plaetze im Alphabet "rotiert", wobei
// am Ende bei Z bei Bedarf wieder bei A angefangen wird zu zaehlen.
// Umlaute, ß und Zeichen, die keine Buchstaben sind, werden nicht codiert.

// Weil wir ein StringBuffer-Objekt verwenden, koennen wir alle Zeichen
// in der Zeile eines nach dem anderen ersetzen.

// Legen Sie fuer jede eingelesene Zeile ein StringBuffer-Objekt an,
// das mit dieser Zeile initialisiert wird.

// Jedes Zeichen dieses StringBuffer-Objekts muss gelesen, codiert und
// wieder zurueckgeschrieben werden.

// Implementieren Sie die Methode rot13, welche die eigentliche
// Verschluesselung vornimmt.

import utilities.TastaturEingabe;

public class Rot13Input {
	public static void main(String[] args) {

		// Endlosschleife
		for (;;) {

			// Eingabeaufforderung ausgeben und Zeile einlesen
			String line = TastaturEingabe.readString("> ");

			// Wenn Zeile leer oder gleich "quit", dann Schleife verlassen
			if (line.equals("") || line.equalsIgnoreCase("quit"))
				break;

			// in einen StringBuffer konvertieren
			// .....
			StringBuffer t = new StringBuffer(line);

			// jedes Zeichen lesen, codieren, zurueckschreiben
			// .....
			char[] h = new char[t.length()];
			for(int i=0; i<t.length(); i++) {
				h[i] = rot13(line.charAt(i));
			}

			// codierte Zeile ausgeben
			// .....
			for(int i = 0; i<h.length; i++) {
				System.out.print(h[i]);
			}
			System.out.println();
		}
	}

	/**
	 * Diese Methode fuehrt die rot13-codierung durch. Jeder Buchstabe wird 13
	 * Positionen durch das Alphabet rotiert. Weil das lateinische Alphabet 26
	 * Buchstaben enthaelt, dient die Methode sowohl zur Codierung als auch zur
	 * Decodierung.
	 **/
	public static char rot13(char c) {
		char tmp;
		// Grossbuchstaben 13 Positionen vorwaerts rotieren
		// und 26 abziehen, falls notwendig
		// .....
		if ('A' <= c && c <= 'Z') {
			tmp = (char) (c + 13);
			if (tmp > 'Z')
				tmp -= 26;
		}
		// das gleiche fuer Kleinbuchstaben
		// .....
		else if ('a' <= c && c <= 'z') {
			tmp = (char) (c + 13);
			if (tmp > 'z')
				tmp -= 26;
		}
		else if(c == ' ')
			tmp=c;
		else {
			System.out.println("ES GABE EIN FEHLER!!!");	
			return '0';
		}
			
	// geaendertes Zeichen zurueckgeben
	// .....
	return tmp;
}}
