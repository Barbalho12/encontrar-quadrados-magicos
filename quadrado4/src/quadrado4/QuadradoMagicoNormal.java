package quadrado4;

import java.util.ArrayList;
import java.util.List;


public class QuadradoMagicoNormal {

    public static void main(String[] args) {
		
		long start, elapsed;
		start = System.currentTimeMillis();
		
		int [][] m = new int[4][4];
		int [] a = new int[8];

 		List<M> qm = new ArrayList<M>();
 		
 		int [] vetor = new int[16];
		
		for (a[0] = 1; a[0] <= 16; a[0]++) {
	    	for (a[1] = 1; a[1] <= 16; a[1]++) {
			if(a[1]==a[0]) continue;
		for (a[2] = 1; a[2] <= 16; a[2]++) {
			if(a[2]==a[0] || a[2]==a[1]) continue;
		for (a[3] = 1; a[3] <= 16; a[3]++) {
			if(a[3]==a[0] || a[3]==a[1] || a[3]==a[2]) continue;
			if((a[1] + a[2] + a[3]) > 34) continue;
		for (a[4] = 1; a[4] <= 16; a[4]++) {
			if(a[4]==a[0] || a[4]==a[1] || a[4]==a[2] || a[4]==a[3]) continue;
		for (a[5] = 1; a[5] <= 16; a[5]++) {
			if(a[5]==a[0] || a[5]==a[1] || a[5]==a[2] || a[5]==a[3] || a[5]==a[4]) continue;
		for (a[6] = 1; a[6] <= 16; a[6]++) {
			if(a[6]==a[0] || a[6]==a[1] || a[6]==a[2] || a[6]==a[3] || a[6]==a[4] || a[6]==a[5]) continue;
			if((a[4] + a[5] + a[6]) >= 34) continue;
		for (a[7] = 1; a[7] <= 16; a[7]++) {

			if(a[7]==a[0] || a[7]==a[1] || a[7]==a[2] || a[7]==a[3] || a[7]==a[4] || a[7]==a[5] || a[7]==a[6]) continue;
			if((a[4] + a[5] + a[6] + a[7]) != 34) continue;

			m[0][0] =  a[0] + a[3] - a[4];
			m[0][1] =  a[0] - a[1] + a[2] +   a[3] -   a[4] - a[5] + a[7];
			m[0][2] = -a[0] + a[1] - a[2] -   a[3] + 2*a[4] + a[5];
			m[0][3] = -a[0] - a[3] + a[4] +   a[5] +   a[6]	;
			m[1][0] = -a[0] + a[1] + a[2];
			m[1][1] = -a[0] - a[2] - a[3] + 2*a[4] +   a[5] + a[6];
			m[1][2] =  a[0] - a[1] + a[3] -   a[4] +   a[7];
			m[2][0] = -a[1] - a[2] - a[3] +   a[4] +   a[5] + a[6] + a[7];
			m[1][3] = a[0];
			m[2][1] = a[1];
			m[2][2] = a[2];
			m[2][3] = a[3];
			m[3][0] = a[4];
			m[3][1] = a[5];
			m[3][2] = a[6];
			m[3][3] = a[7];
			
			if(!(m[0][0]<=16 && m[0][0]>0 &&
				m[0][1]<=16 && m[0][1]>0 &&
				m[0][2]<=16 && m[0][2]>0 &&
				m[0][3]<=16 && m[0][3]>0 &&
				m[1][0]<=16 && m[1][0]>0 &&
				m[1][1]<=16 && m[1][1]>0 &&
				m[1][2]<=16 && m[1][2]>0 &&
				m[2][0]<=16 && m[2][0]>0)){
				continue;
				
			}else{
				
				for (int i = 0; i < 16; i++) {
					vetor[i]= -1;
				}
				
				boolean repetido = false;
				
				for (int i = 0, k=0; i < 4; i++) {
					for (int j = 0; j < 4; j++, k++) {
						vetor[m[i][j]-1]= 1;
					}
				}
				for (int i = 0; i < 16; i++) {
					if(vetor[i]==-1){
						repetido = true;
						break;
					}
				}
				
				if(!repetido)
					qm.add(new M(m));
				
            }
					
			
		}}}}}}}}
		
		
		boolean [] removido = new boolean[qm.size()];
		
		for (int i = 0; i < removido.length; i++) {
			removido[i] = false;
		}
		
//		for (int h = 0; h < qm.size(); h++) {
//			for (int l = 0; l < qm.size(); l++) {
//				if(h==l || removido[h]) continue;
//				
//				boolean rodado1 = true;
//				boolean rodado2 = true;
//				boolean rodado3 = true;
//				
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						if(qm.get(h).get((4-j)-1,i) != qm.get(l).get(i,j)){
//							rodado1 = false;
//							break;
//						}
//					}
//					if(rodado1) break;
//				}
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						
//						if(qm.get(h).get((4-j)-1, i) != qm.get(l).get(j,(4-i)-1)){
//							rodado2 = false;
//							break;
//						}
//					}
//					if(rodado2) break;
//				}
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//					
//						if(qm.get(h).get((4-j)-1, i) != qm.get(l).get((4-i)-1,(4-j)-1)){
//							rodado3 = false;
//							break;
//						}
//					}
//					if(rodado3) break;
//				}
//				if(rodado1 || rodado2 || rodado3){
//					removido[l] = true;
//				}
//			}
//		}
		

		for (int i = removido.length-1; i >= 0; i--) {
			if(removido[i]){
				qm.remove(i);
			}
				
		}
			
		
		for (M mi : qm) {
			mi.print();
			System.out.println("---------");
		}
		
		System.out.println(qm.size());
		
		elapsed = System.currentTimeMillis() - start;
		System.out.println((elapsed/1000.0)+" segundos");

	}
    
}
