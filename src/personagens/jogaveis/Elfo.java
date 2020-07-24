package personagens.jogaveis;

public class Elfo extends HeroiMagico {

	public Elfo(String nome) {
		super(nome);
		this.numDadosAtaque = 2;
		this.numDadosDefesa = 2;
		this.pontosDeVida = 6;
		this.pontosDeInteligencia = 4;
		adicionaArma(new itens.armas.EspadaCurta());
		aprendeMagia(new itens.magias.SimpleHeal());
	}

}