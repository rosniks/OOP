package utilities;

import java.util.GregorianCalendar;

/**
 * Klasse zum Erstellen und Arbeiten mit Datumsangaben.
 */
public class Datum
{
   private int tag, monat, jahr;
   
   /**
    * Aktuelles Datum (d.h. heute) erzeugen.
    */
   public Datum()
   {
      GregorianCalendar gc = new GregorianCalendar();
      tag = gc.get(GregorianCalendar.DAY_OF_MONTH);
      // In der Klasse GregorianCalendar werden die Monate von 0 bis 11
      // durchnummeriert; daher muessen wir den Wert 1 addieren.
      monat = gc.get(GregorianCalendar.MONTH) + 1;
      jahr = gc.get(GregorianCalendar.YEAR);
   }

   /**
    * Ein bestimmtes Datum wird erzeugt, ohne Ueberpruefung auf gueltige Parameter.
    * @param t Tag
    * @param m Monat
    * @param j Jahr
    */
   public Datum(int t, int m, int j)
   {
      tag = t;
      monat = m;
      jahr = j;
   }

   /**
    * Gibt das Datum im Format TT.MM.JJJJ zurueck.
    */
   public String toString()
   {
      return tag + "." + monat + "." + jahr;
   }

   /**
    * Ueberprueft, ob das uebergebene Object dem selben Datum entspricht.
    */
   public boolean equals(Object obj)
   {
      if (obj instanceof Datum)
      {
         Datum d = (Datum)obj;

         return jahr == d.jahr
             && monat == d.monat
             && tag == d.tag;
      }
      else
         return false;
   }

   /**
    * Ueberprueft, ob das Datum vor dem uebergebenen Datum liegt.
    */
   public boolean frueherAls(Datum d)
   {
      if(jahr < d.jahr)
         return true;
      if(jahr == d.jahr)
      {
         if(monat < d.monat)
            return true;
         if(monat == d.monat)
            return tag < d.tag;
      }
      return false;
   }

   /**
    * Ueberprueft, ob das Datum vor dem uebergebenen Datum liegt.
    */
   public boolean vor(Datum d)
   {
      return frueherAls(d);
   }

   /**
    * Ueberprueft, ob das Datum nach dem uebergebenen Datum liegt.
    */
   public boolean nach(Datum d)
   {
      return !vor(d) && !equals(d);
   }
}
