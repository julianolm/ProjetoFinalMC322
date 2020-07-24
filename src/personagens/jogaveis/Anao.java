package personagens.jogaveis;

public class Anao extends Heroi {

	public Anao(String nome) {
		
		super(nome);
		// 2 dados de ataque  -  2 dados de defesa  -  7 pts de vida  -  3 pts de inteligencia
		this.numDadosAtaque = 2;
		this.numDadosDefesa = 2;
		this.pontosDeVida = 7;
		this.pontosDeInteligencia = 3;
		adicionaArma(new itens.armas.EspadaCurta());
	}
	
}
