package tabuleiro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import excecoes.*;
import personagens.monstros.*;
import personagens.jogaveis.*;

public final class Tabuleiro {
	private int largura;
	private int altura;

	private int[][] matriz;

	private Sala[] salas;
	private Corredor[] corredores;

	private ArrayList<Monstro> monstros = new ArrayList<Monstro>();
	private ArrayList<Tesouro> tesouros = new ArrayList<Tesouro>();

	// ArrayList<Armadilha> armadilhas;

	/*
	 * Construtor Assinatura 1: - Gera um tabuleiro aleatório. Têm como parâmetros
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
	 * Construtor Assinatura 2: - Gera um tabuleiro a partir a da leitura de um
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

	public void atualizarPosPersonagem(SerVivo p, int novoI, int novoJ) {
		if (posicaoExiste(novoI, novoJ) && !posicaoOcupada(novoI, novoJ)) {
			apagarCela(p.getI(), p.getJ());
			matriz[novoI][novoJ] = p.simbolo();
		} else {
			throw new PosicaoInvalidaException("Posicao invalida");
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

	public void print_tabuleiro() {
		int i;
		for (i = 0; i < this.altura; i++) {
			System.out.println(this.matriz[i].toString());
		}
	}

	public ArrayList<Monstro> getMonstrosVisiveis(Sala s) {

		ArrayList<Monstro> monstrosVisiveis = new ArrayList<Monstro>();

		for (Monstro m : this.monstros) {
			if (s.contem(heroi.getI(), heroi.getJ())) {
				monstrosVisiveis.add(m);
			}
		}

		return monstrosVisiveis;
	}

	public ArrayList<Monstro> getMonstrosVisiveis(Heroi heroi, Corredor c) {

		ArrayList<Monstro> monstrosVisiveis = new ArrayList<Monstro>();

		// Busca por monstros em um corredor horizontal
		if (c.isHorizontal()) {
			// procura por monstros à direita do herói, adiciona apenas o primeiro que
			// encontrar
			for (int j = heroi.getJ() + 1; j < this.largura; j++) {
				Monstro m = getMonstroEm(heroi.getI(), j);
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
			// procura por monstros à esquerda do herói, adiciona apenas o primeiro que
			// encontrar
			for (int j = heroi.getJ() - 1; j >= 0; j--) {
				Monstro m = getMonstroEm(heroi.getI(), j);
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
			// Busca por monstros em um corredor vertical
		} else {
			// procura por monstros ao norte do herói, adiciona apenas o primeiro que
			// encontrar
			for (int i = heroi.getI() + 1; i < this.altura; i++) {
				Monstro m = getMonstroEm(i, heroi.getJ());
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
			// procura por monstros ao sul do herói, adiciona apenas o primeiro que
			// encontrar
			for (int i = heroi.getI() - 1; i >= 0; i--) {
				Monstro m = getMonstroEm(i, heroi.getJ());
				if (m != null) {
					monstrosVisiveis.add(m);
					break;
				}
			}
		}

		return monstrosVisiveis;
	}
}

