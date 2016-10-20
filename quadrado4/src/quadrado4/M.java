package quadrado4;

public class M {
	
	private int [][]m;

	public M(int length) {
		
		this.setM(new int[length][length]);
		
	}
	
	public int get(int i, int j){
		return m[i][j];
	}

	public int set(int val, int i, int j){
		return m[i][j] = val;
	}
	
	public int [][] getM() {
		return m;
	}

	public void setM(int [][] m) {
		this.m = m;
	}

	
	
	

}
