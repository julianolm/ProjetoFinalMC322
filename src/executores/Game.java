package executores;

import personagens.*;
import personagens.jogaveis.*;
import tabuleiro.*;

import java.util.Scanner;

import excecoes.PosInvalidaException;

public class Game {
	
	private boolean exit;
	private Jogavel heroi;
	private Tabuleiro mapa;
	
	Scanner input = new Scanner(System.in);

	public void start() {
		exit = false;
		System.out.println("Game started!\n");
		
		initialConfig(); //esse metodo recebe as entradas iniciais que determinam o tipo do heroi e seu nome
		Tabuleiro mapa = new Tabuleiro("./src/executores/mapa-default.txt");
		this.mapa = mapa;
		mapa.addHeroi(heroi);
		
		
		while (!exit) {
			drawBoard();
			readInput();
			//updateBoard();
			mapa.printTabuleiro();
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
		
		if (acao.equals("1")) {
			System.out.print("Escolha uma direcao: \n");
			System.out.print("Norte - w\nSul - s\nLeste - d\nOeste - a\n");
			char dir = input.nextLine().toCharArray()[0];
			
			System.out.print("Escolha um número de passos: \n");
			int passos = (int) input.nextLine().toCharArray()[0];
			
			try {
				this.heroi.mover(passos, dir);
			} catch (PosInvalidaException e) {
				System.out.println("Posicao Invalida");
			}
		}
	}
	
	private void initialConfig() {
		System.out.print("Com qual Heroi Voce quer Jogar? (Digite uma letra e pressione enter)\n");
		System.out.print("Anao - D\nBarbaro - B\nElfo - E\nFeiticeiro - W\n");
		String letra = input.nextLine();
		
		System.out.print("Escolha o nome do seu heroi: ");
		String nome = input.nextLine();
		
		if (letra.equals("D"))
			heroi = new Anao(nome);
		else if (letra.contentEquals("B"))
			heroi = new Barbaro(nome);
		else if (letra.contentEquals("E"))
			heroi = new Elfo(nome);
		else if (letra.contentEquals("W"))
			heroi = new Feiticeiro(nome);	
	}
	
}