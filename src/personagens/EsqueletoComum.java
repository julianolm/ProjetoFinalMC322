package personagens;

import itens.armas.Arma;
import itens.armas.EspadaCurta;
import itens.armas.EspadaLonga;
import itens.armas.Punhal;
import personagens.jogaveis.Heroi;
import itens.*;
public class EsqueletoComum extends Esqueleto{
	private Arma arma;
	private final int NUM_ATAQUE = 3;
	public EsqueletoComum(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		int set_gun = this.getRan().nextInt(3);
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
		int at = 0;
		int def = 0;
		for (int i = 0; i < this.NUM_ATAQUE; i++) {
			if (LancaDado.DadoCombate() == FacesCombate.CAVEIRA) {
				at++;
			}
		}
		for (int i = 0; i < this.getHeroi().getDadosDefesa(); i++) {
			if (LancaDado.DadoCombate() == FacesCombate.ESC_HEROI) {
				def++;
			}
		}
		this.getHeroi().mudaVida((def-at < 0)?(def-at):(0));
		
	}

	@Override
	public char simbolo() {
		// TODO Auto-generated method stub
		return 'E';
	}

}
