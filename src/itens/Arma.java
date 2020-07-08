package itens;

public abstract class Arma implements Item {
	private TipoDeArma tipoDeArma;
	private int numDadosDeAtaque;
	
	public Arma(TipoDeArma tipo, int numDados) {
		tipoDeArma = tipo;
		numDadosDeAtaque = numDados;
	}
}
