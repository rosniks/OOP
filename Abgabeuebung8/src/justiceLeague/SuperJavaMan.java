package justiceLeague;

public class SuperJavaMan extends Superman{
	SuperJavaMan(String realName, int knowledge, Mission personalMission, double personalTime){
		super(realName, knowledge, personalMission, personalTime);
	}
	
	SuperJavaMan(){
		super("java", 10, null, 1);
	}


	public static void main (String[] args) {
			SuperJavaMan mick = new SuperJavaMan();
			System.out.println(mick);
			Superman Clark = new Superman("Kal-L", 8, new Mission(20, 7), 100);
			System.out.println(Clark);
			Clark.kaempfen(25);
			System.out.println(Clark);
	}
}