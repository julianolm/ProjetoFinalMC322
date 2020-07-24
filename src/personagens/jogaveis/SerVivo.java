package personagens.jogaveis;

public abstract class SerVivo {
	protected int pontosDeVida;
	protected int pontosDeInteligencia;
	// TODO: POSICIONAMENTO 
	
	public SerVivo(int pontosDeVida, int pontosDeInteligencia) {
		this.pontosDeVida = pontosDeVida;
		this.pontosDeInteligencia = pontosDeInteligencia;
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
