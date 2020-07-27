package itens.magias;

import personagens.jogaveis.SerVivo;
import itens.*;
public class FireBall extends MagiaOfensiva {
	private char t;
	public FireBall(SerVivo serVivo) {
		super(serVivo);
		this.t = 'M';
	
	}
	public FireBall(SerVivo serVivo, char tipo) {
		super(serVivo);
		this.t = tipo; 
	}

	@Override
	public void acaoDeAtaque(SerVivo objetivo) {
		int num_def  = 0;
		for (int i = 0; i < objetivo.getPontosDeInteligencia(); i++) {
			if (this.t == 'M') {
				if (LancaDado.DadoCombate() == FacesCombate.ESC_HEROI) {
					num_def++;
				}
			}else {
				if (LancaDado.DadoCombate() == FacesCombate.ESC_MONSTRO) {
					num_def++;
				}
			}
			
			
		}
		objetivo.mudaVida((num_def-6 < 0)?(num_def-6):(0));
		return;
		
	}
	
}
