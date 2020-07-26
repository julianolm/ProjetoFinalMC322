package tabuleiro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import excecoes.PosInvalidaException;
import personagens.*;
import personagens.jogaveis.*;

public final class Tabuleiro {
	private int largura;
	private int altura;

	private char[][] matriz;
	String[] mapa_default = { "--------------------------", "-###########--#####P#####-", "-#--#---#--#--#--#---#--#-",
			"-#--P---#--#--P--#---#--#-", "-#--#---P--#--#--#---#--#-", "-#--#---#--#--#--#---#--#-",
			"-####P######--########P##-", "-P------#--------#------P-", "-#------#-##P###-#------#-",
			"-########-#----#-########-", "----------#----#----------", "-########-#----#-########-",
			"-#------#-######-#------#-", "-#------#--------#------#-", "-######P#P##--####P######-",
			"-P----#----#--#----#----P-", "-#----#----#--#----#----#-", "-########P##--###P#######-",
			"--------------------------", };

	private Sala[] salas;
	private Corredor[] corredores;

	private ArrayList<Monstro> monstros = new ArrayList<Monstro>();
//	private ArrayList<Tesouro> tesouros = new ArrayList<Tesouro>();
	private Jogavel heroi;

	// ArrayList<Armadilha> armadilhas;

	/*
	 * Construtor Assinatura 1: - Gera um tabuleiro aleatório. Têm como parâmetros
	 * apenas largura e altura do tabuleiro.
	 */
	public Tabuleiro() {
		this.largura = 26;
		this.altura = 19;
		char[][] matriz; //

		corredores = new Corredor[12];
		salas = new Sala[15];

		this.matriz = new char[altura][largura];

		int i = 0;
		for (String linha : mapa_default) {
			this.matriz[i] = linha.toCharArray();
			i++;
		}

		randomize();
	}

	/*
	 * Construtor Assinatura 2: - Gera um tabuleiro a partir a da leitura de um
	 * arquivo. Têm como parâmetros largura, altura e nome do arquivo referente ao
	 * tabuleiro.
	 */
	public Tabuleiro(String nome_arquivo) {

		try {
			File arquivo = new File(nome_arquivo);
			Scanner leitor = new Scanner(arquivo);
			while (leitor.hasNextLine()) {
				String[] linha = leitor.nextLine().split(" ");
				char[] vetor = new char[3];
				for (int i = 0; i < linha.length; i++) {
					vetor[i] = (char) Integer.parseInt(linha[i]);
				}
				Monstro m;
				if(vetor[0] == 'G') {
					m = new Goblin(1, 2, this.heroi, 2);
				} 
				else if (vetor[0] == 'E') {
					m = new EsqueletoComum(1, 2, this.heroi, 2);
				}
				else if (vetor[0] == 'M') {
					m = new EsqueletoMago(1, 2, this.heroi, 2);
				}
				
				this.monstros.add(m);
			}
			leitor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de tabuleiro não encontrado.");
			e.printStackTrace();
		}

	}

	private void randomize() {
		return;
	}

	// metodo que adiciona uma referencia para o heroi ao mapa
	public void addHeroi(Jogavel heroi) {
		this.heroi = heroi;
	}

	public void atualizarPosPersonagem(SerVivo p, int novoI, int novoJ) throws PosInvalidaException {
		if (posicaoExiste(novoI, novoJ) && !posicaoOcupada(novoI, novoJ)) {
			apagarCela(p.getI(), p.getJ());
			matriz[novoI][novoJ] = p.simbolo();
		} else {
			throw new PosInvalidaException("Posicao invalida");
		}
	}

	private void apagarCela(int i, int j) {
		// TODO Auto-generated method stub

	}

	public boolean posicaoExiste(int i, int j) {
		if (i >= 0 && i < altura && j >= 0 && j < largura) {
			return true;
		}
		return false;
	}

	public boolean posicaoOcupada(int i, int j) {
		if (matriz[i][j] != '-') {
			return true;
		}
		return false;
	}

	public void printTabuleiro() {

		int i;
		for (i = 0; i < this.altura; i++) {
			for (int j = 0; j < this.largura; j++) {
				System.out.print(this.matriz[i][j]);
			}
			System.out.println("");
		}
	}

//	public ArrayList<Monstro> getMonstrosVisiveis(Sala s) {
//		ArrayList<Monstro> monstrosVisiveis = new ArrayList<Monstro>();
//		for (Monstro m : this.monstros) {
//			if (s.contem(heroi.getI(), heroi.getJ())) {
//				monstrosVisiveis.add(m);
//			}
//		}
//		return monstrosVisiveis;
//	}

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

	private Monstro getMonstroEm(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
}
