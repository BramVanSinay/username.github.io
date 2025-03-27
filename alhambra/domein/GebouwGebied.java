package domein;


public class GebouwGebied {
	private int[][] gebouwGebied;
	
	public GebouwGebied() {
		gebouwGebied = new int[8][3];
		initGebied();
	}
	
	private int[][] initGebied() {
		for (int rij = 0; rij < gebouwGebied.length; rij++) {
            for (int kolom = 0; kolom < gebouwGebied[rij].length; kolom++) {
                gebouwGebied[rij][kolom] = 8 - rij; 
		
            }
	
		}
		return gebouwGebied;
	}
	
	public int[][] getGebouwGebied() {
		return gebouwGebied;
	}
	

}
