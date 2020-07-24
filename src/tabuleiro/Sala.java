package tabuleiro;

public class Sala extends AreaRetangular{
	
	public Sala(int startI , int startJ, int endI, int endJ) {
		super(startI , startJ, endI, endJ);
	}
	
	public boolean contem(Cela x) {
		if (x.getI() >= superiorEsquerdo.getI() && x.getI() <= inferiorDireito.getI() && 
				x.getJ() <= inferiorDireito.getJ() && x.getJ() >= superiorEsquerdo.getJ()) {
			return true;
		}
		return false;
	}
	
	public void verSala() {
		for (Cela c : this.celas) {
			c.tornarVisivel();
		}
	}
}
