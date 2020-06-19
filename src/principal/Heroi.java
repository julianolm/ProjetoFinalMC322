package principal;

import itens.*;

public abstract class Heroi {
	private String nome;
	private int numDadosAtaque;
	private int numDadosDefesa;
	private int pontosDeVida;
	private int pontosDeInteligencia;

	private Mochila mochila; // A mochila carrega os itens nao utilizados
	private Item armadura; // Armadura utilizada
	private Arma armas[]; // Armazenar as duas armas utilizadas em um array de duas posicoes

	public Heroi(String nome, int numDadosDeAtaque, int numDaDosDeDefesa, int pontosDeVida, int pontosDeInteligencia) {
		this.nome = nome;
		this.numDadosAtaque = numDadosDeAtaque;
		this.numDadosDefesa = numDadosDefesa;
		this.pontosDeVida = pontosDeVida;
		this.pontosDeInteligencia = pontosDeInteligencia;

		// Ainda nao tem um construtor implementado para mochila; chamando esse aqui
		// provisoriamente;
		mochila = new Mochila();
		armas = new Arma[2];

	}

	public void adicionaArma(Arma arma) {
		if (armas[0] == null) // Se a primeira mao nao esta com nenhuma arma, adiciona a arma a ela.
			armas[0] = arma;
		
		else if (armas[1] == null)
			armas[1] = arma;
		
		else
			guardaItem(arma);
	}
	
	// guardaItem eh um metodo de Heroi para guardar itens na mochila.
	// A implementacao deste metodo usa o metodo adicionaItem da classe Mochila.
	public void guardaItem(Item item) {
		mochila.adicionaItem(item);
	}

}
