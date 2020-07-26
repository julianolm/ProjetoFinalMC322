package itens.magias;
import personagens.jogaveis.SerVivo;
public abstract class MagiaOfensiva extends Magia {
	public MagiaOfensiva(SerVivo lancador) {
		super(lancador);
	}
	protected abstract void acaoDeAtaque(SerVivo objetivo);
	public void ataque(SerVivo objetivo) {
		if (this.dado(6) < lancador.getPontosDeInteligencia()) {
			this.acaoDeAtaque(objetivo);
		}
	}
	

}
