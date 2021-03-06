package GameLogic;

public class Score {

	private static long currentScore = 0;
	
	private static long laggedScore = 0;
	
	static {
		new Thread(new Runnable() {
			float delta = 0.09f;
			public void run() {
				for(;;) {
//					laggedScore = (long) (delta*laggedScore + (1-delta)*currentScore);
					laggedScore = (long) (laggedScore + (currentScore-laggedScore)*delta);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	
	public static void addScore(int amount){
		currentScore += amount;
	}
	
	public static void subtractScore(long l){
		currentScore -= l;
	}
	
	public static void resetScore(){
		currentScore = 0;
		laggedScore = 0;
	}
	
	public static long getScore(){
		return laggedScore;
	}
	
	public static boolean isDecreasing(){
		return currentScore < laggedScore;
	}
}
