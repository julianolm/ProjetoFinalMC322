package personagens;
import personagens.jogaveis.Heroi;
//import Java.util.Math.pow;
import personagens.jogaveis.SerVivo;
public abstract class Monstro extends SerVivo{
	private Heroi heroi; // Pra sempre termos a posicão do Heroi
	public Monstro(int pontosDeVida, int pontosDeInteligencia, Heroi heroi) {
		super(pontosDeVida, pontosDeInteligencia);
		this.setHeroi(heroi);
		
		
	}
	
	public abstract void movimenta();
	
	public abstract void ataca();
	
	public int proximidadeDoHeroi() {
		return  (int) (Math.pow(this.getI() - heroi.getI(), 2) + Math.pow(this.getJ() - heroi.getJ(), 2) ) ;
	}

	public Heroi getHeroi() {
		return heroi;
	}

	public void setHeroi(Heroi heroi) {
		this.heroi = heroi;
	}

	
	
}
