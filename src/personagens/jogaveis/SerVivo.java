package personagens.jogaveis;
import tabuleiro.Tabuleiro;
public abstract class SerVivo {
	protected int pontosDeVida;
	protected int pontosDeInteligencia;
	// TODO: POSICIONAMENTO 
	private Tabuleiro tabuleiro;
	private int posicao[];
	public SerVivo(int pontosDeVida, int pontosDeInteligencia, Tabuleiro tabuleiro, int posicao[]) {
		this.pontosDeVida = pontosDeVida;
		this.pontosDeInteligencia = pontosDeInteligencia;
		this.tabuleiro = tabuleiro;
		this.posicao = posicao;
	}
	public SerVivo(int pontosDeVida, int pontosDeInteligencia, Tabuleiro tabuleiro) {
		this.pontosDeVida = pontosDeVida;
		this.pontosDeInteligencia = pontosDeInteligencia;
		this.tabuleiro = tabuleiro;
	}
	public SerVivo(int pontosDeVida, int pontosDeInteligencia) {
		this.pontosDeVida = pontosDeVida;
		this.pontosDeInteligencia = pontosDeInteligencia;
		
	}
	
	public void setPosicao(int x, int y) {
		this.posicao[0] = x;
		this.posicao[1] = y;
	}
	
	public int getX() {
		return posicao[0];
	}
	
	public int getX(int offset) {
		return posicao[0] + offset;
	}
	
	public int getY() {
		return posicao[1];
	}
	
	public int getY(int offset) {
		return posicao[1] + offset;
	}
	
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}
	
	
	public int getPontosDeInteligencia() {
		return pontosDeInteligencia;
	}
	public int getPontosDeVida() {
		return pontosDeVida;
	}
	/*
	 * novaVida -> pontosDeVida + offset
	 */
	public void mudaVida(int offset) {
		this.pontosDeVida += offset;
	}
}
