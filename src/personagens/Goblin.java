package personagens;

import personagens.jogaveis.Heroi;
import personagens.jogaveis.Jogavel;

import java.util.ArrayList;

import excecoes.PosInvalidaException;
import itens.FacesCombate;
import itens.LancaDado;
import itens.armas.Punhal;
public class Goblin extends Monstro {

	private int numeroDePunhais;
	private ArrayList<Punhal> punhais;
	private final int NUM_ATAQUE = 1;
	public Goblin(int pontosDeVida, int pontosDeInteligencia, Heroi heroi, int numeroDePunhais) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		this.numeroDePunhais = numeroDePunhais;
		
		this.punhais = new ArrayList<Punhal>();
		for (int i = 0; i < this.numeroDePunhais; i++) {
			this.punhais.add(new Punhal());
		}
	}
	
	public Goblin(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia, heroi);
		// TODO Auto-generated constructor stub
		this.numeroDePunhais = 5;
		
		this.punhais = new ArrayList<Punhal>();
		for (int i = 0; i < this.numeroDePunhais; i++) {
			this.punhais.add(new Punhal());
		}
		
	}

	@Override
	public void movimenta() {
		// TODO Auto-generated method stub
		int moveX = 0;
		int moveY = 0;
		
		if (this.getI() > this.getHeroi().getI()) {
			moveX = -1;
		}else if((this.getI() < this.getHeroi().getI()) ) {
			moveX = 1;
		}
		
		if (this.getJ() > this.getHeroi().getJ()) {
			moveY = -1;
		}else if((this.getJ() < this.getHeroi().getJ()) ) {
			moveY = 1;
		}
		
		try {
			this.getTabuleiro().atualizarPosPersonagem(this, this.getI(moveY), this.getJ(moveX));
		} catch (PosInvalidaException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

	@Override
	public void ataca() {
		for (int j = 0; j < this.numeroDePunhais; j++) {
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
		
		
	}

	@Override
	public char simbolo() {
		// TODO Auto-generated method stub
		return 'G';
	}

	

	
}
