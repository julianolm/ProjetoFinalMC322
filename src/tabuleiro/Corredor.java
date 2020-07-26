package tabuleiro;

public class Corredor extends AreaRetangular {
	private boolean horizontal;
	
	public Corredor(int startI , int startJ, int endI, int endJ) {
		super(startI , startJ, endI, endJ);
		
		if (endI - startI < endJ - startJ) {
			horizontal = true;
		} else {
			horizontal = false;
		}
	}

	public boolean isHorizontal() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
