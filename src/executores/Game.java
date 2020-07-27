package executores;

import personagens.*;
import personagens.jogaveis.*;
import tabuleiro.*;

import java.util.Scanner;
import itens.*;
import excecoes.*;

public class Game {
	
	private boolean exit;
	private Heroi heroi;
	private Tabuleiro mapa;
	
	Scanner input = new Scanner(System.in);

	public void start() {
		exit = false;
		System.out.println("Game started!\n");
		Tabuleiro mapa = new Tabuleiro("./src/tabuleiro/config1.txt");
		this.mapa = mapa;
		while (true) {
			try {
				initialConfig(); //esse metodo recebe as entradas iniciais que determinam o tipo do heroi e seu nome
				break;
			} catch (ClasseInvalidaException e){
				System.out.println("Classe Inválida, escolha novamente");
			}
		}

		mapa.addHeroi(this.heroi);
		
		
		while (!exit) {
			// Mostra o tabuleiro
			drawBoard();
			// Acao do usuario
			readInput();
			// Movimentacao dos monstros
			this.mapa.movimentaMonstros();
			//updateBoard();
			
			//exit=true; // so p rodar e ver se ta funcionando
		}

		System.out.println("Game terminated. Bye!");

	}
	
	private void drawBoard() {
		mapa.printTabuleiro();
	}
	
	private void readInput() {
		System.out.print("Escolha uma acao: \n");
		System.out.print("Andar - 1\nAtacar Monstro - 2\nColetar item - 3\n\n");
		String acao = input.nextLine();
		int passosMax = 0;
		if (acao.equals("1")) {
			System.out.println("Jogando dados.. ");
			passosMax += LancaDado.DadoVermelho(2);
			System.out.println("Voce pode dar até " + Integer.toString(passosMax) + " passos");
			System.out.print("Escolha uma direcao: \n");
			System.out.print("Norte - w\nSul - s\nLeste - d\nOeste - a\n");
			char dir = input.nextLine().toCharArray()[0];
			int passos = 0;
			while (true) {
				System.out.print("Escolha um número de passos: \n");
				passos = (int) Integer.parseInt(input.nextLine());
				if (passos > passosMax) {
					System.out.println("Numero de Passos Inválido!");	
				}else {
					break;
				}
			}
			try {
				
				this.heroi.mover(passos, dir);
			} catch (PosInvalidaException e) {
				System.out.println("Posicao Invalida");
			}
		}
	}
	
	private void initialConfig() throws ClasseInvalidaException {
		System.out.print("Com qual Heroi Voce quer Jogar? (Digite uma letra e pressione enter)\n");
		System.out.print("Anao - D\nBarbaro - B\nElfo - E\nFeiticeiro - W\n");
		String letra = input.nextLine();
		
		if ((!letra.equalsIgnoreCase("D")) && (!letra.equalsIgnoreCase("B"))  && (!letra.equalsIgnoreCase("E"))  && (!letra.equalsIgnoreCase("W")) ) {
			throw new ClasseInvalidaException("Classe Inválida");
		} 
		
		System.out.print("Escolha o nome do seu heroi: ");
		String nome = input.nextLine();
		
		if (letra.equalsIgnoreCase("D")) {
			heroi = new Anao(nome);
			
		} else if (letra.equalsIgnoreCase("B")) { 
			heroi = new Barbaro(nome);
			
		} else if (letra.equalsIgnoreCase("E")) {
			heroi = new Elfo(nome);
			
		} else if (letra.equalsIgnoreCase("W")) {
			heroi = new Feiticeiro(nome);
			
		}
	}
	
}