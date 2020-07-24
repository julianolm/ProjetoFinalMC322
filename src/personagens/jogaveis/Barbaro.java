package personagens.jogaveis;

public class Barbaro extends Heroi {

	public Barbaro(String nome) {
		super(nome);
		// 3 dados de ataque  -  2 dados de defesa  -  8 pts de vida  -  2 pts de inteligencia
		this.numDadosAtaque = 3;
		this.numDadosDefesa = 2;
		this.pontosDeVida = 8;
		this.pontosDeInteligencia = 2;
		adicionaArma(new itens.armas.EspadaLonga()); //testando
	}
}
