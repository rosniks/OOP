package justiceLeague;

public class Mission {
	private double missionTime;
	private int difficulty;
	
	Mission(double time, int difficulty){
		missionTime = time;
		this.difficulty=difficulty;
	}
	
	public void adjustMissionTime(int zeit) {
		missionTime -= zeit;
	}
	
	public int getDifficulty() {
		return difficulty;
	}

}
