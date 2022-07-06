package justiceLeague;

public class Superman implements Vergesslich{
	private String realName;
	private int knowledge;
	private static int superheroes;
	private Mission personalMission;
	private double personalTime;
	
	Superman(String realName, int knowledge, Mission personalMission, double personalTime){
		this.realName=realName;
		this.knowledge=knowledge;
		this.personalMission=personalMission;
		this.personalTime=personalTime;
		superheroes++;
	}
	
	public void vergessen() {
		knowledge--;
	}
	
	public void kaempfen(int zeit) {
		if(personalMission.getDifficulty()==2*knowledge)
			zeit*=2;
		if(knowledge==2*personalMission.getDifficulty())
			zeit*=(1/2);
		if(zeit>personalTime)
			System.out.println("Die Zeit ist abgelaufen.");
		personalTime-=zeit;
		personalMission.adjustMissionTime(zeit);
	}
	
	public void ueben() {
		knowledge+=1;
	}
	
	public String toString() {
		return "Name: "+realName+", Wissensstand: "+knowledge+", Anzahl der Helden: "+superheroes+", Zeit: "+personalTime;
	}
}
