package personagens;
import java.util.Random;
import itens.armas.*;
import personagens.jogaveis.Heroi;

public abstract class Esqueleto extends Monstro{
	
	private final int moves[][] = {{0,1}, {0,-1}, {1,0}, {-1,0} , {1,1} , {-1,-1}, {-1,1}, {1,-1}};;
	private Random ran;
	public Esqueleto(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// Arma aleatória
		this.ran = new Random();
		
		
	}
	
	public Random getRan() {
		return this.ran;
	}

	
	
	@Override
	public void movimenta() {
//		int moves[][] = {{0,1}, {0,-1}, {1,0}, {-1,0} , {1,1} , {-1,-1}, {-1,1}, {1,-1}}; 
		int[] move;
		for (int mv_count = 0; mv_count < 8; mv_count++) {
			move = moves[ran.nextInt() % 8];
			if (!(this.getTabuleiro().posicaoOcupada(this.getX(move[0]), this.getY(move[1]))) && this.getTabuleiro().posicaoExiste(this.getX(move[0]), this.getY(move[1]))) {
				this.setPosicao(this.getX(move[0]), this.getY(move[1])); 
				break;				
			} 
		}
		
		if (this.proximidadeDoHeroi() < 3) {
			this.ataca();
		}
		
		// Precisamos ver a movimentação pelo mapa
		// Precisamos ver a movimentação pra checar a proximidade do herói
		
	}

	

}
