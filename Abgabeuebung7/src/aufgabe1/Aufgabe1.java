package aufgabe1;

public class Aufgabe1 {
	public static long reverseInt(long n) {
		long tmp=0;
		while(n>0) {
			tmp=tmp*10+n%10;
			n/=10;
		}
		return tmp;
	}
	
	public static long reverseInt2(long n) {
		String tmp = String.valueOf(n);
		StringBuffer help = new StringBuffer(tmp);
		help.reverse();
		tmp = help.toString();
		n = Long.parseLong(tmp);
		return n;
	}

	public static void main(String[] args) {
		System.out.println(reverseInt(123456789));
		System.out.println(reverseInt2(123456789));
	}
}
