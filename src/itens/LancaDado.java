package itens;
import java.util.Random;
public class LancaDado {
	private static Random ran = new Random();;
	public LancaDado() {	
 
	}
	
	public static int DadoVermelho(int n) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += Math.abs(ran.nextInt(6)) + 1;
			
		}
		return res;
	}
	
	public static int DadoVermelho() {
		return Math.abs(ran.nextInt(6)) + 1; 
	}
	
	public static FacesCombate DadoCombate() {
		int choice =  Math.abs(ran.nextInt(6));
		if (choice < 3) {
			return FacesCombate.CAVEIRA;
		} else if (choice > 3 && choice < 5) {
			return FacesCombate.ESC_HEROI;
		} else {
			return FacesCombate.ESC_MONSTRO;
		}
	}
	
}
