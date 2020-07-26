package personagens;

import itens.armas.Arma;
import itens.armas.EspadaCurta;
import itens.armas.EspadaLonga;
import itens.armas.Punhal;
import personagens.jogaveis.Heroi;

public class EsqueletoComum extends Esqueleto{
	private Arma arma;
	public EsqueletoComum(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		int set_gun = this.getRan().nextInt() % 3;
		switch (set_gun) {
			case 0:
				this.setArma(new EspadaCurta());
				break;
			case 1:
				this.setArma(new EspadaLonga());
				break;
			default:
				this.setArma(new Punhal());
				break;
		}
	}

	public void setArma(Arma arma) {
		this.arma = arma;
		
	}
	
	public Arma getArma() {
		return this.arma;
	}
	
	@Override
	public void ataca() {
		// TODO Auto-generated method stub
		
	}

}
