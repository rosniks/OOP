package utilities;

import java.io.*;
/**
 * Klasse zum Einlesen von Tastatureingaben für primitive Datentypen als auch für das Datum.
 */
public class TastaturEingabe
{
   static BufferedReader eing =
      new BufferedReader(new InputStreamReader (System.in));

   /**
    * Dient zum Einlesen einer double-Zahl
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesene double-Zahl
    */
   public static double readDouble (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            String zeile = eing.readLine();
            return Double.parseDouble(zeile);
         }
         catch (NumberFormatException e)
         {
            System.out.println ("Bitte eine Zahl eingeben (ggf. mit Dezimalpunkt).");
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }

   /**
    * Dient zum Einlesen einer int-Zahl
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesene int-Zahl
    */
   public static int readInt (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            String zeile = eing.readLine();
            return Integer.parseInt(zeile);
         }
         catch (NumberFormatException e)
         {
            System.out.println ("Bitte eine ganze Zahl eingeben.");
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }

   /**
    * Dient zum Einlesen einer long-Zahl
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesene long-Zahl
    */
   public static long readLong (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            String zeile = eing.readLine();
            return Long.parseLong(zeile);
         }
         catch (NumberFormatException e)
         {
            System.out.println ("Bitte eine ganze Zahl eingeben.");
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }

   /**
    * Dient zum Einlesen eines Wahrheitswertes.
    * Für Rueckgabewert "true" muss "j" oder "J" eingegeben werden.
    * Für Rueckgabewert "false" muss "n" oder "N" eingegeben werden.
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesener boolean-Wert
    */
   public static boolean readBoolean (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            String e = eing.readLine();
            if (e.equals("j") || e.equals("J"))
               return true;
            if (e.equals("n") || e.equals("N"))
               return false;
            throw new IllegalArgumentException();
         }
         catch (IllegalArgumentException e)
         {
            System.out.println ("Bitte J oder N eingeben.");
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }

   /**
    * Dient zum Einlesen einer Zeichenkette
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesener String
    */
   public static String readString (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            return eing.readLine();
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }

   /**
    * Dient zum Einlesen eines Zeichens
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesene char
    */
   public static char readChar (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            String s = eing.readLine();
            if (s.length() == 0)
               throw new IllegalArgumentException();
            return s.charAt(0);
         }
         catch (IllegalArgumentException e)
         {
            System.out.println ("Bitte ein Zeichen eingeben.");
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }


   /**
    *  wartet auf <Return>
    *  @param b true: Meldung "Weiter ..." wird ausgegeben
    */
   public static void warte(boolean b)
   {
      String s;
      if (b)
      {
         System.out.print("....... Weiter mit <Return>");
         System.out.flush();
      }
      s = readString("");
   }

   /**
    *  wartet auf <Return>
    *  Meldung "....... Weiter mit <Return>" wird immer ausgegeben
    */
   public static void warte()
   {
      warte(true);
   }

   /**
    * Dient zum Einlesen eines Datums
    * Die Eingabe des Datums erfolgt im folgenden Format: TT.MM.JJJJ oder TT/MM/JJJJ
    * @param prompt anzuzeigender Text, unmittelbar bevor die Eingabe erfolgt.
    * @return eingelesenes Datum
    */
   public static Datum readDatum (String prompt)
   {
      while (true)
      {
         System.out.print(prompt);
         try
         {
            String zeile = eing.readLine();
            if (zeile.length()!=10) throw new NumberFormatException();
            int tag = Integer.parseInt(zeile.substring(0,2));
            char trenn = zeile.charAt(2);
            if (trenn!='.' & trenn!='/') throw new NumberFormatException();
            int monat = Integer.parseInt(zeile.substring(3,5));
            trenn = zeile.charAt(5);
            if (trenn!='.' & trenn!='/') throw new NumberFormatException();
            int jahr = Integer.parseInt(zeile.substring(6,10));
            Datum einDatum = new Datum (tag, monat, jahr);
            return einDatum;
         }
         catch (NumberFormatException e)
         {
            System.out.println ("Bitte eine Datum in der Form tt.mm.jjjj eingeben.");
         }
         catch (IllegalArgumentException e)
         {
            System.out.println ("Fehler in Datum: " + e.getMessage());
         }
         catch (IOException e)
         {
            e.printStackTrace();
            System.exit(1);
         }
      }
   }
}
