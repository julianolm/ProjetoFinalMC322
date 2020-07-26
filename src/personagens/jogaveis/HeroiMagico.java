package personagens.jogaveis;

import itens.magias.*;

public abstract class HeroiMagico extends Heroi {
	private LivroDeFeiticos livro;
	
	
	public HeroiMagico(String nome, int numDadosDeAtaque, int numDaDosDeDefesa, int pontosDeVida,
			int pontosDeInteligencia) {
		super(nome, numDadosDeAtaque, numDaDosDeDefesa, pontosDeVida, pontosDeInteligencia);
		
		livro = new LivroDeFeiticos();
	}

	public void aprendeMagia(Magia magia) {
		livro.adicionaMagia(magia);
	}
}
