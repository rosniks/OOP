package aufgabe2;

public class DemoKlasse {
	private int wert;

	DemoKlasse(int wert) {
		setWert(wert);
	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public DemoKlasse addieren(DemoKlasse obj) {
		DemoKlasse tmp = new DemoKlasse(0);
		tmp.setWert(getWert()+obj.getWert());
		return tmp;
		}


	public static void main(String[] args) {
		DemoKlasse achtzehn = new DemoKlasse(18);
		DemoKlasse neun = new DemoKlasse(9);
		
		System.out.println((achtzehn.addieren(neun)).getWert());
	}
}
