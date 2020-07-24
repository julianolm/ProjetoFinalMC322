package personagens;

import itens.armas.*;
import personagens.jogaveis.Heroi;
import java.util.Random;
public class Esqueleto extends Monstro{
	private Arma arma;
	public Esqueleto(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// Arma aleatória
		int ran = (new Random()).nextInt() % 3;
		switch (ran) {
			case 0:
				this.setArma(new EspadaCurta());
				break;
			case 1:
				this.setArma(new EspadaLonga());
				break;
			default:
				this.setArma(new Punhal());
				break;
		}
		
	}

	public void setArma(Arma arma) {
		this.arma = arma;
		
	}
	
	public Arma getArma() {
		return this.arma;
	}
	
	@Override
	public void movimenta() {
		// Precisamos ver a movimentação pelo mapa
		// Precisamos ver a movimentação pra checar a proximidade do herói
		
	}

	@Override
	public void ataca() {
		// Fazer depois que decidimos como vai ser o combate
		
	}

}
