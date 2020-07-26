package itens.magias;

import personagens.jogaveis.SerVivo;

public class SimpleHeal extends MagiaComum {

	
	public SimpleHeal(SerVivo lancador) {
		super(lancador);
	}

	@Override
	public void agir() {
		lancador.mudaVida(dado(6));
		return;
	}

}
