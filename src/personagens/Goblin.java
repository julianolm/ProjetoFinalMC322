package personagens;

import personagens.jogaveis.Heroi;

import java.util.ArrayList;

import itens.armas.Punhal;
public class Goblin extends Monstro {

	private int numeroDePunhais;
	private ArrayList<Punhal> punhais;
	
	public Goblin(int pontosDeVida, int pontosDeInteligencia, Heroi heroi, int numeroDePunhais) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		this.numeroDePunhais = numeroDePunhais;
		
		this.punhais = new ArrayList<Punhal>(this.numeroDePunhais);
		for (int i = 0; i < this.numeroDePunhais; i++) {
			this.punhais.set(i, new Punhal());
		}
	}
	
	public Goblin(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		this.numeroDePunhais = 5;
		
		this.punhais = new ArrayList<Punhal>(this.numeroDePunhais);
		for (int i = 0; i < this.numeroDePunhais; i++) {
			this.punhais.set(i, new Punhal());
		}
		
	}

	@Override
	public void movimenta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		
	}

	

	
}
