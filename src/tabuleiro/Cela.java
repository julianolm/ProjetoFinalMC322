package tabuleiro;

public class Cela {
	private int i;
	private int j;
	
	private boolean visivel;
	
	public Cela(int i, int j) {
		this.i = i;
		this.j = j;
		visivel = false;
	}
	
	public int getI() {
		return i;
	}
	
	public int getJ() {
		return j;
	}
	
	public boolean isVisivel() {
		return visivel;
	}
	
	public void tornarVisivel() {
		this.visivel = true;
	}

}
