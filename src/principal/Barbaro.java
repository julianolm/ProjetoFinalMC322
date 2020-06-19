package principal;

public class Barbaro extends Heroi {

	public Barbaro(String nome) {
		super(nome, 3, 2, 8, 2);
		
		adicionaArma(new itens.EspadaLonga());
	}
}
