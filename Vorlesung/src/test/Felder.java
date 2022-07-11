package test;


public class Felder {
	public int y;
	
	Felder(int y){
		this.y=y;
	}
	 
	public void addieren(int x) throws ArithmeticException {
		if(x+y < 0)
			throw new ArithmeticException("Summer darf nicht kleiner null sein");
		else
			y=x+y;
	}
	
	public String toString() {
		return "y:" + y;
	}
	
	
	
	
	public static void main (String[] args) {
		Felder tmp = new Felder(2);
		try {tmp.addieren(-6);}
		catch(ArithmeticException e) {
			e.printStackTrace();
		}
		finally {System.out.println("geschafft");}
		
		System.out.println(tmp);
		
	}
}
		
		
		