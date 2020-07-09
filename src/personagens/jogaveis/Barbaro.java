package personagens.jogaveis;

public class Barbaro extends Heroi {

	public Barbaro(String nome) {
		super(nome, 3, 2, 8, 2);
		// 3 dados de ataque  -  2 dados de defesa  -  8 pts de vida  -  2 pts de inteligencia
		
		adicionaArma(new itens.EspadaLonga()); //testando
	}
}
