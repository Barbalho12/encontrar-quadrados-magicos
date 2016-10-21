package quadrado4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import quadrado4.QuadradoMagicoNormal.M;

public class MainThreads {

	public static void main(String args[]) {
		long start, elapsed;
		start = System.currentTimeMillis();
		
		QuadradoMagico qm1 = new QuadradoMagico("t1", 1, 8);
		QuadradoMagico qm2 = new QuadradoMagico("t2",9, 16);
		
		qm1.start();
		qm2.start();
		while(qm1.isAlive() && qm2.isAlive());
		List<M> qm = new ArrayList<M>();
		qm.addAll(qm1.getQm());
		qm.addAll(qm2.getQm());
		
		boolean[] removido = new boolean[qm.size()];

		/*Inicializa o vetor que irá definir as matrizes a serem removidas*/
		for (int i = 0; i < removido.length; i++) {
			removido[i] = false;
		}

		boolean rodado1, rodado2, rodado3, espelhoL, espelhoV, espelhoD, espelhoD2;

		/*Marca as matrizes que são rotações ou reflexões, para serem removidas posetiormente, dexando apenas uma de cada*/
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

		/*Remove rotações e reflexões*/
		for (int i = removido.length - 1; i >= 0; i--) {
			if (removido[i]) {
				qm.remove(i);
			}
		}

		/*Imprime todas as matrizes*/
		for (M mi : qm) {
			mi.print();
			System.out.println("---------");
		}

		System.out.println(qm.size());

		elapsed = System.currentTimeMillis() - start;
		System.out.println((elapsed / 1000.0) + " segundos");
	
	}
}
