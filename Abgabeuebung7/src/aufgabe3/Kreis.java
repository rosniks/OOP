package aufgabe3;

public class Kreis extends GeomObjekt {
	private double d;
	
	Kreis(double x, double y, double d){
		super(x,y);
		this.d = d;
	}
	
	public void print() {
		System.out.println("Kreis");
	}
}
