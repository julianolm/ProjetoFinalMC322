package tabuleiro;

import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import personagens.jogaveis.*;

public final class Tabuleiro {
	private int largura;
	private int altura;

	private int[][] matriz;
	
	private Jogavel jogador;
	
	private Sala[] salas;
	private Corredor[] corredores;
	
	private Arraylist<Interagivel> interagiveis = new Arraylist<Interagivel>();
	
	// ArrayList<Armadilha> armadilhas;
	

	/*
	 * Construtor Assinatura 1: 
	 * - Gera um tabuleiro aleatório. Têm como parâmetros
	 * apenas largura e altura do tabuleiro.
	 */
	public Tabuleiro(int largura, int altura) {
		this.largura = largura;
		this.altura = altura;
		
		corredores = new Corredor[12];
		salas = new Sala[16];

		this.matriz = new int[altura][largura];

		randomize();
	}

	/*
	 * Construtor Assinatura 2: 
	 * - Gera um tabuleiro a partir a da leitura de um
	 * arquivo. Têm como parâmetros largura, altura e nome do arquivo referente ao
	 * tabuleiro.
	 */
	public Tabuleiro(String nome_arquivo) {

		this.matriz = new int[altura][largura];

		try {
			File arquivo = new File(nome_arquivo);
			Scanner leitor = new Scanner(arquivo);
			int i = 0;
			
			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine();
				int j = 0;
				for (char c : linha.toCharArray()) {
					this.matriz[i][j] = c;
					j++;
				}
				i++;
			}

			leitor.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de mapa não encontrado.");
			e.printStackTrace();
		}

	}

	private void randomize() {
		return;
	}
	
	public void atualizarPosPersonagem(Personagem p, int novoI, int novoJ) {
		if (posicaoExiste(novoI, novoJ) && !posicaoOcupada(novoI, novoJ)) {
			apagarCela(p.getI(), p.getJ());
			matriz[novoI][novoJ] = p.simbolo();
		} else {
			throw PosicaoInvalidaException("Posicao invalida");
		}
	}
	
	private boolean posicaoExiste(int i, int j) {
		if (i >= 0 && i < altura && j >= 0 && j < largura) {
			return true;
		}
		return false;
	}
	
	private boolean posicaoOcupada(int i, int j) {
		if (matriz[i][j] != '-') {
			return true;
		}
		return false;
	}
	
	public void removerMonstro
	
	public Monstro getMonstroEm(int i, int j) {
		for (Montro m : this.monstros) {
			if (m.getLinha() == i && m.getColuna == j) {
				return m;
			}
		}
		return null;
	}
}
