package personagens.jogaveis;

public class Elfo extends HeroiMagico {

	public Elfo(String nome) {
		super(nome, 2, 2, 6, 4);
		
		adicionaArma(new itens.armas.EspadaCurta());
		aprendeMagia(new itens.magias.SimpleHeal());
	}

}