package werkzeuge;

public interface Vergleichbar {
	//liefert true zur�ck, wenn es sich um ein Objekt der identischen Klasse handelt
	boolean grobVergleichen(Object o);
	//liefert true zur�ck, wenn alle Eigenschaften gleich sind (sofern sinnvoll)
	boolean genauVergleichen(Object o);
}


