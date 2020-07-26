package excecoes;

public class PosInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public PosInvalidaException(String mensagem) {
		super(mensagem);
	}

}
