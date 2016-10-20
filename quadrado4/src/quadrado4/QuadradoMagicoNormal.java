/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrado4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author barbalho12
 */
public class QuadradoMagicoNormal {

    public static void main(String[] args) {
		
		long start, elapsed;
		start = System.currentTimeMillis();
		
		int [][] m = new int[4][4];
		int [] a = new int[8];
		int cont=0;
 		boolean l1,l2,l3,l4,c1,c2,c3,c4,d1,d2;
 		
 		List<M> quadrados_magicos = new ArrayList<M>();
 		
 		int [] vetor = new int[16];
		
		//Iteração TOTAL
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
				
				if(repetido) continue;
				
//				boolean rodadoHor = true;
//				boolean rodadoAnHor = false;
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						if(m[(4-j)-1][i] != m[i][j]){
//							rodadoHor = false;
//							break;
//						}
//					}
//					if(rodadoHor) break;
//				}
//				for (int i = 0; i < 4; i++) {
//					for (int j = 0; j < 4; j++) {
//						if(m[(4-j)-1][i] != m[j][i]){
//							rodadoAnHor = false;
//							break;
//						}
//					}
//					if(rodadoAnHor) break;
//				}
//				if(rodadoHor || rodadoAnHor) continue;
//				
				
				
//				
//				if(m[3][0] == m[0][3])
//				if(m[2][0] == m[1][3])
//				if(m[1][0] == m[2][3])
//				if(m[0][0] == m[3][3])
				
//				if(m[3][0] == m[0][0])
//				if(m[2][0] == m[0][1])
//				if(m[1][0] == m[0][2])
//				if(m[0][0] == m[0][3])
//				
//				if(m[3][1] == m[1][0])
//				if(m[2][1] == m[1][1])
//				if(m[1][1] == m[1][2])
//				if(m[0][1] == m[1][3])
//				
//				if(m[3][2] == m[2][0])
//				if(m[2][2] == m[2][1])
//				if(m[1][2] == m[2][2])
//				if(m[0][2] == m[2][3])
//				
//				if(m[3][3] == m[3][0])
//				if(m[2][3] == m[3][1])
//				if(m[1][3] == m[3][2])
//				if(m[0][3] == m[3][3])
				
//				//Linhas
//	 			l1 = (m[0][0] + m[0][1] + m[0][2] + m[0][3]) == 34;
//	 			l2 = (m[1][0] + m[1][1] + m[1][2] + a[0]) 	 == 34;
//	 			l3 = (m[2][0] + a[1]    + a[2]    + a[3]) 	 == 34;
//	 			l4 = (a[4]    + a[5]    + a[6]    + a[7]) 	 == 34;
//				
//				//Colunas
//	 			c1 = (m[0][0] + m[1][0] + m[2][0] + a[4]) 	 == 34;
//	 			c2 = (m[0][1] + m[1][1] + a[1]    + a[5]) 	 == 34;
//	 			c3 = (m[0][2] + m[1][2] + a[2]    + a[6]) 	 == 34;
//	 			c4 = (m[0][3] + a[0]    + a[3]    + a[7]) 	 == 34;
//				
//				//Diagonais
//	 			d1 = (m[0][0] + m[1][1] + a[2]    + a[7]) 	 == 34;
//	 			d2 = (m[0][3] + m[1][2] + a[1]    + a[4]) 	 == 34;
//				
//				
//				if(l1 && l2 && l3 && l4 && c1 && c2 && c3 && c4 && d1 && d2){
					
						cont++;
						//System.out.println(cont);
		                System.out.println(m[0][0]+" "+m[0][1]+" "+m[0][2]+" "+m[0][3]+"\n"
						+m[1][0]+" "+m[1][1]+" "+m[1][2]+" "+a[0]+"\n"
						+m[2][0]+" "+a[1]+" "+a[2]+" "+a[3]+"\n"
						+a[4]+" "+a[5]+" "+a[6]+" "+a[7]); 
		                            System.out.println("-------"); 
			
					
//				}
				
            }
					
			
		}}}}}}}}
		System.out.println(cont);
		
		elapsed = System.currentTimeMillis() - start;
		System.out.println((elapsed/1000.0)+" segundos");

	}
    
}
