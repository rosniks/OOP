
// Alle Vorkommen eines bestimmten Zeichens in einem StringBuffer-
// Objekt sollen geloescht werden.

import utilities.TastaturEingabe;

class ZeichenLoeschen
{
   // loeschen aller Vorkommen des Zeichens ch aus buf
   // die Laenge der Zeichenkette muss entsprechend angepasst werden
   public static void loeschen(StringBuilder buf, char ch)
   {
      int i, j;

      // .....   (Fuenf Zeilen reichen aus.)

   }

   public static void main(String[] args)
   {
      StringBuilder puffer = new StringBuilder("Mississippi");
      System.out.print("Originalzustand:   ");
      System.out.println(puffer);

      // Zeichen 'i' aus der Zeichenkette loeschen
      loeschen(puffer, 'i');

      System.out.print("nach dem Loeschen: ");
      System.out.println(puffer);


      String str = TastaturEingabe.readString("Bitte eine Zeichenkette eingeben: ");
      puffer = new StringBuilder(str);
      char ch = TastaturEingabe.readChar("Welches Zeichen soll geloescht werden? ");

      loeschen(puffer, ch);

      System.out.print("nach dem Loeschen: ");
      System.out.println(puffer);
   }
}

