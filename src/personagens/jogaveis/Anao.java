package personagens.jogaveis;

public class Anao extends Heroi {

	public Anao(String nome) {
		super(nome, 2, 2, 7, 3);
		// 2 dados de ataque  -  2 dados de defesa  -  7 pts de vida  -  3 pts de inteligencia
		
		adicionaArma(new itens.EspadaCurta());
	}
	
}
