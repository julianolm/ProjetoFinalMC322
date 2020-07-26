package personagens.jogaveis;

import tabuleiro.Tabuleiro;
import excecoes.PosInvalidaException;


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
	
	public void setPosicao(int i, int j) {
		this.posicao[0] = i;
		this.posicao[1] = j;
	}
	
	public void mover(int passos, char direcao) throws PosInvalidaException {
		int novoI = getI();
		int novoJ = getJ();
		if (direcao == 'w') {
			novoI = getI()-passos;
			novoJ = getJ();
		} else if (direcao == 'd') {
			novoI = getI();
			novoJ = getJ() - 1;
		} else if (direcao == 's') {
			novoI = getI()+passos;
			novoJ = getJ();
		} else {
			novoI = getI();
			novoJ = getJ() + passos;
		}
		
		Tabuleiro mapa = this.getTabuleiro();

		if (mapa.posicaoExiste(novoI, novoJ) && 
				!mapa.posicaoOcupada(novoI, novoJ)) {
			
			mapa.atualizarPosPersonagem(this, novoI, novoJ);
			this.setPosicao(novoI, novoJ);
		} else {
			throw new PosInvalidaException("Movimento Invalido");
		}
	}
	
	public int getI() {
		return posicao[0];
	}
	
	public int getI(int offset) {
		return posicao[0] + offset;
	}
	
	public int getJ() {
		return posicao[1];
	}
	
	public int getJ(int offset) {
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

	public abstract char simbolo();
}
