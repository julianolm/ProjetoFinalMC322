package personagens;

import itens.magias.FireBall;
import personagens.jogaveis.Heroi;
import personagens.jogaveis.SerVivo;

public class EsqueletoMago extends Esqueleto {
	FireBall fireball;
	public EsqueletoMago(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		this.fireball = new FireBall((SerVivo) this);
	}

	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		this.fireball.ataque((SerVivo) this.getHeroi());
		
	}

	@Override
	public char simbolo() {
		// TODO Auto-generated method stub
		return 'M';
	}

}
