package tabuleiro;

import java.util.ArrayList;

public abstract class AreaRetangular {
	
	protected Cela superiorEsquerdo;
	protected Cela inferiorDireito;
	
	protected ArrayList<Cela> celas;
	
	public AreaRetangular(int startI , int startJ, int endI, int endJ) {
		this.inferiorDireito = new Cela(endI, endJ);
		this.superiorEsquerdo = new Cela(startI, startJ);
		
		for (int i = startI; i < endI + 1; i++) {
			for (int j = startJ; j < endJ + 1; j++) {
				Cela c = new Cela(i, j);
				this.celas.add(c);
			}
		}
	}

}
