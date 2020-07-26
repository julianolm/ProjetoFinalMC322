package personagens;
import java.util.Random;

import excecoes.PosInvalidaException;
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
		char[] direcoes = {'a', 'w', 's', 'd'};
		int index = new Random().nextInt(direcoes.length);
		
	    char direcao =  direcoes[index];
	    
	  
	    try {
			this.mover(1, direcao);
		} catch (PosInvalidaException e) {
			System.out.println("movimento invalido");
		}
		
		
		if (this.proximidadeDoHeroi() < 3) {
			this.ataca();
		}
		
		// Precisamos ver a movimentação pelo mapa
		// Precisamos ver a movimentação pra checar a proximidade do herói
		
	}

	

}
