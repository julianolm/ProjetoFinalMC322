package itens.magias;

import java.util.ArrayList;

/* SUGESTOES
 * Pode usar um Arraylist para ir adicionando cda nova magia
 * Pode implemtentar como SINGLETON - ja que nao faz sentido ter + de um livro de feiticos
 * */

public class LivroDeFeiticos {

	private ArrayList<Magia> magias;
	
	public LivroDeFeiticos() {
		magias = new ArrayList<Magia>();
		
	}
	
	public void adicionaMagia(Magia magia) {
		magias.add(magia);
	}
	
}
