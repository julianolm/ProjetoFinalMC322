package itens.armas;

import itens.Item;

/*
 * "Cada arma possui as seguintes propriedades: alcance, bonus dados 
 * de ataque, se e destruıda apos ser usada ou nao, e
 * eventualmente outros bonus."
 * */

public abstract class Arma implements Item {
	private TipoDeArma tipoDeArma; //determina se a arma eh SINGLEHANDED ou TWOHANDED
	private int numDadosDeAtaque; //quantos dados de ataque a arma fornece de bonus
	private int alcance;
	private boolean destruidaAposUso;
	
	public Arma(TipoDeArma tipo, int numDados, int alcance, boolean destruida) {
		tipoDeArma = tipo;
		numDadosDeAtaque = numDados;
		this.alcance = alcance;
		this.destruidaAposUso = destruida;
	}
}