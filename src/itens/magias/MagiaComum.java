package itens.magias;

import personagens.jogaveis.SerVivo;

public abstract class MagiaComum extends Magia{

	public MagiaComum(SerVivo lancador) {
		super(lancador);
	}
	
	public abstract void agir(); 
	
	public void ativa() {
		if (this.dado(6) < lancador.getPontosDeInteligencia()) {
			this.agir();
		}
	}
	

}
