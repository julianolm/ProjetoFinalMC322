package personagens.jogaveis;

import itens.Item;
import itens.armas.Arma;

public interface Jogavel {

	public void adicionaArma(Arma arma);
	public void guardaItem(Item item);
	
}
