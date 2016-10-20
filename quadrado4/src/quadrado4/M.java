package quadrado4;

public class M {
	
	private int [][]m;

	public M(int length) {
		
		this.setM(new int[length][length]);
		
	}
	
	public M(int [][]m) {
		this.m = new int[m.length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				this.m[i][j] = m[i][j];
			} 
		}
	}
	
	public void print(){
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				if(m[i][j]>9)
					System.out.print(m[i][j]+" ");
				else{
					System.out.print(m[i][j]+"  ");
				}
			}
			System.out.println();
		}
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
