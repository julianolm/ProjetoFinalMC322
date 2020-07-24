package personagens.jogaveis;

/*ESPECIFICACOES
 * Feiticeiro. Ataque: 1 dado, defesa: 2 dados, pontos de vida: 4, pontos 
 * de inteligencia: 6. Comecao jogo com 3 punhais, cada um fornecendo +1
 * dado para ataque, mas sao perdidos apos o uso. Comeca o jogo com 3 
 * magias magic missile, 1 magia fireball e 1 magia teleport.*/

public class Feiticeiro extends HeroiMagico {

	public Feiticeiro(String nome) {
		super(nome);
		this.numDadosAtaque = 1;
		this.numDadosDefesa = 2;
		this.pontosDeVida = 4;
		this.pontosDeInteligencia = 6;
		
		adicionaArma(new itens.armas.Punhal());
		adicionaArma(new itens.armas.Punhal());
		adicionaArma(new itens.armas.Punhal());
		
		aprendeMagia(new itens.magias.FireBall());
		aprendeMagia(new itens.magias.Teleport());
	}
	
	
}
