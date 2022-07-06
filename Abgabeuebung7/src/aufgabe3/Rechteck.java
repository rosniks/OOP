package aufgabe3;

public class Rechteck extends GeomObjekt {
	private double l, b;
	
	Rechteck(double x, double y, double l, double b){
		super(x,y);
		this.l=l;
		this.b=b;
	}
	
	public void print() {
		System.out.println("Rechteck");
	}
}
