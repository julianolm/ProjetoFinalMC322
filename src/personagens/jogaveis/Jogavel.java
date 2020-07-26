package personagens.jogaveis;

import itens.Item;
import itens.armas.Arma;
import excecoes.PosInvalidaException;

public interface Jogavel {

	public void adicionaArma(Arma arma);
	public void guardaItem(Item item);
	public void mover(int passos, char direcao) throws PosInvalidaException;
	
}
