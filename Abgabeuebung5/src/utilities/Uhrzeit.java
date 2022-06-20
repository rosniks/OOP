package utilities;

/**
 * Klasse zum Erstellen und Arbeiten mit Uhrzeiten.
 */
class Uhrzeit implements Comparable
{
   private int std;      // 0 bis 23
   private int min, sek; // 0 bis 59
   private int zone;     // Zeitzone in Werten von -11 bis +12

   private static int stdNormal;
   private static int minNormal;

   /**
    * Klassenmethode die die Normalzeit setzt
    * @param std Stundenanzahl (0 <= std <= 23)
    * @param min Minutenanzahl (0 <= min <= 59)
    */
   static void setzeNormalzeit (int std, int min)
   {
      if (min<0)
         throw new IllegalArgumentException("Minuten müssen >= 0 sein.");
      else
         while (min>=60)
            min = min - 60;
      minNormal = min;
      if (std<0)
         throw new IllegalArgumentException("Stunden müssen >= 0 sein.");
      else
         while (std>=24)
            std = std - 24;
      stdNormal = std;
   }

   /**
    * Allgemeiner Konstruktor, der die Uhrzeit auf die gesetzte Normalzeit setzt.
    */
   Uhrzeit ()
   {
      std = stdNormal;
      min = minNormal;
      // weitere Angaben nicht noetig (Standardvorbelegung)
   }

   /**
    * Konstruktor für eine Uhrzeit deren Zeitzone bei ± 0 liegt und deren Sekunden auch bei 0 starten.
    * @param std Stundenanzahl (0 <= std <= 23)
    * @param min Minutenanzahl (0 <= min <= 59)
    */
   Uhrzeit (int std, int min)
   {
      setzeStdMin (std, min);
   }

   /**
    * Konstruktor fuer eine Uhrzeit deren Zeitzone bei ± 0 liegt.
    * @param std Stundenanzahl (0 <= std <= 23)
    * @param min Minutenanzahl (0 <= min <= 59)
    * @param sek Sekundenanzahl (0 <= sek <= 59)
    */
   Uhrzeit (int std, int min, int sek)
   {
      setzeUhrzeit (std, min, sek);
   }

   /**
    * Allgemeiner Konstruktor.
    * @param std Stundenanzahl (0 <= std <= 23)
    * @param min Minutenanzahl (0 <= min <= 59)
    * @param sek Sekundenanzahl (0 <= sek <= 59)
    * @param zone Zeitzone (-11 <= zone <= 12)
    */
   Uhrzeit (int std, int min, int sek, int zone)
   {
      setzeUhrzeit (std, min, sek, zone);
   }

   /**
    * Setter fuer Minuten und Stunden.
    * @param std neue Stundenanzahl (0 <= std <= 23)
    * @param min neue Minutenanzahl (0 <= min <= 59)
    */
   private void setzeStdMin (int std, int min)
   {
      if (min<0)
         throw new IllegalArgumentException("Minuten müssen >= 0 sein.");
      else
         while (min>=60)
            min = min - 60;
      this.min = min;
      if (std<0)
         throw new IllegalArgumentException("Stunden müssen >= 0 sein.");
      else
         while (std>=24)
            std = std - 24;
      this.std = std;
   }

   /**
    * Setter fuer Minuten und Stunden mit Reset der Sekunden.
    * @param std neue Stundenanzahl (0 <= std <= 23)
    * @param min neue Minutenanzahl (0 <= min <= 59)
    */
   void setzeUhrzeit (int std, int min)
   {
      setzeStdMin (std, min);
      this.sek = 0;
   }

   /**
    * Setter fuer alle Objekt-Attribute ausser der Zeitzone gebuendelt.
    * @param std neue Stundenanzahl (0 <= std <= 23)
    * @param min neue Minutenanzahl (0 <= min <= 59)
    * @param sek neue Sekundenanzahl (0 <= sek <= 59)
    */
   void setzeUhrzeit (int std, int min, int sek)
   {
      setzeStdMin (std, min);
      if (sek<0 | sek>59)
         throw new IllegalArgumentException("Sekunden müssen zwischen 0 und 59 liegen.");
      this.sek = sek;
      zone = 1;
   }

   /**
    * Setter fuer alle Objekt-Attribute gebuendelt.
    * @param std neue Stundenanzahl (0 <= std <= 23)
    * @param min neue Minutenanzahl (0 <= min <= 59)
    * @param sek neue Sekundenanzahl (0 <= sek <= 59)
    * @param zone neue Zeitzone (-11 <= zone <= 12)
    */
   void setzeUhrzeit (int std, int min, int sek, int zone)
   {
      setzeStdMin (std, min);
      if (sek<0 | sek>59)
         throw new IllegalArgumentException("Sekunden müssen zwischen 0 und 59 liegen.");
      this.sek = sek;
      if (zone<-11 | zone>12)
         throw new IllegalArgumentException("Zeitzone muss zwischen -11 und +12 liegen.");
      this.zone = zone;
   }

   /**
    * Gibt die Differenz als String an, wie viele Stunden, Minuten und Sekunden vergehen muessen, bis die uebergebene Uhrzeit erreicht
    * ist, unter Beachtung der Zeitzonen.
    * @param bis zu erreichender Uhrzeit
    */
   String differenz(Uhrzeit bis)
   {
      int dStd = bis.std + bis.zone - std - zone;
      int dMin = bis.min - min;
      if (dMin < 0)
      {
         dMin = dMin + 60;
         dStd--;
      }
      int dSek = bis.sek - sek;
      if (dSek < 0)
      {
         dSek = dSek + 60;
         dMin--;
      }
      return dStd + " Std " + dMin + " Min " + dSek + " Sek";
   }

   /**
    * Gibt die Uhrzeit im Format hh:mm:ss zurueck mit entsprechender Zeitzonenverschiebung
    */
   public String toString ()
   {
      String zeit = ((std < 10)? "0" + std : "" + std) + ":";
      zeit = zeit + ((min < 10)? "0" + min : "" + min) + ":";
      zeit = zeit + ((sek < 10)? "0" + sek : "" + sek) + " GMT";
      zeit = zeit + ((zone < 0)? "-" : "+") + Math.abs(zone);
      return zeit;
   }

   /**
    * Vergleicht ob die Stunden und Minuten beider Uhrzeit-Objekte uebereinstimmt, unter Beachtung der Zeitzonen
    * @param object zu vergleichendes Uhrzeit-Objekt
    */
   public boolean equals(Object object)
   {
      Uhrzeit eineZeit = (Uhrzeit) object;
      return this.std - this.zone == eineZeit.std - eineZeit.zone
           & this.min == eineZeit.min;
   }

   /**
    * Vergleicht die zeitliche Differenz in Sekunden zwischen den Uhrzeiten.
    * @param object zu vergleichendes Uhrzeit-Objekt
    * @return zeitliche Differenz in Sekunden
    */
   public int compareTo(Object object)
   {
      Uhrzeit z = (Uhrzeit) object;
      return
         (((this.std - this.zone) * 60) + this.min) * 60 + this.sek
        - ((((z.std - z.zone) * 60) + z.min) * 60 + z.sek);
   }

   /**
    * Getter-Methode fuer die Stunden
    */
   public int gibStunde()
   {
      return std;
   }

   /**
    * Getter-Methode fuer die Minuten
    */
   public int gibMinute()
   {
      return min;
   }
}
