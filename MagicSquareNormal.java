import java.util.ArrayList;
import java.util.List;

public class MagicSquareNormal {

	public static void main(String[] args) {

		long start, elapsed;
		start = System.currentTimeMillis();

		int[][] m = new int[4][4];
		
		int[] a = new int[8];

		List<M> qm = new ArrayList<M>();

		int[] vetor = new int[16];

		
		/*Generation of the magic squares, the result is magic squares (with rotations and reflections) */
		for (a[0] = 1; a[0] <= 16; a[0]++) {
			
			for (a[1] = 1; a[1] <= 16; a[1]++) {
				
				if (a[1] == a[0]) continue;
				
				for (a[2] = 1; a[2] <= 16; a[2]++) {
					
					if (a[2] == a[0] || a[2] == a[1])	continue;
					
					for (a[3] = 1; a[3] <= 16; a[3]++) {
						
						if (a[3] == a[0] || a[3] == a[1] || a[3] == a[2])	continue;
						if ((a[1] + a[2] + a[3]) > 34)	continue;
						
						for (a[4] = 1; a[4] <= 16; a[4]++) {
							
							if (a[4] == a[0] || a[4] == a[1] || a[4] == a[2] || a[4] == a[3])	continue;
							
							for (a[5] = 1; a[5] <= 16; a[5]++) {
								
								if (a[5] == a[0] || a[5] == a[1] || a[5] == a[2] || a[5] == a[3] || a[5] == a[4])	continue;
								
								for (a[6] = 1; a[6] <= 16; a[6]++) {
									
									if (a[6] == a[0] || a[6] == a[1] || a[6] == a[2] || a[6] == a[3] || a[6] == a[4] || a[6] == a[5])	continue;
									if ((a[4] + a[5] + a[6]) >= 34)	continue;
									
									for (a[7] = 1; a[7] <= 16; a[7]++) {

										if (a[7] == a[0] || a[7] == a[1] || a[7] == a[2] || a[7] == a[3] || a[7] == a[4] || a[7] == a[5] || a[7] == a[6])	continue;
										if ((a[4] + a[5] + a[6] + a[7]) != 34)	continue;

										m[0][0] = a[0] + a[3] - a[4];
										m[0][1] = a[0] - a[1] + a[2] + a[3] - a[4] - a[5] + a[7];
										m[0][2] = -a[0] + a[1] - a[2] - a[3] + 2 * a[4] + a[5];
										m[0][3] = -a[0] - a[3] + a[4] + a[5] + a[6];
										m[1][0] = -a[0] + a[1] + a[2];
										m[1][1] = -a[0] - a[2] - a[3] + 2 * a[4] + a[5] + a[6];
										m[1][2] = a[0] - a[1] + a[3] - a[4] + a[7];
										m[2][0] = -a[1] - a[2] - a[3] + a[4] + a[5] + a[6] + a[7];
										m[1][3] = a[0];
										m[2][1] = a[1];
										m[2][2] = a[2];
										m[2][3] = a[3];
										m[3][0] = a[4];
										m[3][1] = a[5];
										m[3][2] = a[6];
										m[3][3] = a[7];

										if (!(m[0][0] <= 16 && m[0][0] > 0 && m[0][1] <= 16 && m[0][1] > 0
											&& m[0][2] <= 16 && m[0][2] > 0 && m[0][3] <= 16 && m[0][3] > 0
											&& m[1][0] <= 16 && m[1][0] > 0 && m[1][1] <= 16 && m[1][1] > 0
											&& m[1][2] <= 16 && m[1][2] > 0 && m[2][0] <= 16 && m[2][0] > 0)) {
												
											continue;

										} else {

											for (int i = 0; i < 16; i++) {
												vetor[i] = -1;
											}

											boolean repetido = false;

											for (int i = 0; i < 4; i++) {
												for (int j = 0; j < 4; j++) {
													vetor[m[i][j] - 1] = 1;
												}
											}
											for (int i = 0; i < 16; i++) {
												if (vetor[i] == -1) {
													repetido = true;
													break;
												}
											}

											if (!repetido)
												qm.add(new M(m));

										}
									}
								}
							}
						}
					}
				}
			}
		}

		boolean[] removido = new boolean[qm.size()];

		/*Initializes the vector that will define the matrices to be removed*/
		for (int i = 0; i < removido.length; i++) {
			removido[i] = false;
		}

		boolean rodado1, rodado2, rodado3, espelhoL, espelhoV, espelhoD, espelhoD2;

		/*Mark the matrices that are rotations or reflections, to be removed suitably, leaving only one of each*/
		for (int h = 0; h < qm.size(); h++) {
			for (int l = 0; l < qm.size(); l++) {
				if (h == l || removido[h])
					continue;

				rodado1 = rodado2 = rodado3 = true;
				espelhoL = espelhoV = espelhoD = espelhoD2 = true;

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (qm.get(h).get(i, j) != qm.get(l).get(j, (4 - i) - 1)) {
							rodado1 = false;
						}
						if (qm.get(h).get(i, j) != qm.get(l).get((4 - i) - 1, (4 - j) - 1)) {
							rodado2 = false;
						}
						if (qm.get(h).get(i, j) != qm.get(l).get((4 - i) - 1, i)) {
							rodado3 = false;
						}
						if (qm.get(h).get(i, j) != qm.get(l).get(i, (4 - j) - 1)) {
							espelhoL = false;
						}
						if (qm.get(h).get(i, j) != qm.get(l).get((4 - i - 1), j)) {
							espelhoV = false;
						}
						if (qm.get(h).get(i, j) != qm.get(l).get((4 - j - 1), (4 - i - 1))) {
							espelhoD = false;
						}
						if (qm.get(h).get(i, j) != qm.get(l).get(j, i)) {
							espelhoD2 = false;
						}
					}
				}

				if (rodado1 || rodado2 || rodado3 || espelhoL || espelhoV || espelhoD || espelhoD2) {
					removido[l] = true;
				}
			}
		}

		/*Removes rotations and reflections*/
		for (int i = removido.length - 1; i >= 0; i--) {
			if (removido[i]) {
				qm.remove(i);
			}
		}

		/*Prints all matrices*/
		for (M mi : qm) {
			mi.print();
			System.out.println("---------");
		}

		System.out.println(qm.size());

		elapsed = System.currentTimeMillis() - start;
		System.out.println((elapsed / 1000.0) + " segundos");

	}

}


