package werkzeuge;

public interface Vergleichbar {
	//liefert true zurück, wenn es sich um ein Objekt der identischen Klasse handelt
	boolean grobVergleichen(Object o);
	//liefert true zurück, wenn alle Eigenschaften gleich sind (sofern sinnvoll)
	boolean genauVergleichen(Object o);
}


