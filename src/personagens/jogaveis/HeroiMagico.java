package personagens.jogaveis;

import itens.magias.*;

public abstract class HeroiMagico extends Heroi {
	private LivroDeFeiticos livro;
	
	
	public HeroiMagico(String nome) {
		super(nome);
		livro = new LivroDeFeiticos();
	}

	public void aprendeMagia(Magia magia) {
		livro.adicionaMagia(magia);
	}
}
