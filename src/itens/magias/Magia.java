package itens.magias;
import java.util.Random;
import personagens.jogaveis.SerVivo;
public abstract class Magia {
	/*
	 * Instância de random para gerar o dado.
	 */
	private Random ran;
	protected SerVivo lancador;
	/*
	 * lados: Número de lados do dado
	 * retorno: Número entre 1 e lados
	 */
	public int dado(int lados) {
		return ((ran.nextInt() % lados) + 1);
	}	
	public Magia(SerVivo lancador){
		ran = new Random();
		this.lancador = lancador;
	}
	
	
	
}
